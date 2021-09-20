package xyz.juandiii.name;

import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import xyz.juandiii.name.filters.AuthorizationHeader;
import xyz.juandiii.name.resources.DomainResource;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

public class Name {
  private final Config config;
  private final ResteasyWebTarget target;
  private final Client client;

  public Name(String username, String token, Client resteasyClient) {
    config = new Config(username, token);
    client = resteasyClient != null ? resteasyClient : newResteasyClient();

    target = (ResteasyWebTarget) client.target(config.getServerUri());
    target.register(new AuthorizationHeader(config.getUsername(), config.getToken()));
  }

  private static Client newResteasyClient() {
    ClientBuilder clientBuilder = ClientBuilderWrapper.create();
    clientBuilder.register(JsonBProvider.class);
    return clientBuilder.build();
  }

  public static Name getInstance(String username, String token, Client resteasyClient) {
    return new Name(username, token, resteasyClient);
  }

  public static Name getInstance(String username, String token) {
    return getInstance(username, token, null);
  }

  public DomainResource domains() {
    return new DomainResource(target);
  }
}
