package demo.PoemWithMe.domain.member.controller;

import demo.PoemWithMe.domain.member.Member;
import demo.PoemWithMe.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/find/{id}")
    public Member getMemberById(@PathVariable Long id){
        Optional<Member> result = memberService.findById(id);
            return result.orElse(null);
    }
}
