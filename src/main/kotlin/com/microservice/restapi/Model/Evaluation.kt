package com.microservice.restapi.Model

import java.time.LocalDate
import java.util.*
import javax.persistence.*



@Entity
@Table (name = ("evaluation").toString())
data class Evaluation(val id_student: Int = 0, val qualification:String = "", val type:String = "", val date: String? =null) {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id:Long = 0
}