package com.example.token

import io.micronaut.core.order.Ordered
import io.micronaut.http.HttpRequest
import io.micronaut.security.token.reader.HttpHeaderTokenReader
import io.micronaut.security.token.reader.TokenReader
import java.util.*
import javax.inject.Singleton

@Singleton
class CustomHttpHeaderTokenReader : HttpHeaderTokenReader(), TokenReader {
    override fun getPrefix(): String {
        return "Bearer"
    }

    override fun getHeaderName(): String {
        return "Authorization"
    }

    override fun getOrder(): Int {
        return Ordered.HIGHEST_PRECEDENCE
    }
}

//@Singleton
//class Hoge: TokenReader {
//    override fun findToken(request: HttpRequest<*>?): Optional<String> {
//        TODO("Not yet implemented")
//    }
//
//}
