package com.aem.aemtraining.core.servlets;

import java.io.IOException;
import java.sql.Ref;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aem.aemtraining.core.service.StudentIface;

@Component(service = Servlet.class, property = {

		Constants.SERVICE_DESCRIPTION + "=student  update Servlet",
		"sling.servlet.methods=" + HttpConstants.METHOD_POST, "sling.servlet.paths=" + "/bin/stuUpdate" })



public class StuUpdateServlet extends SlingAllMethodsServlet{
	private static final Logger log = LoggerFactory.getLogger(StuUpdateServlet.class);
	@Reference
	private StudentIface stuUpdate;
@Override
protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
		throws ServletException, IOException {
	// TODO Auto-generated method stub
	super.doGet(request, response);
}
 @Override
	protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	 String name = request.getParameter("Name");
		String Address = request.getParameter("Address");
		String email = request.getParameter("EMail");
		String Password = request.getParameter("Password");
		String Telephone = request.getParameter("Telephone");
		log.info(name + "" + Address + "" + email + "" + Password + "" + Telephone + "");
		try {

			stuUpdate.Stdupate(name, Address, email, Password, Telephone);
		} catch (Exception e) {
			// TODO: handle exception
		}
		// super.doPost(request, response);
		log.info("servlet working");
		// response.getWriter().write("sling servlet working");
	}
		//super.doPost(request, response);
	}

