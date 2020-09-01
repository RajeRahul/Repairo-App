<%@ include file="common/header.jsp" %>
<%@ include file="common/admin-navigation.jsp" %>

<div class="container edit-form-container">

  <form:form method="post" modelAttribute="repairman">

    <form:hidden path="id"></form:hidden>

    <div class="form-group row">
      <form:label path="first_name" class="col-sm-2 col-form-label">First Name</form:label>
      <div class="col-sm-10">
        <form:input type="text" path="first_name" class="form-control" required="required"/>
      </div>
    </div>

    <div class="form-group row">
      <form:label path="last_name" class="col-sm-2 col-form-label">Last Name</form:label>
      <div class="col-sm-10">
        <form:input type="text" path="last_name" class="form-control" required="required"/>
      </div>
    </div>

    <div class="form-group row">
      <form:label path="occupation" class="col-sm-2 col-form-label">Occupation</form:label>
      <div class="col-sm-10">
        <form:input type="text" path="occupation" class="form-control" required="required"/>
      </div>
    </div>

    <div class="form-group row">
      <form:label path="location" class="col-sm-2 col-form-label">Location</form:label>
      <div class="col-sm-10">
        <form:input type="text" path="location" class="form-control" required="required"/>
      </div>
    </div>

    <div class="form-group row">
      <form:label path="base_price" class="col-sm-2 col-form-label">Base Price</form:label>
      <div class="col-sm-10">
        <form:input type="text" path="base_price" class="form-control" required="required"/>
      </div>
    </div>

    <div class="form-group row">
      <form:label path="skills" class="col-sm-2 col-form-label">Skills</form:label>
      <div class="col-sm-10">
        <form:input type="text" path="skills" class="form-control" required="required"/>
      </div>
    </div>

    <div class="form-group row">
      <form:label path="rating" class="col-sm-2 col-form-label">Rating</form:label>
      <div class="col-sm-10">
        <form:input type="text" path="rating" class="form-control" required="required"/>
      </div>
    </div>

    <div class="text-center">
        <button type="submit" class="btn btn-success">Edit</button>
    </div>


  </form:form>
</div>

<%@ include file="common/footer.jsp" %>
