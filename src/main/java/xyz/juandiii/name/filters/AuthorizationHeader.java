package xyz.juandiii.name.filters;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import java.io.IOException;
import java.util.Base64;

public class AuthorizationHeader implements ClientRequestFilter {

  private final String username;
  private final String token;

  public AuthorizationHeader(String username, String token) {
    this.username = username;
    this.token = token;
  }

  @Override
  public void filter(ClientRequestContext requestContext) throws IOException {
    requestContext.getHeaders()
      .add("Authorization", "Basic " + Base64.getEncoder().encodeToString(String.format("%s:%S", this.username, this.token).getBytes()));
  }
}
