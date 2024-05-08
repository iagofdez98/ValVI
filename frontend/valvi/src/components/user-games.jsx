import React, { useEffect } from 'react';
import './home/home.css';
import { Col, Container, Row } from 'react-bootstrap';
import GameList from './home/game-list';
import { getGamesByUser } from '../services/rating-service';

const UserGames = () => {
  const [games, setGames] = React.useState([])

  useEffect(() => {
    getGamesByUser().then((data) => {
      setGames(data)
    }).catch((error) => {
      console.log(error)
    });
  }, []);

  const gamesPlayed = games.filter(e => e.state === "PLAYED").map(game => game.videogame).slice().reverse()
  const gamesPending = games.filter(e => e.state === "PENDING").map(game => game.videogame).slice().reverse()
  const gamesFavorite = games.filter(e => e.state === "FAVORITE").map(game => game.videogame).slice().reverse()

  return (
    <Container>
      <Row className="pt-5 mt-4">
        <Col md={10} className="offset-md-1">
        <Row className="mt-4">
            <Col className="d-flex flex-column mx-2">
              <h3 className="mb-3 text-left">Tus Juegos Favoritos</h3>
              <GameList games={gamesFavorite}/>
            </Col>
          </Row>
          <Row className="pr-0">
            <Col className="d-flex flex-column mx-2">
              <h3 className="mb-3 text-left">Todos tus Juegos Jugados</h3>
              <GameList games={gamesPlayed}/>
            </Col>
          </Row>
          <Row className="mt-4">
            <Col className="d-flex flex-column mx-2">
              <h3 className="mb-3 text-left">Todos tus Juegos Pendientes</h3>
              <GameList games={gamesPending}/>
            </Col>
          </Row>
        </Col>
      </Row>
    </Container>
      );
};

export default UserGames;
