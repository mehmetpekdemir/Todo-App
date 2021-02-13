import React from "react";
import { useHistory } from "react-router-dom";
import { Table } from "reactstrap";
import { ButtonTool } from "../../components/ButtonTool";

const TodoView = (props) => {
  const history = useHistory();
  const { todos, deleteTodo } = props;
  return (
    <div>
      <Table striped>
        <thead>
          <tr>
            <th>Text</th>
            <th>Status</th>
            <th></th>
            <th></th>
          </tr>
        </thead>
        <tbody>
          {todos.map((todo) => (
            <tr key={todo.id}>
              <th>{todo.text}</th>
              <th>{todo.status === true ? "Completed" : "Not finished yet"}</th>
              <td>
                <ButtonTool
                  onClick={() => {
                    history.push("/todo/" + todo.id);
                  }}
                  text="Update"
                  type="submit"
                />
              </td>
              <td>
                <ButtonTool
                  onClick={() => deleteTodo(todo.id)}
                  text="Delete"
                  type="submit"
                />
              </td>
            </tr>
          ))}
        </tbody>
      </Table>
    </div>
  );
};

export default TodoView;
