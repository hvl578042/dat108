<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://unpkg.com/purecss@1.0.0/build/pure-min.css">
<title>Deltagerliste</title>
</head>
<body>
	<h2>Deltagerliste</h2>
	<table class="pure-table">
		<tr bgcolor="#cccccc">
			<th>Kjønn</th>
			<th align="left">Navn</th>
			<th align="left">Mobil</th>
		</tr>
		<c:forEach items="${deltagere}" var="deltager">
			<c:choose>
				<c:when test="${deltager.mobil eq mobil}">
					<tr bgcolor="#aaffaa">

						<c:set var="kjonn" value="${deltager.kjonn}" />
						<c:choose>
							<c:when test="${deltager.kjonn eq 'kvinne'}">
								<td align="center"><font color="#008000">&#9792;</font></td>
							</c:when>
							<c:otherwise>
								<td align="center"><font color="#008000">&#9794;</font></td>
							</c:otherwise>
						</c:choose>
						<td><c:out value="${deltager.fornavn}" /> &nbsp; <c:out
								value="${deltager.etternavn}" /></td>
						<td><c:out value="${deltager.mobil}" /></td>
					</tr>
				</c:when>
				<c:otherwise>
					<tr bgcolor="#ffffff">

						<c:set var="kjonn" value="${deltager.kjonn}" />
						<c:choose>
							<c:when test="${deltager.kjonn eq 'mann'}">
								<td align="center"><font color="#008000">&#9794;</font></td>
							</c:when>
							<c:otherwise>
								<td align="center"><font color="#008000">&#9792;</font></td>
							</c:otherwise>
						</c:choose>
						<td><c:out value="${deltager.fornavn}" /> &nbsp; <c:out
								value="${deltager.etternavn}" /></td>
						<td><c:out value="${deltager.mobil}" /></td>
					</tr>
				</c:otherwise>
			</c:choose>
		</c:forEach>


	</table>




	<p>
		<a href="LoggetUt">Ferdig</a>
	</p>

</body>
</html>