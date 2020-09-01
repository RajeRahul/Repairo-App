<%@ include file="common/header.jsp" %>
<%@ include file="common/admin-navigation.jsp" %>

<div class="container text-center">
  <div class="result-heading">
      <h1>Requests recieved from Users</h1>
  </div>
</div>
<div class="custom-container text-center">
  <table class="table">
    <thead>
      <tr>
        <th>request ID</th>
        <th>repairman ID</th>
        <th>first name</th>
        <th>last name</th>
        <th>email id</th>
        <th>phone no.</th>
        <th>address</th>
        <th>problem</th>
        <th></th>
      </tr>
    </thead>
    <tbody>
      <c:forEach items="${userrequests}" var="request">
        <tr>
          <td>${request.requestId}</td>
          <td>${request.repairmanId}</td>
          <td>${request.user_first_name}</td>
          <td>${request.user_last_name}</td>
          <td>${request.user_email}</td>
          <td>${request.user_phone}</td>
          <td>${request.user_address}</td>
          <td>${request.user_problem}</td>
          <td><a href="/admin-deleterequest?requestid=${request.requestId}" class="btn btn-danger">Delete</a></td>
        </tr>
      </c:forEach>
    </tbody>
  </table>
</div>

<%@ include file="common/footer.jsp" %>
