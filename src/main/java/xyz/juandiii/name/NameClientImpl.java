package xyz.juandiii.name;


import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import xyz.juandiii.name.config.ClientBuilderWrapper;
import xyz.juandiii.name.config.Config;
import xyz.juandiii.name.filters.AuthorizationHeader;
import xyz.juandiii.name.models.*;
import xyz.juandiii.name.utils.JsonBProvider;
import xyz.juandiii.name.utils.ResponseWrapper;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Set;

public class NameClientImpl implements NameClient {

  private final Config config;
  private final ResteasyWebTarget target;
  private final Client client;

  public NameClientImpl(String username, String token, Client resteasyClient) {
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

  public static NameClientImpl getInstance(String username, String token, Client resteasyClient) {
    return new NameClientImpl(username, token, resteasyClient);
  }

  public static NameClientImpl getInstance(String username, String token) {
    return getInstance(username, token, null);
  }

  public ListDomain getDomains() {
    Response response = target
      .path("/domains")
      .request(MediaType.APPLICATION_JSON)
      .get();

    return new ResponseWrapper(response)
      .get(ListDomain.class);
  }

  public Domain getDomain(String domain) {
    Response response = target
      .path(String.format("/domains/%s", domain))
      .request(MediaType.APPLICATION_JSON)
      .get();

    return new ResponseWrapper(response)
      .get(Domain.class);
  }

  public OrderDomain createDomain(CreateDomain createDomain) {
    Response response = target
      .path("/domains")
      .request(MediaType.APPLICATION_JSON)
      .post(Entity.entity(createDomain, MediaType.APPLICATION_JSON));

    return new ResponseWrapper(response)
      .get(OrderDomain.class);
  }

  public CheckAvailabilityDomainResult checkAvailability(String... domains) {
    Response response = target
      .path("/domains:checkAvailability")
      .request(MediaType.APPLICATION_JSON)
      .post(Entity.entity(new CheckAvailabilityDomain()
        .setDomainNames(Set.of(domains)), MediaType.APPLICATION_JSON));

    return new ResponseWrapper(response)
      .get(CheckAvailabilityDomainResult.class);
  }

  public CheckAvailabilityDomainResult search(String keyword) {
    Response response = target
      .path("/domains:search")
      .request(MediaType.APPLICATION_JSON)
      .post(Entity.entity(new SearchDomain().setKeyword(keyword), MediaType.APPLICATION_JSON));

    return new ResponseWrapper(response)
      .get(CheckAvailabilityDomainResult.class);
  }

  public Domain setNameServers(Domain domain) {
    Response response = target
      .path(String.format("/domains/%s:setNameservers", domain.getDomainName()))
      .request(MediaType.APPLICATION_JSON)
      .post(Entity.entity(domain, MediaType.APPLICATION_JSON));

    return new ResponseWrapper(response)
      .get(Domain.class);
  }
}
