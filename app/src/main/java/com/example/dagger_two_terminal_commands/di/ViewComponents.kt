package com.example.dagger_two_terminal_commands.di

import com.example.dagger_two_terminal_commands.MainActivity
import com.example.dagger_two_terminal_commands.ui.CategoriesFragment.CategoriesFragment
import com.example.dagger_two_terminal_commands.ui.SplashScreenFragment.SplashScreenFragment
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [TerminalModules::class])
interface ViewComponents {

    fun injectMainActivity(mainActivity: MainActivity){

    }

}