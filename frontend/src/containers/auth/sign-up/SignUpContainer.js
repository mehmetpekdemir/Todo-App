import React, { useState } from "react";
import SignUpView from "./SignUpView";
import { useHistory } from "react-router-dom";
import { signUp } from "../../../services/AuthService";

export default function SignUpContainer() {
  const [data, setData] = useState([]);
  const [error, setError] = useState({});
  const history = useHistory();

  const handleChange = (event) => {
    const { name, value } = event.target;
    setData((data) => ({ ...data, [name]: value }));
    setError({});
  };

  const handleSignUp = () => {
    const { username, password } = data;
    const body = { username, password, roleName: "USER" };

    signUp(body)
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
      <SignUpView
        error={error}
        handleChange={handleChange}
        handleSignUp={handleSignUp}
      />
    </div>
  );
}
