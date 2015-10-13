<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- Fixed navbar -->
<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
  <div class="container">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
        <span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="${pageContext.request.contextPath}">Llama Kisses</a>
    </div>
    <div class="collapse navbar-collapse">
      <c:choose>
        <c:when test="${empty currentUser}"> 
        <form accept-charset="UTF-8" action="${pageContext.request.contextPath}/j_spring_security_check" class="navbar-form navbar-right" role="form" method="post">
            <div class="form-group">
              <input type="text" name="j_username" placeholder="Email" class="form-control">
            </div>
            <div class="form-group">
              <input type="password" name="j_password" placeholder="Password" class="form-control">
            </div>
            <button type="submit" class="btn btn-success">Sign in</button>
          </form>
        </c:when>
        <c:otherwise>
          <a href="${pageContext.request.contextPath}/j_spring_security_logout" class="btn btn-success navbar-right" style="margin-top: 8px;">Log Out</a>
          <h4 class="navbar-right" style="color: #ffffff; margin: 14px 10px 0px 0px;">${currentUser}</h4>
        </c:otherwise>
      </c:choose>
    </div>
    <!--/.nav-collapse -->
  </div>
</div>
<c:if test="${not empty error}">
  <div class="alert alert-danger" style="padding: 10px; margin: 60px 5px 10px 5px;">
    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
    ${error}
  </div>
</c:if>
<c:if test="${not empty msg}">
  <div class="alert alert-success" style="padding: 10px; margin: 60px 5px 10px 5px;">
    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
    ${msg}
  </div>
</c:if>