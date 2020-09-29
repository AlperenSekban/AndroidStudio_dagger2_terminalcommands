package com.example.dagger_two_terminal_commands.ui.SplashScreenFragment

import android.view.View

interface SplashScreenContract {
    interface View{
        fun openCategoriesFragment()

    }

    interface Presenter{
        fun setView(mView: View, viewObject: android.view.View)
        fun created()

    }


}