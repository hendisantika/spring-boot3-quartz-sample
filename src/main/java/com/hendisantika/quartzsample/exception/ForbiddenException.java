package com.hendisantika.quartzsample.exception;

import com.hendisantika.quartzsample.exception.base.ServiceException;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot3-quartz-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 12/27/23
 * Time: 08:13
 * To change this template use File | Settings | File Templates.
 */
public class ForbiddenException extends ServiceException {

    public ForbiddenException() {
        super();
    }

    public ForbiddenException(String message) {
        super(message);
    }

    public ForbiddenException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
