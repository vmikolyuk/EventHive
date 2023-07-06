import {Box, Flex, Heading, Link, VStack} from '@chakra-ui/react';
import React from 'react';
import {TfiLocationPin} from 'react-icons/tfi';
// import {TfiLocationPin} from 'react-icons/tfi';

const Location = () => {
  // const renderTitle = () => {
  // return (
  //   <Heading
  //     as='h2'
  //     size='sm'
  //   >
  //     Муссон
  //   </Heading>
  // );
  // };

  const renderTitle = () => {
    return (
      <Heading
        as="h3"
        size="sm"
      >
        Муссон
      </Heading>
    );
  };

  // const renderLocation = () => {
  // return (
  //   <Link
  //     color={'blue.400'}
  //     fontSize={'xs'}
  //   >
  //     <TfiLocationPin /> Торговый центр · улица Вакуленчука, 29 / 10
  //   </Link>
  // );
  // };

  const renderLocation = () => {
    return (
      <Flex
        align="center"
        color="gray"
        cursor="pointer"
        fontSize='xs'
        mt={1}
      >
        <Box mr="2px"><TfiLocationPin /></Box>
        <Box>улица Вакуленчука, 29 / 10</Box>
      </Flex>
    );
  };

  const renderDescription = () => {
    // return (
    //   <Text fontSize={'sm'}>
    //     ТЦ Муссон, есть ряд площадок для игры в футбол, волейбол, теннис.
    //   </Text>
    // );
  };

  const renderBody = () => {
    // return (
    //   <CardBody p={0}>
    //     <Image
    //       src='https://lh3.googleusercontent.com/p/AF1QipPJa56wNwRhKhE9hqvi5ODlUccSZI8IsHn_JMWU=s1360-w1360-h1020'
    //     />
    //     <Stack
    //       mt='2'
    //       p='4'
    //       spacing='2'
    //     >
    //       {renderTitle()}
    //       {renderLocation()}
    //       {renderDescription()}
    //     </Stack>
    //   </CardBody>
    // );
  };

  return (
    <Flex direction="row">
      <Box>
        <VStack
          align='flex-start'
          spacing={0}
        >
          {renderTitle()}
          {renderLocation()}
        </VStack>
      </Box>
      <Box></Box>
    </Flex>
  );
};

export default Location;
