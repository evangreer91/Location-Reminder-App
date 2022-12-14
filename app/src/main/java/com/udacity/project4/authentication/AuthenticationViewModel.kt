package com.udacity.project4.authentication

import android.content.Context
import android.preference.PreferenceManager
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import com.udacity.project4.R
import kotlin.random.Random

class AuthenticationViewModel : ViewModel() {
    val message = MutableLiveData<String>("CATS")

    enum class AuthenticationState {
        AUTHENTICATED, UNAUTHENTICATED, INVALID_AUTHENTICATION
    }

    //  create an authenticationState variable based off the FirebaseUserLiveData object.
    //  by creating this variable, other classes will be able to query for whether the user is logged in or not
    val authenticationState = FirebaseUserLiveData().map { user ->
        if (user != null) {
            AuthenticationState.AUTHENTICATED
        } else {
            AuthenticationState.UNAUTHENTICATED
        }
    }
}