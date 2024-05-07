import api from "../api";

export const getLastReviews = (num) => api.getLastReviews(num);

export const getReviewsByGame = (gameId) => api.getReviewsByGame(gameId);

export const createReview = (review) => api.createReview(review);