package com.appdevelopmentshop.validationPsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.controllers.ControllerActivity;

public class MainActivity extends ControllerActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setControllerContainer(R.id.container);
        show(new ValidationFormController());
    }
}
