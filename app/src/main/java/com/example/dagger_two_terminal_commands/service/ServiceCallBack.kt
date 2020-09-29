package com.example.dagger_two_terminal_commands.service


interface ServiceCallBack<T> {
    fun onSuccess(response:T?)
    fun onError(errorCode:Int,errorMessage:String)
}