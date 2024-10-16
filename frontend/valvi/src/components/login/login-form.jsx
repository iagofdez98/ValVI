import "./login-form.css";
import React from 'react';

const LoginForm = ({ onLogin, onRegister }) => {
  const [username, setUsername] = React.useState('');
  const [password, setPassword] = React.useState('');

  const handleUsernameChange = (e) => {
    setUsername(e.target.value);
  };

  const handlePasswordChange = (e) => {
    setPassword(e.target.value);
  };

  const handleRegister = (e) => {
    e.preventDefault();
    onRegister({ username, password });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    onLogin({ username, password });
  };

  return (
    <form className="form-auth" onSubmit={handleSubmit}>
    <p className="form-title">Accede a tu cuenta</p>
    <div className="input-container">
      <input
        type="text"
        className="form-control"
        placeholder="Nombre de usuario"
        value={username}
        onChange={handleUsernameChange}
        required
        />
    </div>
    <div className="input-container">
      <input
        type="password"
        className="form-control"
        placeholder="Contraseña"
        value={password}
        onChange={handlePasswordChange}
        required
      />
    </div>
    <button className="submit" type="submit">
      Acceder
    </button>

    <p className="signup-link">
      ¿Todavía no tienes cuenta?
      <a href="" onClick={handleRegister}> Registrarse</a>
    </p>
  </form>
  )
};

export default LoginForm;
