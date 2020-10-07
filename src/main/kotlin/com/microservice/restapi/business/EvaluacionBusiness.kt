package com.microservice.restapi.business

import com.microservice.restapi.Model.Evaluacion
import com.microservice.restapi.dao.EvaluationRepository
import com.microservice.restapi.exceptions.BusinessException
import com.microservice.restapi.exceptions.NotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.lang.Exception
import java.util.*

@Service
class EvaluacionBusiness : IEvaluacionBusiness {

    @Autowired
    val evaluacionRepository: EvaluationRepository? = null

    override fun list(): List<Evaluacion> {
        try {
            return evaluacionRepository!!.findAll()
        } catch (e: Exception) {
            throw BusinessException(e.message)
        }
    }

    @Throws(BusinessException::class,NotFoundException::class)
    override fun load(idEvaluacion: Long): Evaluacion {
        val op: Optional<Evaluacion>
        try {
            op = evaluacionRepository!!.findById(idEvaluacion)
        } catch (e: Exception) {
            throw BusinessException(e.message)
        }
        if (!op.isPresent) {
            throw NotFoundException("No se encontro la evaluacion con id $idEvaluacion")
        }
        return op.get()
    }
    @Throws(BusinessException::class)
    override fun save(evaluacion: Evaluacion): Evaluacion {
        try {
            return evaluacionRepository!!.save(evaluacion)
        }catch (e:Exception){
            throw BusinessException(e.message)
        }
    }

    @Throws(BusinessException::class)
    override fun remove(idEvaluacion: Long) {
        val op: Optional<Evaluacion>
        try {
            op = evaluacionRepository!!.findById(idEvaluacion)
        }catch (e:Exception){
            throw BusinessException(e.message)
        }
        if (!op.isPresent) {
            throw NotFoundException("No se encontro la evaluacion con id $idEvaluacion")
        }else{
            try {
                evaluacionRepository!!.deleteById(idEvaluacion)
            }catch (e:Exception){
                throw BusinessException(e.message)
            }
        }
    }

}