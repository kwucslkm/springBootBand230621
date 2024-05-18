package com.icia.springbootband230621.repository;

import com.icia.springbootband230621.entity.BandMemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BandMemberRepository extends JpaRepository<BandMemberEntity, Long> {

    Optional<BandMemberEntity> findByMemberEmail(String memberEmail);
}
