package xyz.juandiii.name.models;

import java.util.Set;

public class CheckAvailabilityDomainResult {

  private Set<SearchResultDomain> results;

  public Set<SearchResultDomain> getResults() {
    return results;
  }

  public CheckAvailabilityDomainResult setResults(Set<SearchResultDomain> results) {
    this.results = results;
    return this;
  }
}
