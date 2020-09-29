package com.example.dagger_two_terminal_commands.ui.SplashScreenFragment

import android.view.View
import androidx.fragment.app.FragmentTransaction
import javax.inject.Inject

class SplashScreenPresenter @Inject constructor() :SplashScreenContract.Presenter {


    private lateinit var mView: SplashScreenContract.View
    private lateinit var viewObject: View


    override fun setView(mView: SplashScreenContract.View, viewObject: View) {
        this.mView = mView
        this.viewObject = viewObject
    }

    override fun created() {
        val thread: Thread = object : Thread() {
            override fun run() {
                try {
                    sleep(3000)
                    mView.openCategoriesFragment()
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
            }
        }
        thread.start()
    }
}