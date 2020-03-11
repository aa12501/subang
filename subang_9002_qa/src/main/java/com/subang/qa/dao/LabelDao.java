package com.subang.qa.dao;

import com.subang.qa.pojo.Label;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface LabelDao extends JpaRepository<Label, String>, JpaSpecificationExecutor<Label> {
}
