import React from "react";
import Countdown from "react-countdown";

const Completionist = () => {
  return <span>Stay tuned of upcoming offers!!</span>;
};

const renderer = ({ days, hours, minutes, seconds, completed }) => {
  if (completed) {
    return <Completionist />;
  } else {
    return (
      <span>
        {days}d:{hours}h:{minutes}m:{seconds}s
      </span>
    );
  }
};

const Timer = (props) => {
  return (
    <Countdown date={Date.now() + props.timeTillOffer} renderer={renderer} />
  );
};

export default Timer;
