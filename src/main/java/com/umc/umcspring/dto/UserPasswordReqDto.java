package com.umc.umcspring.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserPasswordReqDto {
    private String email;
    private String prePassword;
    private String newPassword;
}
