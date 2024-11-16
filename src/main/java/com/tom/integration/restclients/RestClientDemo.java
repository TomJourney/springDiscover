package com.tom.integration.restclients;

import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestClient;

/**
 * @author Tom
 * @version 1.0.0
 * @ClassName RestClientDemo.java
 * @Description TODO
 * @createTime 2024年10月21日 06:52:00
 */
public class RestClientDemo {

    public void f1() {
        RestClient defaultClient = RestClient.create();

        RestClient customClient = RestClient.builder()
                .requestFactory(new HttpComponentsClientHttpRequestFactory())
//                .messageConverters(converters -> converters.add(new MyCustomMessageConverter()))
//                .baseUrl("https://example.com")
//                .defaultUriVariables(Map.of("variable", "foo"))
//                .defaultHeader("My-Header", "Foo")
//                .requestInterceptor(myCustomInterceptor)
//                .requestInitializer(myCustomInitializer)
                .build();
    }
}
