import React from "react";
import "./game-list.css";
import { Card, Col, Row } from 'react-bootstrap';

const GameList = ({games = []}) => {
  return (
    <Row>
      {games?.map(game => (
          <Col key={game.id} xs={6} md={4} lg={2}>
              <Card className="cards">
                <Card.Img variant="top" src={game.image} />
                <Card.Body>
                  <Card.Title style={{ fontSize: '0.8rem' }}>{game.title}</Card.Title>
                  <p className="position-absolute top-0 end-0 m-1 text-white fw-bold text-with-shadow">{game.rating}</p>
                </Card.Body>
              </Card>
          </Col>
      ))}
    </Row>
  )
};

export default GameList;
