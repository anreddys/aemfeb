package com.aem.aemtraining.core.impl;

import org.osgi.service.component.annotations.Component;


import com.aem.aemtraining.core.service.SightlySerivceInterface;

@Component(immediate=true,service=SightlySerivceInterface.class)
public class SightlySerivce implements SightlySerivceInterface {

	@Override
	public String getDeveloperName() {
		// TODO Auto-generated method stub
		return "John";
	}

	@Override
	public String getDeveloperProfile() {
		// TODO Auto-generated method stub
		return "AEM Developer";
	}

	@Override
	public String getDeveloperSkills() {
		// TODO Auto-generated method stub
		return "JAVA, OSGI, HTML, JS";
	}

	@Override
	public String getDeveloperData() {
		// TODO Auto-generated method stub
		String name = this.getDeveloperName();
		String profile = this.getDeveloperProfile();
		String skills = this.getDeveloperSkills();
		return name + " is a " + profile + ", He is expert in skills like " + skills;
	}

}
