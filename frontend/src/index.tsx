import './styles/styles.css';
import App from 'components/App';
import configureStore from 'store';
import {defaultGetState} from 'actions/common';
import {Provider} from 'react-redux';
import React from 'react';
import {createRoot} from 'react-dom/client';

const container = document.getElementById('root');

const root = createRoot(container!);

const store = configureStore(defaultGetState());
root.render(
  <Provider store={store}>
    <App/>
  </Provider>
);
