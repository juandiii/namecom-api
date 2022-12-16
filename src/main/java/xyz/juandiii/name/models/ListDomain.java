package xyz.juandiii.name.models;

import javax.json.bind.annotation.JsonbPropertyOrder;
import javax.json.bind.config.PropertyOrderStrategy;
import java.util.List;

@JsonbPropertyOrder(PropertyOrderStrategy.LEXICOGRAPHICAL)
public class ListDomain {

  private List<Domain> domains;

  public List<Domain> getDomains() {
    return domains;
  }

  public ListDomain setDomains(List<Domain> domains) {
    this.domains = domains;
    return this;
  }
}
