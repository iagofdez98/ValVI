import api from "../api";

export const findLists = () => api.findLists();

export const createList = (list) => api.createList(list);

export const deleteList = (id) => api.deleteList(id);