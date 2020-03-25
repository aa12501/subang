package com.subang.activity.dao;

import com.subang.activity.pojo.Pic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PicDao extends JpaRepository<Pic, String>, JpaSpecificationExecutor<Pic> {
}
