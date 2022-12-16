package xyz.juandiii.name;


import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import xyz.juandiii.name.exceptions.BadRequestException;
import xyz.juandiii.name.exceptions.InternalErrorException;
import xyz.juandiii.name.exceptions.NotFoundException;
import xyz.juandiii.name.models.CheckAvailabilityDomainResult;
import xyz.juandiii.name.models.Domain;


import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;


import static javax.ws.rs.client.Invocation.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
//@MockitoSettings(strictness = Strictness.LENIENT)
public class NameTest {

//  @Mock
  NameClient nameClient;

  @Mock
  Builder mockBuilder;

  @Mock
  Response mockResponse;

  @Mock
  ResteasyWebTarget mockWebTarget;

  @Mock
  ClientBuilder clientBuilder;

  @Mock
  Client mockClient;


  @BeforeEach()
  void beforeTest() {

    when(this.mockResponse.readEntity(String.class)).thenReturn("{}");
    when(this.mockResponse.getStatus()).thenReturn(200);

    when(mockWebTarget.path(ArgumentMatchers.anyString())).thenReturn(mockWebTarget);
    when(mockWebTarget.request(ArgumentMatchers.anyString())).thenReturn(mockBuilder);
    when(mockWebTarget.request(MediaType.APPLICATION_JSON)).thenReturn(mockBuilder);

    when(mockClient.target(ArgumentMatchers.anyString())).thenReturn(mockWebTarget);

    nameClient = NameClient.getInstance("", "", mockClient);

//    when(clientBuilder.build()).thenReturn(mockClient);

  }

  @Test
  void testGetDomain_ShouldBeReturnObject() {
    when(mockResponse.readEntity(String.class)).thenReturn("{\"domainName\": \"hola\"}");
    when(mockBuilder.get()).thenReturn(this.mockResponse);

    Domain domain = nameClient.getDomain("domain2.js");


    assertNotNull(domain.getDomainName());
  }

  @Test()
  void testShouldBeZeroArray() {
    when(mockBuilder.post(ArgumentMatchers.any(Entity.class))).thenReturn(this.mockResponse);

    CheckAvailabilityDomainResult result = nameClient.checkAvailability("domain.js").setResults(new ArrayList<>());
    assertEquals(0, result.getResults().size(), "Arraylist expected size 0");
  }

  @Test
  void shouldBeThrowInternalErrorException() {
    when(mockBuilder.post(ArgumentMatchers.any(Entity.class))).thenReturn(this.mockResponse);

    when(this.mockResponse.getStatus()).thenReturn(500);
    when(this.mockResponse.readEntity(String.class)).thenReturn("{\"message\": \"Internal Error\", \"details\": \"errors\"}");

    InternalErrorException exception = assertThrows(InternalErrorException.class, () -> {
      nameClient.checkAvailability("domain.js").setResults(new ArrayList<>());
    });

    assertEquals("Internal Error", exception.getMessage());
  }

  @Test
  void shouldBeThrowNotFoundErrorException() {
    when(mockBuilder.post(ArgumentMatchers.any(Entity.class))).thenReturn(this.mockResponse);

    when(this.mockResponse.getStatus()).thenReturn(404);
    when(this.mockResponse.readEntity(String.class)).thenReturn("{\"message\": \"Not found\", \"details\": \"errors\"}");

    NotFoundException exception = assertThrows(NotFoundException.class, () -> {
      nameClient.checkAvailability("domain.js").setResults(new ArrayList<>());
    });

    assertEquals("Not found", exception.getMessage());
  }

  @Test
  void shouldBeThrowBadRequestException() {
    when(mockBuilder.post(ArgumentMatchers.any(Entity.class))).thenReturn(this.mockResponse);

    when(this.mockResponse.getStatus()).thenReturn(400);
    when(this.mockResponse.readEntity(String.class)).thenReturn("{\"message\": \"Bad Request\", \"details\": \"errors\"}");

    BadRequestException exception = assertThrows(BadRequestException.class, () -> {
      nameClient.checkAvailability("domain.js").setResults(new ArrayList<>());
    });

    assertEquals("Bad Request", exception.getMessage());
  }
}
