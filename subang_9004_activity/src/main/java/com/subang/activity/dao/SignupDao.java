package com.subang.activity.dao;

import com.subang.activity.pojo.Signup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SignupDao extends JpaSpecificationExecutor<Signup>, JpaRepository<Signup, String> {
}
