package com.hrm.turinginversion.base.kts

import android.os.Environment
import com.hrm.turinginversion.base.BaseApplication
import java.io.File

fun getFilePath(dir: String): String {
    val directoryPath: String = if (Environment.MEDIA_MOUNTED == Environment.getExternalStorageState()) {
        BaseApplication.instance.getExternalFilesDir(dir)?.absolutePath ?: ""
    } else {
        //没内存卡就存机身内存
        BaseApplication.instance.filesDir.absolutePath + File.separator + dir
    }
    createOrExistsFile(directoryPath)
    return directoryPath
}

fun createOrExistsFile(directoryPath: String): File {
    val file = File(directoryPath)
    if (!file.exists()) {
        file.mkdir()
    }
    return file
}