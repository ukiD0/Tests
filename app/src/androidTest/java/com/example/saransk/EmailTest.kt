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
import com.example.saransk.presentation.registration.SignInFragment


import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Rule


@RunWith(AndroidJUnit4::class)
class EmailTest {

    @JvmField
    @get:Rule
    val scenarioRule = launchFragmentInContainer<SignInFragment>()
    @Test
    fun validPassword() {
        onView(withId(R.id.passId)).perform(typeText(AuthRepository.TEST_PASSWORD))
        onView(withId(R.id.passId)).check { view, noViewFoundException ->
            if (view is EditText){
               assert(AuthRepository.checkValidPass(view))
            }
        }
    }
    @Test
    fun invalidPasswordAlert() {
        onView(withId(R.id.passId))
            .perform(typeText(AuthRepository.TEST_PASSWORD_INVALID),closeSoftKeyboard())
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
        onView(withId(R.id.emailId)).perform(typeText(AuthRepository.TEST_EMAIL))
        onView(withId(R.id.emailId)).check { view, noViewFoundException ->
            if (view is EditText){
                assert(AuthRepository.checkValidEmail(view))
            }
        }
    }
    @Test
    fun invalidEmailAlert() {
        onView(withId(R.id.emailId)).perform(typeText(AuthRepository.TEST_EMAIL_INVALID))
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