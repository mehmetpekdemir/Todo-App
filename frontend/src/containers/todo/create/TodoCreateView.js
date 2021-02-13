import React from "react";
import { Container, Form } from "reactstrap";
import { InputTool } from "../../../components/InputTool";
import { ButtonTool } from "../../../components/ButtonTool";

const TodoCreateView = (props) => {
  const { error, handleChange, handleCreate } = props;
  return (
    <div>
      <div className="d-flex justify-content-center">
        <Container style={{ marginTop: 30, width: 600 }}>
          <Form>
            <InputTool
              name="text"
              label="Work to do"
              onChange={handleChange}
              type="text"
              placeholder="Work to do"
              error={error.text}
            />
          </Form>
          <ButtonTool onClick={handleCreate} text="Create Todo" type="submit" />
        </Container>
      </div>
    </div>
  );
};

export default TodoCreateView;
