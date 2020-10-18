package com.example.utilities

import io.micronaut.context.annotation.Factory
import javax.inject.Singleton

@Factory
class BarFactory {

    @Singleton
    fun barUtils(): BarUtils = BarUtils()
}