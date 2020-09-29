package com.example.dagger_two_terminal_commands.di

import android.app.Application
import android.content.Context
import com.example.dagger_two_terminal_commands.service.ApiServices
import com.example.dagger_two_terminal_commands.service.CategoriesServices.CategoryServices
import com.example.dagger_two_terminal_commands.service.CategoryInformationsService.CategoryInformationsServices
import com.example.dagger_two_terminal_commands.service.RetrofitClient
import com.example.dagger_two_terminal_commands.ui.CategoriesFragment.CategoriesFragment
import com.example.dagger_two_terminal_commands.ui.CategoriesFragment.CategoriesPresenter
import com.example.dagger_two_terminal_commands.ui.SplashScreenFragment.SplashScreenFragment
import com.example.dagger_two_terminal_commands.ui.SplashScreenFragment.SplashScreenPresenter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class TerminalModules(app: Application) {

    private val context: Context

    init {
        this.context = app
    }

    @Provides
    @Singleton
    internal fun provideContext(): Context {
        return context
    }

    @Provides
    @Singleton
    fun provideSplashScreenFragment(splashScreenPresenter: SplashScreenPresenter,categoriesFragment: CategoriesFragment):SplashScreenFragment{
        return SplashScreenFragment(splashScreenPresenter,categoriesFragment)
    }

    @Provides
    @Singleton
    fun provideSplaşhScreenPresenter():SplashScreenPresenter{
        return SplashScreenPresenter()
    }

    @Provides
    fun provideCategoriesPresenter(apiServices: ApiServices):CategoriesPresenter{
        return CategoriesPresenter(apiServices)
    }

    @Provides
    @Singleton
    fun provideApiServices(categoryServices: CategoryServices,categoryInformationsServices: CategoryInformationsServices):ApiServices{
        return ApiServices(categoryServices,categoryInformationsServices)
    }

    @Provides
    @Singleton
    fun provideCategoryServices(retrofitClient: RetrofitClient):CategoryServices{
        return CategoryServices(retrofitClient)
    }

}