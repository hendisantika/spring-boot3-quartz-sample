package com.hendisantika.quartzsample.exception.base;

import lombok.*;

import java.sql.Timestamp;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot3-quartz-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 12/27/23
 * Time: 08:19
 * To change this template use File | Settings | File Templates.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ErrorResponse {

    /**
     * error code
     */
    private String code;
    /**
     * short error message
     */
    private String message;

    /**
     * error cause timestamp
     */
    private Timestamp timestamp;
}
