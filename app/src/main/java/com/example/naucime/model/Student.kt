package com.example.naucime.model

import kotlinx.serialization.Serializable

@Serializable
class Student (sName: String, sLastName: String) {
    var name: String;
    var lastName: String;

    init {
        name = sName;
        lastName = sLastName;
    }

    // da li kada dodam u lesson novog studenta mogu da vidim da je on dodat iz profesora
    fun subscribeToLesson(lname: String, lprice: Int, profesorName: String, profesorLastName: String) {
        //pronadjem profesora sa datim imenom i prezimenom (za to mi treba nesto sto imitira bazu i skladisti podatke
        //trajno, kada ga pronadjem, pronadjem dati cas iz profesor.lessons i onda za dati pronadjeni
        //cas dodam prijavljenog studenta


    }

}