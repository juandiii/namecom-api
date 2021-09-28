package xyz.juandiii.name.exceptions;

public class InternalErrorException extends RequestException {

  public InternalErrorException(String message) {
    super(message, 500);
  }

  public InternalErrorException() {
    this("Internal Error");
  }
}
