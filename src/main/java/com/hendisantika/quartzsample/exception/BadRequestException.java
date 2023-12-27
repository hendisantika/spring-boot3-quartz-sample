package com.hendisantika.quartzsample.exception;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot3-quartz-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 12/27/23
 * Time: 08:12
 * To change this template use File | Settings | File Templates.
 */

import org.hibernate.service.spi.ServiceException;

/**
 * trigger for bad request exception
 */
public class BadRequestException extends ServiceException {

    public BadRequestException() {
        super();
    }

    public BadRequestException(String message) {
        super(message);
    }

    public BadRequestException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
