package com.microservice.restapi.web

import com.microservice.restapi.Model.Evaluation
import com.microservice.restapi.business.IEvaluationBusiness
import com.microservice.restapi.exceptions.BusinessException
import com.microservice.restapi.exceptions.NotFoundException
import com.microservice.restapi.utils.Constants
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(Constants.URL_BASE_EVALUATION)
class PersonaRestController {

    @Autowired
    val evaluacionBusiness: IEvaluationBusiness? = null

    @GetMapping("")
    fun list(): ResponseEntity<List<Evaluation>> {
        return try {
            ResponseEntity(evaluacionBusiness!!.list(), HttpStatus.OK)
        } catch (e: Exception) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @GetMapping("/{id}")
    fun load(@PathVariable("id") idEvaluation: Long): ResponseEntity<Any> {
        return try {
            ResponseEntity(evaluacionBusiness!!.load(idEvaluation), HttpStatus.OK)
        } catch (e: BusinessException) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }catch (e: NotFoundException) {
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

    @PostMapping("")
    fun insert(@RequestBody evaluation: Evaluation):ResponseEntity<Any>{
        return try {
            evaluacionBusiness!!.save(evaluation)
            val responseHeader = HttpHeaders()
            responseHeader.set("location", Constants.URL_BASE_EVALUATION+"/"+evaluation.id)
            ResponseEntity(responseHeader,HttpStatus.CREATED)
        }catch (e: BusinessException){
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @PutMapping("")
    fun update(@RequestBody evaluation: Evaluation): ResponseEntity<Any>{
        return try{
            evaluacionBusiness!!.save(evaluation)
            ResponseEntity(HttpStatus.OK)
        }catch (e: BusinessException){
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") idEvaluation: Long): ResponseEntity<Any>{
        return try{
            evaluacionBusiness!!.remove(idEvaluation)
            ResponseEntity(HttpStatus.OK)
        }catch (e: BusinessException) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }catch (e: NotFoundException) {
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

}