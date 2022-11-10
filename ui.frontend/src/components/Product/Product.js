import React, { Component } from "react";
import { Link } from "react-router-dom";
import { MapTo } from "@adobe/aem-react-editable-components";
import DOMPurify from "dompurify";
import "bootstrap/dist/css/bootstrap.min.css";
import extractModelId from "../../utils/extract-model-id";
import "./newicon.svg";

import newicon from "./newicon.svg";
import Timer from "./Timer.js";
require("./Product.scss");
// require("./newicon.svg");

export const ProductEditConfig = {
  emptyLabel: "Product",

  isEmpty: function (props) {
    return !props || !props.src || props.src.trim().length < 1;
  },
};

export default class Product extends Component {
  get content() {
    return (
      <img
        className="Image-src"
        src={this.props.src}
        alt={this.props.alt}
        title={this.props.title ? this.props.title : this.props.alt}
      />
    );
  }

  // display our custom bannerText property!
  get productName() {
    if (this.props.productName) {
      return <h2>{this.props.productName}</h2>;
    }

    return null;
  }

  get productDesc() {
    if (this.props.productDesc) {
      return <p>{this.props.productDesc}</p>;
    }

    return null;
  }

  get richTextContent() {
    return (
      <div
        id={extractModelId(this.props.cqPath)}
        data-rte-editelement
        dangerouslySetInnerHTML={{
          __html: DOMPurify.sanitize(this.props.text1),
        }}
      />
    );
  }

  get textContent() {
    return <div>{this.props.text1}</div>;
  }

  get productPrice() {
    if (this.props.productDiscount) {
      return <del> M.R.P.: ₹ {this.props.productPrice}</del>;
    }

    return <>M.R.P.: ₹ {this.props.productPrice}</>;
  }

  get discount() {
    if (this.props.productDiscount) {
      let pp = parseFloat(this.props.productPrice);
      let dis = parseFloat(this.props.productDiscount);
      const dp = (pp * dis) / 100;

      return (
        <>
          You Save: ₹ {dp.toFixed(2)}({this.props.productDiscount}%)
        </>
      );
    } else {
      return null;
    }
  }

  get dealPrice() {
    if (this.props.productDiscount) {
      let pp = parseFloat(this.props.productPrice);
      let dis = parseFloat(this.props.productDiscount);
      const dp = (pp * dis) / 100;
      return <> Deal Price : ₹ {(pp - dp).toFixed(2)} </>;
    }

    return null;
  }

  get buyButton() {
    if (this.props.buyLink) {
      return (
        <Link style={{ color: "black" }} to={this.props.buyLink + ".html"}>
          <button className="pro-btn">Buy Now</button>
        </Link>
      );
    }

    return null;
  }

  get badge() {
    if (this.props.badge) {
      return <img className="pro-badge" src={newicon} alt={this.props.text} />;
    }
    return null;
  }

  get date() {
    const d = new Date(this.props.dateTillOffer);
    const aa = new Date();

    if (this.props.offerBadge) {
      return (
        <h3 className="bg-success mb-3">
          Offer Ends in :<Timer timeTillOffer={d.getTime() - aa.getTime()} />
        </h3>
      );
    } else {
      return null;
    }
  }

  datatolocal = () => {
    localStorage.setItem("Product", JSON.stringify(this.props));
  };

  render() {
    if (ProductEditConfig.isEmpty(this.props)) {
      return null;
    }

    return (
      <div className="Product row">
        <div className="col-4 p-3">
          {this.badge}
          {this.content}
        </div>
        <div className="product-details col-7 m-3 p-3">
          <div className="pro-name">{this.productName}</div>
          <div className="pro-price">
            <p>
              {this.props.productDiscount
                ? this.productPrice
                : this.productPrice}
            </p>

            <p>{this.dealPrice}</p>
            <p>{this.discount}</p>
          </div>
          <div className="pro-desc">{this.productDesc}</div>

          <div>
            {this.props.textIsRich ? this.richTextContent : this.textContent}
          </div>

          <div className="pro-button" onClick={this.datatolocal}>
            {this.buyButton}
          </div>
          {this.date}
        </div>
      </div>
    );
  }
}

MapTo("wknd-spa-react/components/Product")(Product, ProductEditConfig);
