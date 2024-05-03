import React, { useState, useEffect } from 'react';
import "./review-list.css";
import { Container } from 'react-bootstrap';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'

const reviews = [{
  id: 1,
  gameId: 11,
  title: "El mejor juego de la historia",
  date: "2024-02-10",
  description: "Lorem ipsum dolor sit amet consectetur adipisicing elit. Eligendi, fugiat asperiores inventore beatae accusamus odit minima enim, commodi quia, doloribus eius! Ducimus nemo accusantium maiores velit corrupti tempora reiciendis molestiae repellat vero. Eveniet ipsam adipisci illo iusto quibusdam, sunt neque nulla unde ipsum dolores nobis enim quidem excepturi, illum quos!",
  image: "https://images.igdb.com/igdb/image/upload/t_cover_big/co1rgi.png",
  rating: 9.5
},
{
  id: 2,
  gameId: 3,
  title: "Sobrevalorado",
  date: "2024-02-10",
  description: "Lorem ipsum dolor sit amet consectetur adipisicing elit. Eligendi, fugiat asperiores inventore beatae accusamus odit minima enim, commodi quia, doloribus eius! Ducimus nemo accusantium maiores velit corrupti tempora reiciendis molestiae repellat vero. Eveniet ipsam adipisci illo iusto quibusdam, sunt neque nulla unde ipsum dolores nobis enim quidem excepturi, illum quos!",
  image: "https://images.igdb.com/igdb/image/upload/t_cover_big/co5xex.png",
  rating: 6.5
}];

const ReviewList = ({gameId}) => {
  const [gameReviews, setGameReview] = useState([])

  useEffect(() => {
    if (gameId) {
      fetchReviews(gameId)
    } else {
      setGameReview(reviews)
    }
  }, [gameId]);

  const fetchReviews = (gameId) => {
    setGameReview(reviews.filter(review => review.gameId === parseInt(gameId)))
  }

  const renderArticle = (review) => {
    return (<article class="postcard light blue">
      <img class="postcard__img" src={review.image} alt="Title" style={{ maxHeight: '20rem', objectFit: 'cover' }}/>
      <div class="postcard__text t-dark">
        <h1 class="postcard__title">{review.title}</h1>
        <div class="postcard__subtitle small">
          <time datetime="2020-05-25 12:00:00">
            <i class="fas fa-calendar-alt mr-2"></i>{review.date}
          </time>
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
