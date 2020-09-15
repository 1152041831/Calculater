package com.example.c2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Base_conversion extends AppCompatActivity {

    private static int flag = 2; //默认二进制
    private static int re = 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_conversion);

        //加载下拉列表1
        Spinner spinner1 = (Spinner)findViewById(R.id.spSystem);
        final ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,R.array.jinzhi,android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);

        //加载下拉列表2
        Spinner spinner2 = (Spinner)findViewById(R.id.spSystem1);
        final ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,R.array.jinzhi,android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);

        //加载计算器控件
        final TextView txt = findViewById(R.id.edit1);
        final TextView result = findViewById(R.id.edit2);
        GridLayout gridLayout = findViewById(R.id.gridLayout);
        for(int i=0;i<gridLayout.getChildCount();i++){
            final Button bt = (Button)gridLayout.getChildAt(i);  //获取Button
            bt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    selectButtonEvent(bt,txt,result);
                }
            });
        }

        //获取按钮
        final Button zero = (Button)findViewById(R.id.bt_0);
        final Button one = (Button)findViewById(R.id.bt_1);
        final Button two = (Button)findViewById(R.id.bt_2);
        final Button three = (Button)findViewById(R.id.bt_3);
        final Button four = (Button)findViewById(R.id.bt_4);
        final Button five = (Button)findViewById(R.id.bt_5);
        final Button six = (Button)findViewById(R.id.bt_6);
        final Button seven = (Button)findViewById(R.id.bt_7);
        final Button eight = (Button)findViewById(R.id.bt_8);
        final Button nine = (Button)findViewById(R.id.bt_9);
        final Button a = (Button)findViewById(R.id.A);
        final Button b = (Button)findViewById(R.id.B);
        final Button c = (Button)findViewById(R.id.C);
        final Button d = (Button)findViewById(R.id.D);
        final Button e = (Button)findViewById(R.id.E);
        final Button f = (Button)findViewById(R.id.F);


        //下拉列表选择事件监听
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==0) {
                    flag = 2;
                }
                else if(i==1) {
                    flag = 8;
                }
                else if(i==2) {
                    flag = 10;
                }
                else
                    flag = 16;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==0)
                    re = 2;
                else if(i==1)
                    re = 8;
                else if(i==2)
                    re = 10;
                else
                    re = 16;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    private void selectButtonEvent(Button bt,TextView txt,TextView result){
        switch (bt.getText().toString()){
            case "CE":
                txt.setText(null);
                result.setText(null);
                break;
            case "←":
                if(txt.getText().toString().length()!=0)
                    txt.setText(txt.getText().toString().substring(0,txt.getText().toString().length()-1));
                try{
                    conversion(txt.getText().toString(),result);
                }catch (Exception e){
                    break;
                }
                break;
            default:
                txt.setText(txt.getText()+bt.getText().toString());
                try{
                    conversion(txt.getText().toString(),result);
                }catch (Exception e){
                    break;
                }
        }
    }

    protected static void conversion(String front,TextView result){
        if(re == 2){
            switch (flag){

                case 2:result.setText(front);break;
                case 8:result.setText(a8to2(front));break;
                case 10:result.setText(a10to2(front));break;
                case 16:result.setText(a16to2(front));break;
            }
        } else if(re == 8){
            switch(flag){
                case 2:result.setText(a2to8(front));break;
                case 8:result.setText(front);break;
                case 10:result.setText(a10to8(front));break;
                case 16:result.setText(a16to8(front));break;
            }

        }
        else if(re == 10){
            switch(flag){
                case 2:result.setText(a2to10(front));break;
                case 8:result.setText(a8to10(front));break;
                case 10:result.setText(front);break;
                case 16:result.setText(a16to10(front));break;
            }
        }
        else if(re == 16){
            switch(flag){
                case 2:result.setText(a2to16(front));break;
                case 8:result.setText(a8to16(front));break;
                case 10:result.setText(a10to16(front));break;
                case 16:result.setText(front);break;

            }
        }
    }


    //进制转换
    public static String a2to8(String a){
        return Integer.toOctalString(Integer.parseInt(a, 2))+"";
    }
    public static String a2to10(String a){
        return Integer.parseInt(a, 2) +"";
    }
    public static String a2to16(String a){
        return Integer.toHexString(Integer.parseInt(a, 2))+"";
    }
    public static String a8to2(String a){
        return Integer.toBinaryString(Integer.parseInt(a, 8));
    }
    public static String a8to10(String a){
        return Integer.toString(Integer.parseInt(a, 8));
    }
    public static String a8to16(String a){
        return Integer.toHexString(Integer.parseInt(a, 8));
    }
    public static String a10to2(String a){
        return Integer.toBinaryString(Integer.parseInt(a));
    }
    public static String a10to8(String a){
        return Integer.toOctalString(Integer.parseInt(a));
    }
    public static String a10to16(String a){
        return Integer.toHexString(Integer.parseInt(a));
    }
    public static String a16to2(String a){
        return Integer.toBinaryString(Integer.parseInt(a,16));
    }
    public static String a16to8(String a){
        return Integer.toOctalString(Integer.parseInt(a,16));
    }
    public static String a16to10(String a){ return Integer.toString(Integer.parseInt(a,16))+"";
    }
}