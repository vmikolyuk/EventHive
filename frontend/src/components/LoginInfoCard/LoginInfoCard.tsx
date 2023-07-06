import {Button, Card, CardBody, CardFooter, Heading, Mark, Stack, Text, useHighlight} from '@chakra-ui/react';
import React from 'react';

const AuthCard = () => {
  const chunks = useHighlight({
    query: ['создать', 'мероприятие'],
    text: 'Вы сможете создать мероприятие для друзей и знакомых!'
  });

  const renderWordCreate = (text: string, bg: string) => {
    return (
      <Mark
        bg={bg}
        px='2'
        py='1'
        rounded='full'
      >
        {text}
      </Mark>
    );
  };

  const renderText = () => {
    return (
      <Text
        fontSize='lg'
        py='2'
      >

        {chunks.map(({match, text}, key) => {
          if (!match) {
            return text;
          }

          if (text === 'создать') {
            return renderWordCreate(text, 'teal.100');
          }

          if (text === 'мероприятие') {
            return (
              <>
                {renderWordCreate(text, 'red.100')}
                <br/>
              </>
            );
          }

          return text;
        })}

      </Text>
    );
  };

  return (
    <Card
      border={0}
      direction={{base: 'column', sm: 'row'}}
      mt={25}
      overflow='hidden'
      variant='outline'
    >
      <Stack>
        <CardBody>
          <Heading size='lg'>Войдите в аккаунт</Heading>
          {renderText()}
        </CardBody>
        <CardFooter>
          <Button
            colorScheme='teal'
            size='lg'
          >
            Войти
          </Button>
        </CardFooter>
      </Stack>
    </Card>
  );
};

export default AuthCard;
