# 🌎 Name.com Library

![Supported Java 11 and above](https://img.shields.io/badge/JVM-11--17-brightgreen?logo=Java)
![GitHub Workflow Status](<https://img.shields.io/github/workflow/status/juandiii/namecom-api/Build Java and deploy to MVN Repositories>)

Unofficial [**Name.com**](https://nameClient.com) library for Java is an API V4 Rest is accessed over HTTPS. You can use to consuming resources through API [**Name.com**](https://nameClient.com)

This is used by the library HTTP client also known as [**Resteasy**](https://github.com/resteasy/resteasy)

# ⚙️ Configuration

You need to set configuration the properties `username`, `token` and set them properly. Name.com gives your credentials.


| Key            | Description                 | Required  |
|----------------|-----------------------------|-----------|
| username       | Username of Name.com        | ✅        |
| token          | Secret token of Name.com    | ✅        |

# 📄 Example

We have two options for synchronous and asynchronous for some application you can use imperative programming or reactive programming. In my case I do to set reactive programming with Smallrye Mutiny with the framework Quarkus

## 👨🏻‍💻 Example usage (Sync)

```java
// Get an instance
Name client = Name.getInstance("username", "token-123");
// Consuming an endpoint
// Get all domains
ListDomain domains = client.domains().getDomains();
```

## 👨🏻‍💻 Example usage (asynchronous)

```java
// Get an instance asynchronous
NameAsync nameClient = NameAsync.getInstance("username", "token-123");
// Get List domain in asynchronous
CompletionStage<ListDomain> domains = nameClient.async().getDomains();
domains.whenComplete((listDomain, throwable) -> {
  listDomain.getDomains().forEach(domain -> System.out.println(domain.getDomainName()));
});
```

# 😇 Contribution
To be honest
