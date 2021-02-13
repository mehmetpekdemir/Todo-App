import React from "react";
import { Button } from "reactstrap";

export const ButtonTool = (props) => {
  const { onClick, type, text } = props;
  return (
    <div>
      <Button outline color="info" onClick={onClick} type={type}>
        {text}
      </Button>
    </div>
  );
};
