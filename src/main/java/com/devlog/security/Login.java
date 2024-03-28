package com.devlog.security;

import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;
@Slf4j
@Service
public class Login {

    static String client_id = "Iv1.ace15a716c5abb2a";
    static String client_secret = "9825b3e733f6a98e9cbfb5724d9b71407beb2e95";

    static String state = "jojo";


    public static HttpResponse<String> sendRequest(HttpRequest request) throws IOException, InterruptedException {
        HttpResponse<String> response;
        HttpClient httpClient = HttpClient.newHttpClient();
            response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
       return response;
    }

    public String getAccessToken(String code) throws URISyntaxException, IOException, InterruptedException {
        String baseUrl = "https://github.com/login/oauth/access_token";
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("client_id", client_id);
        queryParams.put("client_secret", client_secret);
        queryParams.put("code", code);
        queryParams.put("redirect_uri", "http://localhost:3001/loginRedirect");
       // queryParams.put("state", state);
        StringBuilder queryParamsString = new StringBuilder("?");
        for (Map.Entry<String, String> entry : queryParams.entrySet()) {
            queryParamsString.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
        }
        String finalQueryParams = queryParamsString.substring(0, queryParamsString.length() - 1);
        URI uri = new URI(baseUrl + finalQueryParams);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri).GET()// Change method here if not a GET request
                .build();
       var res = sendRequest(request);
      JSONObject object = parseToJsonObject(res.body());
       return object.getString("access_token");
    }

    public String getUserId(String token) throws URISyntaxException, IOException, InterruptedException {
        String baseUrl = "https://api.github.com/user";
        HttpRequest request = HttpRequest.newBuilder().
                header("Authorization", "Bearer " + token).uri(new URI(baseUrl)).build();
                var res = sendRequest(request);
                JSONObject object = new JSONObject(res.body());
                log.info(object + "this is object");
        return object.getString("repos_url");
    }

    public static JSONObject parseToJsonObject(String input) {
        String[] keyValuePairs = input.split("&");
        JSONObject jsonObject = new JSONObject();

        for (String pair : keyValuePairs) {
            String[] keyValue = pair.split("=");
            if (keyValue.length == 2) {
                String key = keyValue[0];
                String value = keyValue[1];
                jsonObject.put(key, value);
            }
        }

        return jsonObject;
    }



}
