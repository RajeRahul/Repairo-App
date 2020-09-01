<%@ include file="common/header.jsp" %>
<%@ include file="common/navigation.jsp" %>

    <div class="container text-center">
      <h1 class="home-text headline">Welcome to Repairo!</h1>
      <h3 class="home-text tagline">Find the perfect repairman to solve your problems</h3>
      <img class="repairmen-img" src='<c:url value="/resources/images/repairmen.jpg"></c:url>'/>
      <a href="/searchrepairmen" class="btn btn-info btn-xl find-btn">Look for Repairmen</a>
    </div>

    <div class="top-fifteen-div text-center">
      <h1 class="repairmen-heading">Our top skilled repairmen</h1>
    </div>

    <div class="container repairmen-container">
      <div class="row">
        <c:forEach items="${repairlist}" var="repairman">
          <div class="card text-center home-page-cards">
            <img src='<c:url value="/resources/images/${repairman.occupation}.jpg"></c:url>' class="card-img-top" alt="repairman-img" height="260px">
              <div class="card-body">
                <h5 class="card-title">
                  <a href="/servicerequest?id=${repairman.id}">${repairman.first_name} ${repairman.last_name}</a>
                </h5>
                <p class="card-text"><strong>${repairman.occupation}</strong></p>
                <p class="card-text">rating: ${repairman.rating}</p>
              </div>
            </div>
          </c:forEach>
        </div>
      </div>

      <footer id="footer">
        <div class="container-fluid text-center">
          <p class="footer_text">&copy Copyright 2020 Rahul Raje</p>
        </div>
      </footer>

<%@ include file="common/footer.jsp" %>
