import React from 'react';
import { Modal, Button, Form } from 'react-bootstrap';
import Select from '@mui/material/Select';
import MenuItem from '@mui/material/MenuItem';
import { useTheme } from '@mui/material/styles';
import { createList } from '../../services/lists-service';

const CreateListModal = ({ games = [], show, handleClose }) => {
  const [selectedVideogames, setSelectedVideogames] = React.useState([]);
  const theme = useTheme();

  const ITEM_HEIGHT = 48;
  const ITEM_PADDING_TOP = 8;
  const MenuProps = {
    PaperProps: {
      style: {
        maxHeight: ITEM_HEIGHT * 4.5 + ITEM_PADDING_TOP,
        width: 250,
      },
    },
  };

  const handleSubmit = (event) => {
    event.preventDefault();
    createList({
      name: event.target.formTitle.value,
      description: event.target.formDescription.value,
      videogames: games.filter(game => selectedVideogames.includes(game.name))
    });
    handleClose();
  };

  function getStyles(name, selectedVideogames, theme) {
    return {
      fontWeight: selectedVideogames.includes(name)
        ? theme.typography.fontWeightMedium
        : theme.typography.fontWeightRegular,
    };
  }

  const handleChange = (event) => {
    const {
      target: { value },
    } = event;
    setSelectedVideogames(
      typeof value === 'string' ? value.split(',') : value
    );
  };

  return (
    <Modal show={show} onHide={handleClose}>
      <Modal.Header closeButton>
        <Modal.Title>Crear Lista</Modal.Title>
      </Modal.Header>
      <Modal.Body>
        <Form onSubmit={handleSubmit}>
          <Form.Group controlId="formTitle" className="mb-3">
            <Form.Label>Título</Form.Label>
            <Form.Control type="text" placeholder="Ingresa el título de la lista" />
          </Form.Group>
          <Form.Group controlId="formDescription" className="mb-3">
            <Form.Label>Descripción</Form.Label>
            <Form.Control type="text" placeholder="Ingresa la descripción" />
          </Form.Group>
          <Form.Group controlId="formGames" className="mb-3">
            <Form.Label id="demo-multiple-chip-label">Selecciona los videojuegos</Form.Label>
            <Select
              style={{ width: '100%' }}
              multiple
              value={selectedVideogames}
              onChange={handleChange}
              MenuProps={MenuProps}
            >
              {games.map((game) => (
                <MenuItem
                  key={game.id}
                  value={game.name}
                  style={getStyles(game.name, selectedVideogames, theme)}
                >
                  {game.name}
                </MenuItem>
              ))}
            </Select>
          </Form.Group>
          <div className="d-flex justify-content-between">
            <Button variant="primary" type="submit">
              Guardar
            </Button>
            <Button variant="secondary" onClick={handleClose}>
              Cerrar
            </Button>
          </div>
        </Form>
      </Modal.Body>
    </Modal>
  );
};

export default CreateListModal;
