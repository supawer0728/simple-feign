package com.parfait.simplefeign.post.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

@Value
public class Post {

    public static final Post EMPTY = new Post(0L, 0L, null, null);

    private Long userId;
    private Long id;
    private String title;
    private String body;

    @JsonCreator
    public Post(@JsonProperty("userId") Long userId,
                @JsonProperty("id") Long id,
                @JsonProperty("title") String title,
                @JsonProperty("body") String body) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.body = body;
    }
}
