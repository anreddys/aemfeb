package com.aem.aemtraining.core.wcmusepojos;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adobe.cq.sightly.WCMUsePojo;
import com.aem.aemtraining.core.service.SightlySerivceInterface;

public class Developer extends WCMUsePojo {

	Logger logger = LoggerFactory.getLogger(Developer.class);
	protected String detail;
	
	@Override
	public void activate() throws Exception {
		// TODO Auto-generated method stub
		
		 SightlySerivceInterface service = getSlingScriptHelper().getService(SightlySerivceInterface.class);
		    detail = service.getDeveloperData();
		
	}
	
	 public String getDetails() {
		    return this.detail;
		  }
	
	

}
