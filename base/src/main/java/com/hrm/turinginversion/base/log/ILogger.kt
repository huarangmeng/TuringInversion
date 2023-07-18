package com.hrm.turinginversion.base.log

interface ILogger {

    /**
     * 最低级别的日志，打印运行过程中的信息，可以每帧打印
     */
    fun v(tag: String, message: String)

    /**
     * debug级别，用于打印一些状态信息
     */
    fun d(tag: String, message: String)

    /**
     * info级别，打印关键的状态信息
     */
    fun i(tag: String, message: String)

    /**
     * 警告级别，出现异常情况，但有应对策略，可以继续执行任务、影响不大
     */
    fun w(tag: String, message: String)

    /**
     * 异常级别，影响后续的执行流程或者效果等
     */
    fun e(tag: String, message: String)

    /**
     * 异常级别，影响后续的执行流程或者效果等
     */
    fun e(tag: String, message: String, throwable: Throwable)
}