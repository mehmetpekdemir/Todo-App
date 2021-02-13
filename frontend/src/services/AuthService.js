/* eslint-disable import/no-anonymous-default-export */
import axios from "axios";
import { URL } from "./url";

export const login = (data) => {
  return axios.post(URL + "v1/user/login", data);
};

export const signUp = (data) => {
  return axios.post(URL + "v1/user/sign-up", data);
};

export default {
  login,
  signUp,
};
