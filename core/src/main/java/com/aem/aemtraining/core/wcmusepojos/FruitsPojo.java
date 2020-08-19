package com.aem.aemtraining.core.wcmusepojos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adobe.cq.sightly.WCMUsePojo;

public class FruitsPojo extends WCMUsePojo {

	private static final Logger log = LoggerFactory.getLogger(FruitsPojo.class);

	private List<String> file;

	@Override
	public void activate() throws Exception {

		log.info("Inside Activate Method");
		
		

	}

	public List<String> getFiles() {

		file = new ArrayList<String>();
		file.add("Apple");
		file.add("Orange");
		file.add("grapes");

		return file;

	}

}
