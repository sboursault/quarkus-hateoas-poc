package com.sb.hateoas;

import com.github.tomakehurst.wiremock.WireMockServer;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

import com.github.tomakehurst.wiremock.client.MappingBuilder;
import com.github.tomakehurst.wiremock.http.MimeType;
import io.quarkus.runtime.annotations.QuarkusMain;
import io.quarkus.runtime.Quarkus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;
import static com.github.tomakehurst.wiremock.http.MimeType.JSON;

@QuarkusMain
public class Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    private static final int WIREMOCK_PORT = 8085;

    public static void main(String... args) {

        LOGGER.info("**** Start wiremock server on port {} ****", WIREMOCK_PORT);

        var wireMockServer = startWireMock(
                get(
                        urlEqualTo("/pizzas")
                ).willReturn(
                        aResponse()
                                .withStatus(200)
                                .withHeader("Content-Type", JSON.toString())
                                .withBody("" +
                                        "[\n" +
                                        "  {\n" +
                                        "    \"name\": \"Regina\",\n" +
                                        "    \"ingredients\": [ \"Ham\", \"Mushrooms\", \"Mozzarella\", \"Tomato purée\" ],\n" +
                                        "    \"_links\":{\n" +
                                        "      \"self\":{\n" +
                                        "        \"href\":\"/pizzas/875987\"\n" +
                                        "      }\n" +
                                        "    }\n" +
                                        "  }\n" +
                                        "]\n"
                                ))
        );

        Quarkus.run(args);

        LOGGER.info("**** Stop wiremock server ****");
        wireMockServer.stop();
    }

    private static WireMockServer startWireMock(MappingBuilder mappingBuilder) {
        var wireMockServer = new WireMockServer(
                wireMockConfig()
                        .port(WIREMOCK_PORT)

        );
        wireMockServer.start();
        wireMockServer.stubFor(mappingBuilder);
        return wireMockServer;
    }
}