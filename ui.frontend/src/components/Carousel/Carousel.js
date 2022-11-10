import React, { Component } from "react";
import { MapTo } from "@adobe/aem-react-editable-components";

export const CarouselEditConfig = {
  emptyLabel: "Carousel",

  isEmpty: function (props) {
    return !props || !props.src || props.src.trim().length < 1;
  },
};

class Carousel extends Component {
  get content() {
    while (this.props.fileReference) {
      return <img className="Image-src" src={this.props.fileReference} />;
    }
  }

  render() {
    if (CarouselEditConfig.isEmpty(this.props)) {
      return null;
    }

    return this.content;
  }
}

MapTo("wknd-spa-react/components/carousel")(Carousel, CarouselEditConfig);

export default Carousel;
