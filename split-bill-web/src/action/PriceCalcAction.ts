import axios from 'axios';
import { Dispatch } from 'redux';

export const PriceCalcActionType = {};

export const callCalc = () => {
  return async (dispatch: Dispatch) => {
    const res = await axios.post(
      `http://localhost:8080/api/v1/price-calculation/calc`,
      {
        memberInputInfoDtoList: [
          {
            memberName: 'nob',
            memberRole: '部長'
          },
          {
            memberName: 'nob2',
            memberRole: '課長代行'
          }
        ],
        totalPrice: 13000
      } // TODO リクエスト
    );
    console.log(res);
  };
};
