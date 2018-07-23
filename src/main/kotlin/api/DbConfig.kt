package api

import api.models.Positions
import api.models.Users
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils.create
import org.jetbrains.exposed.sql.transactions.transaction

object DbConfig{

    fun init() {

        val db by lazy {
            Database.connect("jdbc:postgresql://localhost:5432/ktor-api?user=bmonsalves", driver = "org.postgresql.Driver")
            transaction {
                create(Positions)
                create(Users)
            }

        }
    }
}