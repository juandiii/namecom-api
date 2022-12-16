package xyz.juandiii.name;

import xyz.juandiii.name.models.*;

import javax.ws.rs.client.Client;

public interface NameClient {

  static NameClient getInstance(String username, String password) {
    return NameClient.getInstance(username, password, null);
  }

  static NameClient getInstance(String username, String password, Client client) {
    return NameClientImpl.getInstance(username, password, client);
  }

  ListDomain getDomains();

  Domain getDomain(String domain);

  OrderDomain createDomain(CreateDomain createDomain);

  CheckAvailabilityDomainResult checkAvailability(String... domains);

  CheckAvailabilityDomainResult search(String keyword);

  Domain setNameServers(Domain domain);


}
