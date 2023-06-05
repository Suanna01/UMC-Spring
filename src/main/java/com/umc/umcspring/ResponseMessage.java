package com.umc.umcspring;

public class ResponseMessage {
    public static final String CREATE_USER = "회원 가입 성공";
    public static final String CREATE_USER_FAIL = "회원 가입 실패";
    public static final String READ_USER = "회원 정보 조회 성공";
    public static final String UPDATE_USER = "회원 정보 수정 성공";
    public static final String DELETE_USER = "회원 탈퇴 성공";
    public static final String READ_USER_PROFILE = "회원 프로필 조회 성공";

    public static final String CREATE_PROD = "상품 등록 성공";
    public static final String READ_PROD = "상품 조회 성공";
    public static final String PUT_PROD = "상품 전체 수정 성공";
    public static final String PATCH_PROD_PRICE = "상품 가격 할인 성공";
    public static final String DELETE_PROD = "상품 삭제 성공";
    public static final String READ_PROD_BY_ID = "특정 상품 조회 성공";
}
