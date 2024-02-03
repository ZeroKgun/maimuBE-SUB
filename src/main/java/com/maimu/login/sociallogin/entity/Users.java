package com.maimu.login.sociallogin.entity;


import com.maimu.login.sociallogin.dto.request.auth.SignUpRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
@Table(name= "users")
public class Users extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="users_id")
    private Long id;

    //oauth2 nickname
    @Column
    private String nickname;

    //oauth2 email
    @Column
    private String email;

    //social login type
    @Column
    private String type;

    //default ROLE_USER
    @Column
    private String role;

    //사용자 설정 생일
    @Column
    private String birth;

    //사용자 설정 nickname
    @Column
    private String maimuNickname;

    //maimu 프로필 사진
    //숫자? 로 저장?
    @Column
    private int profileImage;

    public Users(SignUpRequestDto dto){
        this.nickname = "max";
        this.email = dto.getEmail();
        this.type = "app";
        this.role = "ROLE_USER";
    }

    public Users (String nickname, String email, String type){
        this.nickname = nickname;
        this.email = email;
        this.type = type;
        this.role = "ROLE_USER";
        this.birth = null;
        this.maimuNickname = null;
        this.profileImage = 0;
    }
}