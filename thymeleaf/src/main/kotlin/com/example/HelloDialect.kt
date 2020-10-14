package com.example

import org.thymeleaf.dialect.AbstractProcessorDialect

class HelloDialect : AbstractProcessorDialect(
    "Hello Dialect", "hello", 1000
) {
    override fun getProcessors(dialectPrefix: String): Set<SayToAttributeTagProcessor> =
        setOf(SayToAttributeTagProcessor(dialectPrefix))
}