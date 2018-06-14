package com.appdevelopmentshop.validationPsample;

import android.databinding.Bindable;
import android.databinding.ObservableBoolean;
import android.widget.EditText;

import com.appdevelopmentshop.validationPsample.databinding.LayoutValidationFormBinding;
import com.appdevelopmentshop.validationp.Validator;
import com.appdevelopmentshop.validationp.rules.BaseTextRule;
import com.appdevelopmentshop.validationp.rules.RegexRule;
import com.appdevelopmentshop.validationp.rules.RequiredRule;
import com.appdevelopmentshop.validationp.rules.Rule;
import com.controllers.Controller;

/**
 * Created by Artem Sisetskyi on 6/14/18.
 * AppDevelopmentShop
 * sisetskyi.a@gmail.com
 */
public class ValidationFormController extends Controller<LayoutValidationFormBinding>
        implements Validator.OnValidStateListener {

    @Bindable public transient Validator validator = new Validator(true,this);
    public ObservableBoolean isBtnEnable = new ObservableBoolean(false);

    public Rule[] rules = {new RequiredRule("Обязательное поле"),
            new RegexRule("[0-9]+", "Только цифры"), //пакетный рулл
            new BaseTextRule("Но цифры без 0 и 1") { //можно определить свой кастомный рулл

                @Override
                public boolean isTextValid(String text) {
                    return !(text.contains("0") || text.contains("1"));
                }
            }};

    @Override
    public int getLayoutId() {
        return R.layout.layout_validation_form;
    }

    @Override
    public void onValidChange(boolean newState) {
        isBtnEnable.set(newState);
    }

}
