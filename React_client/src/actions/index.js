import axios from 'axios';
import {
  FETCH_ARCHIVE_DATA,
  FETCH_TODO_DATA,
  DELETE_POST,
  ACTIVATE_GEOD,
  CLOSE_GEOD,
  OPEN_MODAL,
  CLOSE_MODAL
} from './types';

const archiveUrl = 'http://localhost:8080/api/archive';
const todoUrl = 'http://localhost:8080/api/todos';

export const fetchData = (data) => ({
  type: FETCH_ARCHIVE_DATA,
  data
});

export const fetchArchiveData = () => (dispatch) =>
  axios
    .get(archiveUrl)
    .then((response) => {
      dispatch(fetchData(response.data));
    })
    .catch((error) => {
      throw error;
    });

export const fetchTodo = (todos) => ({
  type: FETCH_TODO_DATA,
  todos
});

export const fetchTodoData = () => (dispatch) =>
  axios
    .get(todoUrl)
    .then((response) => {
      dispatch(fetchTodo(response.data));
    })
    .catch((error) => {
      throw error;
    });

export const deletePostSuccess = (id) => ({
  type: DELETE_POST,
  payload: {
    id
  }
});

export const deletePost = (id) => (dispatch) =>
  axios
    .delete(`http://localhost:8080/api/todos/${id}`)
    .then((response) => {
      dispatch(deletePostSuccess(response.data));
    })

    .catch((error) => {
      throw error;
    });

export const activateGeod = (geod) => ({
  type: ACTIVATE_GEOD,
  geod
});

export const closeGeod = () => ({
  type: CLOSE_GEOD
});

export const openModal = () => ({
  type: OPEN_MODAL,
 
});

export const closeModal = () => ({
  type: CLOSE_MODAL,
  
});
