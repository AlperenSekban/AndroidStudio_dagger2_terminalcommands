package com.example.dagger_two_terminal_commands.ui.SplashScreenFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.dagger_two_terminal_commands.MvpApp
import com.example.dagger_two_terminal_commands.R
import com.example.dagger_two_terminal_commands.changeFragment
import com.example.dagger_two_terminal_commands.ui.CategoriesFragment.CategoriesFragment
import javax.inject.Inject


class SplashScreenFragment @Inject constructor(
    private var mPresenter: SplashScreenPresenter,
    private var categoriesFragment: CategoriesFragment
) : Fragment(), SplashScreenContract.View {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_splash_screen, container, false)


        this.mPresenter.setView(this, view)
        this.mPresenter.created()

        return view
    }


    override fun openCategoriesFragment() {
        changeFragment(requireContext(), categoriesFragment)
    }
}