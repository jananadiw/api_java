package com.example.test.model;

/* 
 * REST 호출 결과 코드
 */
public enum ReturnCode {
	/**
	 * 0 : 정상
	 */
	OK(0),
	
	/**
	 * 1 : 오휴
	 */
    ERROR(1),
    
    /**
     * 10 : 자료없음
     */
    NO_DATA(10),
    
    /**
     * 11 : 이미존재하는자료임
     */
    ALREADY_EXIST_CODE(11),
    
    /**
     * 12 : 이미존재하는이름임
     */
    ALREADY_EXIST_NAME(12),
    
    /**
     * 13 : 등록되어 있지 않음
     */
    NOT_REGISTERED(13),
    
    /**
     * 14 : 등록이 불가함
     */
    CAN_NOT_REGISTER(14),
    
    /**
     * 15 : 승인되지 않음
     */
    NOT_APPROVED(15),
    
    /**
     * 20 : 아이디없음
     */
    LOGIN_NO_ID(20),
    
    /**
     * 21 : 암호다름
     */
    LOGIN_INVALID_PW(21),

    /**
     * 31 : 값이 범위를 벗어남
     */
    INVALID_VALUE_RANGE(31),
    
    
    /**
     * 데이터베이스 오류
     */
    CA_DB_ERROR(8001),
    
    /**
     * 쿼리 오류
     */
    CA_DB_QUERY_ERROR(8002),
    
    /**
     * 잘못된요청
     */
    CA_BAD_REQUEST(9400),
    
    /**
     * 잘못된요청
     */
    CA_NOT_FOUND(9404),
    
    /**
     * 지원하지 않는 메소드
     */
    CA_METHOD_NOT_ALLOWED(9405),
    ;

    
    private int numVal ;

    ReturnCode ( int numVal )
    {
    	this.numVal = numVal;
    }

    public int getNumVal ( )
    {
        return numVal;
    }
    
    public String getMessage ( )
    {
    	String msg ;
    	switch(numVal) {
			case 0 : msg = "Success"; break;
			case 10 : msg = "No"; break;
			case 11 : msg = "Already Exists"; break;
			case 12 : msg = "Already Exists"; break;
			case 13 : msg = "Not Registered"; break;
			case 14 : msg = "Cannot Register"; break;
			case 15 : msg = "Cannot Authenticate"; break;
			case 20 : msg = "ID not valid"; break;
			case 21 : msg = "Password does not match."; break;
			case 31 : msg = "Exceed the range"; break;
			
			case 8001 : msg = "Database Error"; break;
			case 8002 : msg = "Query Error"; break;
			case 9400 : msg = "Invalid Request."; break;
			case 9404 : msg = "Invalid Request."; break;
			case 9405 : msg = "Method Unvalid."; break;
			default : msg = "Error"; break;
    	}
        return msg;
    }
}
