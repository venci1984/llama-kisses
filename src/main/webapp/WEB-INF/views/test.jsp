<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="ventsislav.georgiev@qaiware.com">
<link rel="shortcut icon" href="resources/ico/favicon.png">

<title>Llama Kisses</title>

<link href="resources/css/bootstrap.css" rel="stylesheet">
<link href="resources/css/sticky-footer-navbar.css" rel="stylesheet">
<link href="resources/css/navigation.css" rel="stylesheet">

<!-- Just for debugging purposes. Don't actually copy this line! -->
<!--[if lt IE 9]><script src="../../docs-assets/js/ie8-responsive-file-warning.js"></script><![endif]-->

<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
  <![endif]-->
</head>
<body>
  <!-- Fixed navbar -->
  <div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
      <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
          <span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span
            class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="index.php?controller=pages&action=index">Llama Kisses</a>
      </div>
      <div class="collapse navbar-collapse">
        <c:choose>
          <c:when test="${empty currentUser}"> -->
        <form accept-charset="UTF-8" action="j_spring_security_check" class="navbar-form navbar-right" role="form" method="post">
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
            <a href="<c:url value="j_spring_security_logout" />" class="btn btn-success navbar-right" style="margin-top: 8px;">Log Out</a>
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
  <div class="jumbotron">
    <div class="container">
      <div class="pull-right" style="margin-top: 10px;">
        <img src="resources/images/llama-heading.png" alt="Llama" style="margin-top: 20px; height: 225px;">
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
  <div class="container">
    <jsp:include page="partials/never-been-kissed.jsp" />
    <jsp:include page="partials/cant-get-enough.jsp" />
    <jsp:include page="partials/pure-bliss.jsp" />
    <jsp:include page="partials/im-in-heaven.jsp" />
  </div>

  <div id="footer">
    <div class="container">
      <p class="text-muted">
        Copyright © 2013-2014 <a href="http://www.paymill.com" rel="external" style="text-decoration: none;">PAYMILL</a>
      </p>
    </div>
  </div>
  <script src="https://bridge.paymill.com/" type="text/javascript"></script>
  <script src="https://static.paymill.com/resources/js/jquery/jquery-1.7.2.min.js" type="text/javascript"></script>
  <script src="resources/js/paymill.js" type="text/javascript"></script>
  <script src="resources/js/bootstrap.min.js" type="text/javascript"></script>

</body>
</html>
