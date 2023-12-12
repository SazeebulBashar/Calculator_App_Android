package edu.ewubd.calculator;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

class EvaluateString
{
    public static double evaluate(String expression)
    {
        char[] tokens = expression.toCharArray();
        Stack<Double> values = new Stack<>();
        Stack<Character> ops = new Stack<Character>();

        for (int i = 0; i < tokens.length; i++)
        {
            if (tokens[i] == ' ')
                continue;

            if (tokens[i] >= '0' && tokens[i] <= '9')
            {
                StringBuffer sbuf = new
                        StringBuffer();

                while (i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9')
                    sbuf.append(tokens[i++]);

                values.push((double) Integer.parseInt(sbuf.toString()));
                i--;
            }


            else if (tokens[i] == '(')
                ops.push(tokens[i]);

                // Closing brace encountered,
                // solve entire brace
            else if (tokens[i] == ')')
            {
                while (ops.peek() != '(') {
                    values.push(applyOp(ops.pop(), values.pop(), values.pop()));
                }
                ops.pop();
            }

            // Current token is an operator.
            else if (tokens[i] == '+' || tokens[i] == '-' || tokens[i] == 'x' || tokens[i] == '/')
            {

                while (!ops.empty() && hasPrecedence(tokens[i], ops.peek()))
                    values.push(applyOp(ops.pop(), values.pop(), values.pop()));

                ops.push(tokens[i]);
            }
        }


        while (!ops.empty())
            values.push(applyOp(ops.pop(), values.pop(), values.pop()));

        return values.pop();
    }

    public static boolean hasPrecedence(
            char op1, char op2)
    {
        if (op2 == '(' || op2 == ')')
            return false;
        if ((op1 == 'x' || op1 == '/') &&
                (op2 == '+' || op2 == '-'))
            return false;
        else
            return true;
    }

    public static double applyOp(char op, Double b, Double a)
    {
        switch (op)
        {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case 'x':
                return a * b;
            case '/':
                if (b == 0)
                    throw new
                            UnsupportedOperationException("Cannot divide by zero");
                return a / b;
        }
        return 0;
    }

}








public class MainActivity extends AppCompatActivity {


    TextView tvEquation;
    private Button btnDel,btn0,btnEqual, btn9,btn8,btn7,btn6,btn5,btn4,btn3,btn2,btn1,
            btnDot,btnAdd, btnMul,btnSub, btnDiv, btnPrev, btnNext,clear;
    Double num1, num2;
    String op;
    String str="";
    int equ;

    String vals ;

    Stack<String> prevResult = new Stack<>();
    Stack<String> nextResult = new Stack<>();

    ArrayList<String> al = new ArrayList<>();
    boolean isPrevClicked = false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tvEquation =  findViewById(R.id.tvEquation);
        btnDel =findViewById(R.id.btnDel);
        btnAdd = findViewById(R.id.btnAdd);
        btnSub = findViewById(R.id.btnSub);
        btnMul = findViewById(R.id.btnMul);
        btnDiv = findViewById(R.id.btnDiv);
        btnDot = findViewById(R.id.btnDot);
        btnEqual = findViewById(R.id.btnEqual);
        btnNext = findViewById(R.id.btnNext);
        btnPrev = findViewById(R.id.btnPrev);
        clear =  findViewById(R.id.clear);

        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);




        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = tvEquation.getText().toString();
                if (text == null){
                    text = "";
                }
                text = text +9;
                tvEquation.setText(text);
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = tvEquation.getText().toString();
                if (text == null){
                    text = "";
                }
                text = text +8;
                tvEquation.setText(text);
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = tvEquation.getText().toString();
                if (text == null){
                    text = "";
                }
                text = text +7;
                tvEquation.setText(text);
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = tvEquation.getText().toString();
                if (text == null){
                    text = "";
                }
                text = text +6;
                tvEquation.setText(text);
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = tvEquation.getText().toString();
                if (text == null){
                    text = "";
                }
                text = text +5;
                tvEquation.setText(text);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = tvEquation.getText().toString();
                if (text == null){
                    text = "";
                }
                text = text +4;
                tvEquation.setText(text);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = tvEquation.getText().toString();
                if (text == null){
                    text = "";
                }
                text = text +3;
                tvEquation.setText(text);
            }
        });


        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = tvEquation.getText().toString();
                if (text == null){
                    text = "";
                }
                text = text +2;
                tvEquation.setText(text);
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = tvEquation.getText().toString();
                if (text == null){
                    text = "";
                }
                text = text + 1;
                tvEquation.setText(text);
            }
        });

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = tvEquation.getText().toString();
                if (text == null){
                    text = "";
                }
                text = text +0;
                tvEquation.setText(text);
            }
        });

        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = tvEquation.getText().toString();
                if (text == null){
                    text = "";
                }
                text = text +".";
                tvEquation.setText(text);
            }
        });


        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = tvEquation.getText().toString();
                if (text == null){
                    text = "";
                }
                if(text.length()>0){
                    tvEquation.setText(text.substring(0,text.length()-1));
                }
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = tvEquation.getText().toString();
                char last = text.charAt((text.length()-1));
                if(text == null | text.length() <= 0){
                    tvEquation.setText(text +"");
                }
                else if (last == '+' || last == '-' || last ==  'x' || last == '/' ) {
                    tvEquation.setText(text +"");
                }
                else{
                    tvEquation.setText(text + "+");
                }
            }
        });

        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = tvEquation.getText().toString();
                char last = text.charAt((text.length()-1));
                if(text == null | text.length() <= 0){
                    tvEquation.setText(text +"");
                }
                else if (last == '+' || last == '-' || last ==  'x' || last == '/' ) {
                    tvEquation.setText(text +"");
                }
                else{
                    tvEquation.setText(text + "-");
                }
            }
        });

        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = tvEquation.getText().toString();
                char last = text.charAt((text.length()-1));
                if(text == null | text.length() <= 0){
                    tvEquation.setText(text +"");
                }
                else if (last == '+' || last == '-' || last ==  'x' || last == '/' ) {
                    tvEquation.setText(text +"");
                }
                else{
                    tvEquation.setText(text + "x");
                }
            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = tvEquation.getText().toString();
                char last = text.charAt((text.length()-1));
                if(text == null | text.length() <= 0){
                    tvEquation.setText(text +"");
                }
                else if (last == '+' || last == '-' || last ==  'x' || last == '/' ) {
                    tvEquation.setText(text +"");
                }
                else{
                    tvEquation.setText(text + "/");
                }
            }
        });

