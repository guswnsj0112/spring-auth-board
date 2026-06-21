package org.sopt.auth.dto.request;

public record SignupUserRequest (
        String email,
        String nickName,
        String password
){

}
