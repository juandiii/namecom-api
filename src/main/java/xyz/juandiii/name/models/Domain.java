package xyz.juandiii.name.models;

import xyz.juandiii.name.utils.JsonbDateAdapter;

import javax.json.bind.annotation.JsonbPropertyOrder;
import javax.json.bind.annotation.JsonbTypeAdapter;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@JsonbPropertyOrder(value = {"domainName", "nameservers", "privacyEnabled", "locked", "autorenewEnabled", "renewalPrice", "createDate", "expireDate"})
public class Domain {

  private String domainName;
  private List<String> nameservers;
  private boolean privacyEnabled;
  private boolean locked;
  private boolean autorenewEnabled;
  private BigDecimal renewalPrice;
  @JsonbTypeAdapter(JsonbDateAdapter.class)
  private LocalDateTime createDate;
  @JsonbTypeAdapter(JsonbDateAdapter.class)
  private LocalDateTime expireDate;

  public String getDomainName() {
    return domainName;
  }

  public Domain setDomainName(String domainName) {
    this.domainName = domainName;
    return this;
  }

  public List<String> getNameservers() {
    return nameservers;
  }

  public Domain setNameservers(List<String> nameservers) {
    this.nameservers = nameservers;
    return this;
  }

  public boolean isPrivacyEnabled() {
    return privacyEnabled;
  }

  public Domain setPrivacyEnabled(boolean privacyEnabled) {
    this.privacyEnabled = privacyEnabled;
    return this;
  }

  public boolean isLocked() {
    return locked;
  }

  public Domain setLocked(boolean locked) {
    this.locked = locked;
    return this;
  }

  public boolean isAutorenewEnabled() {
    return autorenewEnabled;
  }

  public Domain setAutorenewEnabled(boolean autorenewEnabled) {
    this.autorenewEnabled = autorenewEnabled;
    return this;
  }

  public BigDecimal getRenewalPrice() {
    return renewalPrice;
  }

  public Domain setRenewalPrice(BigDecimal renewalPrice) {
    this.renewalPrice = renewalPrice;
    return this;
  }

  public LocalDateTime getCreateDate() {
    return createDate;
  }

  public Domain setCreateDate(LocalDateTime createDate) {
    this.createDate = createDate;
    return this;
  }

  public LocalDateTime getExpireDate() {
    return expireDate;
  }

  public Domain setExpireDate(LocalDateTime expireDate) {
    this.expireDate = expireDate;
    return this;
  }
}
