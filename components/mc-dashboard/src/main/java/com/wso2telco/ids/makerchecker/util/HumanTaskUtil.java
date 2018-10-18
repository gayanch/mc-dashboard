package com.wso2telco.ids.makerchecker.util;

import com.wso2telco.ids.makerchecker.dto.HumanTaskDto;
import com.wso2telco.ids.makerchecker.exception.HumanTaskException;
import org.apache.axis2.AxisFault;
import org.apache.axis2.client.Options;
import org.apache.axis2.transport.http.HTTPConstants;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.ssl.SSLContexts;
import org.oasis_open.docs.ns.bpel4people.ws_humantask.api._200803.*;
import org.oasis_open.docs.ns.bpel4people.ws_humantask.types._200803.TSimpleQueryCategory;
import org.oasis_open.docs.ns.bpel4people.ws_humantask.types._200803.TSimpleQueryInput;
import org.oasis_open.docs.ns.bpel4people.ws_humantask.types._200803.TTaskSimpleQueryResultRow;
import org.oasis_open.docs.ns.bpel4people.ws_humantask.types._200803.TTaskSimpleQueryResultSet;

import javax.net.ssl.SSLContext;
import java.rmi.RemoteException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class HumanTaskUtil {
    public static List<HumanTaskDto> getAllTasks(String sessionCookie, String taskType, String serviceEndpoint) throws HumanTaskException {
        List<HumanTaskDto> taskList = new LinkedList<>();
        try {
            SSLContext sslContext = SSLContexts.custom()
                    .loadTrustMaterial(new TrustSelfSignedStrategy())
                    .build();
            SSLContext.setDefault(sslContext);

            HumanTaskClientAPIAdminStub stub = new HumanTaskClientAPIAdminStub(serviceEndpoint);
            Options options = stub._getServiceClient().getOptions();
            options.setProperty(HTTPConstants.REUSE_HTTP_CLIENT, "true");
            options.setProperty(HTTPConstants.CHUNKED, "false");
            options.setManageSession(true);

            Map<String, String> property = new HashMap<>();
            property.put("Cookie", sessionCookie);

            options.setProperty( org.apache.axis2.transport.http.HTTPConstants.HTTP_HEADERS , property);

            SimpleQueryDocument document = SimpleQueryDocument.Factory.newInstance();
            SimpleQueryDocument.SimpleQuery query = SimpleQueryDocument.SimpleQuery.Factory.newInstance();
            TSimpleQueryInput input = TSimpleQueryInput.Factory.newInstance();
            input.setSimpleQueryCategory(TSimpleQueryCategory.ALL_TASKS);

            query.setSimpleQueryInput(input);
            document.setSimpleQuery(query);

            SimpleQueryResponseDocument response = stub.simpleQuery(document);
            SimpleQueryResponseDocument.SimpleQueryResponse resp = response.getSimpleQueryResponse();
            TTaskSimpleQueryResultSet resultSet = resp.getTaskSimpleQueryResultSet();
            TTaskSimpleQueryResultRow rows[] =resultSet.getRowArray();
            for (TTaskSimpleQueryResultRow row: rows) {
                HumanTaskDto dto = simpleQueryResultRowToHumanTaskDto(row);
                if (taskType == null || taskType.equals("ALL")) {
                    taskList.add(dto);
                } else {
                    if (dto.getStatus().equals(taskType)) {
                        taskList.add(dto);
                    }
                }
            }

            return taskList;
        } catch (IllegalStateFault illegalStateFault) {
            throw new HumanTaskException(illegalStateFault);
        } catch (NoSuchAlgorithmException e) {
            throw new HumanTaskException(e);
        } catch (IllegalArgumentFault illegalArgumentFault) {
            throw new HumanTaskException(illegalArgumentFault);
        } catch (AxisFault axisFault) {
            throw new HumanTaskException(axisFault);
        } catch (RemoteException e) {
            throw new HumanTaskException(e);
        } catch (KeyStoreException e) {
            throw new HumanTaskException(e);
        } catch (KeyManagementException e) {
            throw new HumanTaskException(e);
        }
    }

    private static HumanTaskDto simpleQueryResultRowToHumanTaskDto(TTaskSimpleQueryResultRow row) {
        HumanTaskDto dto = new HumanTaskDto();
        dto.setTaskId(row.getId());
        dto.setStatus(row.getStatus());
        dto.setPriority(row.getPriority());
        dto.setCreatedTime(row.getCreatedTime());
        dto.setSubject(row.getPresentationSubject());

        return dto;
    }
}
