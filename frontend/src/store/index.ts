import {configureStore} from '@reduxjs/toolkit';
import {createLogger} from 'redux-logger';
import {isDevelopmentMode} from 'helpers/utils';
import root from 'reducers';
import {State} from 'types/index';

export type RootState = ReturnType<typeof root>

export type AppState = {app: State};

export default function configureAppStore (preloadedState: RootState) {
  const store = configureStore({
    reducer: root,
    middleware: (getDefaultMiddleware) => getDefaultMiddleware().concat(createLogger()),
    preloadedState
  });

  if (isDevelopmentMode() && module.hot) {
    const nextRootReducer = require('reducers');
    module.hot.accept('reducers', () => store.replaceReducer(nextRootReducer));
  }

  return store;
}
