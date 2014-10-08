/*
 * Copyright (c) 2014. Shawn Wheeler. All rights reserved.
 */

package com.mypitech.experior.wicket6.service.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.*;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

/**
 * Utility class for generating JSON requests and processing responses.
 * <p/>
 * Created by Shawn Wheeler on 5/21/2014.
 */
public class HttpUtil {

    public static <RequestBean> void put(URI URI, RequestBean requestBean) throws IOException {
        HttpPut httpPut = new HttpPut(URI);
        httpPut.setEntity(getEntity(requestBean));
        getResponse(httpPut);
    }

    public static void delete(URI URI) throws IOException {
        HttpDelete httpDelete = new HttpDelete(URI);
        getResponse(httpDelete);
    }

    /**
     * Generate a GET request.
     *
     * @param URI path to resource
     * @return response in string format
     */
    public static String get(URI URI) throws IOException {
        HttpGet httpGet = new HttpGet(URI);
        return getResponseString(getResponse(httpGet));
    }

    /**
     * Generate a GET request. Process the result into a Bean.
     *
     * @param URI         path to resource
     * @param responseBean Bean class to return the response as
     * @return ResponseBean
     * @throws java.io.IOException
     */
    public static <ResponseBean> ResponseBean get(URI URI, Class<ResponseBean> responseBean) throws IOException {
        HttpGet httpGet = new HttpGet(URI);
        return getResponseBean(getResponse(httpGet), responseBean);
    }

    /**
     * Generate a GET request. Process the result into a Bean list.
     *
     * @param URI         path to resource
     * @param responseBean Bean class to return as list
     * @return List<ResponseBean>
     * @throws java.io.IOException
     */
    public static <ResponseBean> List<ResponseBean> getList(URI URI, Class<ResponseBean> responseBean) throws IOException {
        HttpGet httpGet = new HttpGet(URI);
        return getResponseBeanList(getResponse(httpGet), responseBean);
    }


    /**
     * Generate a POST request. Process the result into a Bean.
     *
     * @param URI         path to resource
     * @param requestBean  Bean to post
     * @param responseBean Bean class to return the response as
     * @return ResponseBean
     * @throws java.io.IOException
     */
    public static <RequestBean, ResponseBean> ResponseBean post(URI URI, RequestBean requestBean, Class<ResponseBean> responseBean) throws IOException {
        HttpPost httpPost = new HttpPost(URI);
        httpPost.setEntity(getEntity(requestBean));
        return getResponseBean(getResponse(httpPost), responseBean);
    }

    /**
     * Generate a POST request. Return the header values.
     *
     * @param URI         path to resource
     * @param requestBean  Bean to post
     * @param headerNames header names to return
     * @return HashMap of header names and values
     * @throws java.io.IOException
     */
    public static <RequestBean> HashMap<String, String> post(URI URI, RequestBean requestBean, String... headerNames) throws IOException {
        HashMap<String, String> resultMap = new HashMap<String, String>();
        HttpPost httpPost = new HttpPost(URI);
        httpPost.setEntity(getEntity(requestBean));
        HttpResponse response = getResponse(httpPost);
        for (String name : headerNames) {
            Header currentHeader = response.getFirstHeader(name);
            resultMap.put(name, currentHeader != null ? currentHeader.getValue() : "");
        }
        return resultMap;
    }

    /**
     * Converts an HTTP response to a Bean.
     *
     * @param response    HTTP response
     * @param responseBean Bean class to convert response to
     * @return ResponseBean
     * @throws java.io.IOException
     */
    private static <ResponseBean> ResponseBean getResponseBean(HttpResponse response, Class<ResponseBean> responseBean) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(response.getEntity().getContent(), responseBean);
    }

    /**
     * Converts an HTTP response to a Bean list.
     *
     * @param response    HTTP response
     * @param responseBean Bean class to convert response to list of
     * @return List<ResponseBean>
     * @throws java.io.IOException
     */
    private static <ResponseBean> List<ResponseBean> getResponseBeanList(HttpResponse response, Class<ResponseBean> responseBean) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(response.getEntity().getContent(), TypeFactory.defaultInstance().constructCollectionType(List.class, responseBean));
    }

    /**
     * Gets a String from an HTTP response entity.
     *
     * @param response HttpResponse
     * @return a string from a HttpResponse entity
     * @throws java.io.IOException
     */
    private static String getResponseString(HttpResponse response) throws IOException {
        return EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);
    }

    /**
     * Converts a Bean to a StringEntity.
     *
     * @param requestBean Bean to convert
     * @return StringEntity
     * @throws JsonProcessingException
     */
    private static <RequestBean> StringEntity getEntity(RequestBean requestBean) throws JsonProcessingException {
        ObjectWriter objectWriter = new ObjectMapper().writer();
        return new StringEntity(objectWriter.writeValueAsString(requestBean), ContentType.APPLICATION_JSON);
    }

    /**
     * Executes a HTTP request and returns the response.
     *
     * @param request HttpUriRequest
     * @return HttpResponse
     * @throws java.io.IOException
     */
    private static HttpResponse getResponse(HttpUriRequest request) throws IOException {
        HttpClient httpClient = HttpClients.createDefault();
        return httpClient.execute(request);
    }

}
