import React from "react";
import { NavLink } from "react-router-dom";

const FooterView = () => {
  return (
    <div>
      <footer className="page-footer font-small blue">
        <div className="footer-copyright text-center py-3">
          © 2020 Copyright
          <NavLink to="/contact"> Contact Us !</NavLink>
        </div>
      </footer>
    </div>
  );
};

export default FooterView;
