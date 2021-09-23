package xyz.juandiii.name.resources;

import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import xyz.juandiii.name.models.*;
import xyz.juandiii.name.utils.ResponseWrapper;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import java.util.Set;
import java.util.concurrent.CompletionStage;

public class DomainAsyncResource {

  private final ResteasyWebTarget target;

  public DomainAsyncResource(ResteasyWebTarget resteasyWebTarget) {
    this.target = resteasyWebTarget;
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
}
