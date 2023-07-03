'use strict';

const define = require('./define');
const {resolve} = require('path');

module.exports = {
  alias: {
    actions: resolve(define.src, 'actions'),
    api: resolve(define.src, 'api'),
    components: resolve(define.src, 'components'),
    constants: resolve(define.src, 'constants'),
    helpers: resolve(define.src, 'helpers'),
    hooks: resolve(define.src, 'hooks'),
    images: resolve(define.src, 'images'),
    init: resolve(define.src, 'init'),
    reducers: resolve(define.src, 'reducers'),
    store: resolve(define.src, 'store'),
    stubs: resolve(define.src, 'stubs'),
    styles: resolve(define.src, 'styles'),
    types: resolve(define.src, 'types')
  },
  extensions: ['.ts', '.tsx', '.js', '.jsx']
};
