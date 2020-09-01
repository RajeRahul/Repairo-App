<%@ include file="common/header.jsp" %>
<%@ include file="common/admin-navigation.jsp" %>

<div class="container text-center">
  <div class="result-heading">
      <h1>Manage your Repairmen here</h1>
  </div>
  <a href="/admin-addrepairman" class="btn btn-info btn-lg add-btn" >Add new Repairman</a>
</div>
<div class="custom-container text-center">
  <table class="table">
    <thead>
      <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Occupation</th>
        <th>Location</th>
        <th>Base Price</th>
        <th>Skills</th>
        <th>Rating</th>
        <th></th>
        <th></th>
      </tr>
    </thead>
    <tbody>
      <c:forEach items="${allrepairmen}" var="repairman">
        <tr>
          <td>${repairman.id}</td>
          <td>${repairman.first_name} ${repairman.last_name}</td>
          <td>${repairman.occupation}</td>
          <td>${repairman.location}</td>
          <td>&#8377; ${repairman.base_price}</td>
          <td>${repairman.skills}</td>
          <td>${repairman.rating}</td>
          <td><a href="/admin-editrepairman?id=${repairman.id}" class="btn btn-success">Edit</a></td>
          <td><a href="/admin-deleterepairman?id=${repairman.id}" class="btn btn-danger">Delete</a></td>
        </tr>
      </c:forEach>
    </tbody>
  </table>
</div>

<%@ include file="common/footer.jsp" %>
