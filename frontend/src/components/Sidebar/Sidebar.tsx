import {BiCaretLeft, BiCaretRight} from 'react-icons/bi';

import {
  Drawer,
  DrawerBody,
  DrawerContent,
  IconButton,
  useDisclosure
} from '@chakra-ui/react';

import AuthCard from 'components/AuthCard';
import React from 'react';
import SearchInput from 'components/SearchInput';

function Sidebar () {
  const {isOpen, onClose, onOpen} = useDisclosure({defaultIsOpen: true});
  const btnRef = React.useRef<any>();

  const renderDrawerBody = () => {
    return (
      <DrawerBody>
        <SearchInput/>
        <AuthCard/>
      </DrawerBody>
    );
  };

  const renderDrawerToggle = (toggle: boolean) => {
    const toggleAction = isOpen ? onClose : onOpen;
    const iconButton = isOpen ? <BiCaretLeft /> : <BiCaretRight />;

    const positions: any = {};

    if (isOpen) {
      positions.right = '-50px';
    } else {
      positions.left = '5px';
    }

    return (
      toggle
        ? <IconButton
          aria-label="Открыть меню"
          icon={iconButton}
          pos="absolute"
          top={2}
          zIndex={10}
          onClick={toggleAction}
          {...positions}
        />
        : null
    );
  };

  const renderDrawerContent = () => {
    return (
      <DrawerContent>
        {renderDrawerToggle(isOpen)}
        {renderDrawerBody()}
      </DrawerContent>
    );
  };

  const renderDrawer = () => {
    const isClose = !isOpen;

    return (
      <>
        {renderDrawerToggle(isClose)}
        <Drawer
          closeOnOverlayClick={false}
          finalFocusRef={btnRef}
          isOpen={isOpen}
          placement='left'
          size={'md'}
          onClose={onClose}
        >
          {renderDrawerContent()}
        </Drawer>
      </>
    );
  };

  return renderDrawer();
}

export default Sidebar;
