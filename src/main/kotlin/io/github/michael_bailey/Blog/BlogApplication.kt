package io.github.michael_bailey.Blog

import org.jetbrains.exposed.spring.autoconfigure.ExposedAutoConfiguration
import org.springframework.boot.autoconfigure.ImportAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration
import org.springframework.boot.runApplication

@SpringBootApplication
class BlogApplication

fun main(args: Array<String>) {
	runApplication<BlogApplication>(*args)
}
