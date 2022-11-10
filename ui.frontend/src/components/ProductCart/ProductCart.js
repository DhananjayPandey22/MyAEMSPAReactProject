import React, { Component } from "react";
import { MapTo } from "@adobe/aem-spa-component-mapping";
import "bootstrap/dist/css/bootstrap.min.css";

export class ProductCart extends Component {
  state = {
    product: JSON.parse(localStorage.getItem("Product")),
  };
  render() {
    return (
      <div className="row">
        <div className="col w-25">
          <img
            style={{ width: 180, height: 180 }}
            src={this.state.product.src}
            alt="Product Image"
          />
        </div>
        <div className="col">
          <h2>{this.state.product.productName}</h2>
        </div>
        <div className="col">
          <h2>{this.state.product.productPrice}</h2>
        </div>
      </div>
    );
  }
}

MapTo("wknd-spa-react/components/productCart")(ProductCart);
