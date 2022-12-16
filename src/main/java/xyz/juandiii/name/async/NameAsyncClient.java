package xyz.juandiii.name.async;

import xyz.juandiii.name.models.*;

import javax.ws.rs.client.Client;
import java.util.concurrent.CompletionStage;

public interface NameAsyncClient {

  static NameAsyncClient getInstance(String username, String password) {
    return NameAsyncClient.getInstance(username, password, null);
  }

  static NameAsyncClient getInstance(String username, String password, Client client) {
    return NameAsyncClientImpl.getInstance(username, password, client);
  }

  CompletionStage<ListDomain> getDomains();

  CompletionStage<Domain> getDomain(String domain);

  CompletionStage<OrderDomain> createDomain(CreateDomain createDomain);

  CompletionStage<CheckAvailabilityDomainResult> checkAvailability(String... domains);

  CompletionStage<CheckAvailabilityDomainResult> search(String keyword);

  CompletionStage<Domain> setNameServers(Domain domain);
}
