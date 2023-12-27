package com.hendisantika.quartzsample.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot3-quartz-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 12/27/23
 * Time: 08:22
 * To change this template use File | Settings | File Templates.
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO {

    private long id;

    @Column(name = "title", nullable = false)
    @NotBlank(message = "Title is mandatory")
    private String title;

    @Column(name = "body")
    @NotBlank(message = "Body is mandatory")
    private String body;

    private long authorId;
}
