import React from 'react';
import { Modal, Button, Form, ListGroup } from 'react-bootstrap';
import { createList } from '../../services/lists-service';

const CreateListModal = ({ games = [], show, handleClose }) => {
  const [selectedVideogames, setSelectedVideogames] = React.useState([]);

  const handleSubmit = (event) => {
    createList({
      name: event.target.formTitle.value,
      description: event.target.formDescription.value,
      videogames: games.filter(game => selectedVideogames.includes(game.id))
    });
    handleClose();
  };

  const handleGameSelect = (gameId) => {
    const isGameSelected = selectedVideogames.includes(gameId);
    if (isGameSelected) {
      setSelectedVideogames(selectedVideogames.filter(id => id !== gameId));
    } else {
      setSelectedVideogames([...selectedVideogames, gameId]);
    }
  };

  return (
    <Modal show={show} onHide={handleClose}>
      <Modal.Header closeButton>
        <Modal.Title>Crear Lista</Modal.Title>
      </Modal.Header>
      <Modal.Body>
        <Form onSubmit={handleSubmit}>
          <Form.Group controlId="formTitle">
            <Form.Label>Título</Form.Label>
            <Form.Control type="text" placeholder="Ingresa el título de la lista" />
          </Form.Group>
          <Form.Group controlId="formDescription">
            <Form.Label>Descripción</Form.Label>
            <Form.Control type="text" placeholder="Ingresa la descripción" />
          </Form.Group>
          <Form.Label>Selecciona los videojuegos a añadir</Form.Label>
            <ListGroup>
              {games.map((game) => (
                <ListGroup.Item key={game.id}>
                  <Form.Check
                    type="checkbox"
                    id={`game-${game.id}`}
                    label={game.name}
                    checked={selectedVideogames.includes(game.id)}
                    onChange={() => handleGameSelect(game.id)}
                  />
                </ListGroup.Item>
              ))}
          </ListGroup>
          <Button variant="primary" type="submit">
            Guardar
          </Button>
          <Button variant="secondary" onClick={handleClose}>Cerrar </Button>
        </Form>
      </Modal.Body>
    </Modal>
  );
};

export default CreateListModal;
