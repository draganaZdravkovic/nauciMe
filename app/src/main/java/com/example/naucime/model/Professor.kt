package com.example.naucime.model

import kotlinx.serialization.Serializable


@Serializable
class Professor (id: Int, fName: String, lName: String){

    var pId: Int
    var name: String
    var lastName: String;
    var contact: String = ""

    var lessons: MutableList<Lesson> = mutableListOf<Lesson>()


    init{
        pId = id
        name = fName
        lastName = lName
    }


    fun addLesson(lname: String, lprice: Int){
        var l: Lesson = Lesson(lname, lprice, this)
        this.lessons.add(l)
    }

    fun removeLessonByName(lName: String){
        for(l in lessons){
            if (l.name == lName)
                lessons.remove(l)
        }
    }

    fun getLessonByName(lname: String) : Lesson? {
        for (l in lessons){
            if(lname == l.name)
                return l
        }
        return null
    }




}