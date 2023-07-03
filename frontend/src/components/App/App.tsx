import React, {FC} from 'react';
import {ChakraProvider} from '@chakra-ui/react';
import Fonts from 'components/Fonts';
import SidebarMap from 'components/SidebarMap';
import theme from '../../theme';

const App: FC = () => {
  return (
    <ChakraProvider theme={theme}>
      <Fonts/>
      <SidebarMap/>
    </ChakraProvider>
  );
};

export default App;
