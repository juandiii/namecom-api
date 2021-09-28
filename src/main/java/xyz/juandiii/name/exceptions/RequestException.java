package xyz.juandiii.name.exceptions;

public class RequestException extends RuntimeException {

  private int code;

  public RequestException(String message, int code) {
    super(message);
    this.code = code;
  }

  public RequestException(String message) {
    this(message, 999);
  }

  public int getCode() {
    return code;
  }

  public RequestException setCode(int code) {
    this.code = code;
    return this;
  }
}
