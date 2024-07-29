package org.acme;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import org.acme.rest.CxfClientRestResource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.common.http.TestHTTPResource;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class TestResource {
    @TestHTTPEndpoint(GreetingResource.class)
    @TestHTTPResource
    URL url;

    @TestHTTPEndpoint(GreetingResource.class)
    @TestHTTPResource("/test")
    URL testHelloUrl;

    @TestHTTPEndpoint(CxfClientRestResource.class)
    @TestHTTPResource("/divide?a=6&b=2")
    URL testDivide;

    @Test
    public void testIndexHtml() throws IOException {
        try (InputStream in = url.openStream()) {
            String contents = new String(in.readAllBytes(), StandardCharsets.UTF_8);
            Assertions.assertEquals("Hello from Quarkus REST", contents);
        }
    }

    @Test
    public void testDivide() throws IOException {
        try (InputStream in = testDivide.openStream()) {
            String contents = new String(in.readAllBytes(), StandardCharsets.UTF_8);
            Assertions.assertEquals("3", contents);
        }
    }

    @Test
    public void testIndex() throws IOException {
        try (InputStream in = testHelloUrl.openStream()) {
            String contents = new String(in.readAllBytes(), StandardCharsets.UTF_8);
            Assertions.assertEquals("Hello", contents);
        }
    }
}
