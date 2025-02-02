package com.example.focus.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.*;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@AllArgsConstructor
@Getter
public enum ErrorCode {

    // 400 BAD_REQUEST: 잘못된 요청
    INVALID_REFRESH_TOKEN(BAD_REQUEST, "리프레시 토큰이 유효하지 않습니다"),
    MISMATCH_REFRESH_TOKEN(BAD_REQUEST, "리프레시 토큰의 유저 정보가 일치하지 않습니다"),
    WRONG_USERNAME(BAD_REQUEST, "아이디가 잘못 입력되었습니다."),
    WRONG_PASSWORD(UNAUTHORIZED, "비밀번호가 잘못 입력되었습니다."),
    WRONG_MULTIPARTFILE(BAD_REQUEST, "Multipartfile에 문제가 있습니다"),
    WRONG_DTO(BAD_REQUEST,"DTO를 다시 확인해주세요"),

    // 401 UNAUTHORIZED: 인증되지 않은 사용자
    INVALID_AUTH_TOKEN(UNAUTHORIZED, "권한 정보가 없는 토큰입니다"),
    UNAUTHORIZED_MEMBER(UNAUTHORIZED, "존재하지 않는 회원입니다."),

    // 403 FORBIDDEN: 허용되지 않는 접근
    FORBIDDEN_TRIP_USER(FORBIDDEN, "전체 여행 계획 권한이 없는 사용자입니다."),
    FORBIDDEN_TRIP_OWNER(FORBIDDEN, "전체 여행 계획 소유자가 아닙니다."),
    FORBIDDEN_REVIEW_USER(FORBIDDEN, "후기글 권한이 없는 사용자입니다."),
    NOT_IN_TRIP_MEMO(FORBIDDEN, "해당 전체 여행 계획에 속한 메모가 아닙니다."),
    NOT_IN_TRIP_PLAN(FORBIDDEN, "해당 전체 여행 계획에 속한 세부 여행 계획이 아닙니다."),
    NOT_IN_TRIP_REVIEW(FORBIDDEN, "해당 전체 여행 계획에 속한 후기글이 아닙니다."),
    EXPIRED_TRIP_URL(FORBIDDEN, "유효 기간이 만료된 url 입니다."),

    // 404 NOT_FOUND: 잘못된 리소스 접근
    REFRESH_TOKEN_NOT_FOUND(NOT_FOUND, "로그아웃 된 사용자입니다"),
    MEMBER_NOT_FOUND(NOT_FOUND, "해당 회원 정보를 찾을 수 없습니다."),
    LANDMARK_NOT_FOUND(NOT_FOUND, "해당 여행지 정보를 찾을 수 없습니다."),
    TRIP_NOT_FOUND(NOT_FOUND, "해당 전체 여행 계획을 찾을 수 없습니다."),
    TRIP_URL_NOT_FOUND(NOT_FOUND, "해당 url을 찾을 수 없습니다."),
    PLAN_NOT_FOUND(NOT_FOUND, "해당 세부 여행 계획을 찾을 수 없습니다."),
    MEMO_NOT_FOUND(NOT_FOUND, "해당 메모를 찾을 수 없습니다."),
    REVIEW_NOT_FOUND(NOT_FOUND, "해당 후기글을 찾을 수 없습니다."),
    LIKE_NOT_FOUND(NOT_FOUND,"해당 좋아요를 찾을 수 없습니다."),
    IMAGE_NOT_FOUND(NOT_FOUND, "해당 이미지를 찾을 수 없습니다."),
    USER_NOT_FOUND(NOT_FOUND, "해당 사용자를 찾을 수 없습니다."),
    PROFILE_IMAGE_NOT_FOUND(NOT_FOUND,"해당 회원의 프로필 사진을 찾을 수 없습니다"),

    // 409 CONFLICT: 중복된 리소스 (요청이 현재 서버 상태와 충돌될 때)
    DUPLICATE_EMAIL(CONFLICT, "이미 존재하는 이메일입니다."),
    DUPLICATE_NICKNAME(CONFLICT, "이미 존재하는 닉네임입니다."),
    DUPLICATE_LANDMARK_LIKE(CONFLICT, "사용자가 이미 좋아요에 추가한 여행지입니다."),
    NO_LANDMARK_LIKE_EXIST(CONFLICT, "사용자가 좋아요에 추가하지 않은 여행지입니다."),
    ALREADY_TRIP_FINISHED(CONFLICT, "이미 종료된 전체 여행 계획입니다."),
    ALREADY_WRITTEN_REVIEW(CONFLICT, "이미 후기글을 작성한 전체 여행 계획입니다."),
    NOT_FINISHED_TRIP(CONFLICT, "아직 종료되지 않은 전체 여행 계획입니다."),
    USER_ALREADY_IN_TRIP(CONFLICT, "이미 전체 여행 계획에 포함된 사용자입니다."),
    PLAN_IS_LOCKED(CONFLICT,"해당 Plan은 다른 유저가 편집중이므로 수정할 수 없습니다."),

    // 500 INTERNAL SERVER ERROR
    SERVER_ERROR(INTERNAL_SERVER_ERROR, "내부 서버 에러입니다."),
    FTP_CONNECTION_FAILED(INTERNAL_SERVER_ERROR, "FTP server 연결 실패"),
    IMAGE_UPLOAD_FAILED(INTERNAL_SERVER_ERROR, "이미지 업로드 실패"),
    IMAGE_DOWNLOAD_FAILED(INTERNAL_SERVER_ERROR, "이미지 다운로드 실패"),
    IMAGE_DELETE_FAILED(INTERNAL_SERVER_ERROR,"이미지 삭제 실패");


    private final HttpStatus httpStatus;
    private final String message;

}
