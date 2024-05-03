import React from "react";
import "./game-list.css";
import { Card, Col, Row } from 'react-bootstrap';
import { Link } from 'react-router-dom';

const GameList = ({maxShowedGames, games = []}) => {

  return (
    <Row>
      {games.slice(0, maxShowedGames)?.map(game => (
          <Col key={game.id} xs={6} md={4} lg={2}>
            <Link to={`/game/${game.id}`}>
              <Card className="cards">
                <Card.Img variant="top" src={game.image} />
                <Card.Body>
                  <Card.Title style={{ fontSize: '0.8rem' }}>{game.name}</Card.Title>
                  <p className="position-absolute top-0 end-0 m-1 text-white fw-bold text-with-shadow">{game.averageRating}</p>
                </Card.Body>
              </Card>
            </Link>
          </Col>
      ))}
    </Row>
  )
};

export default GameList;
