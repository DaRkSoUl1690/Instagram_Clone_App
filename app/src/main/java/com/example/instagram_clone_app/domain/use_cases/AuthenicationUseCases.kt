package com.example.instagram_clone_app.domain.use_cases

data class AuthenicationUseCases(
    val isUserAuthenticated: IsUserAuthenticated,
    val firebaseAuthState: FirebaseAuthState,
    val firebaseSignin: FirebaseSignin,
    val firebaseSignup: FirebaseSignup,
    val firebaseSignout: FirebaseSignout,
)
