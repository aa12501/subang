package com.subang.lost.dao;

import com.subang.lost.pojo.Pic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PicDao extends JpaRepository<Pic, String>, JpaSpecificationExecutor<Pic> {
}
