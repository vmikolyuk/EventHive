import app from 'reducers/appSlice';
import {combineReducers} from 'redux';

export const root = combineReducers({
  app
});

export default root;
