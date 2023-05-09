<%@ page language="java" contentType="text/html; charset=windows-1256"
 pageEncoding="windows-1256"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" type="text/css"
href="webjars/bootstrap/4.3.1/css/bootstrap.min.css" />
<c:url value="/css/main.css" var="jstlCss" />
<link href="${jstlCss}" rel="stylesheet" />
<script type="text/javascript"
src="webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>List Cosmetics</title>
</head>
<body>
<div class="container mt-5">
<div class="card">
 <div class="card-header">
 Liste des Produits
 </div>
 <div class="card-body">
 
 <table class="table table-striped">
 <tr>
<th>Reference</th><th>Name</th><th>Price</th><th>Expiration date</th><th>Delete<th>Edition</th>
 </tr>
 <c:forEach items="${cosmetics}" var="p">
 <tr>
 <td>${p.cosmeticReference }</td>
 <td>${p.cosmeticName }</td>
 <td>${p.itemPrice }</td>

 <td><fmt:formatDate pattern="dd/MM/yyyy"
value="${p.expirationDate}" /></td>
 <td><a onclick="return confirm('Are you sure? ')"
href="supprimerCosmetic?id=${p.cosmeticReference }">Supprimer</a></td>
 <td><a href="modifierCosmetic?id=${p.cosmeticReference }">Edit</a></td>
 </tr>
 </c:forEach> 
 </table>
 </div>
</div>
</div>
</body>
</html>
