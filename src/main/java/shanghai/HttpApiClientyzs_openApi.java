//
//  Created by  fred on 2017/1/12.
//  Copyright © 2016年 Alibaba. All rights reserved.
//

package shanghai;

import com.alibaba.cloudapi.sdk.client.ApacheHttpClient;
import com.alibaba.cloudapi.sdk.enums.HttpMethod;
import com.alibaba.cloudapi.sdk.enums.Scheme;
import com.alibaba.cloudapi.sdk.model.ApiCallback;
import com.alibaba.cloudapi.sdk.model.ApiRequest;
import com.alibaba.cloudapi.sdk.model.ApiResponse;
import com.alibaba.cloudapi.sdk.model.HttpClientBuilderParams;
import com.fasterxml.jackson.databind.ObjectMapper;


public class HttpApiClientyzs_openApi extends ApacheHttpClient{
    public final static String HOST = "yzs-openapi.fat.driverglobe.com";
    static HttpApiClientyzs_openApi instance = new HttpApiClientyzs_openApi();
    public static HttpApiClientyzs_openApi getInstance(){return instance;}
    public static final ObjectMapper mapper = new ObjectMapper();

    public void init(HttpClientBuilderParams httpClientBuilderParams){
        httpClientBuilderParams.setScheme(Scheme.HTTPS);
        httpClientBuilderParams.setHost(HOST);
        super.init(httpClientBuilderParams);
    }




    public void 中意支付回调(byte[] body , ApiCallback callback) {
        String path = "/vehicle-insurance-server/generaliChina/paymentCallBack";
        ApiRequest request = new ApiRequest(HttpMethod.POST_BODY , path, body);
        request.addHeader("Content-Type", "application/json; charset=utf-8");
        sendAsyncRequest(request , callback);
    }

    public ApiResponse 中意支付回调SyncMode(byte[] body) {
        String path = "/vehicle-insurance-server/generaliChina/paymentCallBack";
        ApiRequest request = new ApiRequest(HttpMethod.POST_BODY , path, body);
        request.addHeader("Content-Type", "application/json; charset=utf-8");
        return sendSyncRequest(request);
    }
}