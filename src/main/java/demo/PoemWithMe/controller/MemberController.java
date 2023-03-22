package demo.PoemWithMe.controller;

import demo.PoemWithMe.domain.member.Member;
import demo.PoemWithMe.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/all")
    public List<Member> getMembers(){
        log.info("user call findAll");
        return memberService.findAll();
    }
}
