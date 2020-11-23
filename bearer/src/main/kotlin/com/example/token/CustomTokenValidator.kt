package com.example.token

import io.micronaut.security.authentication.Authentication
import io.micronaut.security.authentication.DefaultAuthentication
import io.micronaut.security.token.validator.TokenValidator
import io.reactivex.Flowable
import org.reactivestreams.Publisher
import java.util.*
import javax.inject.Singleton

@Singleton
class CustomTokenValidator : TokenValidator {
    override fun validateToken(token: String?): Publisher<Authentication> {
        return Flowable.just(DefaultAuthentication("aa", emptyMap()))
    }
}