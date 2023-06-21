package com.icia.springbootband230621.repository;

import com.icia.springbootband230621.entity.BandMemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface bandMemberRepository extends JpaRepository<BandMemberEntity, Long> {
}
