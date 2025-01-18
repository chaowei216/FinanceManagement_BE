package com.weiz.commonservice.exception;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class NotFoundException extends RuntimeException {

  String message;

  public NotFoundException(String message) {
    super(message);
    this.message = message;
  }

  public NotFoundException(String message, Throwable cause) {
    super(message, cause);
    this.message = message;
  }
}
