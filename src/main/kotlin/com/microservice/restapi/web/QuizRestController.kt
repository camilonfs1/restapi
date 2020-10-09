package com.microservice.restapi.web

import com.microservice.restapi.Model.Evaluation
import com.microservice.restapi.Model.Quiz
import com.microservice.restapi.business.IEvaluationBusiness
import com.microservice.restapi.business.IQuizBusiness
import com.microservice.restapi.exceptions.BusinessException
import com.microservice.restapi.exceptions.NotFoundException
import com.microservice.restapi.utils.Constants
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(Constants.URL_BASE_QUIZ)
class QuizRestController {

    @Autowired
    val quizBusiness: IQuizBusiness? = null

    @GetMapping("")
    fun list(): ResponseEntity<List<Quiz>> {
        return try {
            ResponseEntity(quizBusiness!!.list(), HttpStatus.OK)
        } catch (e: Exception) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @GetMapping("/{id}")
    fun load(@PathVariable("id") idQuiz: Long): ResponseEntity<Any> {
        return try {
            ResponseEntity(quizBusiness!!.load(idQuiz), HttpStatus.OK)
        } catch (e: BusinessException) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }catch (e: NotFoundException) {
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

    @PostMapping("")
    fun insert(@RequestBody quiz: Quiz):ResponseEntity<Any>{
        return try {
            quizBusiness!!.save(quiz)
            val responseHeader = HttpHeaders()
            responseHeader.set("location", Constants.URL_BASE_QUIZ+"/"+quiz.id)
            ResponseEntity(responseHeader,HttpStatus.CREATED)
        }catch (e: BusinessException){
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @PutMapping("")
    fun update(@RequestBody quiz: Quiz): ResponseEntity<Any>{
        return try{
            quizBusiness!!.save(quiz)
            ResponseEntity(HttpStatus.OK)
        }catch (e: BusinessException){
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") idQuiz: Long): ResponseEntity<Any>{
        return try{
            quizBusiness!!.remove(idQuiz)
            ResponseEntity(HttpStatus.OK)
        }catch (e: BusinessException) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }catch (e: NotFoundException) {
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

}