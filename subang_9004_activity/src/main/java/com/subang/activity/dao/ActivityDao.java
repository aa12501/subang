package com.subang.activity.dao;

import com.subang.activity.pojo.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ActivityDao extends JpaRepository<Activity, String>, JpaSpecificationExecutor<Activity> {
}
