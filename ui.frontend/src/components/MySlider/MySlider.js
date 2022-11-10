import React, { Component } from "react";
import { Link } from "react-router-dom";
import { MapTo } from "@adobe/aem-react-editable-components";
import "bootstrap/dist/css/bootstrap.css";
import Carousel from "react-bootstrap/Carousel";

const MySliderEditConfig = {
  emptyLabel: "MySlider",

  isEmpty: function (props) {
    return !props.heading;
  },
};

export default class MySlider extends Component {
  render() {
    if (MySliderEditConfig.isEmpty(this.props)) {
      return null;
    }
    return (
      <div style={{ display: "block", width: 700, padding: 30 }}>
        <h4>{this.props.heading}</h4>

        <Carousel>
          {this.props.items1.map((item) => {
            return (
              <Carousel.Item interval={2500}>
                <img
                  className="d-block w-100"
                  src={item.imgurl}
                  alt={item.imgurl}
                />
                <Carousel.Caption>
                  <Link
                    className="text-decoration-none"
                    to={this.props.linkedPage}
                  >
                    <h3 className="text-white ">{item.title}</h3>
                  </Link>
                </Carousel.Caption>
              </Carousel.Item>
            );
          })}
        </Carousel>
      </div>
    );
  }
}
MapTo("wknd-spa-react/components/MySlider")(MySlider, MySliderEditConfig);
