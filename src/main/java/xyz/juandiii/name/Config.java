package xyz.juandiii.name;

public class Config {
  private String username;
  private String token;
  private String serverUri = "https://api.dev.name.com/v4";

  public Config(String username, String token) {
    this.username = username;
    this.token = token;
  }

  public String getUsername() {
    return username;
  }

  public Config setUsername(String username) {
    this.username = username;
    return this;
  }

  public String getToken() {
    return token;
  }

  public Config setToken(String token) {
    this.token = token;
    return this;
  }

  public String getServerUri() {
    return serverUri;
  }

  public Config setServerUri(String serverUri) {
    this.serverUri = serverUri;
    return this;
  }
}
