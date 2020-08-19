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
@Component(service=Servlet.class,
property={
        Constants.SERVICE_DESCRIPTION + "=Employee Register Servlet",
        "sling.servlet.methods=" + HttpConstants.METHOD_POST, "sling.servlet.paths=" + "/bin/employregister"            
})
public class EmployRegisterServlet extends SlingAllMethodsServlet {
	
	 private static final Logger log = LoggerFactory.getLogger(EmployRegisterServlet.class);
	 
	 
	 @Reference
	 private EmployI emp;
	
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
		//super.doPost(request, response);
		
		String name=request.getParameter("name");
		String age=request.getParameter("age");
		String email=request.getParameter("email");
		String weight=request.getParameter("weight");
		
		
		
		
		
		
		try {
			
			Employees emps=new Employees();
			
			emps.setName(name);
			emps.setAge(age);
			emps.setEmail(email);
			emps.setWeight(weight);
			
			
		boolean b=emp.registerEmployeeDetails(emps);
		
		
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
		
		
		
	}

}
