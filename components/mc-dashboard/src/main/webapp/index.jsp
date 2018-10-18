<%@ page import="java.util.List" %>

<%@ page import="com.wso2telco.ids.makerchecker.util.HumanTaskUtil" %>
<%@ page import="com.wso2telco.ids.makerchecker.util.CommonUtil" %>
<%@ page import="com.wso2telco.ids.makerchecker.dto.HumanTaskDto" %>
<%@ page import="com.wso2telco.ids.makerchecker.exception.HumanTaskException" %>

<%
    String user = (String)session.getAttribute("username");
    if (user == null || user.isEmpty()) {
       response.sendRedirect("login.jsp");
       return;
    }

    String sessionCookie = (String)session.getAttribute("sessionCookie");
    if (sessionCookie == null || sessionCookie.isEmpty()) {
        response.sendRedirect("login.jsp");
        return;
    }
    String serviceEndpoint = CommonUtil.constructServerUrl(request) + "/services/HumanTaskClientAPIAdmin/";

    String taskFilter = request.getParameter("taskFilter");

    if (taskFilter == null || taskFilter.isEmpty()) {
        taskFilter = "ALL";
    }

    List<HumanTaskDto> taskList = null;
    try {
        taskList = HumanTaskUtil.getAllTasks(sessionCookie, taskFilter, serviceEndpoint);
    } catch (HumanTaskException e) {
        response.sendRedirect("login.jsp");
        return;
    }
%>

<html>
    <head>
        <title>Dashboard - Maker Checker</title>
        <link rel="stylesheet" type="text/css" href="assets/css/bootstrap.min.css"/>

        <script type="text/javascript" src="assets/js/jquery-3.3.1.min.js"></script>
        <script type="text/javascript" src="assets/js/popper.min.js"></script>
        <script type="text/javascript" src="assets/js/bootstrap.min.js"></script>
    </head>

    <body>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
          <a class="navbar-brand" href="#">DASHBOARD / HOME</a>
          <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>

          <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
            </ul>
            <div class="form-inline my-2 my-lg-0">

            <div class="btn-group">
                <button class=" btn dropdown-toggle" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    <img src="assets/img/person.svg" alt="user icon" width="16px"/>
                    <span><%=user%></span>
                </button>
                <div class="dropdown-menu">
                    <a class="dropdown-item" href="logout.jsp">Logout</a>
                </div>
            </div>
            </div>
          </div>
        </nav>

        <hr/>

        <div class="container">
            <div class="row">
                <div class="col">
                    <div class="form-group">
                        <label for="taskFilterOptions">Filter Tasks</label>
                        <select class="form-control" id="taskFilterOptions">
                            <option selected hidden><%= taskFilter %></option>
                            <option value="ALL">ALL</option>
                            <option value="RESERVED">RESERVED</option>
                            <option value="COMPLETED">COMPLETED</option>
                            <option value="READY">READY</option>
                        </select>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <table class="table table-bordered table-condensed">
                        <thead>
                            <th>Task Id</th>
                            <th>Subject</th>
                            <th>Status</th>
                            <th>Priority</th>
                            <th>Created On</th>
                            <th>Actions</th>
                        </thead>

                        <tbody>
                            <% for (HumanTaskDto task: taskList) { %>
                                <tr>
                                    <td><%=task.getTaskId()%></td>
                                    <td><%=task.getSubject()%></td>
                                    <td><%=task.getStatus()%></td>
                                    <td><%=String.valueOf(task.getPriority())%></td>
                                    <td><%=task.getCreatedTime().toString()%></td>

                                    <td>
                                        <div class="dropdown">
                                            <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                Actions
                                            </button>
                                            <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                                                <a class="dropdown-item" href="#">Approve</a>
                                                <a class="dropdown-item" href="#">Reject</a>
                                                <a class="dropdown-item" href="#">More info</a>
                                            </div>
                                        </div>
                                    </td>
                                </tr>
                            <% } %>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>

        <script type="text/javascript">
            $("#taskFilterOptions").on("click", e => {
                let option = $("#taskFilterOptions").val();

                window.location = "index.jsp?taskFilter=" + option;
            });
        </script>
    </body>
</html>