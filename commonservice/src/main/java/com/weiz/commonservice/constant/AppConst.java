package com.weiz.commonservice.constant;

import com.weiz.commonservice.model.error.MessageCode;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class AppConst {

    // message, code for exception
    public static final MessageCode SERVICE_ERROR = new MessageCode("500", "Service Error");
    public static final MessageCode BAD_REQUEST = new MessageCode("400", "Bad Request");
    public static final MessageCode NOT_FOUND = new MessageCode("404", "Not Found");
    public static final MessageCode CONFLICT = new MessageCode("409", "Resource Conflict");

}
