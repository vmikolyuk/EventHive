/** @type {import('postcss-load-config').Config} */
const config = {
  plugins: [
    require('postcss-import'),
    require('autoprefixer'),
    require('postcss-nested'),
    require('postcss-modules')({
      generateScopedName: '[local]___[hash:base64:5]',
      globalModulePaths: [/(node_modules)/]
    })
  ]
};

module.exports = config;
