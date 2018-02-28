package com.parfait.simplefeign.httpbin;

import com.parfait.simplefeign.httpbin.client.HttpBinClient;
import com.parfait.simplefeign.httpbin.model.DelayResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/delay")
public class DelayController {

    private final HttpBinClient client;

    @Autowired
    public DelayController(HttpBinClient client) {
        this.client = client;
    }

    @GetMapping("/{seconds}")
    public DelayResponse delay(@PathVariable("seconds") int seconds) {
        return client.delay(seconds);
    }
}
