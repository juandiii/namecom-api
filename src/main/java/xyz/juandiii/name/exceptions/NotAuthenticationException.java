package xyz.juandiii.name.exceptions;

public class NotAuthenticationException extends RequestException {

  public NotAuthenticationException(String message) {
    super(message, 401);
  }

  public NotAuthenticationException() {
    this("Not authentication");
  }
}
