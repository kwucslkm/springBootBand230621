package com.icia.springbootband230621.entity;

import javax.persistence.*;

@Entity
public class BandMemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @Column(length = 40, nullable = false,unique = true)
    public String memberEmail;
    @Column(length = 20, nullable = false)
    public String memberPassword;
    @Column(length = 30,nullable = false,unique = true)
    public String memberNickName;
    @Column(length = 20, nullable = false,unique = true)
    public String memberMobile;
    @Column(length = 30, nullable = false)
    public String memberLocal;
    @Column(length = 40, nullable = false)
    public String memberInterest;

}
