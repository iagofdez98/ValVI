import React, { useState, useEffect } from 'react';
import './game-detail.css';
import { useParams } from 'react-router-dom';
import { Container, Col, Row, Button } from 'react-bootstrap';

const games = [
  { id: 1, title: "Baldur's Gate 3", image: "https://images.igdb.com/igdb/image/upload/t_cover_big/co670h.png", rating: 9.2 },
  { id: 2, title: "Elden Ring", image: "https://images.igdb.com/igdb/image/upload/t_cover_big/co4jni.png", rating: 9.0 },
  { id: 3, title: "The Last of Us: Part 1", image: "https://images.igdb.com/igdb/image/upload/t_cover_big/co5xex.png", rating: 9.3 },
  { id: 4, title: "Stardew Valley", image: "https://images.igdb.com/igdb/image/upload/t_cover_big/xrpmydnu9rpxvxfjkiu7.png", rating: 9.5 },
  { id: 5, title: "The Legend of Zelda: Breath of the Wild", image: "https://images.igdb.com/igdb/image/upload/t_cover_big/co3p2d.png", rating: 8.9 },
  { id: 5, title: "Super Mario 64", image: "https://images.igdb.com/igdb/image/upload/t_cover_big/co721v.png", rating: 8.5 },
  { id: 6, title: "Silent Hill 2", image: "https://images.igdb.com/igdb/image/upload/t_cover_big/co2vyg.png", rating: 9.5  },
  { id: 7, title: "Red Dead Redemption 2", image: "https://images.igdb.com/igdb/image/upload/t_cover_big/co1q1f.png", rating: 9.7  },
  { id: 8, title: "Portal 2", image: "https://images.igdb.com/igdb/image/upload/t_cover_big/co1rs4.png", rating: 8.2  },
  { id: 9, title: "Grand Theft Auto: San Andreas", image: "https://images.igdb.com/igdb/image/upload/t_cover_big/co2lb9.png", rating: 8.6  },
  { id: 10, title: "It Takes Two", image: "https://images.igdb.com/igdb/image/upload/t_cover_big/co2t97.png", rating: 9.1  },
  { id: 11, title: "Hollow Knight", image: "https://images.igdb.com/igdb/image/upload/t_cover_big/co1rgi.png", rating: 9.5  }
];

const reviews = [{
    id: 2,
    gameId: 3,
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
    fetchGameById(id)
    setGameReview(reviews.filter(review => review.gameId === parseInt(id)))
  }, [id]);

  const fetchGameById = (id) => {
    setGame(games.find(game => game.id === parseInt(id)))
  }

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
                    <h1>{game.title}</h1>
                  </div>
                </div>
                <div className="position-absolute top-0 end-0 mt-3 me-4">
                  <h3 className="bg-dark px-2 py-1 rounded text-white">{game.rating}</h3>
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
                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed feugiat ipsum eget nibh elementum, ac fermentum ex facilisis. Nulla nec nisi eu dui fermentum viverra. Proin sit amet purus in nulla interdum feugiat. Proin blandit quam nec varius congue. Nullam efficitur ultricies urna vel accumsan. Pellentesque non odio ac risus ultrices blandit. Curabitur vestibulum dui nec nisi hendrerit tristique. Mauris rhoncus libero sit amet libero efficitur, at fringilla felis auctor. In eget felis dolor. Aliquam at magna sit amet elit luctus elementum.</p>
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
