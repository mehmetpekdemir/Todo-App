import React, { useState } from "react";
import { useHistory } from "react-router-dom";
import alertify from "alertifyjs";
import TodoCreateView from "./TodoCreateView";
import { getUserName } from "../../../services/TokenService";
import { createTodo } from "../../../services/TodoService";

export default function TodoCreateContainer() {
  const [todo, setTodo] = useState([]);
  const [error, setError] = useState({});
  const history = useHistory();

  const handleChange = (event) => {
    const { name, value } = event.target;
    setTodo((data) => ({ ...data, [name]: value }));
    setError({});
  };

  const handleCreate = () => {
    const { text } = todo;
    const body = {
      text,
      status: "false",
      username: getUserName(localStorage.getItem("access_token")),
    };

    createTodo(body)
      .then((response) => {
        alertify.success("Successfully Created.");
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
      <TodoCreateView
        error={error}
        handleChange={handleChange}
        handleCreate={handleCreate}
      />
    </div>
  );
}
