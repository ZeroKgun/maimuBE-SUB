package com.maimu.login.sociallogin.service.implement;

import com.maimu.login.sociallogin.dto.request.auth.IdCheckRequestDto;
import com.maimu.login.sociallogin.dto.request.auth.SignInRequestDto;
import com.maimu.login.sociallogin.dto.request.auth.SignUpRequestDto;
import com.maimu.login.sociallogin.dto.response.ResponseDto;
import com.maimu.login.sociallogin.dto.response.auth.IdCheckResponseDto;
import com.maimu.login.sociallogin.dto.response.auth.SignInResponseDto;
import com.maimu.login.sociallogin.dto.response.auth.SignUpResponseDto;
import com.maimu.login.sociallogin.entity.Users;
import com.maimu.login.sociallogin.provider.JwtProvider;
import com.maimu.login.sociallogin.repository.UsersRepository;
import com.maimu.login.sociallogin.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImplement implements AuthService {

    private final UsersRepository usersRepository;
    private final JwtProvider jwtProvider;
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    @Override
    public ResponseEntity<? super IdCheckResponseDto> idCheck(IdCheckRequestDto dto) {
        try{
            String email = dto.getEmail();
            boolean isExistId = usersRepository.existsByEmail(email);
            if(isExistId) return IdCheckResponseDto.duplicateId();
        } catch (Exception exception){
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return IdCheckResponseDto.success();
    }

    @Override
    public ResponseEntity<? super SignUpResponseDto> signUp(SignUpRequestDto dto) {
        try{
            String email = dto.getEmail();
            boolean isExistId = usersRepository.existsByEmail(email);
            if(isExistId) return SignUpResponseDto.duplicatedId();

//            String password = dto.getPassword();
//            String encodedPassword = passwordEncoder.encode(password);
//            dto.setPassword(encodedPassword);

            Users users = new Users(dto);
            usersRepository.save(users);


        } catch(Exception exception){
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return SignUpResponseDto.success();
    }

    @Override
    public ResponseEntity<? super SignInResponseDto> signIn(SignInRequestDto dto) {
        String token = null;

        try{
            String email = dto.getEmail();
            Users users = usersRepository.findByEmail(email);
            if(users == null) SignInResponseDto.signInFail();

//            String password = dto.getPassword();
//            String encodedPassword = users.getPassword();
//            boolean isMatched = passwordEncoder.matches(password, encodedPassword);
//            if(!isMatched) return SignInResponseDto.signInFail();

            token = jwtProvider.create(email);

        } catch(Exception exception){
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return SignInResponseDto.success(token);
    }
}
