package com.example.naucime.db

import com.example.naucime.model.Professor
import com.example.naucime.model.Student

class InMemoryDatabaseService : DatabaseService {


    var ProfessorList : MutableList<Professor> = mutableListOf()
    var StudentList : MutableList<Student> = mutableListOf()



    override fun connect(): DatabaseService {
        return this
    }

    override fun getProfessors(): List<Professor> {
        return emptyList()
    }

    override fun getStudents(): List<Student> {
        TODO("Not yet implemented")
    }


}