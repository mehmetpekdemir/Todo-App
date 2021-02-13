import React from "react";
import { FormGroup, Label, Input } from "reactstrap";

export const SelectTool = (props) => {
  const { name, label, onChange, type, defaultValue, options } = props;
  return (
    <div>
      <FormGroup>
        <Label for={name}>{label}</Label>
        <Input type={type} name={name} id={name} onChange={onChange}>
          {options.map((option) => (
            <option value={option.value} selected={defaultValue}>
              {option.label}
            </option>
          ))}
        </Input>
      </FormGroup>
    </div>
  );
};
