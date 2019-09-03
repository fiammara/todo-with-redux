import { FETCH_TODO_DATA, DELETE_POST } from '../actions/types';

export default function todoReducer(state = [], action) {
  switch (action.type) {
    case FETCH_TODO_DATA:
      return action.todos;
      case DELETE_POST:
          return state.filter((post) => post.id !== action.payload.id);
    default:
      return state;
  }
}
