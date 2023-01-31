package schoolmanagement;

import java.io.IOException;
import java.io.PrintWriter;

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

@WebServlet("/addstud")
public class AdddStudent extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("projectt");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String branch  = req.getParameter("branch");
		long fees = Long.parseLong(req.getParameter("fees"));
		
		Student s = new Student();
		s.setId(id);
		s.setName(name);
		s.setBranch(branch);
		s.setFees(fees);
		
		et.begin();
		em.persist(s);
		et.commit();
		
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter() ;
		pw.write("Students Added");

		
		RequestDispatcher rd = req.getRequestDispatcher("StudentMenu.html");
		rd.include(req, resp);

	}
}
