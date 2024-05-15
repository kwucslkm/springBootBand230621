package com.icia.springbootband230621.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BandMemberDTO {
    private Long id;
    private String memberEmail;
    private String memberPassword;
    private String memberName;
    private String memberNickName;
    private String memberMobile;
    private String memberLocal;
    private String memberInterest;
    private String memberBirth;
    private String memberCreateAt;
    private List<MultipartFile> memberProfileFile;
    private List<String> memberOriginalFileName;
    private List<String> memberStoredFileName;



}
