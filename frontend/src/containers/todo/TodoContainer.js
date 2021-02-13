import React, { useState, useEffect } from "react";
import TodoView from "./TodoView";
import { getUserName } from "../../services/TokenService";
import {
  getAllTodosByUsername,
  deleteTodoById,
} from "../../services/TodoService";

export default function TodoContainer() {
  const [todos, setTodos] = useState([]);

  useEffect(() => {
    const username = getUserName(localStorage.getItem("access_token"));
    getAllTodos(username);
  }, []);

  const getAllTodos = (username) => {
    getAllTodosByUsername(username)
      .then((response) => {
        setTodos(response.data.data.items);
      })
      .catch((error) => {});
  };

  const deleteTodo = (id) => {
    deleteTodoById(id);
    window.location.reload();
  };

  return (
    <div>
      <TodoView todos={todos} deleteTodo={deleteTodo} />
    </div>
  );
}
