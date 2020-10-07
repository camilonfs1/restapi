package com.microservice.restapi.Model

import java.time.LocalDate
import javax.persistence.*


@Entity
@Table(name = ("quiz").toString())
class Quiz(val id_estudiante: Int = 0,  val nota:Int = 0, val fecha: LocalDate? =null) {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id_quiz:Long = 0
}