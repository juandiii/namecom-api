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

  public String getResponse() {
    int status = this.response.getStatus();
    String output = this.response.readEntity(String.class);
    response.close();
    if (status >= 200 && 299 >= status) {
      return output;
    } else if (status == 404) {
      ErrorDomain errorDomain = JsonBConverter.fromJson(output, ErrorDomain.class);
      throw new NotFoundException(errorDomain.getMessage());
    } else if (status >= 400 && 499 >= status) {
      ErrorDomain errorDomain = JsonBConverter.fromJson(output, ErrorDomain.class);
      throw new BadRequestException(errorDomain.getMessage());
    } else if (status >= 500 && 599 >= status) {
      ErrorDomain errorDomain = JsonBConverter.fromJson(output, ErrorDomain.class);
      throw new InternalErrorException(errorDomain.getMessage());
    } else {
        throw new InternalErrorException();
    }
  }

  public <T> T get(Class<T> clazz) {
    try {
      String output = this.getResponse();
      return JsonBConverter.fromJson(output, clazz);
    } catch (ProcessingException ex) {
      return null;
    }
  }
}
