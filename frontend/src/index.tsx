import './styles/styles.less';
import App from 'components/App';
import configureStore from 'store';
import {defaultGetState} from 'actions/common';
import {Provider} from 'react-redux';
import React from 'react';
import {render} from 'react-dom';

const root = document.getElementById('root');
if (root) {
  const store = configureStore(defaultGetState());
  render(
    <Provider store={store}>
      <App/>
    </Provider>,
    root
  );
}
