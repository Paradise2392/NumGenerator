package com.paradise.numgenerator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button generate;
    private TextView result;
    private EditText range;
    private EditText quantity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        generate = (Button) findViewById(R.id.btn_generate);
        result = (TextView) findViewById(R.id.tv_result);
        range = (EditText) findViewById(R.id.et_range);
        quantity = (EditText) findViewById(R.id.et_quantity);

        generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getGenerated();

            }
        });
    }

    public void getGenerated(){
        Random random = new Random();
        List <Integer> numList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        int rangeInt = Integer.parseInt(range.getText().toString());
        int quantityInt = Integer.parseInt(quantity.getText().toString());

        boolean equaly = false;

        for(int i = 0; i < quantityInt; i++){
            int num = random.nextInt(rangeInt);
            if(num != 0){
                if(numList.size() == 0){
                    numList.add(num);
                }else{
                    for(int j = 0; j < numList.size(); j++){
                        if(num != numList.get(j)){
                            equaly = false;
                        }else{
                            equaly = true;
                        }
                    }
                    if(!equaly){
                        numList.add(num);
                    }
                }
            }else{
                quantityInt++;
            }
        }
        for(int temp : numList){
            String str = String.valueOf(temp);
            sb.append(str);
            sb.append(", ");
        }

        result.setText(sb.toString());
    }

}
