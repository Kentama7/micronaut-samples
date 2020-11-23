package com.example

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.security.annotation.Secured
import io.micronaut.security.rules.SecurityRule
import java.security.Principal

@Controller("/hoge")
class HogeController {

    @Get("/authenticated")
    @Secured(SecurityRule.IS_AUTHENTICATED)
    fun get(principal: Principal) = "${principal.name}"

    @Get("/anonymous")
    @Secured(SecurityRule.IS_ANONYMOUS)
    fun anonymous() = "anonymous"
}