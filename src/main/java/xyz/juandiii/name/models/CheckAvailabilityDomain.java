package xyz.juandiii.name.models;

import java.util.Set;

public class CheckAvailabilityDomain {

  private Set<String> domainNames;
  private String promoCode;

  public Set<String> getDomainNames() {
    return domainNames;
  }

  public CheckAvailabilityDomain setDomainNames(Set<String> domainNames) {
    this.domainNames = domainNames;
    return this;
  }

  public String getPromoCode() {
    return promoCode;
  }

  public CheckAvailabilityDomain setPromoCode(String promoCode) {
    this.promoCode = promoCode;
    return this;
  }
}
