import {createSlice} from '@reduxjs/toolkit';
import {initialAppState} from 'init/app';

export const appSlice = createSlice({
  extraReducers: (builder) => {
    // TODO something
  },
  initialState: initialAppState,
  name: 'app',
  reducers: {
  }
});

export default appSlice.reducer;

export const actions = {...appSlice.actions};
