package com.microservice.restapi

import com.microservice.restapi.Model.Evaluacion
import com.microservice.restapi.dao.EvaluationRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@SpringBootApplication
class RestapiApplication:CommandLineRunner{
	@Autowired
	val evaluationRepository: EvaluationRepository? = null
	override fun run(vararg args: String?) {
		val formatter =  DateTimeFormatter.ofPattern("MM-dd-yyyy")
		val evaluation1 = Evaluacion(123456,"camio","vargas", LocalDate.parse("10-02-1997",formatter))

		evaluationRepository!!.save(evaluation1)
	}

}

fun main(args: Array<String>) {
	runApplication<RestapiApplication>(*args)

}
