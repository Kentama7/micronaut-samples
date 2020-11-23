package com.example.fetcher

import io.micronaut.core.order.Ordered
import io.micronaut.http.HttpHeaderValues
import io.micronaut.http.HttpRequest
import io.micronaut.security.authentication.Authentication
import io.micronaut.security.authentication.DefaultAuthentication
import io.micronaut.security.filters.AuthenticationFetcher
import io.reactivex.Maybe
import org.reactivestreams.Publisher
import java.util.*
import javax.inject.Singleton

@Singleton
class CustomAuthenticationFetcher : AuthenticationFetcher {

    companion object {
        private const val PREFIX = HttpHeaderValues.AUTHORIZATION_PREFIX_BEARER + " "
    }

    override fun fetchAuthentication(request: HttpRequest<*>): Publisher<Authentication> =
        request.headers.authorization
            .flatMap { parseCredentials(it) }
            // この辺で検証が必要. AuthenticationProviderでやる？
            .map { Maybe.just(it) }
            .orElseGet { Maybe.empty() }
            .toFlowable()


    fun parseCredentials(authorization: String): Optional<Authentication> = Optional.of(authorization)
        .filter { it.startsWith(PREFIX) }
        .map { it.substring(PREFIX.length) }
        // TODO name, attributes
        .flatMap { Optional.of(DefaultAuthentication("${authorization}", emptyMap())) }
}
