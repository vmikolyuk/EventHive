import {Box, BoxProps, Flex, FlexProps, StackProps, VStack} from '@chakra-ui/react';
import React, {ReactNode} from 'react';

type SideBarType = FlexProps & { isOpen: boolean, children: ReactNode}
function Sidebar ({children, isOpen = false, ...props}: SideBarType) {
  const renderSidebar = () => {
    return isOpen
      ? (
        <Flex
          boxShadow='xl'
          color='white'
          textColor='black'
          {...props}
        >
          {children}
        </Flex>
      )
      : null;
  };

  return renderSidebar();
}

type SideBarContentType = StackProps & {children: ReactNode}
const renderSidebarContent = ({children, ...props}: SideBarContentType) => {
  return (
    <VStack
      align='stretch'
      bg='white'
      minH="100vh"
      p={4}
      spacing={4}
      w='lg'
      {...props}
    >
      {children}
    </VStack>
  );
};

type SideBarHeaderType = FlexProps & {children: ReactNode}
const SidebarHeader = ({children, ...props}: SideBarHeaderType) => {
  return (
    <Flex
      align='center'
      {...props}
    >
      {children}
    </Flex>
  );
};

type SideBarBodyType = BoxProps & {children: ReactNode}
const SidebarBody = ({children, ...props}: SideBarBodyType) => {
  return (
    <Box {...props}>
      {children}
    </Box>
  );
};

Sidebar.Content = renderSidebarContent;
Sidebar.Header = SidebarHeader;
Sidebar.Body = SidebarBody;

export default Sidebar;
