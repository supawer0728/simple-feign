package com.parfait.simplefeign.httpbin.client;

import com.parfait.simplefeign.httpbin.model.DelayResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class HttpBinClientFallback implements HttpBinClient {
    @Override
    public DelayResponse delay(int seconds) {
        log.debug("fallback called");
        return DelayResponse.EMPTY;
    }
}
