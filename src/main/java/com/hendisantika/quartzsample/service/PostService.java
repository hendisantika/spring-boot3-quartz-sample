package com.hendisantika.quartzsample.service;

import com.hendisantika.quartzsample.dto.PostDTO;
import com.hendisantika.quartzsample.entity.Author;
import com.hendisantika.quartzsample.entity.Post;
import com.hendisantika.quartzsample.entity.Tag;
import com.hendisantika.quartzsample.exception.BadRequestException;
import com.hendisantika.quartzsample.exception.DataNotFoundException;
import com.hendisantika.quartzsample.repository.AuthorRepository;
import com.hendisantika.quartzsample.repository.PostRepository;
import com.hendisantika.quartzsample.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;
import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot3-quartz-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 12/27/23
 * Time: 08:31
 * To change this template use File | Settings | File Templates.
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class PostService {

    private final ModelMapper modelMapper;

    private final PostRepository postRepository;

    private final AuthorRepository authorRepository;

    private final TagRepository tagRepository;

    @Cacheable(value = "posts")
    public List<Post> getAllPosts(String title) {
        List<Post> postList;
        if (title == null) {
            postList = postRepository.findAll();
        } else {
            postList = postRepository.findByTitleContaining(title);
        }
        return postList;
    }

    public Post getById(Long id) {
        return postRepository
                .findById(id)
                .orElseThrow(
                        () ->
                                new DataNotFoundException(
                                        MessageFormat.format("Post id {0} not found", String.valueOf(id))));
    }

    public Post createOrUpdate(PostDTO postRequest) {
        Optional<Post> existingPost = postRepository.findById(postRequest.getId());

        if (existingPost.isPresent()) {
            Post postUpdate = existingPost.get();

            postUpdate.setTitle(postRequest.getTitle());
            postUpdate.setBody(postRequest.getBody());
            if (postRequest.getAuthorId() != 0) {
                Optional<Author> author = authorRepository.findById(postRequest.getAuthorId());
                author.ifPresent(postUpdate::setAuthor);
            }

            return postRepository.save(postUpdate);
        } else {
            return postRepository.save(modelMapper.map(postRequest, Post.class));
        }
    }

    public List<Tag> getAllTagsByPostId(Long id) {
        if (!postRepository.existsById(id)) {
            throw new DataNotFoundException(
                    MessageFormat.format("Post id {0} not found", String.valueOf(id)));
        }

        List<Tag> tagList = postRepository.findById(id).get().getTagList();
        return tagList;
    }

    public Tag addTag(Long postId, Tag tagRequest) {
        return postRepository
                .findById(postId)
                .map(
                        post -> {
                            Optional<Tag> existingTag = tagRepository.findById(tagRequest.getId());
                            if (tagRequest.getId() != 0) {
                                if (existingTag.isPresent()) {
                                    post.addTag(existingTag.get());
                                    postRepository.save(post);
                                    return existingTag.get();
                                } else {
                                    throw new DataNotFoundException(
                                            MessageFormat.format(
                                                    "Tag id {0} not found", String.valueOf(tagRequest.getId())));
                                }
                            } else {
                                // create new tag
                                post.addTag(tagRequest);
                                return tagRepository.save(tagRequest);
                            }
                        })
                .orElseThrow(
                        () ->
                                new DataNotFoundException(
                                        MessageFormat.format("Post id {0} not found", String.valueOf(postId))));
    }

    public void deleteTagFromPost(Long postId, Long tagId) {
        Optional<Post> post = postRepository.findById(postId);
        if (post.isPresent()) {
            post.get().removeTag(tagId);
            postRepository.save(post.get());
        } else {
            throw new BadRequestException("Delete error, please check ID and try again");
        }
    }
}
