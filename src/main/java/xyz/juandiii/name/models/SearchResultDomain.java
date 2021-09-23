package xyz.juandiii.name.models;

import javax.json.bind.annotation.JsonbPropertyOrder;

@JsonbPropertyOrder(value = {"domainName", "sld", "tld", "purchasable", "premium", "purchasePrice", "purchaseType", "renewalPrice"})
public class SearchResultDomain {
  private String domainName;
  private String sld;
  private String tld;
  private Boolean purchasable;
  private Boolean premium;
  private Float purchasePrice;
  private String purchaseType;
  private Float renewalPrice;

  public String getDomainName() {
    return domainName;
  }

  public SearchResultDomain setDomainName(String domainName) {
    this.domainName = domainName;
    return this;
  }

  public String getSld() {
    return sld;
  }

  public SearchResultDomain setSld(String sld) {
    this.sld = sld;
    return this;
  }

  public String getTld() {
    return tld;
  }

  public SearchResultDomain setTld(String tld) {
    this.tld = tld;
    return this;
  }

  public Boolean getPurchasable() {
    return purchasable;
  }

  public SearchResultDomain setPurchasable(Boolean purchasable) {
    this.purchasable = purchasable;
    return this;
  }

  public Boolean getPremium() {
    return premium;
  }

  public SearchResultDomain setPremium(Boolean premium) {
    this.premium = premium;
    return this;
  }

  public Float getPurchasePrice() {
    return purchasePrice;
  }

  public SearchResultDomain setPurchasePrice(Float purchasePrice) {
    this.purchasePrice = purchasePrice;
    return this;
  }

  public String getPurchaseType() {
    return purchaseType;
  }

  public SearchResultDomain setPurchaseType(String purchaseType) {
    this.purchaseType = purchaseType;
    return this;
  }

  public Float getRenewalPrice() {
    return renewalPrice;
  }

  public SearchResultDomain setRenewalPrice(Float renewalPrice) {
    this.renewalPrice = renewalPrice;
    return this;
  }
}
