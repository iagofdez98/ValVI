import React, { useState } from 'react';
import { Modal, Button, Alert } from 'react-bootstrap';
import { upsertRating } from '../../services/rating-service';

const RatingModal = ({ show, handleClose, game }) => {
  const [number, setNumber] = useState(0);

  const handleSave = () => {
    upsertRating({videogame: game, qualification: number});
    handleClose();
  };

  return (
    <Modal show={show} onHide={handleClose}>
      <Modal.Header closeButton>
        <Modal.Title>¿Como valoras {game.name}?</Modal.Title>
      </Modal.Header>
      <Modal.Body>
        <input
          type="number"
          min="0"
          max="10"
          value={number}
          onChange={(e) => setNumber(parseInt(e.target.value))}
          className="form-control"
        />
      </Modal.Body>
      <Modal.Footer>
        <Button variant="secondary" onClick={handleClose}>
          Cancelar
        </Button>
        <Button variant="primary" onClick={handleSave}>
          Guardar
        </Button>
      </Modal.Footer>
    </Modal>
  );
}

export default RatingModal;
