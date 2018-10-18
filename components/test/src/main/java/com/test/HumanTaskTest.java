package com.test;

import org.apache.axiom.mime.Header;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;
import org.apache.axis2.transport.http.HTTPConstants;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.ssl.SSLContexts;
import org.oasis_open.docs.ns.bpel4people.ws_humantask.api._200803.HumanTaskClientAPIAdminStub;
import org.oasis_open.docs.ns.bpel4people.ws_humantask.api._200803.SimpleQueryDocument;
import org.oasis_open.docs.ns.bpel4people.ws_humantask.api._200803.SimpleQueryResponseDocument;
import org.oasis_open.docs.ns.bpel4people.ws_humantask.types._200803.TSimpleQueryCategory;
import org.oasis_open.docs.ns.bpel4people.ws_humantask.types._200803.TSimpleQueryInput;
import org.oasis_open.docs.ns.bpel4people.ws_humantask.types._200803.TTaskSimpleQueryResultRow;
import org.oasis_open.docs.ns.bpel4people.ws_humantask.types._200803.TTaskSimpleQueryResultSet;

import javax.net.ssl.SSLContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HumanTaskTest {
    public static void main(String[] args) {
        try {
            SSLContext sslContext = SSLContexts.custom()
                    .loadTrustMaterial(new TrustSelfSignedStrategy())
                    .build();
            SSLContext.setDefault(sslContext);

            HumanTaskClientAPIAdminStub stub = new HumanTaskClientAPIAdminStub("https://localhost:9443/services/HumanTaskClientAPIAdmin/");
            Options options = stub._getServiceClient().getOptions();
            options.setProperty(HTTPConstants.REUSE_HTTP_CLIENT, "true");
            options.setProperty(HTTPConstants.CHUNKED, "false");
            options.setManageSession(true);

            Map<String, String> property = new HashMap<>();
            property.put("Cookie", "JSESSIONID=8A8A79C60D031B55E42A0986E68F4A1A");
//            property.put("AccessToken", "fgfsdfsdfddfdfdf==");

            options.setProperty( org.apache.axis2.transport.http.HTTPConstants.HTTP_HEADERS , property);

            stub._getServiceClient().setOptions(options);

//            Header header = new Header("Cookie", "JSESSIONID=430D053F3C65B9307A6864A696E6CE73");
//            List<Header> headerList = new ArrayList<>();
//            headerList.add(header);
//            options.setProperty(org.apache.axis2.transport.http.HTTPConstants.HTTP_HEADERS, headerList);

            SimpleQueryDocument document = SimpleQueryDocument.Factory.newInstance();
            SimpleQueryDocument.SimpleQuery query = SimpleQueryDocument.SimpleQuery.Factory.newInstance();
            TSimpleQueryInput input = TSimpleQueryInput.Factory.newInstance();
            input.setSimpleQueryCategory(TSimpleQueryCategory.ALL_TASKS);

            query.setSimpleQueryInput(input);
            document.setSimpleQuery(query);


//            MessageContext context = stub._getServiceClient().getLastOperationContext().getMessageContext(WSDLConstants.MESSAGE_LABEL_OUT_VALUE);
//            CommonsTransportHeaders commonsTransportHeaders=(CommonsTransportHeaders)context.getProperty(MessageContext.TRANSPORT_HEADERS);
//            commonsTransportHeaders.put("Cookie", "JSESSIONID=430D053F3C65B9307A6864A696E6CE73");

            SimpleQueryResponseDocument response = stub.simpleQuery(document);




            SimpleQueryResponseDocument.SimpleQueryResponse resp = response.getSimpleQueryResponse();



            TTaskSimpleQueryResultSet resultSet = resp.getTaskSimpleQueryResultSet();
            TTaskSimpleQueryResultRow rows[] =resultSet.getRowArray();
            for (TTaskSimpleQueryResultRow row: rows) {

            }

            System.out.println(resultSet.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
//
    }
}
