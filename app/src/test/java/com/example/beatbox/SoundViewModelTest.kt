package com.example.beatbox

import org.hamcrest.core.Is.`is`
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

class SoundViewModelTest {

    private lateinit var beatBox: BeatBox
    private lateinit var sound: Sound
    private lateinit var subject: SoundViewModel

    @Before
    fun setUp() {
        beatBox = mock(BeatBox::class.java)
        sound = Sound("assetPath")
        subject = SoundViewModel(beatBox)
        subject.sound = sound
    }

    @Test
    fun exposeSoundNameAsTitle() {
        //This following code line reads as sentence,
        // "Assert that subject’s title property is the same value as sound’s name property."
        assertThat(subject.title, `is`(sound.name))
    }

    @Test
    fun callsBeatBoxPlayOnButtonClicked() {
        subject.onButtonClicked()

        /** Call verify(Object) to ensure that onButtonClicked() calls BeatBox.play(Sound) with the Sound
         * object you hooked up to your SoundViewModel.
         *
         * verify(Object) uses a fluent interface. It is an abbreviation for the following code:
         * verify(beatBox) >>> This means >>> I am about to verify that a function was called on beatBox
         * beatBox.play(sound) >>> Verify that this function was called like this.
         *
         * verify(beatBox).play(sound) >>> Verify that the play(…) function was called on beatBox with this specific sound as a parameter.
         * */

        verify(beatBox).play(sound) // >>> Verify that the play(…) function was called on beatBox with this specific sound as a parameter.
    }
}