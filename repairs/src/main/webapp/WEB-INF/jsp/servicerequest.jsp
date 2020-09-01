<%@ include file="common/header.jsp" %>
<%@ include file="common/navigation.jsp" %>

<div class="row">
  <div class="container column1">
  <h1 class="service-heading">Your Details</h1>

  <c:forEach items="${repairman}" var="repairman">
  <form class="service-form" action="/success?" method="get">
    <div class="form-group row">
      <label for="form-first-name" class="col-sm-2 col-form-label">First Name</label>
      <div class="col-sm-10">
        <input type="text" name="fname" class="form-control" id="form-first-name" required>
      </div>
    </div>
    <div class="form-group row">
      <label for="form-last-name" class="col-sm-2 col-form-label">Last Name</label>
      <div class="col-sm-10">
        <input type="text" name="lname" class="form-control" id="form-last-name" required>
      </div>
    </div>
    <div class="form-group row">
      <label for="form-email" class="col-sm-2 col-form-label">Email</label>
      <div class="col-sm-10">
        <input type="email" name="email" class="form-control" id="form-email">
      </div>
    </div>
    <div class="form-group row">
      <label for="form-phone-no" class="col-sm-2 col-form-label">Phone No.</label>
      <div class="col-sm-10">
        <input type="text" name="phone" class="form-control" id="form-phone-no" pattern="[7-9]{1}[0-9]{9}" placeholder="E.g:9181653465 Must start with 7,8 or 9 and be exactly 10 characters" maxlength="10" required>
      </div>
    </div>
    <div class="form-group row">
      <label for="form-address" class="col-sm-2 col-form-label">Address</label>
      <div class="col-sm-10">
        <textarea class="form-control" name="address" id="form-address" rows="2" maxlength="100" placeholder="E.g: 102 LMD complex, Shinde street, Bavdhan, Pune (Limit to 100 charachters)" required></textarea>
      </div>
    </div>
    <div class="form-group row">
      <label for="form-problem" class="col-sm-2 col-form-label">Problem Description</label>
      <div class="col-sm-10">
        <textarea class="form-control" name="problem" id="form-problem" rows="3" maxlength="100" placeholder="Optional. E.g: Leakage problem, Bedroom Painting, customize furniture, customize vehicle e.t.c (Limit to 100 characters)"></textarea>
      </div>
    </div>
    <div class="form-group row">
      <label for="form-repairman-id" class="col-sm-2 col-form-label">Repairman ID</label>
      <div class="col-sm-10">
        <input type="text" name="repairmanId" class="form-control" value="${repairman.id}" id="form-repairman-id" readonly>
      </div>
    </div>
    <div class="form-group text-center">
      <input type="submit" class="btn btn-info btn-xl" value="Request Service">
    </div>
  </form>
</c:forEach>
  </div>

  <div class="container column2">
    <h1 class="service-heading">Repairman Information</h1>
    <table class="table">
      <c:forEach items="${repairman}" var="repairman">
        <tr>
          <th style="text-align: center;"><img src='<c:url value="/resources/images/${repairman.occupation}.jpg"></c:url>'  alt="repairman-img" height="260px"></th>
        </tr>
        <tr>
          <td><strong>Name: </strong>${repairman.first_name} ${repairman.last_name}</td>
        </tr>
        <tr>
          <td><strong>Occupation: </strong>${repairman.occupation}</td>
        </tr>
        <tr>
          <td><strong>Location: </strong>${repairman.location}</td>
        </tr>
        <tr>
          <td><strong>Base Price: </strong>&#8377; ${repairman.base_price}</td>
        </tr>
        <tr>
          <td><strong>Skills: </strong>${repairman.skills}</td>
        </tr>
        <tr>
          <td><strong>Rating: </strong>${repairman.rating}</td>
        </tr>
      </c:forEach>
    </table>
  </div>
</div>



<%@ include file="common/footer.jsp" %>
