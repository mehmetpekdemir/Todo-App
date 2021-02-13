import jwtDecoder from "jwt-decode";

export const getUserRole = (token) => {
  if (token === null) {
    return;
  }
  return jwtDecoder(token).auth;
};

export const getUserName = (token) => {
  if (token === null) {
    return;
  }
  return jwtDecoder(token).sub;
};

export const getAuthType = (token) => {
  if (token === null) {
    return;
  }
  return jwtDecoder(token).details.userAuthorizationType;
};
