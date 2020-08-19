package com.aem.aemtraining.core.servlets;

import java.io.IOException;

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

import com.aem.aemtraining.core.service.EmployI;
import com.aem.aemtraining.core.service.StudentIface;

@Component(service = Servlet.class, property = {

		Constants.SERVICE_DESCRIPTION + "=student  Register Servlet",
		"sling.servlet.methods=" + HttpConstants.METHOD_POST, "sling.servlet.paths=" + "/bin/sturegi" })
public class Stdserv extends SlingAllMethodsServlet {

	private static final Logger log = LoggerFactory.getLogger(Stdserv.class);

	 @Reference
	private StudentIface ref;

	@Override
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// super.doGet(request, response);
	}

	@Override
	protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response)
			
			throws ServletException, IOException {
		log.info("do post method called");
		// TODO Auto-generated method stub
		String name = request.getParameter("Name");
		String Address = request.getParameter("Address");
		String email = request.getParameter("EMail");
		String Password = request.getParameter("Password");
		String Telephone = request.getParameter("Telephone");
		log.info(name + "" + Address + "" + email + "" + Password + "" + Telephone + "");
		try {

			ref.Stdregi(name, Address, email, Password, Telephone);
		} catch (Exception e) {
			// TODO: handle exception
		}
		// super.doPost(request, response);
		log.info("servlet working");
		// response.getWriter().write("sling servlet working");
	}
}
