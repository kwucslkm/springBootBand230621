package com.icia.springbootband230621.controller;

import com.fasterxml.jackson.databind.deser.std.StringArrayDeserializer;
import com.icia.springbootband230621.dto.BandMemberDTO;
import com.icia.springbootband230621.service.BandMemberService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

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
    @GetMapping("/bandMemberPages/memberLogin")
    public String loginForm(){
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
    @GetMapping("/bandMemberPages/memberList")
    public String findAll(Model model){
        List<BandMemberDTO> bandMemberDTOList = bandMemberService.findAll();
        model.addAttribute("memberList", bandMemberDTOList);
        return "bandMemberPages/memberList";
    }
@GetMapping("/member/{id}")
    public String findById(@PathVariable Long id, Model model){
        BandMemberDTO memberDTO = bandMemberService.findById(id);
        model.addAttribute("member", memberDTO);
        return "bandMemberPages/memberDetail";
    }
@GetMapping("/bandMemberPages/bandMemberUpdate/{memberEmail}")
    public String memberUpdateForm(@PathVariable String memberEmail, Model model){
       BandMemberDTO memberDTO =  bandMemberService.findByMemberEmail(memberEmail);
//       System.out.println("memberDTO = " + memberDTO);
       model.addAttribute("member", memberDTO);
       return "bandMemberPages/memberUpdateForm";
    }

@GetMapping("bandMemberPages/bandMemberUpdate")
    public String memberUpdateFormM(HttpSession httpSession, Model model) {
        System.out.println("넘어는 오나=====");
        String memberEmail = (String) httpSession.getAttribute("loginEmail");
        BandMemberDTO memberDTO = bandMemberService.findByMemberEmail(memberEmail);
//    System.out.println("memberDTO = " + memberDTO);
        model.addAttribute("member", memberDTO);
        return "bandMemberPages/memberUpdateForm";
    }
@PostMapping("/bandMemberPages/bandMemberUpdate")
    public String memberUpdate(@ModelAttribute BandMemberDTO bandMemberDTO){
        bandMemberService.update(bandMemberDTO);
        return "redirect:/member/"+bandMemberDTO.getId();
    }
@GetMapping("/member/delete/{id}")
    public String memberDelete(@PathVariable Long id){
        bandMemberService.deleteById(id);
        return "redirect:/bandMemberPages/memberList";
}
}
