import React, { useState } from "react";
import { NavLink } from "react-router-dom";
import {
  Collapse,
  Navbar,
  NavbarToggler,
  NavbarBrand,
  Nav,
  NavItem,
  NavLink as Link,
} from "reactstrap";

import { getUserRole } from "../../services/TokenService";

const HeaderView = () => {
  const [isOpen, setIsOpen] = useState(false);

  const toggle = () => setIsOpen(!isOpen);

  const role = getUserRole(localStorage.getItem("access_token"));

  return (
    <div>
      <Navbar color="light" light expand="md">
        <NavbarBrand>Todo Application</NavbarBrand>
        <NavbarToggler onClick={toggle} />
        <Collapse isOpen={isOpen} navbar>
          <Nav className="mr-auto" navbar>
            {!role && (
              <NavItem>
                <Link>
                  <NavLink to="/login">Login</NavLink>
                </Link>
              </NavItem>
            )}
            {!role && (
              <NavItem>
                <Link>
                  <NavLink to="/sign-up">Sign up</NavLink>
                </Link>
              </NavItem>
            )}
          </Nav>

          <Nav className="ml-auto" navbar>
            <NavItem>
              <Link>
                <NavLink to="/todos">My Todo</NavLink>
              </Link>
            </NavItem>
            <NavItem>
              <Link>
                <NavLink to="/todo">Create New Todo</NavLink>
              </Link>
            </NavItem>
            <NavItem>
              <Link>
                <NavLink to="/contact">Contact</NavLink>
              </Link>
            </NavItem>
          </Nav>
        </Collapse>
      </Navbar>
    </div>
  );
};

export default HeaderView;
