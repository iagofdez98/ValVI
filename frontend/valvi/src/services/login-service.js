import api from '../api';

export const loginUser = (username, password) => api.loginUser(username, password);

export const registerUser = (username, password) => api.registerUser(username, password);