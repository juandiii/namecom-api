package xyz.juandiii.name.exceptions;

public class NotFoundException extends RequestException {

  public NotFoundException(String message) {
    super(message, 404);
  }

  public NotFoundException() {
    this("Not found");
  }
}
