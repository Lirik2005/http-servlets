package com.lirik.client;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.nio.file.Path;

import static java.net.http.HttpResponse.*;

public class HttpClientExample {

    public static void main(String[] args) throws IOException, InterruptedException {

        HttpClient httpClient = HttpClient.newBuilder()
                                          .version(HttpClient.Version.HTTP_1_1)
                                          .build();

        HttpRequest getRequest = HttpRequest.newBuilder(URI.create("https://www.google.com"))
                                            .GET()
                                            .build();

        HttpRequest postRequest = HttpRequest.newBuilder(URI.create("https://www.google.com"))
                                             .POST(BodyPublishers.ofFile(Path.of("path", "to", "file")))
                                             .build();

        HttpResponse<String> getResponse = httpClient.send(getRequest, BodyHandlers.ofString()); //таким образом мы отправляем запрос

        System.out.println(getResponse.body());
        System.out.println(getResponse.headers());
    }
}
