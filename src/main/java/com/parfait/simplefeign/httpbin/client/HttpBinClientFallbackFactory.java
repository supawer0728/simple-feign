package com.parfait.simplefeign.httpbin.client;

import com.parfait.simplefeign.httpbin.model.DelayResponse;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class HttpBinClientFallbackFactory implements FallbackFactory<HttpBinClient> {

    @Override
    public HttpBinClient create(Throwable cause) {
        log.error(cause.getMessage(), cause);
        return seconds -> DelayResponse.EMPTY;
    }
}
