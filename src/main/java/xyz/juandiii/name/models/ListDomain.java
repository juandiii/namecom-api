package xyz.juandiii.name.models;

import java.util.Set;

public class ListDomain {

  private Set<Domain> domains;

  public Set<Domain> getDomains() {
    return domains;
  }

  public ListDomain setDomains(Set<Domain> domains) {
    this.domains = domains;
    return this;
  }
}
