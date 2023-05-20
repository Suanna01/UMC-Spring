package com.umc.umcspring.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor(staticName = "of")
public class DefalutResDTO<D> {
    private final String resultCode;
    private final String message;
    private final D data;
}
