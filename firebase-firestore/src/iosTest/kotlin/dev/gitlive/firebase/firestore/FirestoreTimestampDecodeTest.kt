package dev.gitlive.firebase.firestore

import cocoapods.FirebaseFirestore.FIRTimestamp
import dev.gitlive.firebase.decode
import kotlinx.serialization.Serializable
import platform.Foundation.NSMutableDictionary
import platform.Foundation.NSString
import platform.darwin.NSObject
import kotlin.test.Test
import kotlin.test.assertEquals

class FirestoreTimestampDecodeTest {
    @Suppress("CAST_NEVER_SUCCEEDS")
    @Test
    fun canDecodeTimestamp() {
        val stub = NSMutableDictionary()
        stub.setObject(FIRTimestamp(253402300799, 999_999_999), "timestamp" as NSString)

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
