import React, { Component } from "react";
import { MapTo } from "@adobe/aem-react-editable-components";

const MyTitleEditConfig = {
  emptyLabel: "MyTitle",

  isEmpty: function (props) {
    return !props || !props.myTitle || props.myTitle.trim().length < 1;
  },
};

export default class MyTitle extends Component {
  get myTitle() {
    return <h2> {this.props.myTitle}</h2>;
  }

  render() {
    if (MyTitleEditConfig.isEmpty(this.props)) {
      return null;
    }

    return (
      <>
        {this.myTitle}

        <img src="https://m.media-amazon.com/images/I/91zVSkGGZbS._AC_AA360_.jpg" />
      </>
    );
  }
}

MapTo("wknd-spa-react/components/myTitle")(MyTitle);
