package com.icia.springbootband230621.repository;

import com.icia.springbootband230621.entity.BandMemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BandMemberRepository extends JpaRepository<BandMemberEntity, Long> {

}
