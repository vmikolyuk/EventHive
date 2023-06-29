import {createAsyncThunk} from '@reduxjs/toolkit';

const initializeApp = createAsyncThunk<{}, {}, {rejectValue: {error: string}}>(
  'app/initializeApp',
  // eslint-disable-next-line no-empty-pattern
  async ({}, thunkApi) => {
    try {
      // TODO body
    } catch (e) {
      const error = e as Error;
      return thunkApi.rejectWithValue({error: error.message});
    }
  }
);

export {
  initializeApp
};
