package xyz.juandiii.name.models;

import java.util.List;

public class CheckAvailabilityDomainResult {

  private List<SearchResultDomain> results;

  public List<SearchResultDomain> getResults() {
    return results;
  }

  public CheckAvailabilityDomainResult setResults(List<SearchResultDomain> results) {
    this.results = results;
    return this;
  }
}
