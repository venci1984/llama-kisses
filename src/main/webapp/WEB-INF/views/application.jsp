<!DOCTYPE html>

<html lang="en">
<jsp:include page="application/head.jsp" />
<body>
  <div id="wrap">
    <jsp:include page="application/navigation.jsp" />
    <jsp:include page="${addView}" flush="true" />
  </div>
  <jsp:include page="application/footer.jsp" />
</body>
</html>