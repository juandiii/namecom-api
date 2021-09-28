package xyz.juandiii.name.models;

public class ErrorDomain {

  private String message;
  private String details = "";

  public String getMessage() {
    return message;
  }

  public ErrorDomain setMessage(String message) {
    this.message = message;
    return this;
  }

  public String getDetails() {
    return details;
  }

  public ErrorDomain setDetails(String details) {
    this.details = details;
    return this;
  }
}
