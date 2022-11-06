package com.g3c1.temiuser.global.error

enum class ErrorCode(val message:String,val status: Int) {
    SEAT_NOT_USED("사용 중이지않는 좌석입니다.",400),
    SEAT_NOT_FOUND("좌석을 찾을 수 없습니다.",404),
    ALREADY_USED_SEAT("이미 사용중인 좌석입니다.",409)
}