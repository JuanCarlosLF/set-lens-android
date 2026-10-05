package com.jclopez.setlens.data.repository

import com.jclopez.setlens.domain.model.Exercise
import com.jclopez.setlens.domain.model.RecordedSet
import com.jclopez.setlens.domain.repository.RecordedSetRepository
import java.util.UUID

class MockRecordedSetRepository : RecordedSetRepository {

    override fun getRecordedSets(): List<RecordedSet> = recordedSets

    private companion object {
        val recordedSets = listOf(
            RecordedSet(
                id = UUID.fromString("0edcce41-ce0d-4ac8-9edc-b5e8da77f5c2"),
                exercise = Exercise(
                    id = UUID.fromString("15981bf8-5650-4db1-9560-8379cdabd9dd"),
                    name = "Sentadilla trasera",
                ),
                loadKg = 160.0,
                repetitions = 3,
                rpe = 8.5,
                recordedAtEpochMillis = 1_725_560_700_000L,
                durationSeconds = 18L,
            ),
            RecordedSet(
                id = UUID.fromString("d09aeb47-6b68-4cb0-b1ec-90935275c22d"),
                exercise = Exercise(
                    id = UUID.fromString("4e5b3e2f-d8e2-4dee-af4a-6f9938c4f338"),
                    name = "Press de banca",
                ),
                loadKg = 115.0,
                repetitions = 2,
                rpe = 9.0,
                recordedAtEpochMillis = 1_725_487_200_000L,
                durationSeconds = 14L,
            ),
            RecordedSet(
                id = UUID.fromString("d73852de-d6be-44a7-8fa5-c2a149ba16f5"),
                exercise = Exercise(
                    id = UUID.fromString("bdcd396f-034f-4144-ab28-9788245fe50c"),
                    name = "Peso muerto convencional",
                ),
                loadKg = 200.0,
                repetitions = 1,
                rpe = 8.0,
                recordedAtEpochMillis = 1_726_509_300_000L,
                durationSeconds = 22L,
            ),
            RecordedSet(
                id = UUID.fromString("0cc3ca11-26f3-40c0-9c4a-104413158550"),
                exercise = Exercise(
                    id = UUID.fromString("5ed3278c-2c6b-4861-af6e-0b4fd2f092f7"),
                    name = "Press militar",
                ),
                loadKg = 70.0,
                repetitions = 5,
                rpe = 7.5,
                recordedAtEpochMillis = 1_726_336_200_000L,
                durationSeconds = 16L,
            ),
        )
    }
}
