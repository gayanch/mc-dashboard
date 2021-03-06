package com.wso2telco.ids.makerchecker;

public class Constants {
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";

//    public static final String ERROR_TAG = "${error}";
//    public static final String MESSAGE_TAG = "${message}";
//    public static final String RESPONSE_JSON = "{\"error\": " + ERROR_TAG + ", \"message\": \"" + MESSAGE_TAG +"\"}";

    public static final String SET_COOKIE_HEADER = "Set-Cookie";
    public static final String SESSION_COOKIE = "sessionCookie";

    //Servlet parameter names
    public static final String SERVICE_ENDPOINT = "serviceEndpoint";

    //SOAP endpoint names
    public static final String AUTHENTICATION_ENDPOINT = "/services/AuthenticationAdmin.AuthenticationAdminHttpsSoap11Endpoint/";
    public static final String HUMAN_TASK_ENDPOINT = "/services/HumanTaskClientAPIAdmin/";

    //human task states
    public static final String APPROVED = "APPROVED";
    public static final String REJECTED = "REJECTED";
    public static final String RELEASED = "RELEASED";
}
