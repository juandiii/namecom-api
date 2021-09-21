package xyz.juandiii.name.models;

public class CreateDomain {

  private Domain domain;
  private Float purchasePrice;
  private String purchaseType;
  private Integer years;

  public Domain getDomain() {
    return domain;
  }

  public CreateDomain setDomain(Domain domain) {
    this.domain = domain;
    return this;
  }

  public Float getPurchasePrice() {
    return purchasePrice;
  }

  public CreateDomain setPurchasePrice(Float purchasePrice) {
    this.purchasePrice = purchasePrice;
    return this;
  }

  public String getPurchaseType() {
    return purchaseType;
  }

  public CreateDomain setPurchaseType(String purchaseType) {
    this.purchaseType = purchaseType;
    return this;
  }

  public Integer getYears() {
    return years;
  }

  public CreateDomain setYears(Integer years) {
    this.years = years;
    return this;
  }
}
