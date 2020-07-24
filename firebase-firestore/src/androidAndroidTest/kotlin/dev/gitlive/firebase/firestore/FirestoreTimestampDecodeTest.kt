package dev.gitlive.firebase.firestore

import dev.gitlive.firebase.decode
import kotlinx.serialization.Serializable
import kotlin.test.Test
import kotlin.test.assertEquals
import com.google.firebase.Timestamp

class FirestoreTimestampDecodeTest {
    @Test
    fun canDecodeTimestamp() {
        val stub = mapOf(
            "timestamp" to Timestamp(253402300799, 999_999_999)
        )

        assertEquals(
            decode(TestData.serializer(), stub),
            TestData(TestTimestamp(253402300799, 999_999_999))
        )
    }
}

@Serializable
private data class TestData(val timestamp: TestTimestamp)

@Serializable
private data class TestTimestamp(val seconds: Long, val nanoseconds: Int)
