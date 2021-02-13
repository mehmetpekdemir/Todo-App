import React from "react";
import { Redirect, Route, Switch } from "react-router-dom";

import { getUserRole } from "../services/TokenService";

import HeaderView from "../common/header/HeaderView";
import FooterView from "../common/footer/FooterView";

//Containers
import LoginContainer from "../containers/auth/login/LoginContainer";
import SignUpContainer from "../containers/auth/sign-up/SignUpContainer";
import TodoContainer from "../containers/todo/TodoContainer";
import TodoCreateContainer from "../containers/todo/create/TodoCreateContainer";
import TodoUpdateContainer from "../containers/todo/update/TodoUpdateContainer";
import ContactView from "../common/contact/ContactView";
import NotFoundView from "../common/notfound/NotFoundView";

export const Routes = () => {
  return (
    <div>
      <HeaderView />
      <Switch>
        <Redirect exact path="/" to="/todos" />
        <Route path="/login" exact component={LoginContainer} />
        <Route path="/sign-up" exact component={SignUpContainer} />
        <PrivateRoute path="/todos" exact component={TodoContainer} />
        <PrivateRoute path="/todo/:id" exact component={TodoUpdateContainer} />
        <PrivateRoute path="/todo" exact component={TodoCreateContainer} />
        <Route path="/contact" exact component={ContactView} />
        <Route component={NotFoundView} />
      </Switch>
      <FooterView />
    </div>
  );
};

const PrivateRoute = (props) => {
  const role = getUserRole(localStorage.getItem("access_token"));
  return role === "USER" || role === "ADMIN" ? (
    <Route path={props.path} component={props.component} />
  ) : (
    <Redirect to="/login" />
  );
};
