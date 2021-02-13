/* eslint-disable import/no-anonymous-default-export */
import axios from "axios";
import { URL } from "./url";

export const getTodoById = (id) => {
  return axios.get(URL + "v1/todo/" + id);
};

export const getAllTodosByUsername = (username) => {
  return axios.get(URL + "v1/todo/username/" + username);
};

export const createTodo = (data) => {
  return axios.post(URL + "v1/todo", data);
};

export const updateTodo = (data) => {
  return axios.put(URL + "v1/todo", data);
};

export const deleteTodoById = (id) => {
  return axios.delete(URL + "v1/todo/" + id);
};

export default {
  getTodoById,
  getAllTodosByUsername,
  createTodo,
  updateTodo,
  deleteTodoById,
};
