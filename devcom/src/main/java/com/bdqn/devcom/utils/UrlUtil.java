package com.bdqn.devcom.utils;

public class UrlUtil {

    public static final String HTTP = "http://www.oschina.net/";
    public static  final String CALLBACK_ADDRESS = "action/oauth2/authorize?";
    public static  final String GRANT_TYPE = "grant_type=authorization_code";
    public static  final String SEPARATOR = "&";
    public static  final String RESPONSE_TYPE = "response_type=code";
    public static  final String DATA_TYPE = "dataType=json";
    public static  final String CLIENT_ID = "client_id=tJQM18hAfBfMykA9HiB3";
    public static  final String REDIRECT_URI = "redirect_uri=http://www.kuba.com/";
    public static  final String CLIENT_SECRET = "client_secret=Gdh1kPKC6fYFbe6G494BwuE6FwbD2MTy";
    public static  final String CALLBACK_AUTHORIZECODE_ADDRESS = "action/openapi/token?";
    public static  final String NEWS_LIST = "/action/openapi/news_list?";
    public static  final String ACCESS_TOKEN = "access_token=";



    public static final String AUTHORIZEURL = HTTP+CALLBACK_ADDRESS+RESPONSE_TYPE+SEPARATOR+CLIENT_ID+SEPARATOR+REDIRECT_URI;

    /**
     * 获得code
     * @param url
     * @return
     */
    public static String getAuthorizeCode(String url) {
        String authorizeCode = HTTP+CALLBACK_AUTHORIZECODE_ADDRESS+CLIENT_ID+SEPARATOR+CLIENT_SECRET+
                SEPARATOR+GRANT_TYPE+SEPARATOR+REDIRECT_URI+SEPARATOR+DATA_TYPE+SEPARATOR+"code="+url;
        return authorizeCode;
    }

    public static String getNewsList(String token,int catalog){
        String newsList =HTTP+NEWS_LIST+ACCESS_TOKEN+token+SEPARATOR+"catalog="+catalog+SEPARATOR+
                "page=2"+SEPARATOR+"pageSize=4"+SEPARATOR+DATA_TYPE;
        return newsList;
    }
}
