package com.icia.springbootband230621.entity;

import com.icia.springbootband230621.dto.BandMemberDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "band_member_table")
public class BandMemberEntity {
    @Id // pk 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    private Long id;
    @Column(length = 40, nullable = false, unique = true)
    private String memberEmail;
    @Column(length = 20, nullable = true)
    private String memberPassword;
    @Column(length = 30, nullable = true, unique = true)
    private String memberName;
    @Column(length = 30, nullable = true, unique = true)
    private String memberNickName;
    @Column(length = 20, nullable = true, unique = true)
    private String memberMobile;
    @Column(length = 30, nullable = true)
    private String memberLocal;
    @Column(length = 40, nullable = true)
    private String memberInterest;
    @Column(length = 40, nullable = true)
    private String memberBirth;
    @Column(length = 40, nullable = true)
    private String memberCreateAt;
    @Column(length = 40, nullable = true)
    private String memberProfileFile;
    @Column(length = 40, nullable = true)
    private String memberOriginalFileName;
    @Column(length = 40, nullable = true)
    private String memberStoredFileName;

    public static BandMemberEntity toBandMemberEntity(BandMemberDTO bandMemberDTO) {
        BandMemberEntity bandMemberEntity = new BandMemberEntity();
        bandMemberEntity.setMemberEmail(bandMemberDTO.getMemberEmail());
        bandMemberEntity.setMemberPassword(bandMemberEntity.getMemberPassword());
        bandMemberEntity.setMemberBirth(bandMemberEntity.getMemberBirth());
        bandMemberEntity.setMemberCreateAt(bandMemberEntity.getMemberCreateAt());
        bandMemberEntity.setMemberName(bandMemberEntity.getMemberName());
        bandMemberEntity.setMemberNickName(bandMemberEntity.getMemberNickName());
        bandMemberEntity.setMemberLocal(bandMemberEntity.getMemberLocal());
        bandMemberEntity.setMemberMobile(bandMemberEntity.getMemberMobile());
        bandMemberEntity.setMemberInterest(bandMemberEntity.getMemberInterest());
        bandMemberEntity.setMemberProfileFile(bandMemberEntity.getMemberProfileFile());
        bandMemberEntity.setMemberOriginalFileName(bandMemberEntity.getMemberOriginalFileName());
        bandMemberEntity.setMemberStoredFileName(bandMemberEntity.getMemberStoredFileName());

        return bandMemberEntity;
    }
}