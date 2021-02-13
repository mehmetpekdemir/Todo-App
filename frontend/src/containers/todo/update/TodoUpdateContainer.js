import React, { useState } from "react";
import { useHistory, useParams } from "react-router-dom";
import alertify from "alertifyjs";
import TodoUpdateView from "./TodoUpdateView";
import { getUserName } from "../../../services/TokenService";
import { updateTodo } from "../../../services/TodoService";

export default function TodoUpdateContainer() {
  const [todo, setTodo] = useState([]);
  const [error, setError] = useState({});
  const history = useHistory();
  const { id } = useParams();

  const handleChange = (event) => {
    const { name, value } = event.target;
    setTodo((data) => ({ ...data, [name]: value }));
    setError({});
  };

  const handleUpdate = () => {
    if (todo.status === undefined) {
      todo.status = 0;
    }
    if (todo.status === "0") {
      todo.status = 0;
    }
    if (todo.status === "1") {
      todo.status = 1;
    }
    const { text, status } = todo;
    const body = {
      id: id,
      text,
      status,
      username: getUserName(localStorage.getItem("access_token")),
    };

    updateTodo(body)
      .then((response) => {
        alertify.success("Successfully Updated.");
        history.push("/todos");
      })
      .catch((err) => {
        const error = {};
        error.text = "must not be null.";
        setError({ ...error, text: error.text });
      });
  };

  return (
    <div>
      <TodoUpdateView
        error={error}
        handleChange={handleChange}
        handleUpdate={handleUpdate}
      />
    </div>
  );
}
