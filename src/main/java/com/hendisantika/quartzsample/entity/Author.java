package com.hendisantika.quartzsample.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

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
@Entity
@Table(name = "authors")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Author implements Serializable {

    private static final long serialVersionUID = 7156526077883281623L;
    @OneToMany(mappedBy = "author")
    List<Post> postList;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name")
    private String name;
}
