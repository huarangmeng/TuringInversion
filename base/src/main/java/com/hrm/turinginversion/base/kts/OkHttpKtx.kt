package com.hrm.turinginversion.base.kts

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.suspendCancellableCoroutine
import okhttp3.Call
import okhttp3.Callback
import okhttp3.Response
import java.io.IOException
import kotlin.coroutines.resumeWithException

@OptIn(ExperimentalCoroutinesApi::class)
suspend fun Call.awaitResponse(): Response {
    return suspendCancellableCoroutine {
        it.invokeOnCancellation {
            cancel()
        }
        enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                it.resumeWithException(e)
            }

            override fun onResponse(call: Call, response: Response) {
                it.resume(response) {
                    cancel()
                }
            }
        })
    }
}