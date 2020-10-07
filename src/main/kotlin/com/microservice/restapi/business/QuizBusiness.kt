package com.microservice.restapi.business

import com.microservice.restapi.Model.Quiz
import com.microservice.restapi.dao.QuizRepository
import com.microservice.restapi.exceptions.BusinessException
import com.microservice.restapi.exceptions.NotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.lang.Exception
import java.util.*

@Service
class QuizBusiness: IQuizBusiness  {


    @Autowired
    val QuizRepository: QuizRepository? = null

    override fun list(): List<Quiz> {
        try {
            return QuizRepository!!.findAll()
        } catch (e: Exception) {
            throw BusinessException(e.message)
        }
    }

    @Throws(BusinessException::class, NotFoundException::class)
    override fun load(idQuiz: Long): Quiz {
        val op: Optional<Quiz>
        try {
            op = QuizRepository!!.findById(idQuiz)
        } catch (e: Exception) {
            throw BusinessException(e.message)
        }
        if (!op.isPresent) {
            throw NotFoundException("No se encontro la evaluacion con id $idQuiz")
        }
        return op.get()
    }
    @Throws(BusinessException::class)
    override fun save(quiz: Quiz): Quiz {
        try {
            return QuizRepository!!.save(quiz)
        }catch (e: Exception){
            throw BusinessException(e.message)
        }
    }

    @Throws(BusinessException::class)
    override fun remove(idQuiz: Long) {
        val op: Optional<Quiz>
        try {
            op = QuizRepository!!.findById(idQuiz)
        }catch (e: Exception){
            throw BusinessException(e.message)
        }
        if (!op.isPresent) {
            throw NotFoundException("No se encontro la evaluacion con id $idQuiz")
        }else{
            try {
                QuizRepository!!.deleteById(idQuiz)
            }catch (e: Exception){
                throw BusinessException(e.message)
            }
        }
    }
}