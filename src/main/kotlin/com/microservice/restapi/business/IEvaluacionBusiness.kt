package com.microservice.restapi.business

import com.microservice.restapi.Model.Evaluacion

interface IEvaluacionBusiness {
    fun list():List<Evaluacion>
    fun load(idEvaluacion:Long): Evaluacion
    fun save(evaluacion:Evaluacion): Evaluacion
    fun remove(idEvaluacion: Long)
}