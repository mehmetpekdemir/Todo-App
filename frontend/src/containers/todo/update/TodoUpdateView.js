import React from "react";
import { Container, Form } from "reactstrap";
import { InputTool } from "../../../components/InputTool";
import { ButtonTool } from "../../../components/ButtonTool";
import { SelectTool } from "../../../components/SelectTool";

const TodoUpdateView = (props) => {
  const { error, handleChange, handleUpdate } = props;
  const options = [
    {
      label: "Not Finished Yet",
      value: 0,
    },
    {
      label: "Completed",
      value: 1,
    },
  ];
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
              placeholder={"Work to do"}
              error={error.text}
            />
            <SelectTool
              name="status"
              label="Status"
              onChange={handleChange}
              type="select"
              options={options}
              defaultValue={0}
            />
          </Form>
          <ButtonTool onClick={handleUpdate} text="Update Todo" type="submit" />
        </Container>
      </div>
    </div>
  );
};

export default TodoUpdateView;
