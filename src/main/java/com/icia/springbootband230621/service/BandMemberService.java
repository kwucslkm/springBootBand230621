package com.icia.springbootband230621.service;

import com.icia.springbootband230621.dto.BandMemberDTO;
import com.icia.springbootband230621.entity.BandMemberEntity;
import com.icia.springbootband230621.repository.BandMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BandMemberService {

    private final BandMemberRepository bandMemberRepository;

    public void save(BandMemberDTO bandMemberDTO){
        System.out.println("bandMemberDTO = " + bandMemberDTO);
        BandMemberEntity bandMemberEntity =  BandMemberEntity.toBandMemberEntity(bandMemberDTO);
        bandMemberRepository.save(bandMemberEntity);

    }

    public BandMemberDTO login(BandMemberDTO bandMemberDTO) {

        Optional<BandMemberEntity> byMemberEmail = bandMemberRepository.findByMemberEmail(bandMemberDTO.getMemberEmail());
        if (byMemberEmail.isPresent()) {
            BandMemberEntity memberEntity = byMemberEmail.get();
            if (memberEntity.getMemberPassword().equals(bandMemberDTO.getMemberPassword())) {
                System.out.println("로그인 성공");
                BandMemberDTO memberDTO = BandMemberDTO.toMemberDTO(memberEntity);
                return memberDTO;
            } else {
                return null;
            }
        }else {
            return null;
        }
    }

    public List<BandMemberDTO> findAll() {
        List<BandMemberEntity> bandMemberEntityList = bandMemberRepository.findAll();
        List<BandMemberDTO> memberDTOList = new ArrayList<>();
        for (BandMemberEntity bandMemberEntity: bandMemberEntityList){
            memberDTOList.add(BandMemberDTO.toMemberDTO(bandMemberEntity));
        }
        return memberDTOList;
    }

    public BandMemberDTO findById(Long id) {
        Optional<BandMemberEntity> optionalBandMemberEntity = bandMemberRepository.findById(id);
        return BandMemberDTO.toMemberDTO(optionalBandMemberEntity.get());
    }
}
