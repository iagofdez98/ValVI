import api from '../api';

export const getGamesByUser = () => api.getGamesByUser();

export const getRatingByUserAndGame = (gameId) => api.getRatingByUserAndGame(gameId);

export const upsertRating = (rating) => api.upsertRating(rating);