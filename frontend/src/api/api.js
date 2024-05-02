const express = require('express');
const cors = require('cors');
const app = express();

// Middleware de CORS
app.use(cors());

const getUser = (user) => {
  fetch('http://localhost:8080/users', {method: "GET", body: user})
  .then(response => response.json())
}

const registerUser = (user) => {
  fetch('http://localhost:8080/users', {
    method: "POST",
    headers: {
      "Content-Type": "application/json"
    },
    body: JSON.stringify(user)
  })
  .then(response => {
    // Manejar la respuesta aquí si es necesario
    console.log(response);
  })
  .catch(error => {
    // Manejar cualquier error de la solicitud
    console.error('Error al registrar usuario:', error);
  });
}


export default {
  getUser,
  registerUser
}