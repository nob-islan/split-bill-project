import { store } from '../..';
import { callCalc } from '../../action/PriceCalcAction';

interface Props {}

/**
 * 割り勘価格計算のための情報を入力する画面です。
 *
 * @returns
 */
const Input: React.FC<Props> = () => {
  /**
   * 計算ボタン押下時処理
   */
  const handleOnClickCalcButton = () => {
    // 割り勘価格計算API呼び出し
    store.dispatch(callCalc());
  };

  return (
    <div>
      <button onClick={handleOnClickCalcButton}>計算</button>
    </div>
  );
};

export default Input;
