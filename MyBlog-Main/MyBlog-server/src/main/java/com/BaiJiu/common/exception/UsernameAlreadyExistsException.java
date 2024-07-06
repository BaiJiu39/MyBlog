package com.BaiJiu.common.exception;

/**
 * 账号重复异常
 */
public class UsernameAlreadyExistsException extends BaseException {
    public UsernameAlreadyExistsException() {
    }
    public UsernameAlreadyExistsException(String message) {super(message);}
}
