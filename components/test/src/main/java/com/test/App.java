//package com.test;
//
//import org.apache.axis2.AxisFault;
//import org.apache.axis2.client.Options;
//import org.apache.axis2.context.MessageContext;
//import org.apache.axis2.transport.http.CommonsTransportHeaders;
//import org.apache.axis2.transport.http.HTTPConstants;
//import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
//import org.apache.http.ssl.SSLContexts;
//import org.wso2.carbon.core.services.authentication.AuthenticationAdminAuthenticationExceptionException;
//import org.wso2.carbon.core.services.authentication.AuthenticationAdminStub;
//import org.wso2.carbon.core.services.authentication.Login;
//import org.wso2.carbon.core.services.authentication.LoginResponse;
//
//import javax.net.ssl.SSLContext;
//import java.rmi.RemoteException;
//import java.security.KeyManagementException;
//import java.security.KeyStoreException;
//import java.security.NoSuchAlgorithmException;
//
//public class App {
//    public static void main(String[] args) {
//        try {
//
//            SSLContext sslContext = SSLContexts.custom()
//                    .loadTrustMaterial(new TrustSelfSignedStrategy())
//                    .build();
//            SSLContext.setDefault(sslContext);
//
//
//            AuthenticationAdminStub stub = new AuthenticationAdminStub("https://127.0.0.1:9443/services/AuthenticationAdmin.AuthenticationAdminHttpsSoap11Endpoint/");
//            Options options =stub._getServiceClient().getOptions();
//            options.setProperty(HTTPConstants.REUSE_HTTP_CLIENT, "true");
//            options.setProperty(HTTPConstants.CHUNKED, "false");
//            options.setManageSession(true);
//
//            Login login = new Login();
//            login.setUsername("checker2");
//            login.setPassword("checker2");
//            //login.setRemoteAddress("127.0.0.1");
//            LoginResponse response = stub.login(login);
//
////            MessageContext context = stub._getServiceClient().getLastOperationContext().getMessageContext("In");
//            MessageContext context = stub._getServiceClient().getLastOperationContext().getMessageContext(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
//            //SOAPEnvelope envelope = context.getEnvelope();
////            System.out.println(envelope);
//            CommonsTransportHeaders commonsTransportHeaders=(CommonsTransportHeaders)context.getProperty(MessageContext.TRANSPORT_HEADERS);
//            System.out.println(commonsTransportHeaders.get("Set-Cookie").toString());
//        } catch (AxisFault axisFault) {
//            axisFault.printStackTrace();
//        } catch (AuthenticationAdminAuthenticationExceptionException e) {
//            e.printStackTrace();
//        } catch (RemoteException e) {
//            e.printStackTrace();
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        } catch (KeyStoreException e) {
//            e.printStackTrace();
//        } catch (KeyManagementException e) {
//            e.printStackTrace();
//        }
//    }
//}
