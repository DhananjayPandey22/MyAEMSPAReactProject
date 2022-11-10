package com.adobe.aem.guides.wknd.spa.react.core.models.impl;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.Exporter;

import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ExporterConstants;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.apache.sling.models.annotations.Model;

import com.adobe.aem.guides.wknd.spa.react.core.models.MyTitleModel;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;

@Model(adaptables = SlingHttpServletRequest.class, adapters = { MyTitleModel.class,
        ComponentExporter.class }, resourceType = MyTitleModelImpl.SLING_SERVLET_RESOURCE_TYPE, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
@Exporter( // Exporter annotation that serializes the modoel as JSON
        name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)

public class MyTitleModelImpl implements MyTitleModel {

    @ValueMapValue

    private String myTitle;

    static final String SLING_SERVLET_RESOURCE_TYPE = "wknd-spa-react/components/myTitle";

    @Override
    public String getExportedType() {
        // TODO Auto-generated method stub
        return MyTitleModelImpl.SLING_SERVLET_RESOURCE_TYPE;
    }

    @Override
    public String getMyTitle() {
        // TODO Auto-generated method stub
        return myTitle;
    }

}
