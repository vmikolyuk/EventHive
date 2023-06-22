import {createSlice} from '@reduxjs/toolkit';
import {initialAppState} from 'init/app';

export const appSlice = createSlice({
  name: 'app',
  initialState: initialAppState,
  reducers: {
  },
  extraReducers: (builder) => {
    // TODO something
  }
});

export default appSlice.reducer;

export const actions = {...appSlice.actions};
