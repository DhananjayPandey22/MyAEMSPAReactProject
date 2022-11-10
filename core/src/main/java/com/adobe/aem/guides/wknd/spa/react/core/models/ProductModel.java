package com.adobe.aem.guides.wknd.spa.react.core.models;

import com.adobe.cq.wcm.core.components.models.Image;
import org.osgi.annotation.versioning.ProviderType;

@ProviderType
public interface ProductModel extends Image {

    public String getProductName();

    public String getProductDesc();

    public String getProductPrice();

    public String getProductDiscount();

    public String getBuyLink();

    public boolean getBadge();

    public boolean getOfferBadge();

    public String getText();

    public String getDateTillOffer();

    public String getText1();

    public String getCqPath();

    public boolean getTextIsRich();

}
