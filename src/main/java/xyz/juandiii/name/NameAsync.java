package xyz.juandiii.name;

import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import xyz.juandiii.name.filters.AuthorizationHeader;
import xyz.juandiii.name.resources.DomainAsyncResource;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

public class NameAsync {

  private final Config config;
  private final ResteasyWebTarget target;
  private final Client client;

  public NameAsync(String username, String token, Client resteasyClient) {
    config = new Config(username, token);
    client = resteasyClient != null ? resteasyClient : newResteasyClient();
    target = (ResteasyWebTarget) client.target("https://api.dev.name.com/v4");
    target.register(new AuthorizationHeader(config.getUsername(), config.getToken()));
  }

  private static Client newResteasyClient() {
    ClientBuilder clientBuilder = ClientBuilderWrapper.create();
    clientBuilder.register(JsonBProvider.class);
    return clientBuilder.build();
  }

  public static NameAsync getInstance(String username, String token, Client resteasyClient) {
    return new NameAsync(username, token, resteasyClient);
  }

  public static NameAsync getInstance(String username, String token) {
    return new NameAsync(username, token, null);
  }

  public DomainAsyncResource async() {
    return new DomainAsyncResource(target);
  }
}
