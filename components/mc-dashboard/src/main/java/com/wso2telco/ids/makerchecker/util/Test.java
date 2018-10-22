package com.wso2telco.ids.makerchecker.util;

import com.wso2telco.ids.makerchecker.Constants;
import com.wso2telco.ids.makerchecker.exception.AuthenticationException;
import com.wso2telco.ids.makerchecker.exception.HumanTaskException;

public class Test {
    public static void main(String[] args) {
        String serviceEp = "https://localhost:9443/services/" + Constants.AUTHENTICATION_ENDPOINT;
        String serviceEpHt = "https://localhost:9443/services/HumanTaskClientAPIAdmin/";
        try {
            String sessionCookie = AuthenticationUtil.authenticate("checker2", "checker2", serviceEp);
//            HumanTaskUtil.getTaskInfo("4851", sessionCookie, serviceEpHt);
//            HumanTaskUtil.getTaskDetails("4854", sessionCookie, serviceEpHt);
//            HumanTaskUtil.getTaskInput("4854", sessionCookie, serviceEpHt);

            final String taskId = "9901";
            HumanTaskUtil.startTask(taskId, sessionCookie, serviceEpHt);

            HumanTaskUtil.completeTask(taskId, sessionCookie, serviceEpHt);
        } catch (AuthenticationException e) {
            e.printStackTrace();
        } catch (HumanTaskException e) {
            e.printStackTrace();
        }
    }
}
