<%@ include file="common/header.jsp" %>
<%@ include file="common/navigation.jsp" %>

<div class="container text-center">
  <div class="result-heading">
      <h1>Repairmen according to your preferences</h1>
  </div>
</div>
<div class="custom-container text-center">
  <table class="table">
    <thead>
      <tr>
        <th>Name</th>
        <th>Occupation</th>
        <th>Location</th>
        <th>Base Price</th>
        <th>Skills</th>
        <th>Rating</th>
        <th></th>
      </tr>
    </thead>
    <tbody>
      <c:forEach items="${resultlist}" var="repairman">
        <tr>
          <td>${repairman.first_name} ${repairman.last_name}</td>
          <td>${repairman.occupation}</td>
          <td>${repairman.location}</td>
          <td>&#8377; ${repairman.base_price}</td>
          <td>${repairman.skills}</td>
          <td>${repairman.rating}</td>
          <td><a href="/servicerequest?id=${repairman.id}" class="btn btn-warning">Request for Service</a></td>
        </tr>
      </c:forEach>
    </tbody>
  </table>
</div>

<%@ include file="common/footer.jsp" %>
