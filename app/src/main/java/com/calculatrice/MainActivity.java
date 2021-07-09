package com.calculatrice;

import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity  {

    EditText screen;
    final List<String> options = new ArrayList<>();
    double a, b, res;
    String Op = "+";


    public void numero(View view) {
        String num = view.getTag().toString();
        String txtscreen = screen.getText().toString();
        if(txtscreen.equals("NaN") || txtscreen.equals("0")   )
            txtscreen="";
        txtscreen += num;
        screen.setText(txtscreen);
    }

    public void operation(View view) {
        Button btn = (Button) view;
        String screenTxt = screen.getText().toString();
        try {
            a = Double.valueOf(screenTxt);
        }
        catch (NumberFormatException e) {
            screen.setText(e.getMessage());
        }
        screen.setText("");
        Op = btn.getText().toString();
    }

//    _________________________Switch des operations_________________________________________
    public void equal(View view) {
        String txtscreen = screen.getText().toString();
        try {
            if(!txtscreen.isEmpty()) {
                b = Double.valueOf(txtscreen);
            }
            else {
                screen.setText(" ");
            }

            Log.i("test", "OP = "+ Op);
            switch (Op)
            {
                case "+" :
                    res = a + b;
                    break;
                case "-" :
                    res = a - b;
                    break;
                case "/" :
                    res = b==0? Double.NaN : a / b;
                    break;
                case "x" :
                    res =  a * b;
                    break;
                case "1/x":
                    res = a==0? Double.NaN :1/a;
                    break;
                case "sin":
                    res = Math.sin(b);
                    break;
                case "cos":
                    res = Math.cos(b);
                    break;
                case "tan":
                    res = Math.tan(b);
                    break;

            }
            screen.setText(Double.toString(res));
        }
        catch (NumberFormatException e) {
            screen.setText(e.getMessage());
        }
    }


    //    _________________________Supprimer le dernier numero saisie_________________________________________
    public void clear(View view)
    {
        screen.setText(screen.getText().subSequence(0, screen.getText().length() - 1));
    }

//    public void clear(View view)
//    {
//        screen.setText("");
//    }
}