package com.example.fetcher

import io.micronaut.core.annotation.Introspected
import io.micronaut.security.authentication.AuthenticationRequest
import java.io.Serializable

@Introspected
class CustomCredentials(
    private val secret: String
) : Serializable, AuthenticationRequest<String, String> {

    override fun getIdentity(): String = ""

    override fun getSecret(): String = secret
}