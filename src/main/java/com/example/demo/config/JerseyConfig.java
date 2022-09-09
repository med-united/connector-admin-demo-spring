package com.example.demo.config;

import com.example.demo.odata.RuntimeConfigsODataJPAServiceFactory;
import org.apache.olingo.odata2.core.rest.ODataRootLocator;
import org.apache.olingo.odata2.core.rest.app.ODataApplication;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManagerFactory;
import javax.ws.rs.ApplicationPath;

@Component
@ApplicationPath("/odata")
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig(RuntimeConfigsODataJPAServiceFactory serviceFactory, EntityManagerFactory emf) {
        ODataApplication app = new ODataApplication();
        app
                .getClasses()
                .forEach(c -> {
                    if (!ODataRootLocator.class.isAssignableFrom(c)) {
                        register(c);
                    }
                });

        register(new RuntimeConfigsRootLocator(serviceFactory));
        register(new EntityManagerFilter(emf));
    }

}
