import React, { Component } from "react";
import { MapTo } from "@adobe/aem-react-editable-components";
require("./Banner.scss");

export const BannerEditConfig = {
  emptyLabel: "Banner",

  isEmpty: function (props) {
    return !props || !props.src || props.src.trim().length < 1;
  },
};

export default class Banner extends Component {
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
  get bannerText() {
    if (this.props.bannerText) {
      return <h2 className="Ba-Text">{this.props.bannerText}</h2>;
    }

    return null;
  }

  get bannerbtn() {
    if (this.props.btnText) {
      return (
        <button className="Ba-btn">
          <a style={{ color: "white" }} href={this.props.btnLink + ".html"}>
            {this.props.btnText}
          </a>
        </button>
      );
    }

    return null;
  }

  render() {
    if (BannerEditConfig.isEmpty(this.props)) {
      return null;
    }

    return (
      <div className="Banner">
        <div className="Ba-TextDiv">{this.bannerText}</div>
        <div className="BannerImage">{this.content}</div>
        <div className="Ba-ButtonDiv">{this.bannerbtn}</div>
      </div>
    );
  }
}

MapTo("wknd-spa-react/components/Banner")(Banner, BannerEditConfig);
