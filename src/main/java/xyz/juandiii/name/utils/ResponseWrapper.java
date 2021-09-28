package xyz.juandiii.name.utils;

import xyz.juandiii.name.exceptions.BadRequestException;
import xyz.juandiii.name.exceptions.InternalErrorException;
import xyz.juandiii.name.exceptions.NotFoundException;
import xyz.juandiii.name.models.ErrorDomain;

import javax.ws.rs.ProcessingException;
import javax.ws.rs.core.Response;

public class ResponseWrapper {

  private final Response response;

  public ResponseWrapper(Response response) {
    this.response = response;
  }

  public int getStatus() {
    return response.getStatus();
  }

  public String getResponse() {
    String output = response.readEntity(String.class);
    if (getStatus() >= 200 && 299 >= getStatus()) {
      return output;
    } else if (getStatus() == 404) {
      ErrorDomain errorDomain = JsonBConverter.fromJson(output, ErrorDomain.class);
      throw new NotFoundException(errorDomain.getMessage());
    } else if (getStatus() >= 400 && 499 >= getStatus()) {
      ErrorDomain errorDomain = JsonBConverter.fromJson(output, ErrorDomain.class);
      throw new BadRequestException(errorDomain.getMessage());
    } else if (getStatus() >= 500 && 599 >= getStatus()) {
      ErrorDomain errorDomain = JsonBConverter.fromJson(output, ErrorDomain.class);
      throw new BadRequestException(errorDomain.getMessage());
    } else {
        throw new InternalErrorException();
    }
  }

  public <T> T get(Class<T> clazz) {
    try {
      String output = getResponse();
      return JsonBConverter.fromJson(output, clazz);
    } catch (ProcessingException ex) {
      return null;
    }
  }
}
