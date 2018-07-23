package api.models

import org.jetbrains.exposed.sql.Table
import org.joda.time.DateTime

object Positions : Table() {
    val id = integer("id").primaryKey().autoIncrement()
    val name = varchar("name", 255)
    val slug = varchar("slug",255)
    val createdAt = DateTime("createdAt")
    val updatedAt = DateTime("updatedAt")
}

data class Position(
        val id: Int?,
        val name: String?,
        val slug: String?
)