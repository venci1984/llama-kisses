<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="col-xs-12 col-md-3">
  <div class="panel panel-danger">
    <c:if test="${empty offerId}">
      <div class="cnrflash">
        <div class="cnrflash-inner">
          <span class="cnrflash-label">MOST<br />POPULAR
          </span>
        </div>
      </div>
    </c:if>
    <div class="panel-heading">
      <h3 class="panel-title">Pure Bliss</h3>
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
        49&euro;<span class="subscript">/mo</span>
      </h1>
      <small>1 month FREE trial</small>
        <div>
          <h3>100 Kisses</h3>
          <span>each month</span>
        </div>
      </div>
    </div>
    <c:if test="${empty offerId}">
    <div class="panel-footer">
      <a href="${pageContext.request.contextPath}/signup?offerId=3" class="btn btn-success" role="button">Sign Up</a> 1 month FREE trial
    </div>
    </c:if>
  </div>
</div>