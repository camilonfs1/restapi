package com.microservice.restapi.Model

import java.time.LocalDate
import java.util.*
import javax.persistence.*


@Entity
@Table (name = ("evaluacion").toString())
data class Evaluacion(val dni: Int = 0, val nombre:String = "", val appellido:String = "", val fechaNac: LocalDate? =null) {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id:Long = 0
}