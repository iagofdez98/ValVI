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
    <form onSubmit={handleSubmit}>
      <div className="form-group">
        <input
          type="text"
          className="form-control"
          placeholder="Nombre de usuario"
          value={username}
          onChange={handleUsernameChange}
          required
        />
      </div>
      <div className="form-group">
        <input
          type="password"
          className="form-control"
          placeholder="Contraseña"
          value={password}
          onChange={handlePasswordChange}
          required
        />
      </div>
      <div className="d-flex justify-content-between">
        <button type="submit" className="btn btn-primary">Iniciar sesión</button>
        <button type="button" className="btn btn-secondary" onClick={handleRegister}>Registrarse</button>
      </div>
    </form>
  );
};

export default LoginForm;
