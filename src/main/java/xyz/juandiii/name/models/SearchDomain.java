package xyz.juandiii.name.models;

public class SearchDomain {
  private String keyword;
  private String tldFilter;

  public String getKeyword() {
    return keyword;
  }

  public SearchDomain setKeyword(String keyword) {
    this.keyword = keyword;
    return this;
  }

  public String getTldFilter() {
    return tldFilter;
  }

  public SearchDomain setTldFilter(String tldFilter) {
    this.tldFilter = tldFilter;
    return this;
  }
}
