package demo.PoemWithMe.global;

import demo.PoemWithMe.domain.member.Member;
import demo.PoemWithMe.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String loginId) throws UsernameNotFoundException {
        Member member = memberRepository.findByName(loginId)
                .orElseThrow(() -> new UsernameNotFoundException("존재하지 않는 사용자 입니다." + loginId));
        return new UserDetailsImpl(member);
    }
}
