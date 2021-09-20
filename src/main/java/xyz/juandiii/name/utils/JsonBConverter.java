package xyz.juandiii.name.utils;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbException;

public class JsonBConverter {

  private static final Jsonb jsonb = JsonbBuilder.create();

  public static <T> T fromJson(String json, Class<T> clazz) {
    try {
      return jsonb.fromJson(json, clazz);
    } catch (JsonbException | NullPointerException ex) {
      return null;
    }
  }

  public static String toJSON(Object object) {
    try {
      return JsonbBuilder.create().toJson(object);
    } catch (JsonbException | NullPointerException ex) {
      return null;
    }
  }
}
