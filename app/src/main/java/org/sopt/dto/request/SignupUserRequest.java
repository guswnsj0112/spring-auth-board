package org.sopt.dto.request;

public record SignupUserRequest (
        String email,
        String nickName,
        String password
){

}
