package xyz.juandiii.name.utils;

import javax.ws.rs.ProcessingException;
import javax.ws.rs.core.Response;

public class ResponseWrapper {

  private final Response response;

  public ResponseWrapper(Response response) {
    this.response = response;
  }

  public <T> T get(Class<T> clazz) {
    try {
      String output = response.readEntity(String.class);
      return JsonBConverter.fromJson(output, clazz);
    } catch (ProcessingException ex) {
      return null;
    }
  }
}
