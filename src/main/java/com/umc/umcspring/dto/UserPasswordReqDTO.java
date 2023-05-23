package com.umc.umcspring.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserPasswordReqDTO {
    private String email;
    private String prePassword;
    private String newPassword;
}
