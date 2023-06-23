'use strict';

const define = require('./define');
const MiniCssExtractPlugin = require('mini-css-extract-plugin');

module.exports = {
  rules: [
    {
      exclude: /(node_modules|bower_components)/,
      test: /\.tsx?$/,
      use: {
        loader: 'ts-loader',
        options: {
          transpileOnly: define.development
        }
      }
    },
    {
      test: /\.(css)$/,
      use: [
        {
          loader: MiniCssExtractPlugin.loader,
          options: {
            publicPath: ''
          }
        },
        {
          loader: 'css-loader',
          options: {
            sourceMap: define.development
          }
        },
        {
          loader: 'postcss-loader',
          options: {
            sourceMap: define.development
          }
        }
      ]
    },
    {
      test: /\.(gif|png|jpg|jpeg|woff|woff2|ttf|eot|svg)$/,
      use: {
        loader: 'file-loader'
      }
    }
  ]
};
