<!DOCTYPE html>

<html lang="en">
  <jsp:include page="application/head.jsp" />
  <body>
    <div id="wrap">
      <jsp:include page="application/navigation.jsp" />
      <jsp:include page="pages/index.jsp" />
      <!-- {{ yield|raw }}  -->
    </div>
    <jsp:include page="application/footer.jsp" />
  </body>
</html>