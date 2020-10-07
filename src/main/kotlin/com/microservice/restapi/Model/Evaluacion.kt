package com.microservice.restapi.Model

import java.time.LocalDate
import java.util.*
import javax.persistence.*


@Entity
@Table (name = ("evaluacion").toString())
data class Evaluacion(val id_estudiante: Int = 0, val tipo_repeticion:Int = 0, val nota:Int = 0, val fecha: LocalDate? =null) {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id_evaluacion:Long = 0
}