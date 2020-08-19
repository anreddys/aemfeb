package com.aem.aemtraining.core.servlets;

import java.io.IOException;
import java.util.List;

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

@Component(service = Servlet.class, property = { Constants.SERVICE_DESCRIPTION + "=Employee Fetch Servlet",
		"sling.servlet.methods=" + HttpConstants.METHOD_POST, "sling.servlet.paths=" + "/bin/employfetch" })
public class EmployFetchServlet extends SlingAllMethodsServlet {

	private static final Logger log = LoggerFactory.getLogger(EmployFetchServlet.class);

	@Reference
	private EmployI emp;
	
	Employees obj;

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

		try {

			List<Employees> b = emp.getAllEmployees();
			
			log.info("list of Employees -------------------from EmployeFertchServlet"+b);
			for (int i = 0; i < b.size(); i++) {
			String ag=obj.getAge();
			
			if(ag=="30") {
				
				obj.getWeight();
				
			}
			 obj=b.get(0);
			 
			 
			 
			     
			
			
				
			}
			
			log.info("Allu Record getting from  database----------"+obj);
			

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
