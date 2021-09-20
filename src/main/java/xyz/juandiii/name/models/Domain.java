package xyz.juandiii.name.models;

import java.util.Set;

public class Domain {

  private String domainName;
  private Set<String> nameservers;

  public String getDomainName() {
    return domainName;
  }

  public Domain setDomainName(String domainName) {
    this.domainName = domainName;
    return this;
  }

  public Set<String> getNameservers() {
    return nameservers;
  }

  public Domain setNameservers(Set<String> nameservers) {
    this.nameservers = nameservers;
    return this;
  }
}
