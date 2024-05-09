import React, { useState, useEffect } from 'react';
import "./review-list.css";
import { Container } from 'react-bootstrap';
import { getLastReviews } from '../../services/review-service';
import { getDateFormatted } from '../utils/utils';
import { getReviewsByGame } from '../../services/review-service';

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

  const renderArticle = (review) => {
    return (<article class="postcard light blue container-margin">
      <img class="postcard__img" src={review.videogame.image} alt="Title" style={{ maxHeight: '20rem', objectFit: 'cover' }}/>
      <div class="postcard__text t-dark">
        <h1 class="postcard__title">{review.title}</h1>
        <div class="postcard__subtitle small">
          <time datetime="2020-05-25 12:00:00">
            <i class="fas fa-calendar-alt mr-2"></i>{getDateFormatted(review.date)}
          </time>
        </div>
        <div class="postcard__subtitle small">
          <p>De: {review.username}</p>
        </div>
        <div class="postcard__bar"></div>
        <div class="postcard__preview-txt">{review.description}</div>
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
    <div className="d-flex flex-grow-1 pt-2 container-card">
      <h3 className="mb-3 text-left">Reviews de la comunidad</h3>
    </div>
    {gameReviews.map(review => gameId ? renderArticleLiteVersion(review) : renderArticle(review))}
  </Container>
  );
}

export default ReviewList;
