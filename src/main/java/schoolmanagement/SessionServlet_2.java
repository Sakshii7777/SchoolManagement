package schoolmanagement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/project2")
public class SessionServlet_2 extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EntityManagerFactory emf =Persistence.createEntityManagerFactory("projectt");
		EntityManager em = emf.createEntityManager();
		
		String email = req.getParameter("email");
		String pwd = req.getParameter("pwd");
		
		Query q = em.createQuery("Select p from Principal p where p.email=?1 and p.pwd=?2");
		q.setParameter(1, email);
		q.setParameter(2, pwd);
		
		List<Principal> pr = q.getResultList();
		if(pr.size()>0)
		{
			RequestDispatcher rd = req.getRequestDispatcher("NavigationFile2.html");
			rd.forward(req, resp);
		}
		else
		{
			System.out.println("Invalid Credentials...");
		}
	}
}
