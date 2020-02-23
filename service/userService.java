package com.example.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

import com.example.test.dao.userMapper;
import com.example.test.common.ReturnCode;
import com.example.test.model.ReturnMsg;
import com.example.test.model.req.LoginReqModel;
import com.example.test.model.rsp.LoginRspModel;

public class userService{
	

	@Autowired
	userMapper userMapper;

	/**
	 * User Login
	 * 
	 * @param loginModel
	 * @return
	 */
	@Transactional
	public ReturnMsg checkLogin(LoginReqModel loginModel) {

		ReturnMsg returnMsg = new ReturnMsg();
		try {
			if (loginModel.getUserName() == null || loginModel.getPassword() == null) {
				returnMsg.setReturnCode(ReturnCode.ERROR);
				return returnMsg;
			}
			
			LoginRspModel userInfo = userMapper.getUserInfo(loginModel.getUserId());

        	if (userInfo == null) {
        		//ID check
        		returnMsg.setReturnCode(ReturnCode.LOGIN_NO_ID);
        	} else {
        		String encPassword = Encryption.getEncSHA256(loginModel.getPassword());
        				
        		if (userInfo.getPassword().equals(encPassword) == false) {
            		//Password Check
        			returnMsg.setReturnCode(ReturnCode.LOGIN_INVALID_PW);
            	} else {
            		//update login time
            		userMapper.updateLoginDt(userInfo.getUserId());
            		//l
            		userMapper.insertLogConnect(loginModel.getuserName());
            		
        			returnMsg.setReturnCode(ReturnCode.OK);
        			returnMsg.setData(userInfo);
            	}
        	}
		} catch (Exception ex) {
			returnMsg.setReturnCode(ReturnCode.ERROR);
		}
		return returnMsg;
	}


    /**
     * Change PW
     * @param model Change pw data model
     * @return
     */
    public ReturnMsg changePassword(PasswordReqModel model) {

    	ReturnMsg returnMsg = new ReturnMsg();
    	try {
    		if (model.getLoginId() == null || model.getOldPassword() == null || model.getNewPassword() == null) {
				returnMsg.setReturnCode(ReturnCode.ERROR);
				return returnMsg;
			}
    		
    		int count = userMapper.getUserCount(model.getLoginId());
        	
        	if (count == 0) {
        		//아이디 존재여부 확인
        		returnMsg.setReturnCode(ReturnCode.LOGIN_NO_ID);
        		return returnMsg;
        	}
        	
        	LoginRspModel userInfo = userMapper.getLoginUserInfo(model.getLoginId());
        	        	
        	String encOldPassword = Encryption.getEncSHA256(model.getOldPassword());
			String encNewPassword = Encryption.getEncSHA256(model.getNewPassword());
			
    		if (userInfo.getLoginPw().equals(encOldPassword) == false) {
        		//암호확인
    			returnMsg.setReturnCode(ReturnCode.LOGIN_INVALID_PW);
        		return returnMsg;
        	}
        	
        	userMapper.setPassword(model.getLoginId(), encNewPassword);

			returnMsg.setReturnCode(ReturnCode.OK);

    	} catch (Exception ex) {
    		returnMsg.setReturnCode(ReturnCode.ERROR);
    	}
        return returnMsg;
    }
       

	public ReturnMsg forgotPw(LoginReqModel loginModel) {

		ReturnMsg returnMsg = new ReturnMsg();
		try {

			String newPassword = RandomStringUtils.randomAlphabetic(8);
			String newEncPass = Encryption.getEncSHA256(newPassword);

			userMapper.setPassword(loginModel.getLoginId(), newEncPass);
			returnMsg.setReturnCode(ReturnCode.OK);

		} catch (Exception ex) {
			returnMsg.setReturnCode(ReturnCode.ERROR);
		}
		return returnMsg;
	}
	
}
