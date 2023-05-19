package com.luongvandat.services;

import com.luongvandat.entities.Comment;

public interface CommentServices {
    Comment findOneById(String id);

    Comment add(Comment Comment);

    Comment deleteById(String id);

    Comment update(Comment Comment);
}