import React, {useState} from "react";
import "./register-modal.css"
import { Modal } from "react-bootstrap";
import { registerUser } from "../services/login-service";

const RegisterModal = ({visible, onClose}) => {

  const [username, setUsername] = useState("")
  const [password, setPassword] = useState("")
  const [name, setName] = useState("")
  const [image, setImage] = useState("")

  const onRegister = ()  => registerUser({username, password, name, image})

  return (
    <Modal
      show={visible}
      onHide={onClose}
      dialogClassName="modal-register"
    >
      <Modal.Header closeButton>
        <Modal.Title>Registrar usuario</Modal.Title>
      </Modal.Header>
      <Modal.Body>
        <form>
          <div className="input-group flex-nowrap mb-3">
            <span className="input-group-text" id="addon-wrapping">@</span>
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
              className="form-control"
              id="floatingInput"
              placeholder="Nombre"
              value={name}
              onChange={(event) => setName(event.target?.value)}
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
          <div className="input-group mb-3">
            <input className="form-control" type="file" id="formFile"/>
            <label className="input-group-text" htmlFor="inputGroupFile02">Foto</label>
          </div>
        </form>
      </Modal.Body>
      <Modal.Footer>
        <button type="button" className="btn btn-outline-secondary" onClick={onClose}>Cerrar</button>
        <button type="button" className="btn btn-outline-secondary" onClick={onRegister}>Registrarse</button>
      </Modal.Footer>
    </Modal>
  )

}

export default RegisterModal;
