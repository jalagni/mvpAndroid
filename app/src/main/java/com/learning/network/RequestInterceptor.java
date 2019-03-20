package com.learning.network;

import com.learning.appSupport.AppConst;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class RequestInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {

        Request request = chain.request();

        // Read the activity name request header.
        String activityName = request.header(AppConst.HEADER_TAG);

        // Remove it so we don’t send it over the network.
        request = request.newBuilder()
                .removeHeader("Activity-Name")
                .build();

        return chain.proceed(request);

    }
}
