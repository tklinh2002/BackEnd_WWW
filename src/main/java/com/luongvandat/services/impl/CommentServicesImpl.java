package com.luongvandat.services.impl;

import com.luongvandat.entities.Comment;
import com.luongvandat.repositories.CommentRepository;
import com.luongvandat.services.CommentServices;
import org.springframework.stereotype.Service;

@Service
public class CommentServicesImpl implements CommentServices {
    private final CommentRepository commentRepository;

    public CommentServicesImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public Comment findOneById(String id) {
        return commentRepository.findById(id).orElse(null);
    }

    @Override
    public Comment add(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public Comment deleteById(String id) {
        Comment comment = findOneById(id);
        commentRepository.deleteById(id);
        return comment;
    }

    @Override
    public Comment update(Comment comment) {
        return commentRepository.save(comment);
    }
}