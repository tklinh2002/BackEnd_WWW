package com.edu.iuh.services;

import com.edu.iuh.entities.Comment;

public interface CommentServices {
    Comment findOneById(String id);

    Comment add(Comment Comment);

    Comment deleteById(String id);

    Comment update(Comment Comment);
}