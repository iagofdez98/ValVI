import React from 'react';
import LoginForm from '../login/login-form';
import api from '../../api';

const LoadingPage = ({onLogin}) => {
  const handleLogin = (formData) => {
    api.loginUser(formData.username, formData.password)
  };

  const handleRegister = (formData) => {
    api.registerUser(formData.username, formData.password).then((response) => {
      console.log(response);
    });
  }


  return (
    <div className="container">
      <div className="row justify-content-center">
        <div className="col-md-8 text-center">
          <h1 className="mt-5">Bienvenidos a Valvi</h1>
          <p className="lead">¡Explora y valora los mejores videojuegos!</p>
          <LoginForm onLogin={handleLogin} onRegister={handleRegister}/>
        </div>
      </div>
    </div>
  );
};

export default LoadingPage;
