package com.microservice.restapi.business

import com.microservice.restapi.Model.Evaluation
import com.microservice.restapi.dao.EvaluationRepository
import com.microservice.restapi.exceptions.BusinessException
import com.microservice.restapi.exceptions.NotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.lang.Exception
import java.util.*

@Service
class EvaluationBusiness : IEvaluationBusiness {

    @Autowired
    val evaluacionRepository: EvaluationRepository? = null

    override fun list(): List<Evaluation> {
        try {
            return evaluacionRepository!!.findAll()
        } catch (e: Exception) {
            throw BusinessException(e.message)
        }
    }

    @Throws(BusinessException::class,NotFoundException::class)
    override fun load(idEvaluation: Long): Evaluation {
        val op: Optional<Evaluation>
        try {
            op = evaluacionRepository!!.findById(idEvaluation)
        } catch (e: Exception) {
            throw BusinessException(e.message)
        }
        if (!op.isPresent) {
            throw NotFoundException("No se encontro la evaluacion con id $idEvaluation")
        }
        return op.get()
    }
    @Throws(BusinessException::class)
    override fun save(evaluation: Evaluation): Evaluation {
        try {
            return evaluacionRepository!!.save(evaluation)
        }catch (e:Exception){
            throw BusinessException(e.message)
        }
    }

    @Throws(BusinessException::class)
    override fun remove(idEvaluation: Long) {
        val op: Optional<Evaluation>
        try {
            op = evaluacionRepository!!.findById(idEvaluation)
        }catch (e:Exception){
            throw BusinessException(e.message)
        }
        if (!op.isPresent) {
            throw NotFoundException("No se encontro la evaluacion con id $idEvaluation")
        }else{
            try {
                evaluacionRepository!!.deleteById(idEvaluation)
            }catch (e:Exception){
                throw BusinessException(e.message)
            }
        }
    }



}