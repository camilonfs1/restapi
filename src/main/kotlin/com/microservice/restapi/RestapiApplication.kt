package com.microservice.restapi

import com.microservice.restapi.Model.Evaluation
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
		val evaluation1 = Evaluation(123456,"3.2","tarea", LocalDate.parse("10-02-2055",formatter))

		evaluationRepository!!.save(evaluation1)
	}

}

fun main(args: Array<String>) {
	runApplication<RestapiApplication>(*args)

}


