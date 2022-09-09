package com.example.demo.config;

import com.example.demo.odata.RuntimeConfigsODataJPAServiceFactory;
import org.apache.olingo.odata2.api.ODataServiceFactory;
import org.apache.olingo.odata2.core.rest.ODataRootLocator;

import javax.ws.rs.Path;

@Path("/")
public class RuntimeConfigsRootLocator extends ODataRootLocator {
    private RuntimeConfigsODataJPAServiceFactory serviceFactory;
    public RuntimeConfigsRootLocator(RuntimeConfigsODataJPAServiceFactory serviceFactory) {
        this.serviceFactory = serviceFactory;
    }

    @Override
    public ODataServiceFactory getServiceFactory() {
        return this.serviceFactory;
    }
}
