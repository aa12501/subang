package com.subang.lost.dao;

import com.subang.lost.pojo.Collect;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CollectDao extends JpaRepository<Collect, String>, JpaSpecificationExecutor<Collect> {
}
