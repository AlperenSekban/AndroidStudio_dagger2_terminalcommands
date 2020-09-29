package com.example.dagger_two_terminal_commands

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.example.dagger_two_terminal_commands.ui.SplashScreenFragment.SplashScreenFragment
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    lateinit var progressDialog: ProgressDialog
    private var alertDialogBuilder: AlertDialog.Builder? = null

    @Inject
    lateinit var splashScreenFragment: SplashScreenFragment


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        (application as MvpApp).getActivityComponent()?.injectMainActivity(this)

        addFragment(this,splashScreenFragment)

    }

   fun showLoading() {
        progressDialog = showLoadingDialog(this@MainActivity)
    }

    fun hideLoading() {
        if (progressDialog != null) {
            if (progressDialog.isShowing) {
                progressDialog.dismiss()

            }
        }
    }
}