
package com.adobe.aem.guides.wknd.spa.react.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class MySliderData {

    @ValueMapValue(name = "title")
    private String title;

    @ValueMapValue(name = "linkUrl")
    private String linkUrl;

    @ValueMapValue(name = "imgUrl")
    private String imgUrl;

    public String getTitle() {
        return title;
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public String getImgurl() {
        return imgUrl;
    }

}