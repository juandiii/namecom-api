package xyz.juandiii.name.resources;

import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import xyz.juandiii.name.models.*;
import xyz.juandiii.name.utils.ResponseWrapper;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Set;

public class DomainResource {

  private final ResteasyWebTarget resteasyWebTarget;

  public DomainResource(ResteasyWebTarget resteasyWebTarget) {
    this.resteasyWebTarget = resteasyWebTarget;
  }

  public ListDomain getDomains() {
    Response response = resteasyWebTarget
      .path("/domains")
      .request(MediaType.APPLICATION_JSON)
      .get();

    return new ResponseWrapper(response)
      .get(ListDomain.class);
  }

  public Domain getDomain(String domain) {
    Response response = resteasyWebTarget
      .path(String.format("/domains/%s", domain))
      .request(MediaType.APPLICATION_JSON)
      .get();

    return new ResponseWrapper(response)
      .get(Domain.class);
  }

  public OrderDomain createDomain(CreateDomain createDomain) {
    Response response = resteasyWebTarget
      .path("/domains")
      .request(MediaType.APPLICATION_JSON)
      .post(Entity.entity(createDomain, MediaType.APPLICATION_JSON));

    return new ResponseWrapper(response)
      .get(OrderDomain.class);
  }

  public CheckAvailabilityDomainResult checkAvailability(String... domains) {
    Response response = resteasyWebTarget.path("/domains:checkAvailability")
      .request(MediaType.APPLICATION_JSON)
      .post(Entity.entity(new CheckAvailabilityDomain()
        .setDomainNames(Set.of(domains)), MediaType.APPLICATION_JSON));

    return new ResponseWrapper(response)
      .get(CheckAvailabilityDomainResult.class);
  }

  public CheckAvailabilityDomainResult search(String keyword) {
    Response response = resteasyWebTarget.path("/domains:search")
      .request(MediaType.APPLICATION_JSON)
      .post(Entity.entity(new SearchDomain().setKeyword(keyword), MediaType.APPLICATION_JSON));

    return new ResponseWrapper(response)
      .get(CheckAvailabilityDomainResult.class);
  }

}
