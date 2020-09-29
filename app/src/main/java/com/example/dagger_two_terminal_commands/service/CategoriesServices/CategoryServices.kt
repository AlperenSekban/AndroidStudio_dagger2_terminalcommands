package com.example.dagger_two_terminal_commands.service.CategoriesServices

import com.example.dagger_two_terminal_commands.models.CategoriesModel
import com.example.dagger_two_terminal_commands.service.RestApi
import com.example.dagger_two_terminal_commands.service.RetrofitClient
import com.example.dagger_two_terminal_commands.service.ServiceCallBack
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class CategoryServices  {

    lateinit var restApi: RestApi

    @Inject
    constructor(retrofitClient: RetrofitClient) {
        restApi = retrofitClient.getClient().create(RestApi::class.java)
    }


    fun getCategories(callback: ServiceCallBack<List<CategoriesModel>>) {
        var call =restApi.getCategories()

        call.enqueue(object : Callback<List<CategoriesModel>>{
            override fun onResponse(
                call: Call<List<CategoriesModel>>,
                response: Response<List<CategoriesModel>>
            ) {

                callback.onSuccess(response.body())
            }

            override fun onFailure(call: Call<List<CategoriesModel>>, t: Throwable) {
                callback.onError(500,t.message.toString())
            }
        })


    }

}
