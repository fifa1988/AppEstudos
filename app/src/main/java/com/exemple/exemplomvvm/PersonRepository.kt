package com.exemple.exemplomvvm

class PersonRepository {
    fun login(email: String, password: String): Boolean {
        return (email == "admin") && (password == "pass")
    }
}