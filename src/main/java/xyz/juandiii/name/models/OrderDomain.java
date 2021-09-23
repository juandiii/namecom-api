package xyz.juandiii.name.models;

import javax.json.bind.annotation.JsonbPropertyOrder;

@JsonbPropertyOrder(value = {"domain", "order", "totalPaid"})
public class OrderDomain {
  private Domain domain;
  private Long order;
  private Float totalPaid;

  public Domain getDomain() {
    return domain;
  }

  public OrderDomain setDomain(Domain domain) {
    this.domain = domain;
    return this;
  }

  public Long getOrder() {
    return order;
  }

  public OrderDomain setOrder(Long order) {
    this.order = order;
    return this;
  }

  public Float getTotalPaid() {
    return totalPaid;
  }

  public OrderDomain setTotalPaid(Float totalPaid) {
    this.totalPaid = totalPaid;
    return this;
  }
}
