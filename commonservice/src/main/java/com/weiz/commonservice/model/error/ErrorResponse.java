package com.weiz.commonservice.model.error;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collections;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse extends MessageCode {
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private transient Map<String, Object> details;

    public ErrorResponse(String code, String message) {
        this(code, message, Collections.emptyMap());
    }

    public ErrorResponse(String code, String message, Map<String, Object> details) {
        super(code, message);
        this.details = details;
    }

    public ErrorResponse setDetails(Map<String, Object> details) {
        this.details = details;
        return this;
    }
}
