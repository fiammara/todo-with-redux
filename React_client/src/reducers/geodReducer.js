import { ACTIVATE_GEOD, CLOSE_GEOD } from '../actions/types';

export default function geodReducer(state = {}, action) {
  switch (action.type) {
    case ACTIVATE_GEOD:
      return action.geod;
    case CLOSE_GEOD:
      return {};
    default:
      return state;
  }
}
