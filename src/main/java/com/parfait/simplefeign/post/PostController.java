package com.parfait.simplefeign.post;

import com.parfait.simplefeign.post.client.PostClient;
import com.parfait.simplefeign.post.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostClient postClient;

    @Autowired
    public PostController(PostClient postClient) {
        this.postClient = postClient;
    }

    @GetMapping("/{id}")
    public Post get(@PathVariable Long id) {

        return postClient.get(id);
    }
}
