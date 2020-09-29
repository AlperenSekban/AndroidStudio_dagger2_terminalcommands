package com.example.dagger_two_terminal_commands

import android.app.Application
import com.example.dagger_two_terminal_commands.di.DaggerViewComponents
import com.example.dagger_two_terminal_commands.di.TerminalModules
import com.example.dagger_two_terminal_commands.di.ViewComponents

class MvpApp:Application() {

    private var viewComponents: ViewComponents? = null

    fun getActivityComponent(): ViewComponents? {
        return viewComponents
    }

    fun setActivityComponent(activityComponent: ViewComponents) {
        this.viewComponents = activityComponent
    }

    override fun onCreate() {
        super.onCreate()

        viewComponents = DaggerViewComponents.builder().terminalModules(TerminalModules(this)).build()


    }
}