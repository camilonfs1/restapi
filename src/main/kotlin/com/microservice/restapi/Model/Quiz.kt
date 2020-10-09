package com.microservice.restapi.Model

import java.time.LocalDate
import java.util.*
import javax.persistence.*



@Entity
@Table (name = ("quiz").toString())
data class Quiz(val id_student: Int = 0, val qualification:String = "", val type:String = "", val date: LocalDate? =null) {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id:Long = 0
}