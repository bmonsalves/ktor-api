package api.services

import api.models.User

class UserService {

    fun getAll(): List<User>{

        val list = mutableListOf<User>()

        list.add(User(1,"bernardo","monsalves",30))

        return list
    }

    fun getUser(id: Int?): User {
        return User(id,"bernardo","monsalves",30)
    }

    fun addUser(user: User): User{
        return user
    }

    fun deleteUser(id: Int?):Boolean{
        return true
    }

}