import {AppState} from 'store';
import {initialAppState} from 'init/app';

const defaultGetState = (): AppState => ({
  app: initialAppState
});

export {
  defaultGetState
};
