'use strict';

const {EnvironmentPlugin} = require('webpack');
const HtmlWebpackPlugin = require('html-webpack-plugin');
const MiniCssExtractPlugin = require('mini-css-extract-plugin');
const {version} = require('../package.json');
const Dotenv = require('dotenv-webpack');

const plugins = [
  new MiniCssExtractPlugin({
    chunkFilename: '[id].css',
    filename: '[hash].css'
  }),
  new HtmlWebpackPlugin({
    filename: 'index.html',
    meta: {
      version
    },
    template: './src/index.html'
  }),
  new EnvironmentPlugin({
    NEED_STUB: false,
    NODE_ENV: 'production'
  }),
  new Dotenv()

];

module.exports = plugins;
