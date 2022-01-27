package com.appknot.mentore.di

import com.appknot.mentore.viewmodel.MainViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

/**
 *
 * @author Ethan on 2022-01-26
 */
val appContext = module {
    single(named("appContext")) { androidContext() }
}

val viewModelModule = module {
    viewModel { MainViewModel() }
}