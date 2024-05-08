import React, { useState, useEffect } from 'react';
import './game-detail.css';
import { useParams } from 'react-router-dom';
import { Container, Col, Row, Button } from 'react-bootstrap';
import ListGroup from 'react-bootstrap/ListGroup';
import { getRatingByUserAndGame } from '../../services/rating-service';
import { getDateFormatted } from '../utils/utils';
import RatingModal from './rating-modal.jsx';
import { upsertRating } from '../../services/rating-service';
import ReviewList from '../review/review-list.jsx';
import AddReviewModal from './modal-add-review.jsx';

const GameDetail = ({games = []}) => {
  const { id } = useParams();
  const [gameInfo, setGameInfo] = useState({});
  const [videogame, setVideogame] = useState({});
  const [isRatingModalOpen, setIsRatingModalOpen] = useState(false)
  const [isReviewModalOpen, setIsReviewModalOpen] = useState(false)

  useEffect(() => {
    getRatingByUserAndGame(id)
      .then(setGameInfo)
      .catch(() => setGameInfo(({ ...gameInfo, videogame: games.find(game => game.id === parseInt(id))})));
  }, [id]);

  useEffect(() => {
    gameInfo?.videogame ? setVideogame(gameInfo.videogame) : setVideogame(games.find(game => game.id === parseInt(id)));
  }, [gameInfo]);

  const handleState = (state) => {
    setGameInfo({ ...gameInfo, videogame, state });
    upsertRating(gameInfo);
  };

  return (
    <Container fluid className='pt-5'>
      {videogame ? <>
      <RatingModal show={isRatingModalOpen} handleClose={() => setIsRatingModalOpen(false)} game={videogame} />
      <Row className="justify-content-center align-items-center h-100">
        <Col lg="9" xl="7">
            <Row>
              <Container className="position-relative">
                <div className="rounded-top text-white d-flex flex-row" style={{ backgroundColor: '#000', height: '200px' }}>
                  <div className="ms-4 mt-5 d-flex flex-column" style={{ width: '13.5rem' }}>
                    <img class="postcard__img" src={videogame.image} alt="Title" style={{ maxHeight: '20rem', objectFit: 'cover' }}/>
                  </div>
                  <div className="ms-3 text-with-shadow" style={{ marginTop: '130px' }}>
                    <h1>{videogame.name}</h1>
                  </div>
                </div>
                <div className="position-absolute top-0 end-0 mt-3 me-4">
                  <h3 className="bg-dark px-2 py-1 rounded text-white text-center">{videogame.averageRating}</h3>
                  {gameInfo?.qualification ?
                    <p className="px-2 py-1 text-white">Tu nota: {gameInfo?.qualification}</p> :
                    <Button variant="light" onClick={() => setIsRatingModalOpen(true)}>¿Valorar?</Button>
                  }
                </div>
              </Container>
            </Row>
            <Row className='bg-light text-dark m-0'>
              <Row>
                <Col className="button-group-column mt-custom" xs={3}>
                  <div className="d-flex flex-column">
                  <ListGroup as="ul">
                    <ListGroup.Item className='text-center state-button' active={gameInfo.state === "PLAYED"} onClick={() => handleState("PLAYED")}>Jugado</ListGroup.Item>
                    <ListGroup.Item className='text-center state-button' active={gameInfo.state === "PENDING"} onClick={() => handleState("PENDING")}>Pendiente</ListGroup.Item>
                    <ListGroup.Item className='text-center state-button' active={gameInfo.state === "FAVORITE"} onClick={() => handleState("FAVORITE")}>Favorito</ListGroup.Item>
                  </ListGroup>
                </div>
                </Col>
                <Col xs={9} className='mt-4'>
                  <div>
                    <h3>Sobre el juego</h3>
                    <p className='mb-0'><strong>Desarrollador:</strong> {videogame.developer}</p>
                    <p className='mb-0'><strong>Fecha de lanzamiento:</strong> {getDateFormatted(videogame.releaseDate)}</p>
                    <p className='mb-0'><strong>Géneros:</strong> {videogame.genres?.map(e => e.description).join(", ")}</p>
                    <p><strong>PEGI {videogame.requiredAge}</strong></p>
                    <p>{videogame.description}</p>
                  </div>
                  <div>
                  <div className="pt-2 d-flex align-items-center">
                    <div className="d-flex flex-grow-1">
                      <h3 className="mr-auto">Reseñas</h3>
                    </div>
                    <Button variant="outline-dark" onClick={() => setIsReviewModalOpen(true)}>Añadir</Button>
                  </div>
                    <AddReviewModal show={isReviewModalOpen} handleClose={() => setIsReviewModalOpen(false)} videogame={videogame}/>
                    <ReviewList gameId={videogame.id}/>
                  </div>
                </Col>
              </Row>
            </Row>
        </Col>
      </Row></>
      : <div>Loading...</div>}
    </Container>
  );
};

export default GameDetail;
