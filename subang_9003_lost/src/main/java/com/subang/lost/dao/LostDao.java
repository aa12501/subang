package com.subang.lost.dao;

import com.subang.lost.pojo.Lost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface LostDao extends JpaRepository<Lost, String>, JpaSpecificationExecutor<Lost> {
}
