import React, { useState } from "react";
import LoginView from "./LoginView";
import { useHistory } from "react-router-dom";
import { login } from "../../../services/AuthService";

export default function LoginContainer() {
  const [data, setData] = useState([]);
  const [error, setError] = useState({});
  const history = useHistory();

  const handleChange = (event) => {
    const { name, value } = event.target;
    setData((data) => ({ ...data, [name]: value }));
    setError({});
  };

  const handleLogin = () => {
    const { username, password } = data;
    const body = { username, password };

    login(body)
      .then((response) => {
        if (response.data.data.token && response.data.errors === null) {
          localStorage.setItem("access_token", response.data.data.token);
          history.push("/todos");
          window.location.reload();
        }
      })
      .catch((err) => {
        const error = {};
        error.text = "Invalid username or password.";
        setError({ ...error, text: error.text });
      });
  };

  return (
    <div>
      <LoginView
        error={error}
        handleChange={handleChange}
        handleLogin={handleLogin}
      />
    </div>
  );
}
