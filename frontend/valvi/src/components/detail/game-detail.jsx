import React, { useState, useEffect } from 'react';
import './game-detail.css';
import { useParams } from 'react-router-dom';
import { Container, Col, Row, Button } from 'react-bootstrap';
import { getGameById } from '../../services/videogame-service';

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
  const [game, setGame] = useState({});
  const [gameReview, setGameReview] = useState([])

  useEffect(() => {
    getGameById(id).then(setGame);
    setGameReview(reviews.filter(review => review.gameId === parseInt(id)))
  }, [id]);

  return (
    <Container fluid>
      <Row className="justify-content-center align-items-center h-100">
        <Col lg="9" xl="7">
            <Row>
              <Container className="position-relative">
                <div className="rounded-top text-white d-flex flex-row" style={{ backgroundColor: '#000', height: '200px' }}>
                  <div className="ms-4 mt-5 d-flex flex-column" style={{ width: '150px' }}>
                    <img class="postcard__img" src={game.image} alt="Title" style={{ maxHeight: '20rem', objectFit: 'cover' }}/>
                  </div>
                  <div className="ms-3 text-with-shadow" style={{ marginTop: '130px' }}>
                    <h1>{game.name}</h1>
                  </div>
                </div>
                <div className="position-absolute top-0 end-0 mt-3 me-4">
                  <h3 className="bg-dark px-2 py-1 rounded text-white">{game.averageRating}</h3>
                </div>
              </Container>
            </Row>
            <Row className='bg-light text-dark m-0'>
              <Row>
                <Col className="button-group-column mt-custom" xs={3}>
                  <div className="d-flex flex-column">
                    <Button className="button-style me-3 mb-2" variant="dark">Jugado</Button>
                    <Button className='button-style' variant="dark">Pendiente</Button>
                  </div>
                </Col>
                <Col xs={9} className='mt-4'>
                  <div>
                    <h3>Sobre el juego</h3>
                    <p className='mb-0'><strong>Desarrollador:</strong> {game.developer}</p>
                    <p><strong>Fecha de lanzamiento:</strong> {game.releaseDate}</p>
                    <p>{game.description}</p>
                  </div>
                  <div>
                    <h3>Reseñas</h3>
                    {gameReview?.map(review =>
                      <div>{review.description}</div>)}
                  </div>
                </Col>
              </Row>
            </Row>
        </Col>
      </Row>
    </Container>
  );
};

export default GameDetail;
