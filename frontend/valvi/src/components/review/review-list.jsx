import React, { useState, useEffect } from 'react';
import "./review-list.css";
import { Container, Button } from 'react-bootstrap';
import { getLastReviews, deleteReview } from '../../services/review-service';
import { getDateFormatted } from '../utils/utils';
import { getReviewsByGame } from '../../services/review-service';
import { getUsername } from '../../api_helper';

const ReviewList = ({gameId, lastReviews = 2}) => {
  const [gameReviews, setGameReviews] = useState([])

  useEffect(() => {
    if (gameId) {
      getReviewsByGame(gameId)
      .then(setGameReviews)
    } else {
      getLastReviews(lastReviews).then(setGameReviews)
    }
  }, [gameId, lastReviews]);

  const handleDeleteReview = (id) => {
    deleteReview(id).then(() => {
      getLastReviews(lastReviews).then(setGameReviews)
    })
  }

  const renderArticle = (review) => {
    return (<article className="postcard light blue container-margin">
      <img className="postcard__img" src={review.videogame.image} alt="Title" style={{ maxHeight: '20rem', objectFit: 'cover' }}/>
      <div className="postcard__text t-dark">
        <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center' }}>
          <h1 className="postcard__title">{review.title}</h1>

          {review.username === getUsername() && (
            <Button variant="danger" onClick={() => handleDeleteReview(review.id)}>
              Borrar
            </Button>
          )}
        </div>
        <div className="postcard__subtitle small">
          <time datetime="2020-05-25 12:00:00">
            <i className="fas fa-calendar-alt mr-2"></i>{getDateFormatted(review.date)}
          </time>
        </div>
        <div className="postcard__subtitle small">
          <p>De: {review.username}</p>
        </div>
        <div className="postcard__bar"></div>
        <div className="postcard__preview-txt">{review.description}</div>
      </div>
    </article>
  )};

  const renderArticleLiteVersion = (review) => {
    return (
      <article className="postcard light blue">
        <div className="postcard__textlite t-dark">
          <h4 style={{ fontSize: '1rem', fontWeight: 'bold' }}>{review.title}</h4>
          <div style={{ fontSize: '0.8rem', paddingLeft: '10px' }}>{review.description}</div>
          <div className="row justify-content-end">
            <div className="col-auto">
              <p className="t-dark" style={{ fontStyle: 'italic' }}>- {review.username}</p>
            </div>
          </div>
        </div>
      </article>
    )};


  return (
	<Container className='py-2'>
    {!gameId && <div className="d-flex flex-grow-1 pt-2 container-card">
      <h3 className="mb-3 text-left">Reviews de la comunidad</h3>
    </div>}
    {gameReviews.map(review => gameId ? renderArticleLiteVersion(review) : renderArticle(review))}
  </Container>
  );
}

export default ReviewList;
