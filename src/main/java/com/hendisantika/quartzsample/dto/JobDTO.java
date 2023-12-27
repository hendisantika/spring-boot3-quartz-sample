package com.hendisantika.quartzsample.dto;

import lombok.*;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot3-quartz-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 12/27/23
 * Time: 08:21
 * To change this template use File | Settings | File Templates.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JobDTO {
    private String from;
    private String to;
    private String subject;
    private String body;
}
