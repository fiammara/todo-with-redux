import { combineReducers } from 'redux';
import data from './archiveReducer';
import todos from './todoReducer';
import geod from './geodReducer';
// import modalState from './modalReducer';
import modalReducer from './modalReducer';

export default combineReducers({
    data,
    todos,
    geod,
    modal: modalReducer
});
