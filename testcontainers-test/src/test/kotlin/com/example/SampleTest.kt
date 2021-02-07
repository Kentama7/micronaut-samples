package com.example

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.testcontainers.containers.PostgreSQLContainer
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers
import java.sql.DriverManager

@Testcontainers
class SampleTest {

    @Container
    private val container = PostgreSQLContainer<Nothing>("postgres:11")
        .apply {
            withDatabaseName("foo")
            withUsername("bar")
            withPassword("baz")
            withInitScript("1.sql")
        }


    @Test
    fun `should perform simple query`() {

        DriverManager.getConnection(container.jdbcUrl, container.username, container.password)
            .use { conn ->

                conn.createStatement().use { stmt ->

                    stmt.executeQuery("SELECT * FROM customer").use { resultSet ->

                        resultSet.next()

                        Assertions.assertEquals(resultSet.getInt(1), 0)
                    }
                }
            }
    }
}


@Testcontainers
class KotlinSimpleQueryTest {

    @Container
    private val container = PostgreSQLContainer<Nothing>("postgres:11")


    @Test
    fun `should perform simple query`() {

        DriverManager.getConnection(container.jdbcUrl, container.username, container.password)
            .use { conn ->

                conn.createStatement().use { stmt ->

                    stmt.executeQuery("SELECT 1").use { resultSet ->

                        resultSet.next()

                        Assertions.assertEquals(resultSet.getInt(1), 1)
                    }
                }
            }
    }


}