package schoolmanagement;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/project")
public class SessionServlet1 extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("projectt");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		String name= req.getParameter("name");
		int age = Integer.parseInt(req.getParameter("age")) ;
		String email = req.getParameter("email");
		long mobile_number = Long.parseLong(req.getParameter("mobile_number"));
		String password = req.getParameter("password");
		
		Principal p = new Principal();
		p.setName(name);
		p.setEmail(email);
		p.setAge(age);
		p.setMobilenum(mobile_number);
		p.setPwd(password);

		et.begin();
		em.persist(p);
		et.commit();
	
		RequestDispatcher rd = req.getRequestDispatcher("LoginFile.html");
		rd.forward(req, res);
	}

	
}
