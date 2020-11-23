package com.example.fetcher

import io.micronaut.http.HttpRequest
import io.micronaut.security.authentication.AuthenticationProvider
import io.micronaut.security.authentication.AuthenticationRequest
import io.micronaut.security.authentication.AuthenticationResponse
import org.reactivestreams.Publisher
import javax.inject.Singleton

@Singleton
class AuthenticationProviderBaerer: AuthenticationProvider {
    override fun authenticate(httpRequest: HttpRequest<*>?, authenticationRequest: AuthenticationRequest<*, *>?): Publisher<AuthenticationResponse> {
        TODO("Not yet implemented")
    }
}