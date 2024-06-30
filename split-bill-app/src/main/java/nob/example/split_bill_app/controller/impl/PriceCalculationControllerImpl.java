package nob.example.split_bill_app.controller.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import nob.example.split_bill_app.controller.PriceCalculationController;
import nob.example.split_bill_app.controller.reqres.CalcSplitPriceRequest;
import nob.example.split_bill_app.controller.reqres.CalcSplitPriceResponse;
import nob.example.split_bill_app.service.PriceCalculationService;
import nob.example.split_bill_app.service.inout.CalcSplitPriceInModel;
import nob.example.split_bill_app.service.inout.CalcSplitPriceOutModel;

/**
 * 価格計算に関するコントローラ実装クラスです。
 * 
 * @author nob
 */
@RestController
public class PriceCalculationControllerImpl implements PriceCalculationController {

    @Autowired
    private PriceCalculationService priceCalculationService;

    @Override
    public CalcSplitPriceResponse calcSplitPrice(CalcSplitPriceRequest calcSplitPriceRequest) {

        // サービス呼び出しinModel作成
        CalcSplitPriceInModel calcSplitPriceInModel = new CalcSplitPriceInModel();
        BeanUtils.copyProperties(calcSplitPriceRequest, calcSplitPriceInModel);

        // サービス呼び出し
        CalcSplitPriceOutModel calcSplitPriceOutModel = priceCalculationService.calcSplitPrice(calcSplitPriceInModel);

        // 返却値の作成
        CalcSplitPriceResponse calcSplitPriceResponse = new CalcSplitPriceResponse();
        BeanUtils.copyProperties(calcSplitPriceOutModel, calcSplitPriceResponse);

        return calcSplitPriceResponse;
    }
}
