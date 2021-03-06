import { FETCH_ARCHIVE_DATA } from '../actions/types';

export default function archiveReducer(state = [], action) {
  switch (action.type) {
    case FETCH_ARCHIVE_DATA:
      return action.data;
    default:
      return state;
  }
}
