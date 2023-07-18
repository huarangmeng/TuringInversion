package com.hrm.turinginversion.base.utils

import java.lang.reflect.Field
import java.lang.reflect.InvocationTargetException
import java.lang.reflect.Method

object ReflectionUtils {
    @JvmStatic
    fun getDeclaredField(obj: Any, fieldName: String): Field? {
        var clazz: Class<*> = obj.javaClass
        while (clazz != Any::class.java) {
            try {
                return clazz.getDeclaredField(fieldName)
            } catch (e: Exception) {
            }
            clazz = clazz.superclass
        }
        return null
    }

    @JvmStatic
    fun getDeclaredMethod(obj: Any, methodName: String, vararg parameterTypes: Class<*>): Method? {
        var clazz: Class<*> = obj.javaClass
        while (clazz != Any::class.java) {
            try {
                return clazz.getDeclaredMethod(methodName, *parameterTypes)
            } catch (e: Exception) {
            }
            clazz = clazz.superclass
        }
        return null
    }

    @JvmStatic
    fun invokeMethod(
        obj: Any, methodName: String, parameterTypes: Array<Class<*>>,
        parameters: Array<Any>
    ): Any? {
        val method: Method? = getDeclaredMethod(obj, methodName, *parameterTypes)
        method?.isAccessible = true
        try {
            return method?.invoke(obj, *parameters)
        } catch (e: IllegalArgumentException) {
            e.printStackTrace()
        } catch (e: IllegalAccessException) {
            e.printStackTrace()
        } catch (e: InvocationTargetException) {
            e.printStackTrace()
        }
        return null
    }

    @JvmStatic
    fun setFieldValue(obj: Any, fieldName: String, value: Any) {
        val field: Field? = getDeclaredField(obj, fieldName)
        field?.isAccessible = true
        try {
            field?.set(obj, value)
        } catch (e: IllegalArgumentException) {
            e.printStackTrace()
        } catch (e: IllegalAccessException) {
            e.printStackTrace()
        }
    }

    @JvmStatic
    fun getFieldValue(obj: Any, fieldName: String): Any? {
        val field: Field? = getDeclaredField(obj, fieldName)
        field?.isAccessible = true
        try {
            return field?.get(obj)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return null
    }
}