package com.example.naucime.db

import com.example.naucime.model.Professor
import com.example.naucime.model.Student

interface DatabaseService {

    fun connect() : DatabaseService
    fun getProfessors (): List<Professor>
    fun getStudents () : List<Student>
}