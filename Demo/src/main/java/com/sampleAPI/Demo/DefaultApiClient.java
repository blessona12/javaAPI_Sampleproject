package com.sampleAPI.Demo;

import okhttp3.*;


public class DefaultApiClient implements ApiClient {

    private OkHttpClient httpClient;

    public DefaultApiClient() {
        this.httpClient = new OkHttpClient();
    }

    @Override
    public String makeGetRequest(String url) throws Exception {
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();

        try (Response response = httpClient.newCall(request).execute()) {
            if (response.isSuccessful()) {
                return response.body().string();
            } else {
                throw new Exception("API call failed with status code: " + response.code());
            }
        }
    }
}

