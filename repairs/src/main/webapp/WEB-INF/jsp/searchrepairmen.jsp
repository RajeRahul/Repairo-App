<%@ include file="common/header.jsp" %>
<%@ include file="common/navigation.jsp" %>

<div class="container text-center">
  <form class="form" action="/results" method="get" onsubmit="return atLeastOneChecked()">

  <div class="search-heading">
      <h1>Select types of services required</h1>
  </div>

    <div class="row types-container">
      <c:forEach items="${occupationlist}" var="occupation">
        <div class="types-div">
          <input type="checkbox" class="search-checkbox service-chk" name="<c:out value = "${occupation}"/>" id="<c:out value = "${occupation}"/>">
          <label class="checkbox-label" for="<c:out value = "${occupation}"/>"><c:out value = "${occupation}"/></label>
        </div>
      </c:forEach>
    </div>

    <div class="search-heading">
        <h1>Select preferred locations</h1>
    </div>

    <div class="row locations-container">
      <c:forEach items="${locationlist}" var="location">
        <div class="locations-div">
          <input type="checkbox" class="search-checkbox location-chk" name="<c:out value = "${location}"/>" id="<c:out value = "${location}"/>">
          <label class="checkbox-label" for="<c:out value = "${location}"/>"><c:out value = "${location}"/></label>
        </div>
      </c:forEach>
    </div>

    <input type="submit" class="btn btn-info btn-xl find-btn" value="Find repairmen">

  </form>

</div>

<%@ include file="common/footer.jsp" %>
