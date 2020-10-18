package com.microservice.restapi.business

import com.microservice.restapi.Model.Evaluation

interface IEvaluationBusiness {
    fun list():List<Evaluation>
    fun load(idEvaluation:Long): Evaluation
    fun load_student_eva(student:String): List<Evaluation>
    fun save(evaluation:Evaluation): Evaluation
    fun remove(idEvaluation: Long)

}