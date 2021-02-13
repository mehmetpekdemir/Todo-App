import React from "react";
import ReactDOM from "react-dom";
import { Routes } from "./routes/Routes";
import reportWebVitals from "./reportWebVitals";

import "bootstrap/dist/css/bootstrap.min.css"; //Bootstrap

import "alertifyjs/build/css/alertify.min.css"; //Alertify

import { BrowserRouter } from "react-router-dom"; //Routing

ReactDOM.render(
  <React.StrictMode>
    <BrowserRouter>
      <Routes />
    </BrowserRouter>
  </React.StrictMode>,
  document.getElementById("root")
);

reportWebVitals();
