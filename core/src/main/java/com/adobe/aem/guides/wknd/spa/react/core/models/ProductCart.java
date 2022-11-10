package com.adobe.aem.guides.wknd.spa.react.core.models;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;

import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ExporterConstants;

@Model(adaptables = SlingHttpServletRequest.class, adapters = { ProductCart.class,
        ComponentExporter.class }, resourceType = ProductCart.RESOURCE_TYPE, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXPORTER_NAME)
public class ProductCart implements ComponentExporter {

    final static String RESOURCE_TYPE = "wknd-spa-react/components/productCart";

    @Override
    public String getExportedType() {
        // TODO Auto-generated method stub
        return ProductCart.RESOURCE_TYPE;
    }

}
