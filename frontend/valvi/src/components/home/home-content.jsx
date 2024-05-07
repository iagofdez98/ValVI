import React, { useEffect } from 'react';
import './home.css';
import { Col, Container, Row } from 'react-bootstrap';
import ImageCarousel from './carousel-home';
import GameList from './game-list';
import ReviewList from './review-list';
import { getGamesByUser } from '../../services/rating-service';

const HomeContent = () => {
  const [games, setGames] = React.useState([])

  useEffect(() => {
    getGamesByUser().then((data) => {
      setGames(data)
    }).catch((error) => {
      console.log(error)
    });
  }, []);

  const gamesPlayed = games.filter(e => e.state === "PLAYED").map(game => game.videogame)
  const gamesPending = games.filter(e => e.state === "PENDING").map(game => game.videogame)

  return (
  <Container fluid className='p-0'>
    <ImageCarousel/>
    <Container>
      <Row className="mt-4">
        <Col md={10} className="offset-md-1">
          <Row className="pr-0">
            <Col className="d-flex flex-column mx-2">
              <h3 className="mb-3 text-left">Últimos Juegos</h3>
              <GameList maxShowedGames={6} games={gamesPlayed}/>
            </Col>
          </Row>
          <Row className="mt-4">
            <Col className="d-flex flex-column mx-2">
              <h3 className="mb-3 text-left">Juegos Pendientes</h3>
              <GameList maxShowedGames={6} games={gamesPending}/>
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
