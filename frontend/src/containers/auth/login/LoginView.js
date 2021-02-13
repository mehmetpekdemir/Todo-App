import React from "react";
import { Container, Form } from "reactstrap";
import { InputTool } from "../../../components/InputTool";
import { ButtonTool } from "../../../components/ButtonTool";

const LoginView = (props) => {
  const { error, handleChange, handleLogin } = props;
  return (
    <div>
      <div className="d-flex justify-content-center">
        <Container style={{ marginTop: 30, width: 600 }}>
          <Form>
            <InputTool
              name="username"
              label="User Name"
              onChange={handleChange}
              type="text"
              placeholder="User Name"
              error={error.text}
            />
            <InputTool
              name="password"
              label="Password"
              onChange={handleChange}
              type="password"
              placeholder="Password"
              error={error.text}
            />
          </Form>
          <ButtonTool onClick={handleLogin} text="Login" type="submit" />
        </Container>
      </div>
    </div>
  );
};

export default LoginView;
