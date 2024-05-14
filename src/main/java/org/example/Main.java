package org.example;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

public class Main {
  public static void main(String[] args) {
    Response response = sendRequestToXgate();
    if (response == null || response.body() == null) {
      System.err.println("Failed to send request to Xgate");
      return;
    }

    XgateResponse xgateResponse = parseXgateResponse(response);
    if (xgateResponse == null) {
      System.err.println("Failed to parse Xgate response");
      return;
    }

    System.out.println("Failed Response: " + xgateResponse);

    System.out.println("\n");

    try (InputStream is = Objects.requireNonNull(getResourceAsStream("success.xml"))) {
      XgateResponse successXgateResponse = parseXgateResponse(is);
      System.out.println("Success Response: " + successXgateResponse);
    } catch (IOException | NullPointerException e) {
      e.printStackTrace();
      System.err.println("Failed to parse success.xml");
    }
  }

  private static XgateResponse parseXgateResponse(InputStream inputStream) {
    try {
      XmlMapper xmlMapper = new XmlMapper();
      return xmlMapper.readValue(inputStream, XgateResponse.class);
    } catch (IOException e) {
      e.printStackTrace();
      return null;
    }
  }

  private static XgateResponse parseXgateResponse(Response response) {
    try (response) {  // Auto-closing the response
      XmlMapper xmlMapper = new XmlMapper();
      return xmlMapper.readValue(response.body().byteStream(), XgateResponse.class);
    } catch (IOException e) {
      e.printStackTrace();
      return null;
    }
  }

  private static Response sendRequestToXgate() {
    OkHttpClient client = new OkHttpClient();

    MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
    RequestBody body = RequestBody.create(mediaType,
      "userId=ebl_emperorcen&userPassword=25221181&messageType=TEXT&messageLanguage=UTF8&messageReceiver=6281282961674&messageBody=test");

    Request request = new Request.Builder()
      .url("https://smsc.xgate.com.hk/smshub/sendsms")
      .post(body)
      .addHeader("Content-Type", "application/x-www-form-urlencoded")
      .build();

    try {
      return client.newCall(request).execute();
    } catch (IOException e) {
      e.printStackTrace();
      return null;
    }
  }

  private static InputStream getResourceAsStream(String resource) {
    ClassLoader classloader = Thread.currentThread().getContextClassLoader();
    return classloader.getResourceAsStream(resource);
  }
}
