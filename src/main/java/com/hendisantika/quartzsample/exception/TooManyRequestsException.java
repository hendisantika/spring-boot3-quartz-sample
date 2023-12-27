package com.hendisantika.quartzsample.exception;

import org.hibernate.service.spi.ServiceException;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot3-quartz-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 12/27/23
 * Time: 08:14
 * To change this template use File | Settings | File Templates.
 */
public class TooManyRequestsException extends ServiceException {

    public TooManyRequestsException() {
        super();
    }

    public TooManyRequestsException(String message) {
        super(message);
    }

    public TooManyRequestsException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
