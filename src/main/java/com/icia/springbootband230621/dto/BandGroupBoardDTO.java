package com.icia.springbootband230621.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BandGroupBoardDTO {
    private Long id;
    private String boardTitle;
    private String boardContents;
    private String createMemberId;
    private LocalDateTime boardCreateAt;
    private List<MultipartFile> boardProfileFile;
    private List<String> boardOriginalFileName;
    private List<String> boardStoredFileName;



}
