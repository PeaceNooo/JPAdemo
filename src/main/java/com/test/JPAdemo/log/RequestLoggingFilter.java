package com.test.JPAdemo.log;

import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

@Component
public class RequestLoggingFilter extends CommonsRequestLoggingFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(RequestLoggingFilter.class);

    public RequestLoggingFilter() {
        setIncludeQueryString(true);
        setIncludePayload(true);
        setIncludeHeaders(false);
        setMaxPayloadLength(10000);
    }

    @Override
    protected boolean shouldLog(HttpServletRequest request) {
        return LOGGER.isDebugEnabled();
    }

    @Override
    protected void beforeRequest(HttpServletRequest request, String message) {
        LOGGER.debug("Incoming request: {}", message);
    }

    @Override
    protected void afterRequest(HttpServletRequest request, String message) {
        LOGGER.debug("Outgoing response: {}", message);
    }

}
