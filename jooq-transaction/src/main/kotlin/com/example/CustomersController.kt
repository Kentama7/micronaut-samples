package com.example

import com.example.jooq.Tables.CUSTOMER
import com.example.jooq.Tables.CUSTOMER_DETAIL
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.transaction.annotation.TransactionalAdvice
import org.jooq.DSLContext
import org.jooq.impl.DSL
import java.time.LocalDateTime
import javax.inject.Singleton

@Controller("/customers")
class CustomersController(
    private val customersService: CustomersService,
    private val customerServiceWithJooqTransaction: CustomerServiceWithJooqTransaction,
    private val customersServiceWithMicronautTransaction: CustomersServiceWithMicronautTransaction
) {

    @Post
    fun add(@Body("name") name: String): HttpResponse<String> = runCatching {
        customersService.add(name)
    }.fold(
        { HttpResponse.created("OK") },
        { HttpResponse.badRequest("${it.message}") }
    )

    @Post("jooq")
    fun addWithJooqTransaction(@Body("name") name: String): HttpResponse<String> = runCatching {
        customerServiceWithJooqTransaction.add(name)
    }.fold(
        { HttpResponse.created("OK") },
        { HttpResponse.badRequest("${it.message}") }
    )

    @Post("micronaut")
    fun addWithMicronautTransaction(@Body("name") name: String): HttpResponse<String> = runCatching {
        customersServiceWithMicronautTransaction.add(name)
    }.fold(
        { HttpResponse.created("OK") },
        { HttpResponse.badRequest("${it.message}") }
    )
}

@Singleton
class CustomersService(
    private val dslContext: DSLContext
) {

    fun add(name: String) {
        val id = dslContext
            .insertInto(CUSTOMER, CUSTOMER.CREATED_AT)
            .values(LocalDateTime.now())
            .returningResult(CUSTOMER.ID)
            .fetchOptional()
            .orElseThrow()
            .getValue(CUSTOMER.ID)

        dslContext
            .insertInto(CUSTOMER_DETAIL, CUSTOMER_DETAIL.CUSTOMER_ID, CUSTOMER_DETAIL.NAME, CUSTOMER_DETAIL.CREATED_AT)
            .values(id, name, LocalDateTime.now())
            .execute()
    }
}

@Singleton
class CustomerServiceWithJooqTransaction(
    private val dslContext: DSLContext
) {
    // DSLContext#transactionを使ったバージョン
    fun add(name: String) {
        dslContext.transaction { c ->
            val id = DSL.using(c)
                .insertInto(CUSTOMER, CUSTOMER.CREATED_AT)
                .values(LocalDateTime.now())
                .returningResult(CUSTOMER.ID)
                .fetchOptional()
                .orElseThrow()
                .getValue(CUSTOMER.ID)

            DSL.using(c)
                .insertInto(
                    CUSTOMER_DETAIL,
                    CUSTOMER_DETAIL.CUSTOMER_ID,
                    CUSTOMER_DETAIL.NAME,
                    CUSTOMER_DETAIL.CREATED_AT
                )
                .values(id, name, LocalDateTime.now())
                .execute()
        }
    }
}


@Singleton
open class CustomersServiceWithMicronautTransaction(
    private val dslContext: DSLContext
) {

    @TransactionalAdvice
    open fun add(name: String) {
        val id = dslContext
            .insertInto(CUSTOMER, CUSTOMER.CREATED_AT)
            .values(LocalDateTime.now())
            .returningResult(CUSTOMER.ID)
            .fetchOptional()
            .orElseThrow()
            .getValue(CUSTOMER.ID)

        dslContext
            .insertInto(CUSTOMER_DETAIL, CUSTOMER_DETAIL.CUSTOMER_ID, CUSTOMER_DETAIL.NAME, CUSTOMER_DETAIL.CREATED_AT)
            .values(id, name, LocalDateTime.now())
            .execute()
    }
}