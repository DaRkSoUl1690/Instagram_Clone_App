package com.example.instagram_clone_app.domain.use_cases

import com.example.instagram_clone_app.domain.repository.AuthenticationRepository
import javax.inject.Inject

class FirebaseSignup @Inject constructor(
    private val repository: AuthenticationRepository
) {
    operator fun invoke(email: String, password: String,userName: String)
            = repository.firebaseSignUp(email,password,userName)
}