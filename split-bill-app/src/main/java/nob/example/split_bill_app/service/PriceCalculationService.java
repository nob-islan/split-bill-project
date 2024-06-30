package nob.example.split_bill_app.service;

import org.springframework.stereotype.Service;

import nob.example.split_bill_app.service.inout.CalcSplitPriceInModel;
import nob.example.split_bill_app.service.inout.CalcSplitPriceOutModel;

/**
 * 価格計算に関するサービスインターフェースです。
 * 
 * @author nob
 */
@Service
public interface PriceCalculationService {

    /**
     * 割り勘価格を計算します。
     * 
     * @param calcSplitPriceInModel 各メンバーの入力情報
     * @return 各メンバーの割り勘価格
     */
    CalcSplitPriceOutModel calcSplitPrice(CalcSplitPriceInModel calcSplitPriceInModel);
}
