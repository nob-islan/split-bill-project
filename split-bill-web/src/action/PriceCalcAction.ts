import axios from 'axios';
import { Dispatch } from 'redux';

export const PriceCalcActionType = {};

export const callCalc = () => {
  return async (dispatch: Dispatch) => {
    const res = await axios.post(
      `http://localhost:8080/api/v1/price-calculation/calc`,
      {} // TODO リクエスト
    );
    console.log(res);
  };
};
