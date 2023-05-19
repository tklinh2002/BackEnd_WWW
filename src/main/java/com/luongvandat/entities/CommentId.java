package com.luongvandat.entities;

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Embeddable
public class CommentId implements Serializable {
    private String userId;
    private String bookId;
}