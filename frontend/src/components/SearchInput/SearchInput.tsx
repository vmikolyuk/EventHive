import {Box, Input, InputGroup, InputRightElement, List, ListItem} from '@chakra-ui/react';
import React, {useState} from 'react';
import {FiSearch} from 'react-icons/fi';

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
        <InputRightElement pointerEvents="none">
          <FiSearch color="gray.300" />
        </InputRightElement>
        <Input
          placeholder="Поиск"
          type="text"
          value={searchTerm}
          onBlur={handleInputBlur}
          onChange={handleInputChange}
        />
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
        >
          {searchResults.map((result) => (
            <ListItem
              key={result}
              p={2}>
              {result}
            </ListItem>
          ))}
        </List>
      )}
    </Box>
  );
};

export default SearchInput;
