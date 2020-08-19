/*
 *  Copyright 2015 Adobe Systems Incorporated
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.aem.aemtraining.core.servlets;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.api.resource.ValueMap;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aem.aemtraining.core.dbutil.DatabaseConnectionHelper;
import com.aem.aemtraining.core.service.PageService;
import com.aem.aemtraining.core.service.ReadXMLFiles;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;
import java.sql.Connection;

/**
 * Servlet that writes some sample content into the response. It is mounted for
 * all resources of a specific Sling resource type. The
 * {@link SlingSafeMethodsServlet} shall be used for HTTP methods that are
 * idempotent. For write operations use the {@link SlingAllMethodsServlet}.
 */
@Component(service=Servlet.class,
property={
        Constants.SERVICE_DESCRIPTION + "=Testing Servlet",
        "sling.servlet.methods=" + HttpConstants.METHOD_GET, "sling.servlet.paths=" + "/bin/testing"            
})
public class TestingServlet extends SlingSafeMethodsServlet {

    private static final long serialVersionUid = 1L;
    protected static final Logger log=LoggerFactory.getLogger(TestingServlet.class); 
   /* @Reference
    ReadXMLFiles readXMlFiles;*/
    
    /*@Reference
    private DatabaseConnectionHelper helper;*/
    
   /* @Reference
    private PageService PageService;*/
    
   @Reference
    private ReadXMLFiles readXmls;
   

    @Override
    protected void doGet(final SlingHttpServletRequest req,
            final SlingHttpServletResponse resp) throws ServletException, IOException {
        final Resource resource = req.getResource();
        resp.setContentType("text/plain");
   //  Connection conn=helper.getDataBaseConnection("student");
     
   // log.info("Got Connection in Servlet--------------"+conn);
        
      /*  PageService.CreatePage("trainingpage");*/
        
        readXmls.writeToFile();
        
        resp.getWriter().write("Title = " + resource.adaptTo(ValueMap.class).get("jcr:title"));
    }
}
