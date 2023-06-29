module.exports = {
  moduleDirectories: [
    'node_modules',
    'src'
  ],
  moduleFileExtensions: [
    'js',
    'jsx',
    'ts',
    'tsx'
  ],
  moduleNameMapper: {
    '\\.(css|less)$': 'identity-obj-proxy',
    '\\.(jpg|jpeg|png|gif|eot|otf|webp|svg|ttf|woff|woff2|mp4|webm|wav|mp3|m4a|aac|oga)$': '<rootDir>/__tests__/__mocks__/fileMock.js'
  },
  preset: 'ts-jest',
  setupFiles: [
    '<rootDir>/jest-setup.ts'
  ],
  testEnvironment: 'jsdom',
  testPathIgnorePatterns: [
    '/build/',
    '/node_modules/',
    '__tests__/__mocks__/*'
  ],
  testRegex: '(/__tests__/.*|(\\.|/)(test|spec))\\.(t|j)sx?$'
};
