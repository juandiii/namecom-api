package xyz.juandiii.name.async;


import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import xyz.juandiii.name.config.ClientBuilderWrapper;
import xyz.juandiii.name.config.Config;
import xyz.juandiii.name.utils.JsonBProvider;
import xyz.juandiii.name.filters.AuthorizationHeader;
import xyz.juandiii.name.models.*;
import xyz.juandiii.name.utils.ResponseWrapper;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import java.util.Set;
import java.util.concurrent.CompletionStage;

public class NameAsyncClientImpl implements NameAsyncClient {

  private final Config config;
  private final ResteasyWebTarget target;
  private final Client client;

  public NameAsyncClientImpl(String username, String token, Client resteasyClient) {
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

  public static NameAsyncClientImpl getInstance(String username, String token, Client resteasyClient) {
    return new NameAsyncClientImpl(username, token, resteasyClient);
  }

  public static NameAsyncClientImpl getInstance(String username, String token) {
    return new NameAsyncClientImpl(username, token, null);
  }

  public CompletionStage<ListDomain> getDomains() {
    return target
      .path("/domains")
      .request(MediaType.APPLICATION_JSON)
      .rx()
      .get()
      .thenApply(response -> new ResponseWrapper(response)
        .get(ListDomain.class));
  }

  public CompletionStage<Domain> getDomain(String domain) {
    return target
      .path(String.format("/domains/%s", domain))
      .request(MediaType.APPLICATION_JSON)
      .rx()
      .get()
      .thenApply(response -> new ResponseWrapper(response)
        .get(Domain.class));
  }

  public CompletionStage<OrderDomain> createDomain(CreateDomain createDomain) {
    return target.path("/domains")
      .request(MediaType.APPLICATION_JSON)
      .rx()
      .post(Entity.entity(createDomain, MediaType.APPLICATION_JSON))
      .thenApply(response -> new ResponseWrapper(response)
        .get(OrderDomain.class));
  }

  public CompletionStage<CheckAvailabilityDomainResult> checkAvailability(String... domains) {
    return target.path("/domains:checkAvailability")
      .request(MediaType.APPLICATION_JSON)
      .rx()
      .post(Entity.entity(new CheckAvailabilityDomain()
        .setDomainNames(Set.of(domains)), MediaType.APPLICATION_JSON))
      .thenApply(response -> new ResponseWrapper(response)
        .get(CheckAvailabilityDomainResult.class));
  }

  public CompletionStage<CheckAvailabilityDomainResult> search(String keyword) {
    return target.path("/domains:search")
      .request(MediaType.APPLICATION_JSON)
      .rx()
      .post(Entity.entity(new SearchDomain().setKeyword(keyword), MediaType.APPLICATION_JSON))
      .thenApply(response -> new ResponseWrapper(response)
        .get(CheckAvailabilityDomainResult.class));
  }

  public CompletionStage<Domain> setNameServers(Domain domain) {
    return target.path(String.format("/domains/%s:setNameservers", domain.getDomainName()))
      .request(MediaType.APPLICATION_JSON)
      .rx()
      .post(Entity.entity(domain, MediaType.APPLICATION_JSON))
      .thenApply(response -> new ResponseWrapper(response)
        .get(Domain.class));
  }
}
