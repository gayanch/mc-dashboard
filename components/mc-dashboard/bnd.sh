#!/bin/bash

mvn clean install
rm /home/gayan/dev/wso2/is-packs/wso2is-5.2.0/repository/deployment/server/webapps/mc-dashboard.war
rm -r /home/gayan/dev/wso2/is-packs/wso2is-5.2.0/repository/deployment/server/webapps/mc-dashboard
cp target/mc-dashboard-1.0.0.war /home/gayan/dev/wso2/is-packs/wso2is-5.2.0/repository/deployment/server/webapps/mc-dashboard.war
echo "done"
