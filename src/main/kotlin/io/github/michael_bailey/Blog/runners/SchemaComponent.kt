package io.github.michael_bailey.Blog.runners

import io.github.michael_bailey.Blog.database.post.PostTable
import org.jetbrains.exposed.sql.SchemaUtils
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
@Transactional
class SchemaComponent: ApplicationRunner {
	override fun run(args: ApplicationArguments?) {
		SchemaUtils.create(PostTable)
	}
}