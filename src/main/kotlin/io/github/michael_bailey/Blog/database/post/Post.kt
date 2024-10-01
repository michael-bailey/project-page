package io.github.michael_bailey.Blog.database.post

import org.jetbrains.exposed.dao.UUIDEntity
import org.jetbrains.exposed.dao.UUIDEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import java.util.*

class Post(
	id: EntityID<UUID>
): UUIDEntity(id = id) {
	companion object: UUIDEntityClass<Post>(PostTable)

	var title by PostTable.title
	var content by PostTable.content

	val time by PostTable.time
}