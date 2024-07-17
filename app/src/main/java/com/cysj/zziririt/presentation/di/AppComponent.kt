package com.cysj.zziririt.presentation.di

import com.cysj.zziririt.Zziririt
import com.cysj.zziririt.data.di.RepositoryModule
import dagger.Component

@Component(modules = [RepositoryModule::class])
interface AppComponent {
    fun inject(application: Zziririt)
}