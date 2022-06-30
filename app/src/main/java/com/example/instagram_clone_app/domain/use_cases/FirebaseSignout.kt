package com.example.instagram_clone_app.domain.use_cases

import com.example.instagram_clone_app.domain.repository.AuthenticationRepository
import javax.inject.Inject

class FirebaseSignout @Inject constructor(
    private val repository: AuthenticationRepository
) {
   operator fun invoke() = repository.firebaseSignOut()
}