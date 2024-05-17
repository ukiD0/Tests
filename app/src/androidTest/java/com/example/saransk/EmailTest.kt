package com.example.saransk

import android.widget.EditText
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.RootMatchers.isDialog
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.saransk.domain.AuthRepository
import com.example.saransk.presentation.SignInFragment


import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule


@RunWith(AndroidJUnit4::class)
class EmailTest {

    @JvmField
    @get:Rule
    val scenarioRule = launchFragmentInContainer<SignInFragment>()
    @Test
    fun validPassword() {
        val pass = "12345!Ab"
        onView(withId(R.id.passId)).perform(typeText(pass))
        onView(withId(R.id.passId)).check { view, noViewFoundException ->
            if (view is EditText){
               assert(AuthRepository.checkValidPass(view))
            }
        }
    }
    @Test
    fun invalidPasswordAlert() {
        val pass = "12345"
        onView(withId(R.id.passId))
            .perform(typeText(pass),closeSoftKeyboard())
        onView(withId(R.id.passId)).check { view, noViewFoundException ->
            if (view is EditText){
                assert(!AuthRepository.checkValidPass(view))
            }
        }
        onView(withId(R.id.btnHide))
            .check(matches(isDisplayed()))
            .perform(ViewActions.click())
        onView(withText("Ошибка"))
            .inRoot(isDialog())
            .check(matches(isDisplayed()))
    }
    @Test
    fun validEmail() {
        val pass = "valusa@123mewo.ry"
        onView(withId(R.id.emailId)).perform(typeText(pass))
        onView(withId(R.id.emailId)).check { view, noViewFoundException ->
            if (view is EditText){
                assert(AuthRepository.checkValidEmail(view))
            }
        }
    }
    @Test
    fun invalidEmailAlert() {
        val pass = "valusDDDSa@12sSSD3mewo.ry"
        onView(withId(R.id.emailId)).perform(typeText(pass))
        onView(withId(R.id.emailId)).check { view, noViewFoundException ->
            if (view is EditText){
                assert(!AuthRepository.checkValidEmail(view))
            }
        }
        onView(withId(R.id.invisible)).perform(click())
        onView(withText("Ошибка"))
            .inRoot(isDialog())
            .check(matches(isDisplayed()))
    }
}