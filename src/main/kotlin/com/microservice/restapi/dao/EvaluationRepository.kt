package com.microservice.restapi.dao

import com.microservice.restapi.Model.Evaluacion
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface EvaluationRepository: JpaRepository<Evaluacion,Long>