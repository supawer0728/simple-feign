package com.parfait.simplefeign.httpbin.client;

import com.parfait.simplefeign.httpbin.model.DelayResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "http-bin-api", url = "${feign.http-bin-api.url}", fallbackFactory = HttpBinClientFallbackFactory.class)
public interface HttpBinClient {

    @GetMapping("/delay/{seconds}")
    DelayResponse delay(@PathVariable("seconds") int seconds);
}
