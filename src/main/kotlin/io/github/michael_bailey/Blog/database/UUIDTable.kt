package io.github.michael_bailey.Blog.database

import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IdTable
import org.jetbrains.exposed.sql.Column
import java.util.*

open class UUIDTable(name: String = "", columnName: String = "id") : IdTable<UUID>(name) {
	override val id: Column<EntityID<UUID>> = uuid(columnName)
		.autoGenerate()
		.entityId()



	override val primaryKey by lazy { super.primaryKey ?: PrimaryKey(id) }
}