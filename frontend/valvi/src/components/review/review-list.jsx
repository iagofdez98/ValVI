import React, { useState, useEffect } from 'react';
import "./review-list.css";
import { Container } from 'react-bootstrap';
import { getLastReviews } from '../../services/review-service';
import { getDateFormatted } from '../utils/utils';

const ReviewList = ({gameId}) => {
  const [gameReviews, setGameReviews] = useState([])

  useEffect(() => {
    // if (gameId) {
      // fetchReviews(gameId)
    // } else {
      getLastReviews(2).then(setGameReviews)
    // }
  }, []);

  const renderArticle = (review) => {
    return (<article class="postcard light blue">
      <img class="postcard__img" src={review.videogame.image} alt="Title" style={{ maxHeight: '20rem', objectFit: 'cover' }}/>
      <div class="postcard__text t-dark">
        <h1 class="postcard__title">{review.title}</h1>
        <div class="postcard__subtitle small">
          <time datetime="2020-05-25 12:00:00">
            <i class="fas fa-calendar-alt mr-2"></i>{getDateFormatted(review.date)}
          </time>
        </div>
        <div class="postcard__subtitle small">
          <p>De: {review.username.username}</p>
        </div>
        <div class="postcard__bar"></div>
        <div class="postcard__preview-txt">{review.description}</div>
      </div>
    </article>
  )};


  return (
	<Container className='py-2'>
    {gameReviews.map(review => renderArticle(review))}
  </Container>
  );
}

export default ReviewList;
