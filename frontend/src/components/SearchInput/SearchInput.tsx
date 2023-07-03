import {Box, Input, InputGroup, InputLeftElement, InputRightElement, List, ListItem} from '@chakra-ui/react';
import React, {useState} from 'react';
import {FiSearch} from 'react-icons/fi';
import {TfiLocationPin} from 'react-icons/tfi';

const SearchInput = () => {
  const [searchTerm, setSearchTerm] = useState('');
  const [showDropDown, setShowDropDown] = useState(false);

  const handleInputChange = (event: any) => {
    setSearchTerm(event.target.value);
    setShowDropDown(true);
  };

  const handleInputBlur = () => {
    setShowDropDown(false);
  };

  const searchResults = [
    'Результат 1',
    'Результат 2',
    'Результат 3'
  ];

  return (
    <Box position="relative">
      <InputGroup>
        <InputLeftElement pointerEvents="none">
          <TfiLocationPin color="gray.300" />
        </InputLeftElement>
        <Input
          placeholder="Поиск"
          type="text"
          value={searchTerm}
          onBlur={handleInputBlur}
          onChange={handleInputChange}
        />
        <InputRightElement pointerEvents="none">
          <FiSearch color="gray.300" />
        </InputRightElement>
      </InputGroup>
      {showDropDown && (
        <List
          bg="white"
          boxShadow="md"
          left={0}
          mt={2}
          position="absolute"
          right={0}
          top="100%"
          zIndex={2}
        >
          {searchResults.map((result) => (
            <ListItem
              key={result}
              p={2}
            >
              {result}
            </ListItem>
          ))}
        </List>
      )}
    </Box>
  );
};

export default SearchInput;
