import {Box, Card, CardBody, Heading, Text} from '@chakra-ui/react';
import React from 'react';

const Events = () => {
  const renderEvent = () => {
    return (
      <Card
        border={0}
        variant='outline'
      >
        <CardBody>
          <Box>
            <Heading fontSize='md'>
              Муссон площадка
            </Heading>
            <Text
              fontSize='sm'
              pt='1'
            >
              05 июня (ср), 19:00-21:00, 200 руб
            </Text>
          </Box>
        </CardBody>
      </Card>
    );
  };

  return (
    <>
      {renderEvent()}
    </>
  );
};

export default Events;
