import React from 'react';
import LoginForm from '../login/login-form';
import api from '../../api';

const LoadingPage = () => {
  const handleLogin = (formData) => {
    api.loginUser(formData.username, formData.password).then(() => {
      refreshPage();
    });
  };

  const handleRegister = (formData) => {
    api.registerUser(formData.username, formData.password).then(() => {
      refreshPage();
    });
  }

  const refreshPage = () => {
    window.location.reload();
  }

    return (
      <div className="container-page-login">
        <div className="left-column">
          <h1>ValVi</h1>
          <p>
            Aquí puedes manejar tus videojuegos, añadir nuevos títulos a tu lista y
            organizar tus juegos favoritos de manera sencilla.
          </p>
        </div>
        <div className="right-column">
          <LoginForm onLogin={handleLogin} onRegister={handleRegister} />
        </div>
      </div>
    );
};

export default LoadingPage;
