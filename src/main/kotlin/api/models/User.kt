package api.models

import org.jetbrains.exposed.sql.Table
import org.joda.time.DateTime

object Users : Table() {
    val id = integer("id").primaryKey().autoIncrement()
    val name = varchar("name", 255)
    val lastname = varchar("lastname",255)
    val age = integer("quantity")
    val createdAt = DateTime("createdAt")
    val updatedAt = DateTime("updatedAt")
    val positionId = (integer("positionId") references Positions.id).nullable()
}

data class User(
        val id: Int?,
        val name: String?,
        val lastname: String?,
        val age:Int?
)