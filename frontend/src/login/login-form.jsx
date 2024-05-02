import React, {useState} from "react";
import './login-form.css';
import RegisterModal from "./register-modal";
import { getUser } from "../services/login-service";

const LoginForm = () => {

  const [username, setUsername] = useState("")
  const [password, setPassword] = useState("")
  const [isRegisterModalVisible, setIsRegisterModalVisible] = useState(false);

  const onLogin = ()  => {
    getUser({username, password})
  }

  const handleClose = () => setIsRegisterModalVisible(false)

  return (
    <>
      <RegisterModal visible={isRegisterModalVisible} onClose={handleClose}/>
      <form style={{width: "300px"}}>
        <div className="mb-3">
          <input
            className="form-control"
            id="floatingInput"
            placeholder="Nombre de usuario"
            value={username}
            onChange={(event) => setUsername(event.target?.value)}
          />
        </div>
        <div className="mb-3">
          <input
            type="password"
            className="form-control"
            placeholder="Contraseña"
            value={password}
            onChange={(event) => setPassword(event.target?.value)}
          />
        </div>
        <div className="buttongroup-login">
          <button type="submit" className="btn me-2" onClick={onLogin}>Login</button>
          <button type="button" className="btn" onClick={() => setIsRegisterModalVisible(true)}>Registrarse</button>
        </div>
      </form>
    </>
  )

}

export default LoginForm;