<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:message code="page.main" var="title" />
<jsp:include page="/WEB-INF/views/header.jsp">
    <jsp:param name="title" value="${title}"/>
    <jsp:param name="activeLink" value="home"/>
</jsp:include>

<div class="content">
    <div class="container">

        <div class="page-title brand-description">
            <h1 class="home-brand">&lt Apartment Booking &gt</h1>
            <h2><spring:message code="brand.motto"/></h2>
            <h3><spring:message code="brand.description"/></h3>
        </div>

        <%--<div class="page-title">
            <p><spring:message code="user.login" />: ${user.login}</p>
            <p><spring:message code="user.password" />: ${user.password}</p>
            <p><spring:message code="user.role" />: ${user.role}</p>
        </div>--%>

    </div><!-- /.container -->
</div>
<!-- /.content -->

<%@ include file="/WEB-INF/views/footer.jsp" %>