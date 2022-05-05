package com.example.naucime.db

class DatabaseServiceProvider {

    companion object {
        val db : DatabaseService = InMemoryDatabaseService().connect()
    }
}