package com.jclopez.setlens.domain.repository

import com.jclopez.setlens.domain.model.RecordedSet

interface RecordedSetRepository {
    fun getRecordedSets(): List<RecordedSet>
}
