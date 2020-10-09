package com.microservice.restapi.dao

import com.microservice.restapi.Model.Evaluation
import com.microservice.restapi.Model.Quiz
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface QuizRepository: JpaRepository<Quiz,Long>