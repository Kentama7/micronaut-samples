package com.example

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.transaction.annotation.ReadOnly
import io.micronaut.transaction.annotation.TransactionalAdvice
import nu.studer.sample.Tables
import org.jooq.DSLContext
import java.time.LocalDateTime
import javax.inject.Singleton

@Controller
class CustomerController(
    private val customerService: CustomerService
) {
    @Get
    fun count(): Int = customerService.count()
}

@Singleton
open class CustomerService(
    private val dslContext: DSLContext
) {

    @ReadOnly
    open fun count(): Int = dslContext.select(Tables.CUSTOMER.ID).from(Tables.CUSTOMER).execute()

    @TransactionalAdvice
    open fun add(): Int =
        dslContext.insertInto(Tables.CUSTOMER, Tables.CUSTOMER.CREATED_AT).values(LocalDateTime.now()).execute()

    @TransactionalAdvice
    open fun delete(): Int =
        dslContext.deleteFrom(Tables.CUSTOMER).where(Tables.CUSTOMER.ID.eq(1)).execute()
}