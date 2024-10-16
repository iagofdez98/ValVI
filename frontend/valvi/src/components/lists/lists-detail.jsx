import React, { useEffect, useState } from 'react';
import "./lists-detail.css"
import { Card, Container, Button } from 'react-bootstrap';
import GameList from '../home/game-list';
import { findLists, deleteList } from "../../services/lists-service";
import CreateListModal from './create-list-modal';
import { getUsername } from '../../api_helper';

const ListDetails = ({games}) => {
  const [lists, setLists] = useState([])
  const [isListModalOpen, setIsListModalOpen] = useState(false)

  useEffect(() => {
    findLists().then(setLists)
  }, []);

  const handleDeleteList = (id) => {
    deleteList(id).then(() => {
      findLists().then(setLists)
    })
  }

  const handleClose = () => {
    setIsListModalOpen(false);
    findLists().then(setLists)
  }

  return (
    <Container className='container-accordion'>
      <CreateListModal show={isListModalOpen} handleClose={() => handleClose()} games={games}/>
      <div className='container-card'>
        <div className="pt-2 d-flex align-items-center">
          <div className="d-flex flex-grow-1">
            <h3 className="mb-3 text-left">Listas de la comunidad</h3>
          </div>
          <Button variant="outline-light" onClick={() => setIsListModalOpen(true)}>Crear lista</Button>
        </div>
        {lists.map((list, index) => (
          <Card key={index} className='mt-2'>
            <Card.Header className="d-flex justify-content-between align-items-center">
              <span>{list.name}</span>
              {list.username === getUsername() && <Button variant="danger" onClick={() => handleDeleteList(list.id)}>Borrar</Button>}
            </Card.Header>
            <Card.Body>
              <blockquote className="blockquote mb-0">
                <p>{list.description}</p>
                <footer className="blockquote-footer">
                  <cite title={list.username}>{list.username}</cite>
                </footer>
              </blockquote>
              <GameList games={list.videogames}/>
            </Card.Body>
          </Card>
        ))}
      </div>
    </Container>
  );
};

export default ListDetails;