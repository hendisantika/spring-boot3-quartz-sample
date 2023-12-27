package com.hendisantika.quartzsample.service;

import com.hendisantika.quartzsample.entity.Author;
import com.hendisantika.quartzsample.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot3-quartz-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 12/27/23
 * Time: 08:29
 * To change this template use File | Settings | File Templates.
 */
@Service
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorRepository authorRepository;

    public List<Author> getAllAuthors() {
        List<Author> authorList = authorRepository.findAll();
        return authorList;
    }
}
