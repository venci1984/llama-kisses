<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="col-xs-12 col-md-3">
  <div class="panel panel-primary">
    <div class="panel-heading">
      <h3 class="panel-title">I'm in Heaven</h3>
    </div>
    <div class="panel-body">
      <c:choose>
        <c:when test="${not empty offerId}">
          <div class="the-price" style="padding: 52px 20px;">
        </c:when>
        <c:otherwise>
          <div class="the-price">
        </c:otherwise>
      </c:choose>
      <h1>
        99&euro;<span class="subscript">/mo</span>
      </h1>
      <small>1 month FREE trial</small>
        <div>
          <h3>250 Kisses</h3>
          <span>each month</span>
        </div>
      </div>
    </div>
    <c:if test="${empty offerId}">
    <div class="panel-footer">
      <a href="${pageContext.request.contextPath}/signup?offerId=4" class="btn btn-success" role="button">Sign Up</a> 1 month FREE trial
    </div>
    </c:if>
  </div>
</div>