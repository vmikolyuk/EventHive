import {
  ChakraProvider,
  CloseButton,
  Flex,
  Heading,
  IconButton,
  Spacer,
  useDisclosure
} from '@chakra-ui/react';

import React, {FC} from 'react';
import Authentication from 'components/Authentication';
import {FiMenu} from 'react-icons/fi';
import Map from 'components/Map';
import SearchInput from 'components/SearchInput';
import Sidebar from 'components/common/Sidebar';

const App: FC = () => {
  const {isOpen, onClose, onOpen} = useDisclosure({defaultIsOpen: true});

  const renderSidebarToggle = () => {
    const isClose = !isOpen;

    if (isClose) {
      return (
        <IconButton
          aria-label="Открыть меню"
          icon={<FiMenu />}
          left={'5px'}
          pos="absolute"
          top={2}
          zIndex={2}
          onClick={onOpen}
        />
      );
    }
  };

  return (
    <ChakraProvider>
      <Flex
        color='white'
        textColor='black'
      >
        <Sidebar isOpen={isOpen}>
          <Sidebar.Content>
            <Sidebar.Header>
              <Heading
                as='h1'
                fontSize='xl'
              >
              Улей мероприятий
              </Heading>
              <Spacer/>
              <CloseButton onClick={onClose}/>
            </Sidebar.Header>
            <Sidebar.Body>
              <SearchInput />
              <Authentication />
            </Sidebar.Body>
          </Sidebar.Content>
        </Sidebar>
        {renderSidebarToggle()}
        <Map />
      </Flex>
    </ChakraProvider>
  );
};

export default App;
