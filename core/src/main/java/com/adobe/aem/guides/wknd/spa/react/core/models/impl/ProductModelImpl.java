package com.adobe.aem.guides.wknd.spa.react.core.models.impl;

import com.adobe.aem.guides.wknd.spa.react.core.models.ProductModel;
import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ExporterConstants;
import com.adobe.cq.wcm.core.components.models.Image;
import org.apache.sling.models.annotations.*;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.apache.sling.models.annotations.via.ResourceSuperType;

@Model(adaptables = SlingHttpServletRequest.class, adapters = { ProductModel.class,
        ComponentExporter.class }, resourceType = ProductModelImpl.RESOURCE_TYPE, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class ProductModelImpl implements ProductModel {

    // points to the the component resource path in ui.apps
    static final String RESOURCE_TYPE = "wknd-spa-react/components/Product";

    @Self
    private SlingHttpServletRequest request;

    // With sling inheritance (sling:resourceSuperType) we can adapt the current
    // resource to the Image class
    // this allows us to re-use all of the functionality of the Image class, without
    // having to implement it ourself
    // see
    // https://github.com/adobe/aem-core-wcm-components/wiki/Delegation-Pattern-for-Sling-Models
    @Self
    @Via(type = ResourceSuperType.class)
    private Image image;

    // map the property saved by the dialog to a variable named `bannerText`
    @ValueMapValue
    private String productName;

    @ValueMapValue
    private String productDesc;

    @ValueMapValue
    private String productPrice;

    @ValueMapValue
    private String productDiscount;

    @ValueMapValue
    private String buyLink;

    @ValueMapValue
    private boolean badge;

    @ValueMapValue
    private boolean offerbadge;

    @ValueMapValue
    private String text;
    @ValueMapValue
    private String text1;
    @ValueMapValue
    private String cqPath;

    @ValueMapValue
    private boolean textIsRich;

    @ValueMapValue
    private String dateTillOffer;

    // public getter to expose the value of `bannerText` via the Sling Model and
    // JSON output

    // Re-use the Image class for all other methods:

    @Override
    public String getSrc() {
        return null != image ? image.getSrc() : null;
    }

    @Override
    public String getAlt() {
        return null != image ? image.getAlt() : null;
    }

    @Override
    public String getTitle() {
        return null != image ? image.getTitle() : null;
    }

    // method required by `ComponentExporter` interface
    // exposes a JSON property named `:type` with a value of
    // `wknd-spa-react/components/banner`
    // required to map the JSON export to the SPA component props via the `MapTo`
    @Override
    public String getExportedType() {
        return ProductModelImpl.RESOURCE_TYPE;
    }

    @Override
    public String getProductName() {
        // TODO Auto-generated method stub
        return productName;
    }

    @Override
    public String getProductDesc() {
        // TODO Auto-generated method stub
        return productDesc;
    }

    @Override
    public String getProductPrice() {
        // TODO Auto-generated method stub
        return productPrice;
    }

    @Override
    public String getBuyLink() {
        // TODO Auto-generated method stub
        return buyLink;
    }

    @Override
    public boolean getBadge() {
        // TODO Auto-generated method stub
        return badge;
    }

    @Override
    public String getText() {
        // TODO Auto-generated method stub
        return text;
    }

    @Override
    public String getDateTillOffer() {
        // TODO Auto-generated method stub
        return dateTillOffer;
    }

    @Override
    public String getText1() {
        // TODO Auto-generated method stub
        return text1;
    }

    @Override
    public String getCqPath() {
        // TODO Auto-generated method stub
        return cqPath;
    }

    @Override
    public boolean getTextIsRich() {
        // TODO Auto-generated method stub
        return textIsRich;
    }

    @Override
    public boolean getOfferBadge() {
        // TODO Auto-generated method stub
        return offerbadge;
    }

    @Override
    public String getProductDiscount() {
        // TODO Auto-generated method stub
        return productDiscount;
    }

}
