package org.zerock.api01.security;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.zerock.api01.domain.APIUser;
import org.zerock.api01.dto.APIUserDTO;
import org.zerock.api01.repository.APIUserRepository;

import java.util.List;
import java.util.Optional;

@Service
@Log4j2
@RequiredArgsConstructor
public class APIUserDetailsService implements UserDetailsService {

    private final APIUserRepository apiUserRepository;

    //스프링 사용의 핵심(authentication())
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //UserDetails를 구현한 User를 상속한 APIUserDTO를 생성후 반환하자 (권한 구현부분을 상속받음)
        Optional<APIUser> result = apiUserRepository.findById(username);
        APIUser apiUser = result.orElseThrow(() -> new UsernameNotFoundException("Cannot find mid"));
        log.info("APIUserDetailsService apiUser-----");
        APIUserDTO apiUserDTO = new APIUserDTO(
                apiUser.getMid(),
                apiUser.getMpw(),
                List.of(new SimpleGrantedAuthority("ROLE_USER"))
        );
        log.info(apiUserDTO);
        return apiUserDTO;
    }
}
