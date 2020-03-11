package com.subang.vote.dao;

import com.subang.vote.pojo.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface VoteDao extends JpaRepository<Vote, String>, JpaSpecificationExecutor<Vote> {
}
