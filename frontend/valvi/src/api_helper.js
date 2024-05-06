
export const getAuthToken = () => {
  return localStorage.getItem('auth_token');
}

export const setAuthToken = (token) => {
  localStorage.setItem('auth_token', token);
}