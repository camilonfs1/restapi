package com.microservice.restapi.web

import com.microservice.restapi.Model.Evaluacion
import com.microservice.restapi.business.IEvaluacionBusiness
import com.microservice.restapi.exceptions.BusinessException
import com.microservice.restapi.exceptions.NotFoundException
import com.microservice.restapi.utils.Constants
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(Constants.URL_BASE_PERSONAS)
class PersonaRestController {

    @Autowired
    val evaluacionBusiness: IEvaluacionBusiness? = null

    @GetMapping("")
    fun list(): ResponseEntity<List<Evaluacion>> {
        return try {
            ResponseEntity(evaluacionBusiness!!.list(), HttpStatus.OK)
        } catch (e: Exception) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @GetMapping("/{id}")
    fun load(@PathVariable("id") idPersona: Long): ResponseEntity<Any> {
        return try {
            ResponseEntity(evaluacionBusiness!!.load(idPersona), HttpStatus.OK)
        } catch (e: BusinessException) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }catch (e: NotFoundException) {
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

    @PostMapping("")
    fun insert(@RequestBody evaluacion: Evaluacion):ResponseEntity<Any>{
        return try {
            evaluacionBusiness!!.save(evaluacion)
            val responseHeader = HttpHeaders()
            responseHeader.set("location", Constants.URL_BASE_PERSONAS+"/"+evaluacion.id)
            ResponseEntity(responseHeader,HttpStatus.CREATED)
        }catch (e: BusinessException){
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @PutMapping("")
    fun update(@RequestBody evaluacion: Evaluacion): ResponseEntity<Any>{
        return try{
            evaluacionBusiness!!.save(evaluacion)
            ResponseEntity(HttpStatus.OK)
        }catch (e: BusinessException){
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") idPersona: Long): ResponseEntity<Any>{
        return try{
            evaluacionBusiness!!.remove(idPersona)
            ResponseEntity(HttpStatus.OK)
        }catch (e: BusinessException) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }catch (e: NotFoundException) {
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }
}