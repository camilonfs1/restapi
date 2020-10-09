package com.microservice.restapi.business

import com.microservice.restapi.Model.Evaluation

interface IEvaluationBusiness {
    fun list():List<Evaluation>
    fun load(idEvaluation:Long): Evaluation
    fun save(evaluation:Evaluation): Evaluation
    fun remove(idEvaluation: Long)

}