import React from "react";
import "./game-list.css";
import { Card, Col, Row } from 'react-bootstrap';
import { Link } from 'react-router-dom';
import Rating from '@mui/material/Rating';

const GameList = ({maxShowedGames = 1000, games = []}) => {

  return (
    <Row>
      {games.slice(0, maxShowedGames)?.map(game => (
          <Col key={game.id} xs={6} md={4} lg={2}>
            <Link to={`/game/${game.id}`}>
              <Card className="cards mb-3">
                <Card.Img variant="top" src={game.image} />
                <Card.Body>
                  <Card.Title style={{ fontSize: '0.8rem' }}>{game.name}</Card.Title>
                  <p className="position-absolute top-0 end-0 m-1 text-white fw-bold text-with-shadow"><Rating name="customized-1" precision={0.1} value={game.averageRating/10} max={1} readOnly/></p>
                </Card.Body>
              </Card>
            </Link>
          </Col>
      ))}
    </Row>
  )
};

export default GameList;
