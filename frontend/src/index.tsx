import './styles/styles.css';
import App from 'components/App';
import {Provider} from 'react-redux';
import React from 'react';
import configureStore from 'store';
import {createRoot} from 'react-dom/client';
import {defaultGetState} from 'actions/common';

const container = document.getElementById('root');

const root = createRoot(container!);

const store = configureStore(defaultGetState());
root.render(
  <Provider store={store}>
    <App/>
  </Provider>
);
