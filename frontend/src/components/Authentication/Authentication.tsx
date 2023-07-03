import {Card, CardBody, CardFooter, Skeleton, Stack} from '@chakra-ui/react';
import AuthCard from 'components/LoginInfoCard';
import React from 'react';

const Authentication = () => {
  const renderLoginCardSkeleton = () => {
    return (
      <Card
        direction={{base: 'column', sm: 'row'}}
        mt={25}
        overflow='hidden'
        variant='outline'>
        <Stack spacing={4}>
          <CardBody>
            <Skeleton
              endColor='gray.400'
              height='20px'
              mb={5}
              startColor='gray.200'
              width='200px'
            />
            <Skeleton
              endColor='gray.400'
              height='15px'
              mb={1}
              startColor='gray.200'
              width='300px'
            />
            <Skeleton
              endColor='gray.400'
              height='15px'
              startColor='gray.200'
              width='200px' />
          </CardBody>
          <CardFooter>
            <Skeleton
              endColor='gray.400'
              height='40px'
              startColor='gray.200'
              width='80px' />
          </CardFooter>
        </Stack>
      </Card>
    );
  };

  const renderLoginCard = () => {
    return (
      <AuthCard />
    );
  };

  const renderLoginForm = () => {
    return (
      <>
        {/* TODO убрать игнор после того как добавим форму авторизации */}
        {/* {renderLoginCardSkeleton()} */}
        {renderLoginCard()}
      </>
    );
  };

  return (
    <>
      {renderLoginForm()}
    </>
  );
};

export default Authentication;
