package com.parfait.simplefeign.post.client;

import com.parfait.simplefeign.post.model.Post;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "post-api", url = "${feign.post-api.url}")
public interface PostClient {

    @GetMapping("/posts/{id}")
    Post get(@PathVariable("id") Long id);
}
