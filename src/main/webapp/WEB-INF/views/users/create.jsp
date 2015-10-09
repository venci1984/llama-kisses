<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!-- {% if errors is not null %} -->
<div class="container">
  <div class="row">
    <div class="col-xs-12 col-sm-12 col-md-4 col-md-offset-4 well well-sm">
      <legend><i class="glyphicon glyphicon-globe"></i> Sign up!</legend>
      <c:if test="${not empty errors}">
      <ul style="padding: 0px;">
        <c:forEach items="${errors}" var="error">
          <li class="alert alert-danger" style="list-style-type: none; padding: 5px;">${error}</li>
        </c:forEach>
      </ul>
      </c:if>
      <form:form action="${pageContext.request.contextPath}/signup/${offerId}" commandName="userForm" method="post" class="form" role="form">
        <form:input class="form-control" path="email" value="${email}" placeholder="Your Email *" type="email" />
        <form:input class="form-control" path="password" placeholder="New Password *" type="password" />
        <form:input class="form-control" path="passwordConfirm" placeholder="Re-enter password *" type="password" />
        <form:input class="form-control" path="name" placeholder="Full Name" value="${name}" type="text" />
<%--         <form:input class="form-control" path="offer" value="${offer}" type="hidden" /> --%>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign up</button>
      </form:form>
    </div>
  </div>
</div>
<!-- {% else %} -->
<!--   <script>window.location.href = "index.php?controller=pages&action=index"</script> -->
<!-- {% endif %}   -->