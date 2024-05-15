package com.icia.springbootband230621.service;

import com.icia.springbootband230621.dto.BandMemberDTO;
import com.icia.springbootband230621.entity.BandMemberEntity;
import com.icia.springbootband230621.repository.BandMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BandMemberService {

    private final BandMemberRepository bandMemberRepository;

    public void save(BandMemberDTO bandMemberDTO){
        System.out.println("bandMemberDTO = " + bandMemberDTO);
        BandMemberEntity bandMemberEntity =  BandMemberEntity.toBandMemberEntity(bandMemberDTO);
        bandMemberRepository.save(bandMemberEntity);

    }

}
