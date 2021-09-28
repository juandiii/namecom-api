package xyz.juandiii.name.exceptions;

public class BadRequestException extends RequestException {

  public BadRequestException(String message) {
    super(message, 400);
  }

  public BadRequestException() {
    super("Bad request");
  }
}
