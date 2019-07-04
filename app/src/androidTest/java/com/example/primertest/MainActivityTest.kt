package com.example.primertest


import android.widget.EditText
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

import androidx.test.espresso.assertion.ViewAssertions.matches
import kotlinx.android.synthetic.main.activity_main.*


@RunWith(AndroidJUnit4::class)
class MainActivityTest
{

    lateinit var txtinit: EditText
    @get:Rule
    var activityTestRule: ActivityTestRule<MainActivity> = ActivityTestRule<MainActivity>(MainActivity::class.java)

    @Test
    fun editTextUpdatesTextView() {
        // Arrange
        val givenString = "hola"
        onView(withId(R.id.txtinicio)).perform(typeText(givenString), closeSoftKeyboard())
        // Act
        onView(withId(R.id.btnCambiar)).perform(click())//.perform(pressImeActionButton())

        // Assert
        onView(withId(R.id.txtfinal)).check(matches(withText(activityTestRule.activity.txtinicio.text.toString())))
    }

}