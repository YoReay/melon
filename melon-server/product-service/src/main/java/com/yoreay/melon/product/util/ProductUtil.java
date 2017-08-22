package com.yoreay.melon.product.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ProductUtil {

    private static final String product_api_url_host_name = "http://webapi.chinatrace.org";

    private static final String product_api_url_path = "/api/getProductData";

    private HttpClient client;

    private ProductUtil(HttpClient client) {
        this.client = client;
    }

    public static ProductUtil newInstance() {
        return new ProductUtil(HttpClients.createDefault());
    }

    public String getProductFromApi(String code) {
        String mac = CommonUtil.getMac(product_api_url_path + "?productCode=" + code);
        String url = product_api_url_host_name + product_api_url_path + "?productCode=" + code + "&mac=" + mac;
        HttpGet get = new HttpGet(url);
        try {
            HttpResponse response = client.execute(get);
            if (response.getStatusLine().getStatusCode() == 200) {
                System.out.println(EntityUtils.toString(response.getEntity()));
                return EntityUtils.toString(response.getEntity());
            }
        } catch (IOException e) {
            log.error("error in ProductUtil --> getProductFromApi: ", e);
        }
        return null;
    }
}
