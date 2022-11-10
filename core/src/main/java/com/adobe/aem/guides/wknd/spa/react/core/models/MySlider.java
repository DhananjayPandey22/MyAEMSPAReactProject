package com.adobe.aem.guides.wknd.spa.react.core.models;

import java.util.Collection;

import javax.annotation.PostConstruct;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;

import org.apache.sling.models.annotations.injectorspecific.ChildResource;

import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ExporterConstants;

@Model(adaptables = SlingHttpServletRequest.class, adapters = { MySlider.class,
        ComponentExporter.class }, resourceType = MySlider.RESOURCE_TYPE, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXPORTER_NAME)

public class MySlider implements ComponentExporter {

    static final String RESOURCE_TYPE = "wknd-spa-react/components/MySlider";

    @ValueMapValue
    private String heading;

    @ValueMapValue
    protected String subtitle;

    @ValueMapValue
    protected String subtitlelink;

    @ChildResource(name = "items1")
    Collection<MySliderData> items1;

    @PostConstruct
    protected void init() {
        items1 = CollectionUtils.emptyIfNull(this.items1);
    }

    public String getHeading() {
        return heading;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public String getSubtitlelink() {
        return subtitlelink;
    }

    public Collection<MySliderData> getItems1() {
        return items1;
    }

    @Override
    public String getExportedType() {
        return MySlider.RESOURCE_TYPE;
    }

}
