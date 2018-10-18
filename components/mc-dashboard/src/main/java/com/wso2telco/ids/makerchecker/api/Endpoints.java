package com.wso2telco.ids.makerchecker.api;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.wso2telco.ids.makerchecker.Constants;
import com.wso2telco.ids.makerchecker.exception.AuthenticationException;
import com.wso2telco.ids.makerchecker.util.AuthenticationUtil;
import com.wso2telco.ids.makerchecker.util.CommonUtil;
import org.apache.log4j.Logger;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("v1/")
public class Endpoints {

    private static final Logger log = Logger.getLogger(Endpoints.class);

    @Context
    private ServletConfig servletConfig;
    @Context
    private ServletContext servletContext;
    @Context
    private HttpServletRequest httpServletRequest;
    @Context
    private HttpServletResponse httpServletResponse;

    @GET
    @Path("auth/callback")
    public Response callback(String entity) {
        System.out.println(CommonUtil.constructServerUrl(httpServletRequest));
        return Response.noContent().build();
    }

    @POST
    @Path("auth/login")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response login(String data) {
        String response = null;
        JsonObject loginData = new JsonParser().parse(data).getAsJsonObject();

        if (loginData.has(Constants.USERNAME) && loginData.has(Constants.PASSWORD)) {
            String username = loginData.get(Constants.USERNAME).getAsString();
            String password = loginData.get(Constants.PASSWORD).getAsString();
            String serviceEndpoint = CommonUtil.constructServerUrl(httpServletRequest) + "/services/" + Constants.AUTHENTICATION_ENDPOINT;

            if (username != null && password != null && (!username.isEmpty()) && (!password.isEmpty())) {
                try {
                    String sessionId = AuthenticationUtil.authenticate(username, password, serviceEndpoint);
                    if (sessionId != null && (!sessionId.isEmpty())) {
                        httpServletRequest.getSession().setAttribute(Constants.USERNAME, username);
                        httpServletRequest.getSession().setAttribute(Constants.SESSION_COOKIE, sessionId);
                        log.info("Maker Checker Dashboard: Successfully authenticated user: " + username);
                        response = Constants.RESPONSE_JSON.replace(Constants.ERROR_TAG, "false")
                                .replace(Constants.MESSAGE_TAG, "Successfully authenticated");
                    } else {
                        response = Constants.RESPONSE_JSON.replace(Constants.ERROR_TAG, "true")
                                .replace(Constants.MESSAGE_TAG, "Authentication failed. Check credentials and try again.");
                    }
                } catch (AuthenticationException e) {
                    response = Constants.RESPONSE_JSON.replace(Constants.ERROR_TAG, "true")
                            .replace(Constants.MESSAGE_TAG, "Authentication Failed");
                }
            } else {
                response = Constants.RESPONSE_JSON.replace(Constants.ERROR_TAG, "true")
                        .replace(Constants.MESSAGE_TAG, "Authentication failed. Check credentials and try again.");
            }

        } else {
            response = Constants.RESPONSE_JSON.replace(Constants.ERROR_TAG, "true")
                    .replace(Constants.MESSAGE_TAG, "Missing required fields (username or password)");
        }
        return Response.status(Response.Status.OK).entity(response).build();
    }

}
