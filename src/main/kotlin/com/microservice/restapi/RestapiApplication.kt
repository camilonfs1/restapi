package com.microservice.restapi

import com.microservice.restapi.Model.Evaluacion
import com.microservice.restapi.Model.Quiz
import com.microservice.restapi.dao.EvaluationRepository
import com.microservice.restapi.dao.QuizRepository
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
	val quizRepository: QuizRepository? = null
	override fun run(vararg args: String?) {

		val formatter =  DateTimeFormatter.ofPattern("MM-dd-yyyy")

		val evaluation1 = Evaluacion(123456,1,10, LocalDate.parse("10-02-1997",formatter))

		val quiz1 = Quiz(25896,6, LocalDate.parse("10-02-1997",formatter))

		evaluationRepository!!.save(evaluation1)
		//quizRepository!!.save(quiz1)
	}
}

fun main(args: Array<String>) {
	runApplication<RestapiApplication>(*args)
}
