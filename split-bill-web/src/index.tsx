import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import { Provider } from 'react-redux';
import {
  applyMiddleware,
  combineReducers,
  legacy_createStore as createStore
} from 'redux';
import { thunk } from 'redux-thunk';
import { reducers } from './reducer';

const root = ReactDOM.createRoot(
  document.getElementById('root') as HTMLElement
);

// 各種reducer, stateを用意
const rootReducer = combineReducers(reducers);
export type RootState = ReturnType<typeof rootReducer>;
export const store = createStore(rootReducer, applyMiddleware(thunk));

root.render(
  <Provider store={store}>
    <App />
  </Provider>
);
