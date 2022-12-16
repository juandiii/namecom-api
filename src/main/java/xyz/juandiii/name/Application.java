package xyz.juandiii.name;

public class Application {

  public static void main(String[] args) {
    NameClient nameClient = NameClientImpl.getInstance("juandiii-test", "11e785b87626647c472ab2f1a4928ea9bf955eef");
//    name.domains().getDomains()
    nameClient.getDomains().getDomains().forEach(domain -> System.out.println(domain.getDomainName()));

//    name.async().getDomain("juandiii2.xyz")
//      .toCompletableFuture()
//      .thenAccept(e -> System.out.println(e.getDomainName()));
  }
}
