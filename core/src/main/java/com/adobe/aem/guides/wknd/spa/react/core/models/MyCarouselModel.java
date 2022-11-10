package com.adobe.aem.guides.wknd.spa.react.core.models;

import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ExporterConstants;
import java.util.Collection;
import javax.annotation.PostConstruct;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

/**
 * Multifield Example model.
 * 
 * @author suraj.kamdi
 */
@Model(adaptables = SlingHttpServletRequest.class, adapters = { ComponentExporter.class,
        MyCarouselModel.class }, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL, resourceType = MyCarouselModel.RESOURCE_TYPE)
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class MyCarouselModel implements ComponentExporter {

    protected static final String RESOURCE_TYPE = "wknd-spa-react/components/myCarousel";

    @ValueMapValue
    protected String heading;

    @ValueMapValue
    protected String subtitle;

    @ValueMapValue
    protected String subtitlelink;

    // Multifield Child Resource for social links
    @ChildResource(name = "items1")
    Collection<MyCarouselDataModel> items1;

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

    public Collection<MyCarouselDataModel> getItems1() {
        return items1;
    }

    @Override
    public String getExportedType() {
        return MyCarouselModel.RESOURCE_TYPE;
    }

}