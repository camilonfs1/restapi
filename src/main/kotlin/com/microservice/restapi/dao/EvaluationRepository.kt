package com.microservice.restapi.dao

import com.microservice.restapi.Model.Evaluation
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository


@Repository
interface EvaluationRepository: JpaRepository<Evaluation, Long>{

    @Query(value = "select * from evaluation where student = :student_name", nativeQuery = true)
    fun evaluationbyStudent(@Param("student_name") student_name: String): List<Evaluation?>?

}

