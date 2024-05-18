package com.icia.springbootband230621.controller;

import com.fasterxml.jackson.databind.deser.std.StringArrayDeserializer;
import com.icia.springbootband230621.dto.BandMemberDTO;
import com.icia.springbootband230621.service.BandMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class MemberController {
    private final BandMemberService bandMemberService;
    //회원가입 페이지 출력 요청
    @GetMapping("/bandMemberPages/saveForm")
    public String save(){
        return "bandMemberPages/saveForm";
    }
    @PostMapping("/bandMemberPages/saveForm")
    public String saveForm(@ModelAttribute BandMemberDTO bandMemberDTO){
        System.out.println("MemberController.saveForm");
        System.out.println("bandMemberDTO = " + bandMemberDTO);
        bandMemberService.save(bandMemberDTO);
        return "bandMemberPages/bandMemberLogin";
    }
    @PostMapping("/bandMemberPages/bandMemberLogin")
    public String login(@ModelAttribute BandMemberDTO bandMemberDTO,
                        HttpSession httpSession){
        BandMemberDTO loginResult = bandMemberService.login(bandMemberDTO);
        if (loginResult != null){
            httpSession.setAttribute("loginEmail", loginResult.getMemberEmail());
            return "main";
        }else {
            return "bandMemberPages/bandMemberLogin";
        }

    }
}
