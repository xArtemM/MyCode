package ru.netology;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        final String REMOTE_SERVICE_URI = "https://api.nasa.gov/planetary/apod?api_key=hSm6D5mdI6yZWeZhLMm8A81qhXj1U2v52MkaerHb";

        CloseableHttpClient httpClient = HttpClientBuilder.create()
                .setDefaultRequestConfig(RequestConfig.custom()
                        .setConnectTimeout(5000)    // максимальное время ожидание подключения к серверу
                        .setSocketTimeout(30000)    // максимальное время ожидания получения данных
                        .setRedirectsEnabled(false) // возможность следовать редиректу в ответе
                        .build())
                .build();


        HttpGet request = new HttpGet(REMOTE_SERVICE_URI);
        CloseableHttpResponse response = httpClient.execute(request);
        String body = new String(response.getEntity().getContent().readAllBytes());
        final String resourceURL = body.substring(body.indexOf("\"url\":\"") + 7, body.lastIndexOf("jpg") + 3);
        System.out.println(resourceURL);


        request = new HttpGet(resourceURL);
        response = httpClient.execute(request);

        try (FileOutputStream fos = new FileOutputStream(resourceURL.substring(resourceURL.lastIndexOf("/") + 1))) {
            fos.write(response.getEntity().getContent().readAllBytes());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }
}