package org.sopt.service;

import lombok.RequiredArgsConstructor;

import org.sopt.dto.request.SignupUserRequest;
import org.sopt.entity.User;
import org.sopt.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public User register(SignupUserRequest request) {

        if (userRepository.existsByEmail(request.email())) {
            throw new IllegalArgumentException("이미 존재하는 이메일입니다.");
        }

        //비밀번호 암호화는 조금 더 공부하고 넣을 예정
        User savedUser = userRepository.save(new User(
                request.email(),
                request.nickName(),
                request.password()
        ));
        return savedUser;

    }
}
