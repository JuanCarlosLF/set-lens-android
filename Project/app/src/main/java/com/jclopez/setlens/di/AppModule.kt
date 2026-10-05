package com.jclopez.setlens.di

import com.jclopez.setlens.di.domain.domainModule
import com.jclopez.setlens.di.presentation.presentationModule

val appModule = listOf(domainModule, presentationModule)
