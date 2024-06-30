package nob.example.split_bill_app.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import nob.example.split_bill_app.constant.UrlConstant;
import nob.example.split_bill_app.controller.reqres.CalcSplitPriceRequest;
import nob.example.split_bill_app.controller.reqres.CalcSplitPriceResponse;

/**
 * 価格計算に関するコントローラインターフェースです。
 * 
 * @author nob
 */
@RestController
@RequestMapping(value = UrlConstant.API_BASE + UrlConstant.PRICE_CALCULATION)
@Tag(name = "Price calculation", description = "価格計算に関するAPIです。")
public interface PriceCalculationController {

    /**
     * 割り勘価格を計算します。
     * 
     * @param calcSplitPriceRequest 各メンバーの入力情報
     * @return 各メンバーの割り勘価格
     */
    @PostMapping(value = "/calc")
    @Operation(summary = "割り勘価格の計算", description = "${sampleapidoc.describe.price-calculation.calc:説明文}")
    CalcSplitPriceResponse calcSplitPrice(@RequestBody CalcSplitPriceRequest calcSplitPriceRequest);
}
