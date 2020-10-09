package com.microservice.restapi.dao

import com.microservice.restapi.Model.Evaluation
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface EvaluationRepository: JpaRepository<Evaluation,Long>