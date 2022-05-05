package com.example.naucime.model

import kotlinx.serialization.Serializable

@Serializable
class Lesson constructor(lName: String, lPrice: Int, sProfessor: Professor){
    var name : String
    var price: Int
    var professor : Professor

    init {
        name = lName
        price = lPrice
        professor = sProfessor
    }

    var subscribers : MutableList<Student> = mutableListOf<Student>()


}