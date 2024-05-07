import React, { useState } from 'react';
import { Modal, Button, Form } from 'react-bootstrap';

const AddReviewModal = ({ show, handleClose }) => {
  const [titulo, setTitulo] = useState('');
  const [contenido, setContenido] = useState('');

  const handleSubmit = () => {
    // Aquí puedes hacer lo que quieras con los valores de los campos de texto
    console.log("Título:", titulo);
    console.log("Contenido:", contenido);
    // Por ejemplo, puedes enviarlos a través de una función o hacer otra operación.
    // Luego, cierra el modal
    handleClose();
  };

  return (
    <Modal show={show} onHide={handleClose}>
      <Modal.Header closeButton>
        <Modal.Title>Editar</Modal.Title>
      </Modal.Header>
      <Modal.Body>
        <Form.Group controlId="titulo">
          <Form.Label>Título</Form.Label>
          <Form.Control
            type="text"
            placeholder="Introduce el título"
            value={titulo}
            onChange={(e) => setTitulo(e.target.value)}
          />
        </Form.Group>
        <Form.Group controlId="contenido">
          <Form.Label>Contenido</Form.Label>
          <Form.Control
            as="textarea"
            rows={3}
            placeholder="Introduce el contenido"
            value={contenido}
            onChange={(e) => setContenido(e.target.value)}
          />
        </Form.Group>
      </Modal.Body>
      <Modal.Footer>
        <Button variant="secondary" onClick={handleClose}>
          Cerrar
        </Button>
        <Button variant="primary" onClick={handleSubmit}>
          Guardar cambios
        </Button>
      </Modal.Footer>
    </Modal>
  );
}

export default AddReviewModal;
