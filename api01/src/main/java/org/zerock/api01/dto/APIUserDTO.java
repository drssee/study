package org.zerock.api01.dto;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

@Getter
@Setter
@ToString
public class APIUserDTO extends User {
    private String mid;
    private String mpw;

    //부모클래스에서 기본생성자를 막아서 super()를 호출할수 없으니
    //부모클래스 생성자의 매개변수 형식을 맞춰서 호출해줘야함
    public APIUserDTO(String username,
                      String password,
                      Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
        //super 호출후 부모클래스가 생성된 뒤에 자식클래스가 생성됨
        this.mid = username;
        this.mpw = password;
    }
}
