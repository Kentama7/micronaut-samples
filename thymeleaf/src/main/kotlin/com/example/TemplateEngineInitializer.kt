package com.example

import io.micronaut.context.event.BeanCreatedEvent
import io.micronaut.context.event.BeanCreatedEventListener
import org.thymeleaf.TemplateEngine
import javax.inject.Singleton

@Singleton
class TemplateEngineInitializer : BeanCreatedEventListener<TemplateEngine> {
    override fun onCreated(event: BeanCreatedEvent<TemplateEngine>): TemplateEngine {
        val engine = event.bean
        engine.addDialect(HelloDialect())
        return engine
    }
}