package com.jclopez.setlens.di.domain

import com.jclopez.setlens.data.repository.MockRecordedSetRepositoryImpl
import com.jclopez.setlens.domain.repository.RecordedSetRepository
import org.koin.dsl.module

val domainModule = module {
    single<RecordedSetRepository> { MockRecordedSetRepositoryImpl() }
}
