package com.example.dagger_two_terminal_commands.ui.CategoriesFragment

import android.view.View
import com.example.dagger_two_terminal_commands.MainActivity
import com.example.dagger_two_terminal_commands.models.CategoriesModel
import com.example.dagger_two_terminal_commands.service.ApiServices
import com.example.dagger_two_terminal_commands.service.ServiceCallBack
import javax.inject.Inject

class CategoriesPresenter : CategoriesContract.Presenter {
    private lateinit var mView: CategoriesContract.View
    private lateinit var viewObject: View
    private lateinit var apiServices: ApiServices


    @Inject
    constructor(apiServices: ApiServices) {
        this.apiServices = apiServices
    }


    override fun setView(mView: CategoriesContract.View, viewObject: View) {
        this.mView = mView
        this.viewObject = viewObject
    }

    override fun created() {
        MainActivity().showLoading()

        apiServices.getCategories(object : ServiceCallBack<List<CategoriesModel>> {
            override fun onSuccess(response: List<CategoriesModel>?) {

                if (response != null) {
                    mView.setAdapter(response, viewObject)
                }


                MainActivity().hideLoading()

            }

            override fun onError(errorCode: Int, errorMessage: String) {

            }


        })
    }


}