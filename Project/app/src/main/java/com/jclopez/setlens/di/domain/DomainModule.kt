package com.jclopez.setlens.di.domain

import com.jclopez.setlens.data.repository.MockRecordedSetRepositoryImpl
import com.jclopez.setlens.domain.repository.RecordedSetRepository
import com.jclopez.setlens.domain.usecase.RecordedSetUseCase
import com.jclopez.setlens.domain.usecase.RecordedSetUseCaseImpl
import org.koin.dsl.module

val domainModule = module {
    single<RecordedSetRepository> { MockRecordedSetRepositoryImpl() }
    single<RecordedSetUseCase> { RecordedSetUseCaseImpl(repository = get()) }
}
