package com.example.dagger_two_terminal_commands.ui.CategoriesFragment

import android.view.View
import com.example.dagger_two_terminal_commands.models.CategoriesModel

interface CategoriesContract {
    interface View{
        fun setAdapter(response: List<CategoriesModel>, viewObject: android.view.View)

    }

    interface Presenter{
        fun setView(mView: View, viewObject: android.view.View)
        fun created()

    }
}