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


import com.aem.aemtraining.core.bean.Student;

import com.aem.aemtraining.core.service.StudentIface;

@Component(service = Servlet.class, property = {

		Constants.SERVICE_DESCRIPTION + "=student  Register Servlet",
		"sling.servlet.methods=" + HttpConstants.METHOD_POST, "sling.servlet.paths=" + "/bin/sturegi" })
public class StuGetServ extends SlingAllMethodsServlet {

	private static final Logger log = LoggerFactory.getLogger(StuGetServ.class);

	 @Reference
	private StudentIface ref;
	 Student obj;
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
		try {

			List<Student> b = ref.getAllStudent();
			
			log.info("list of Student -------------------from StuGetServ"+b);
			for (int i = 0; i < b.size(); i++) {
			String e=obj.getEmail();
			
			if(e=="hj") {
				
				obj.getPassword();
				
			}
			 obj=b.get(0);
			 
			 	
				
			}
			
			log.info("Aj Record getting from  database----------"+obj);
			

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
}
