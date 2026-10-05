package com.jclopez.setlens.domain.usecase

import com.jclopez.setlens.domain.model.RecordedSet
import com.jclopez.setlens.domain.repository.RecordedSetRepository

class RecordedSetUseCaseImpl(
    private val repository: RecordedSetRepository
) : RecordedSetUseCase {

    override fun getRecordedSets(): List<RecordedSet> = repository.getRecordedSets()
}
