package ru.netology;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.config.*;
import org.apache.http.client.methods.*;
import org.apache.http.impl.client.*;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {

        final String REMOTE_SERVICE_URI = "https://raw.githubusercontent.com/netology-code/jd-homeworks/master/http/task1/cats";

        CloseableHttpClient httpClient = HttpClientBuilder.create()
                .setDefaultRequestConfig(RequestConfig.custom()
                        .setConnectTimeout(5000)    // максимальное время ожидание подключения к серверу
                        .setSocketTimeout(30000)    // максимальное время ожидания получения данных
                        .setRedirectsEnabled(false) // возможность следовать редиректу в ответе
                        .build())
                .build();

        HttpGet request = new HttpGet(REMOTE_SERVICE_URI);

        CloseableHttpResponse response = httpClient.execute(request);

//        String body = new String(response.getEntity().getContent().readAllBytes());
//        System.out.println(body);

        ObjectMapper mapper = new ObjectMapper();
        List<Cats> cats = mapper.readValue(response.getEntity().getContent(),
                new TypeReference<>() {
                });

        cats = cats.stream()
                .filter(value -> value.getUpVotes() != null && value.getUpVotes() > 0)
                .collect(Collectors.toList());

        cats.forEach(System.out::println);

    }
}