package com.example.week6_assignment1.model

val listStudents = mutableListOf<Student>()
class Database {
    fun appendStudent(student:Student){
        listStudents.add(student)
    }
    fun returnStudent():MutableList<Student>{
        return listStudents
    }

}

