package com.microservice.restapi.business

import com.microservice.restapi.Model.Quiz

interface IQuizBusiness {
    fun list():List<Quiz>
    fun load(idQuiz:Long): Quiz
    fun save(quiz:Quiz): Quiz
    fun remove(idQuiz: Long)

}