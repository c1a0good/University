import React, {useContext} from "react";
import {
    Navigate,
    useLocation
  } from "react-router-dom";


function RequireAuth({ children }) {
    const location = useLocation();

    console.log("Auth")

    return localStorage.getItem('token') ? (
      children
    ) : (
      <Navigate to="/login" replace state={{ path: location.pathname }} />
    );
  }

  export default RequireAuth;