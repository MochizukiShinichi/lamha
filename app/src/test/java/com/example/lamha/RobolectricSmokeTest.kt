package com.example.lamha

import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import org.robolectric.annotation.ConscryptMode

/**
 * Low-spec verification gate for ARM64: ensure the app can create/launch the main Activity on the JVM.
 * This catches missing resources, broken manifests/themes, and many Compose/runtime crashes early.
 */
@RunWith(RobolectricTestRunner::class)
@ConscryptMode(ConscryptMode.Mode.OFF)
@Config(sdk = [34])
class RobolectricSmokeTest {

    @Test
    fun launchMainActivity_doesNotCrash() {
        // Passing condition: Activity setup completes without throwing.
        Robolectric.buildActivity(MainActivity::class.java).setup()
    }
}
