import React from 'react';
import './home.css';
import { Col, Container, Row } from 'react-bootstrap';
import ImageCarousel from './carousel-home';
import GameList from './game-list';

const Home = ({ username }) => {
  const lastGames = [
      { id: 1, title: "Baldur's Gate 3", image: "https://images.igdb.com/igdb/image/upload/t_cover_big/co670h.png", rating: 9.2 },
      { id: 2, title: "Elden Ring", image: "https://images.igdb.com/igdb/image/upload/t_cover_big/co4jni.png", rating: 9.0 },
      { id: 3, title: "The Last of Us: Part 1", image: "https://images.igdb.com/igdb/image/upload/t_cover_big/co5xex.png", rating: 9.3 },
      { id: 4, title: "Stardew Valley", image: "https://images.igdb.com/igdb/image/upload/t_cover_big/xrpmydnu9rpxvxfjkiu7.png", rating: 9.5 },
      { id: 5, title: "The Legend of Zelda: Breath of the Wild", image: "https://images.igdb.com/igdb/image/upload/t_cover_big/co3p2d.png", rating: 8.9 },
      { id: 5, title: "Super Mario 64", image: "https://images.igdb.com/igdb/image/upload/t_cover_big/co721v.png", rating: 8.5 }
  ];

  const pendingGames = [
      { id: 6, title: "Silent Hill 2", image: "https://images.igdb.com/igdb/image/upload/t_cover_big/co2vyg.png", rating: 9.5  },
      { id: 7, title: "Red Dead Redemption 2", image: "https://images.igdb.com/igdb/image/upload/t_cover_big/co1q1f.png", rating: 9.7  },
      { id: 8, title: "Portal 2", image: "https://images.igdb.com/igdb/image/upload/t_cover_big/co1rs4.png", rating: 8.2  },
      { id: 9, title: "Grand Theft Auto: San Andreas", image: "https://images.igdb.com/igdb/image/upload/t_cover_big/co2lb9.png", rating: 8.6  },
      { id: 10, title: "It Takes Two", image: "https://images.igdb.com/igdb/image/upload/t_cover_big/co2t97.png", rating: 9.1  },
      { id: 10, title: "Hollow Knight", image: "https://images.igdb.com/igdb/image/upload/t_cover_big/co1rgi.png", rating: 9.5  }
  ];

  return (
  <Container fluid>
    <ImageCarousel/>
    <Container>
      <Row className="mt-4">
        <Col md={10} className="offset-md-1">
          <Row className="pr-0">
            <Col className="d-flex flex-column mx-2">
              <h3 className="mb-3 text-left">Últimos Juegos</h3>
              <GameList games={lastGames}/>
            </Col>
          </Row>
          <Row className="mt-4">
            <Col className="d-flex flex-column mx-2">
              <h3 className="mb-3 text-left">Juegos Pendientes</h3>
              <GameList games={pendingGames}/>
            </Col>
          </Row>
        </Col>
      </Row>
    </Container>
  </Container>
  );
};

export default Home;
