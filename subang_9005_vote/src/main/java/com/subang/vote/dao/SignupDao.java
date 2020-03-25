package com.subang.vote.dao;

import com.subang.vote.pojo.Signup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SignupDao extends JpaRepository<Signup, String>, JpaSpecificationExecutor<Signup> {
}
