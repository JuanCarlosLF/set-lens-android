package com.jclopez.setlens.domain.model

import java.util.UUID

data class RecordedSet(
    val id: UUID,
    val exercise: Exercise,
    val loadKg: Double,
    val repetitions: Int,
    val rpe: Double?,
    val recordedAtEpochMillis: Long,
    val durationSeconds: Long,
    val comments: List<Comment> = emptyList(),
)
