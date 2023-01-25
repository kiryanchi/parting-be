package com.appdong.parting.config;

import lombok.Getter;

/**
 * 에러 코드 관리
 */
@Getter
public enum BaseResponseStatus {
    /**
     * 1000 : 요청 성공
     */
    SUCCESS(true, 1000, "요청에 성공하였습니다."),


    /**
     * 2000 : Request 오류
     */
    // Common
    REQUEST_ERROR(false, 2000, "입력값을 확인해주세요."),
    EMPTY_JWT(false, 2001, "JWT를 입력해주세요."),
    INVALID_JWT(false, 2002, "유효하지 않은 JWT입니다."),
    INVALID_USER_JWT(false,2003,"권한이 없는 유저의 접근입니다."),




    /**
     * 3000 : Response 오류
     */
    // Common
    RESPONSE_ERROR(false, 3000, "값을 불러오는데 실패하였습니다."),




    /**
     * 4000 : Database, Server 오류
     */
    DATABASE_ERROR(false, 4000, "데이터베이스 에러입니다."),
    SERVER_ERROR(false, 4001, "서버와의 연결에 실패하였습니다."),


    PASSWORD_ENCRYPTION_ERROR(false, 4011, "비밀번호 암호화에 실패하였습니다."),
    PASSWORD_DECRYPTION_ERROR(false, 4012, "비밀번호 복호화에 실패하였습니다."),


    PARTY_OR_USER_ID_INVALID(false,5000,"partyId 혹은 userId를 확인해주세요"),
    CAN_NOT_WITHDRAW_HOST(false,5001,"host는 파티를 나갈 수 없습니다. 파티를 삭제해주세요"),
    USER_NOT_EXIST_IN_PARTY(false,5002,"해당 유저가 해당 파티에 속해있지 않습니다."),
    USER_IS_NOT_HOST(false,5003,"host유저만이 파티를 삭제할 수 있습니다."),

    PARTY_CAN_HAS_TWO_OR_ONE_CATEGORY_DETAIL(false,5004,"파티는 세부카테고리를 1개 혹은 2개까지 가질수있습니다."),
    PARTY_CAN_HAS_ONE_CATEGORY(false,5004,"파티는 하나의 카테고리만 연관될 수 있습니다.");

    private final boolean isSuccess;
    private final int code;
    private final String message;

    private BaseResponseStatus(boolean isSuccess, int code, String message) {
        this.isSuccess = isSuccess;
        this.code = code;
        this.message = message;
    }
}
