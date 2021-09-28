package xyz.juandiii.name.exceptions;

public class ForbiddenException extends RequestException {

  public ForbiddenException(String message) {
    super(message, 403);
  }

  public ForbiddenException() {
    this("Forbidden");
  }
}
