package io.github.michael_bailey.Blog.database.post

import io.github.michael_bailey.Blog.database.UUIDTable
import kotlinx.datetime.toKotlinLocalDateTime
import org.jetbrains.exposed.sql.kotlin.datetime.datetime
import java.time.LocalDateTime

object PostTable: UUIDTable() {
	val title = text("title")
	val content = text("content")

	val time = datetime("created_time")
		.clientDefault { LocalDateTime.now().toKotlinLocalDateTime() }
}