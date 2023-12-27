package com.hendisantika.quartzsample.repository;

import com.hendisantika.quartzsample.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot3-quartz-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 12/27/23
 * Time: 08:25
 * To change this template use File | Settings | File Templates.
 */
@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {
}
