import {
  Box,
  ChakraProvider,
  useColorModeValue
} from '@chakra-ui/react';

import React, {FC} from 'react';
import Map from 'components/Map';
import Sidebar from 'components/Sidebar';

const App: FC = () => {
  return (
    <ChakraProvider>
      <Box
        bg={useColorModeValue('gray.100', 'gray.900')}
        minH="100vh"
      >
        <Sidebar/>
        <Map />
      </Box>
    </ChakraProvider>
  );
};

export default App;

/**
  <Box>
  <Sidebar>
    <Sidebar.Header></Sidebar.Header>
    <Sidebar.></Sidebar.Header>
  <Sidebar>
  Map
  </Box>
 */
