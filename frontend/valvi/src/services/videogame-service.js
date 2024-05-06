import api from '../api';

export const getGames = (filter) => api.getGames(filter);

export const getGameById = (id) => api.getGameById(id);