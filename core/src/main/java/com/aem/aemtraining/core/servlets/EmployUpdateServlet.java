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

import com.aem.aemtraining.core.bean.Employees;
import com.aem.aemtraining.core.service.EmployI;

@Component(service = Servlet.class, property = { Constants.SERVICE_DESCRIPTION + "=Employee update Servlet",
		"sling.servlet.methods=" + HttpConstants.METHOD_POST, "sling.servlet.paths=" + "/bin/employupdate" })
public class EmployUpdateServlet extends SlingAllMethodsServlet {

	private static final Logger log = LoggerFactory.getLogger(EmployUpdateServlet.class);

	@Reference
	private EmployI empUpdate;

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
		// super.doPost(request, response);

		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String email = request.getParameter("email");
		String weight = request.getParameter("weight");

		try {

			boolean b = empUpdate.updateEmployee(name,age,email,weight);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
