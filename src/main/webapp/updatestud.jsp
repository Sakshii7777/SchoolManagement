<%@page import="javax.persistence.EntityManagerFactory"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="schoolmanagement.Student"%>



<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	int id =Integer.parseInt(request.getParameter("id"));
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("projectt");
	EntityManager em = emf.createEntityManager();
	Student s = em.find(Student.class, id);
%>

	<form action="updates" method="post">
		id: <input type="number" value="<%=s.getId()%>" name="id">
		name: <input type="text" value="<%=s.getName()%>" name="name">
		branch: <input type="text" value="<%=s.getBranch()%>" name="branch">
		fees: <input type="number" value="<%=s.getFees()%>"name="fees">
		<input type="submit">
	</form>
	

</body>
</html>