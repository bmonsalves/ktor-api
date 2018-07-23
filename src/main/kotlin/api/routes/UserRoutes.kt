package api.routes

import api.models.User
import api.services.UserService
import io.ktor.application.call
import io.ktor.http.HttpStatusCode
import io.ktor.request.receive
import io.ktor.response.respond
import io.ktor.routing.*

fun Route.user(userService: UserService){

    route("/user"){

        get("/") {
            call.respond(userService.getAll())
        }

        get("/{id}") {

            val id = try {
                call.parameters["id"]?.toInt()
            }catch (e: NumberFormatException){
                null
            }

            if (id == null) call.respond(HttpStatusCode.BadRequest)

            val user = userService.getUser(id)
            if (user == null) call.respond(HttpStatusCode.NotFound)

            call.respond(user)
        }


        post("/") {
            val user = call.receive<User>()
            call.respond(userService.addUser(user))
        }

        delete("/{id}"){

            val id = try {
                call.parameters["id"]?.toInt()
            }catch (e: NumberFormatException){
                null
            }

            if (id == null) call.respond(HttpStatusCode.BadRequest)

            val confirm = userService.deleteUser(id)
            if (confirm) call.respond(HttpStatusCode.NotFound)

            call.respond(confirm)
        }
    }
}