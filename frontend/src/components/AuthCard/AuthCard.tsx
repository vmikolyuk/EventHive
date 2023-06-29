import {Button, Card, CardBody, CardFooter, Heading, Stack, Text} from '@chakra-ui/react';
import React from 'react';

const AuthCard = () => {
  return (
    <Card
      direction={{base: 'column', sm: 'row'}}
      mt={25}
      overflow='hidden'
      variant='outline'
    >
      <Stack>
        <CardBody>
          <Heading size='md'>Войдите в аккаунт</Heading>
          <Text py='2'>
            Вы сможете создать мероприятие <br/>
            для друзей и знакомых!
          </Text>
        </CardBody>
        <CardFooter>
          <Button
            colorScheme='blue'
            variant='solid'
          >
            Войти
          </Button>
        </CardFooter>
      </Stack>
    </Card>
  );
};

export default AuthCard;
