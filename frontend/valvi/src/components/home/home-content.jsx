import React from 'react';
import './home.css';
import { Col, Container, Row } from 'react-bootstrap';
import ImageCarousel from './carousel-home';
import GameList from './game-list';
import ReviewList from './review-list';

const HomeContent = ({games = []}) => {

  return (
  <Container fluid>
    <ImageCarousel/>
    <Container>
      <Row className="mt-4">
        <Col md={10} className="offset-md-1">
          <Row className="pr-0">
            <Col className="d-flex flex-column mx-2">
              <h3 className="mb-3 text-left">Últimos Juegos</h3>
              <GameList maxShowedGames={6} games={games}/>
            </Col>
          </Row>
          <Row className="mt-4">
            <Col className="d-flex flex-column mx-2">
              <h3 className="mb-3 text-left">Juegos Pendientes</h3>
              <GameList maxShowedGames={6} games={games}/>
            </Col>
          </Row>
          <Row className="mt-4">
            <Col className="d-flex flex-column mx-2">
              <h3 className="mb-3 text-left">Reseñas recientes</h3>
              <ReviewList/>
            </Col>
          </Row>
        </Col>
      </Row>
    </Container>
  </Container>
  );
};

export default HomeContent;
