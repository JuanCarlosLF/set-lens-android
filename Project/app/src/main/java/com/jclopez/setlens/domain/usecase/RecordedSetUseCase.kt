package com.jclopez.setlens.domain.usecase

import com.jclopez.setlens.domain.model.RecordedSet

interface RecordedSetUseCase {
    fun getRecordedSets(): List<RecordedSet>
}