//        btnEqual.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String text = tvEquation.getText().toString();
//                if (text == null){
//                    text = "";
//                }
//                int p = opPosition(text);
//
//                num1 = Double.parseDouble(text.substring(0,p));
//                num2 = Double.parseDouble(text.substring(p+1,text.length()));
//
//                char sign  = text.charAt(p);
//                Double result;
//                switch (sign){
//                    case '+':
//                        result = num1 + num2;
//                        tvEquation.setText(new DecimalFormat("##.##").format(result) +"");
//                        break;
//                    case '-':
//                        result = num1 - num2;
//                        tvEquation.setText(new DecimalFormat("##.##").format(result) +"");
//                        break;
//                    case 'x':
//                        result = num1 * num2;
//                        tvEquation.setText(new DecimalFormat("##.##").format(result) +"");
//                        break;
//                    case '/':
//                        result = num1 / num2;
//                        tvEquation.setText(new DecimalFormat("##.##").format(result) +"");
//                        break;
//
//
//
//                }
//            }
//        });




        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = tvEquation.getText().toString();
                if (text == null){
                    text = "";
                }

                double result = EvaluateString.evaluate(text);
//                tvEquation.setText(Double.toString(result));

                tvEquation.setText(new DecimalFormat("##.##").format(result));


                str += text +"---";
//                Toast.makeText(getApplicationContext(),str,Toast.LENGTH_LONG).show();


                SharedPreferences sp = getSharedPreferences("savedEquation",MODE_PRIVATE);
                SharedPreferences.Editor editor  = sp.edit();

                editor.putString("key",str);
                editor.apply();


            onResume();

            }
        });

//        SharedPreferences getSp = getSharedPreferences("savedEquation",MODE_PRIVATE);
//        vals = getSp.getString("key","");
//        String[] equations = vals.split("---");
//        al = new ArrayList<String>(Arrays.asList(equations));
//        equ = al.size()-1;




        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(getApplicationContext(),equ+" ",Toast.LENGTH_LONG).show();



                if(equ>=0) {
                    tvEquation.setText(al.get(equ));
                    equ--;
                    if(equ<0)
                        equ =0;
                    isPrevClicked = true;
                }

            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(equ>=0 && equ <= al.size()-1) {

//                    Toast.makeText(getApplicationContext(),equ+" ",Toast.LENGTH_LONG).show();
                    tvEquation.setText(al.get(equ));
                    equ++;
                    if(equ > al.size()-1)
                        equ = al.size()-1;
                }

            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvEquation.setText("");
            }
        });




    }

    static int opPosition(String t) {
        int p = 0;
        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) == '+' || t.charAt(i) == '-' || t.charAt(i) == 'x' || t.charAt(i) == '/') {
                p = i;
                break;
            }
        }
        return p;
    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences getSp = getSharedPreferences("savedEquation",MODE_PRIVATE);
        vals = getSp.getString("key","");
        String[] equations = vals.split("---");
        al = new ArrayList<String>(Arrays.asList(equations));
        equ = al.size()-1;

    }

}

