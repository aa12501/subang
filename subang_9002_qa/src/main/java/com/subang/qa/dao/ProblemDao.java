package com.subang.qa.dao;

import com.subang.qa.pojo.Problem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ProblemDao extends JpaRepository<Problem, String>, JpaSpecificationExecutor<Problem> {
}
