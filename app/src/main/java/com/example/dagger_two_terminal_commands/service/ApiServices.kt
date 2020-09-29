package com.example.dagger_two_terminal_commands.service

import com.example.dagger_two_terminal_commands.models.CategoriesModel
import com.example.dagger_two_terminal_commands.service.CategoriesServices.CategoryServices
import com.example.dagger_two_terminal_commands.service.CategoryInformationsService.CategoryInformationsServices
import javax.inject.Inject

class ApiServices {

    lateinit var categoryServices: CategoryServices
    lateinit var categoryInformationsServices: CategoryInformationsServices

    @Inject
    constructor(categoryServices: CategoryServices,categoryInformationsServices: CategoryInformationsServices){
        this.categoryServices=categoryServices
        this.categoryInformationsServices=categoryInformationsServices
    }


    fun getCategories(serviceCallBack: ServiceCallBack<List<CategoriesModel>>) {
        categoryServices!!.getCategories(serviceCallBack)
    }
}