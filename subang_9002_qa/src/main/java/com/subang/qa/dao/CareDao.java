package com.subang.qa.dao;

import com.subang.qa.pojo.Care;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CareDao extends JpaSpecificationExecutor<Care>, JpaRepository<Care, String> {
}
