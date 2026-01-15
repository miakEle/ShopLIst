package com.example.shoplist.di

import com.example.shoplist.presentation.MainActivity
import com.example.shoplist.presentation.ShopItemFragment
import dagger.Subcomponent

@Subcomponent(modules = [ViewModelModule::class])
interface ActivityComponent {


    fun inject(activity: MainActivity)

    fun inject(fragment: ShopItemFragment)

    @Subcomponent.Factory
    interface ActivityComponentFactory {
        fun create(): ActivityComponent


    }
}