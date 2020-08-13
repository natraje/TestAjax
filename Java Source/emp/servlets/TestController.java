package emp.servlets;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import emp.broker.EmpBroker;

/**
 * @version 	1.0
 * @author
 */
public class TestController extends HttpServlet {

	/**
	* @see javax.servlet.http.HttpServlet#void (javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	*/
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
		
		performAction(req,resp);
	}

	/**
	* @see javax.servlet.http.HttpServlet#void (javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	*/
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
			
			performAction(req,resp);

	}

	/**
	* @see javax.servlet.GenericServlet#java.lang.String ()
	*/
	public String getServletInfo() {

		return super.getServletInfo();

	}

	/**
	* @see javax.servlet.GenericServlet#void ()
	*/
	public void init() throws ServletException {

		super.init();

	}

	/**
	 * Method performAction.
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	private void performAction(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Inside PerformAction");
		String action=req.getParameter("action");
		String targetId = req.getParameter("id");

		if(null==action){
			callJSPPage(req,resp,"/Jsp/emp/MainPage.jsp");
		} else{
			System.out.println("In else loop");
			System.out.println("ID Value:"+targetId);
		if ((targetId != null)) 
    	 {
    	 	EmpBroker empBroker=new EmpBroker();
    	 	System.out.println("testing");
            resp.setContentType("text/xml");
            resp.setHeader("Cache-Control", "no-cache");
            String name=empBroker.checkEmployee(targetId);
            if("".equals(name)){
            	name="invalid id";
            }
            resp.getWriter().write(name); 
	     } 
    	 else 
	     {
            resp.setContentType("text/xml");
            resp.setHeader("Cache-Control", "no-cache");
            resp.getWriter().write("invalid"); 
    	  }

		}
	}


	/**
	 * Method callJSPPage.
	 * @param req
	 * @param resp
	 * @param strPageName
	 */
	public void callJSPPage(HttpServletRequest req,HttpServletResponse resp,String strPageName) {

	try {
			ServletContext sc = getServletContext();
			RequestDispatcher rd =sc.getRequestDispatcher( strPageName);
			rd.forward(req, resp);
		} catch (Exception e) {
			System.out.println("Exp:"+e.getMessage());			
		}

	}	

}
