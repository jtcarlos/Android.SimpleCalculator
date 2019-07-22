package com.example.simplecalculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    //global variables
    String main_equation = "";
    String equation = "";

    String[] mdas = {"%", "*", "÷", "+", "-"};
    int mdas_counter = 0;
    int operator_index = 0;

    boolean clean_flag = true;
    boolean is_equation = true;

    double num1 = 0;
    double num2 = 0;
    double result = 0;
    double temp_num;
    double temp_num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Numeric Buttons
        Button btn0 = (Button)findViewById(R.id.btn0);
        Button btn1 = (Button)findViewById(R.id.btn1);
        Button btn2 = (Button)findViewById(R.id.btn2);
        Button btn3 = (Button)findViewById(R.id.btn3);
        Button btn4 = (Button)findViewById(R.id.btn4);
        Button btn5 = (Button)findViewById(R.id.btn5);
        Button btn6 = (Button)findViewById(R.id.btn6);
        Button btn7 = (Button)findViewById(R.id.btn7);
        Button btn8 = (Button)findViewById(R.id.btn8);
        Button btn9 = (Button)findViewById(R.id.btn9);
        Button dotBtn = (Button)findViewById(R.id.dotBtn);

        //Arithmetic Buttons
        Button addBtn = (Button)findViewById(R.id.addBtn);
        Button minBtn = (Button)findViewById(R.id.minBtn);
        Button mulBtn = (Button)findViewById(R.id.mulBtn);
        Button divBtn = (Button)findViewById(R.id.divBtn);
        Button modBtn = (Button)findViewById(R.id.modBtn);
        Button sqrtBtn = (Button)findViewById(R.id.sqrtBtn);
        Button eqBtn = (Button)findViewById(R.id.eqBtn);

        //Equation Control
        Button clearBtn = (Button)findViewById(R.id.clearBtn);
        Button delBtn = (Button)findViewById(R.id.delBtn);

        //TextViews
        final TextView simpleCalculator = (TextView)findViewById(R.id.simpleCalculator);
        final TextView resultTxtView = (TextView)findViewById(R.id.resultTxtView) ;
        final TextView subTextView = (TextView)findViewById(R.id.subTextView);

        //Numeric Buttons
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                equation += "0";
                main_equation += "0";
                resultTxtView.setText(equation);
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                equation += "1";
                main_equation += "1";
                resultTxtView.setText(equation);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                equation += "2";
                main_equation += "2";
                resultTxtView.setText(equation);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                equation += "3";
                main_equation += "3";
                resultTxtView.setText(equation);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                equation += "4";
                main_equation += "4";
                resultTxtView.setText(equation);
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                equation += "5";
                main_equation += "5";
                resultTxtView.setText(equation);
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                equation += "6";
                main_equation += "6";
                resultTxtView.setText(equation);
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                equation += "7";
                main_equation += "7";
                resultTxtView.setText(equation);
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                equation += "8";
                main_equation += "8";
                resultTxtView.setText(equation);
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                equation += "9";
                main_equation += "9";
                resultTxtView.setText(equation);
            }
        });
        dotBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                equation += ".";
                main_equation += ".";
                resultTxtView.setText(equation);
            }
        });

        //Arithmetic Buttons
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                equation += "+";
                main_equation += " + ";
                resultTxtView.setText(equation);
            }
        });
        minBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                equation += "-";
                main_equation += " - ";
                resultTxtView.setText(equation);
            }
        });
        mulBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                equation += "*";
                main_equation += " * ";
                resultTxtView.setText(equation);
            }
        });
        divBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                equation += "÷";
                main_equation += " ÷ ";
                resultTxtView.setText(equation);
            }
        });
        modBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                equation += "%";
                main_equation += " % ";
                resultTxtView.setText(equation);
            }
        });
        sqrtBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                equation += " √";
                main_equation += " √";
                resultTxtView.setText(equation);
            }
        });

        //Equation Control
        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                equation = "";
                main_equation = "";
                resultTxtView.setText(equation);
                subTextView.setText(main_equation);
            }
        });
        delBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (equation.length() != 0) {
                    equation = equation.substring(0, equation.length() - 1);
                    if (Character.isWhitespace(main_equation.charAt(main_equation.length() - 1))) {
                        main_equation = main_equation.substring(0, main_equation.length() - 2);
                    }
                    else {
                        main_equation = main_equation.substring(0, main_equation.length() - 1);
                    }
                    resultTxtView.setText(equation);
                }
            }
        });
        eqBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //reset counters
                result = 0;
                mdas_counter = 0;

                //clean equation
                clean_flag = true;

                try {
                    while (clean_flag) {
                        main_equation = main_equation.trim();
                        String last_char = main_equation.substring(main_equation.length() - 1);
                        if (last_char.equals("+") || last_char.equals("-") || last_char.equals("*") || last_char.equals("÷") || last_char.equals("%")) {
                            main_equation = main_equation.substring(0, main_equation.length() - 2);
                        } else {
                            clean_flag = false;
                        }
                    }

                    subTextView.setText(main_equation);
                    String[] split_string = main_equation.split("\\s+");

                    //perform arithmetic
                    if (split_string.length == 1) {
                        if (split_string[0].contains("√")) {
                            temp_num = Double.parseDouble(split_string[0].replaceAll("√", ""));
                            temp_num = Math.sqrt(temp_num);
                        }
                        subTextView.setText(String.valueOf(split_string[0]));
                        result = temp_num;
                    } else {
                        while(mdas_counter < 5) {
                            System.out.println(Arrays.toString(split_string));
                            operator_index = Arrays.asList(split_string).indexOf(mdas[mdas_counter]);
                            if (operator_index == -1) {
                                mdas_counter++;
                            }
                            else {
                                //Initialize number
                                if (split_string[operator_index - 1].contains("√")) {
                                    temp_num = Double.parseDouble(split_string[operator_index - 1].replaceAll("√", ""));
                                    num1 = Math.sqrt(temp_num);
                                    num2 = Double.parseDouble(split_string[operator_index + 1]);
                                } else if (split_string[operator_index + 1].contains("√")) {
                                    temp_num2 = Double.parseDouble(split_string[operator_index + 1].replaceAll("√", ""));
                                    num2 = Math.sqrt(temp_num2);
                                    num1 = Double.parseDouble(split_string[operator_index - 1]);
                                } else {
                                    num1 = Double.parseDouble(split_string[operator_index - 1]);
                                    num2 = Double.parseDouble(split_string[operator_index + 1]);
                                }
                                //perform arithmetic
                                switch (mdas[mdas_counter]) {
                                    case "%":
                                        result = num1 % num2;
                                        break;
                                    case "*":
                                        result = num1 * num2;
                                        break;
                                    case "÷":
                                        result = num1 / num2;
                                        break;
                                    case "+":
                                        result = num1 + num2;
                                        break;
                                    case "-":
                                        result = num1 - num2;
                                        break;
                                }
                                //remove the operator
                                split_string[operator_index - 1] = String.valueOf(result);
                                for (int i = operator_index; i < Array.getLength(split_string) - 1; i++) {
                                    split_string[i] = split_string[i + 1];
                                }
                                for (int i = operator_index; i < Array.getLength(split_string) - 1; i++) {
                                    split_string[i] = split_string[i + 1];
                                }
                                split_string[Array.getLength(split_string) - 1] = "X";
                            }
                        }
                    }

                    resultTxtView.setText(String.valueOf(result));
                } catch (Exception e) {
                    subTextView.setText("");
                    resultTxtView.setText("Error");
                }

                //reset equations
                main_equation = "";
                equation = "";
            }
        });

        simpleCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startIntent = new Intent(getApplicationContext(), about_activity.class);
                startActivity(startIntent);
            }
        });
    }
}
