<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="jumbotron">
  <div class="container">
    <div class="pull-right" style="margin-top: 10px;">
      <img src="${pageContext.request.contextPath}/resources/images/llama-heading.png" alt="Llama" style="margin-top: 20px; height: 225px;">
    </div>
    <h1>Llama Ranch</h1>
    <p style="text-align: justify;">Here you can see how to process credit card payments or recurring payments (subscriptions) through
      Java web application using PAYMILL. PAYMILL is a payment gateway that is easy to set up and which is very developer friendly.</p>
    <p>
      <a href="https://github.com/paymill/paymill-example-php-subscriptions" class="btn btn-primary btn-lg" role="button" rel="external">Learn
        more »</a>
    </p>
  </div>
</div>
<c:choose>
  <c:when test="${empty currentUser}">
    <jsp:include page="offers.jsp" />
  </c:when>
  <c:otherwise>
    <jsp:include page="selected-offer.jsp" />
  </c:otherwise>
</c:choose>