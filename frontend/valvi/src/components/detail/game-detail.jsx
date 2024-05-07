import React, { useState, useEffect } from 'react';
import './game-detail.css';
import { useParams } from 'react-router-dom';
import { Container, Col, Row, Button, Alert } from 'react-bootstrap';
import ListGroup from 'react-bootstrap/ListGroup';
import { getRatingByUserAndGame } from '../../services/rating-service';
import { getDateFormatted } from '../utils/utils';
import RatingModal from './rating-modal.jsx';
import { upsertRating } from '../../services/rating-service';

const reviews = [{
    id: 2,
    gameId: 3 ,
    title: "Sobrevalorado",
    date: "2024-02-10",
    description: "Lorem ipsum dolor sit amet consectetur adipisicing elit. Eligendi, fugiat asperiores inventore beatae accusamus odit minima enim, commodi quia, doloribus eius! Ducimus nemo accusantium maiores velit corrupti tempora reiciendis molestiae repellat vero. Eveniet ipsam adipisci illo iusto quibusdam, sunt neque nulla unde ipsum dolores nobis enim quidem excepturi, illum quos!",
    image: "https://images.igdb.com/igdb/image/upload/t_cover_big/co5xex.png",
    rating: 6.5
  }
]

const GameDetail = () => {
  const { id } = useParams();
  const [gameInfo, setGameInfo] = useState({});
  const [gameReview, setGameReview] = useState([])
  const [isRatingModalOpen, setIsRatingModalOpen] = useState(false)

  useEffect(() => {
    getRatingByUserAndGame(id).then(setGameInfo)
    setGameReview(reviews.filter(review => review.gameId === parseInt(id)))
  }, [id]);

  const handleState = (state) => {
    setGameInfo({ ...gameInfo, state });
    upsertRating(gameInfo);
  };

  return (
    <Container fluid>
      {gameInfo.videogame ? <>
      <RatingModal show={isRatingModalOpen} handleClose={() => setIsRatingModalOpen(false)} game={gameInfo?.videogame} />
      <Row className="justify-content-center align-items-center h-100">
        <Col lg="9" xl="7">
            <Row>
              <Container className="position-relative">
                <div className="rounded-top text-white d-flex flex-row" style={{ backgroundColor: '#000', height: '200px' }}>
                  <div className="ms-4 mt-5 d-flex flex-column" style={{ width: '150px' }}>
                    <img class="postcard__img" src={gameInfo?.videogame.image} alt="Title" style={{ maxHeight: '20rem', objectFit: 'cover' }}/>
                  </div>
                  <div className="ms-3 text-with-shadow" style={{ marginTop: '130px' }}>
                    <h1>{gameInfo?.videogame.name}</h1>
                  </div>
                </div>
                <div className="position-absolute top-0 end-0 mt-3 me-4">
                  <h3 className="bg-dark px-2 py-1 rounded text-white text-center">{gameInfo?.videogame.averageRating}</h3>
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
                  </ListGroup>
                </div>
                </Col>
                <Col xs={9} className='mt-4'>
                  <div>
                    <h3>Sobre el juego</h3>
                    <p className='mb-0'><strong>Desarrollador:</strong> {gameInfo?.videogame.developer}</p>
                    <p><strong>Fecha de lanzamiento:</strong> {getDateFormatted(gameInfo?.videogame.releaseDate)}</p>
                    <p>{gameInfo?.videogame.description}</p>
                  </div>
                  <div>
                    <h3>Reseñas</h3>
                    {gameReview?.map(review =>
                      <div key={review.id}>{review.description}</div>)}
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
