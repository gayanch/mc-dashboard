package com.wso2telco.ids.makerchecker.util;

import com.wso2telco.ids.makerchecker.Constants;
import com.wso2telco.ids.makerchecker.exception.AuthenticationException;
import org.apache.axis2.AxisFault;
import org.apache.axis2.client.Options;
import org.apache.axis2.context.MessageContext;
import org.apache.axis2.transport.http.CommonsTransportHeaders;
import org.apache.axis2.transport.http.HTTPConstants;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.ssl.SSLContexts;
import org.wso2.carbon.core.services.authentication.AuthenticationAdminAuthenticationExceptionException;
import org.wso2.carbon.core.services.authentication.AuthenticationAdminStub;
import org.wso2.carbon.core.services.authentication.Login;
import org.wso2.carbon.core.services.authentication.LoginResponse;

import javax.net.ssl.SSLContext;
import java.rmi.RemoteException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

public class AuthenticationUtil {

    /**
     *
     * @param username
     * @param password
     * @return
     * @throws AuthenticationException
     */
    public static String authenticate(String username, String password, String serviceEndpoint) throws AuthenticationException {
        try {

            SSLContext sslContext = SSLContexts.custom()
                    .loadTrustMaterial(new TrustSelfSignedStrategy())
                    .build();
            SSLContext.setDefault(sslContext);

            AuthenticationAdminStub stub = new AuthenticationAdminStub(serviceEndpoint);
            Options options =stub._getServiceClient().getOptions();
            options.setProperty(HTTPConstants.REUSE_HTTP_CLIENT, "true");
            options.setProperty(HTTPConstants.CHUNKED, "false");
            options.setManageSession(true);

            Login login = new Login();
            login.setUsername(username);
            login.setPassword(password);
            LoginResponse response = stub.login(login);

            if (!response.get_return()) {
                return null;
            }

            MessageContext context = stub._getServiceClient().getLastOperationContext().getMessageContext(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
            CommonsTransportHeaders commonsTransportHeaders=(CommonsTransportHeaders)context.getProperty(MessageContext.TRANSPORT_HEADERS);
            String setCookie = commonsTransportHeaders.get(Constants.SET_COOKIE_HEADER).toString();

            String sessionId = null;
            if (setCookie != null && (!setCookie.isEmpty())) {
                sessionId = setCookie.split(";")[0];
            }

            return sessionId;
        } catch (AxisFault
                | AuthenticationAdminAuthenticationExceptionException
                | NoSuchAlgorithmException
                | KeyStoreException
                | KeyManagementException
                ex) {
            throw new AuthenticationException(ex);
        } catch (RemoteException e) {
            throw new AuthenticationException(e);
        }
    }
}
