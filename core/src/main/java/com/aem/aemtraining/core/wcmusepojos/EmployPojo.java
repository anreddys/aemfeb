package com.aem.aemtraining.core.wcmusepojos;


import java.util.ArrayList;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adobe.cq.sightly.WCMUsePojo;
import com.aem.aemtraining.core.bean.Employ;
import com.aem.aemtraining.core.bean.Employees;
import com.aem.aemtraining.core.service.EmployI;

public class EmployPojo extends WCMUsePojo {

	private static final Logger log = LoggerFactory.getLogger(EmployPojo.class);

	private List<Employees> details;
	private Employees em;
	private Employ obj;

	private List<String> file;
	@Override
	public void activate() throws Exception {

		log.info("Inside Activate Method");

		EmployI empRecords = getSlingScriptHelper().getService(EmployI.class);
		details = empRecords.getAllEmployees();

		for (int i = 0; i < details.size(); i++) {
			Employees em = details.get(0);
			
			/*
			 * String name=em.getName(); String age=em.getAge(); String email=em.getEmail();
			 * String weight=em.getWeight();
			 */
			
			Employ obj = new Employ();

			obj.setName(em.getName());
			obj.setAge(em.getAge());
			obj.setEmail(em.getEmail());
			obj.setWeight(em.getWeight());


		}

		
	}

	public Employ getObj() {
		return obj;
	}
	
	
	public List<String> getFiles() {

		file = new ArrayList<String>();
		file.add("Apple");
		file.add("Orange");
		file.add("grapes");

		return file;

	}


}
