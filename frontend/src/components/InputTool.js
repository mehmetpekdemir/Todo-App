import React from "react";
import { FormGroup, Label, Input } from "reactstrap";

export const InputTool = (props) => {
  const { label, type, name, placeholder, onChange, error } = props;
  const className = error ? "form-control is-invalid" : "form-control";
  return (
    <div>
      <FormGroup>
        <Label for={name}>{label}</Label>
        <Input
          className={className}
          name={name}
          onChange={onChange}
          type={type}
          placeholder={placeholder}
        />
        <div className="invalid-feedback">{error}</div>
      </FormGroup>
    </div>
  );
};
