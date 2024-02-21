package com.example.fifthlessonsolvingmathematicalequations;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    // поля

    private TextView equationOne, equationTwo, equationThree; // поля вывода примеров
    private EditText solvingOne, solvingTwo, solvingThree; //  поля ввода ответов
    private int[] equationValue; // массив шести чисел (для трёх примеров)
    private boolean right = false; // флаг правильности решения примеров
    private Button button; // кнопка генерации следующих примеров

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // привязка к полям
        equationOne = findViewById(R.id.equationOne);
        equationTwo = findViewById(R.id.equationTwo);
        equationThree = findViewById(R.id.equationThree);
        solvingOne = findViewById(R.id.solvingOne);
        solvingTwo = findViewById(R.id.solvingTwo);
        solvingThree = findViewById(R.id.solvingThree);

        button = findViewById(R.id.button);

        // формирование массива случайных чисел
        equationValue = valueArrayRandom();

        // заполнение строк примерами для решения
        equationOne.setText(equationValue[0] + " + " + equationValue[1] + " = ");
        equationTwo.setText(equationValue[2] + " + " + equationValue[3] + " = ");
        equationThree.setText(equationValue[4] + " + " + equationValue[5] + " = ");

        // обработву фокусировку/снятия фокусироыки с EditText
        solvingOne.setOnFocusChangeListener(focusListener);
        solvingTwo.setOnFocusChangeListener(focusListener);
        solvingThree.setOnFocusChangeListener(focusListener);

        button.setOnClickListener(listener);
    }

    // создание слушателя для кнопки
    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(right) {
                equationValue = valueArrayRandom(); // формирование нового массива случайных чисел
                // заполнение строк примерами для решения
                equationOne.setText(equationValue[0] + " + " + equationValue[1] + " = ");
                equationTwo.setText(equationValue[2] + " + " + equationValue[3] + " = ");
                equationThree.setText(equationValue[4] + " + " + equationValue[5] + " = ");
                // задание исходного цвета
                solvingOne.setBackgroundColor(Color.rgb( 0xE7, 0xE4, 0xEC)); // закрашиваем в исходный цвет
                solvingTwo.setBackgroundColor(Color.rgb( 0xE7, 0xE4, 0xEC)); // закрашиваем в исходный цвет
                solvingThree.setBackgroundColor(Color.rgb( 0xE7, 0xE4, 0xEC)); // закрашиваем в исходный цвет
                // задание пустых EditText
                solvingOne.setText("");
                solvingTwo.setText("");
                solvingThree.setText("");
            }
        }
    };

    // создания слушателя фокусировку/снятие фокусировки с EditText
    private View.OnFocusChangeListener focusListener = new View.OnFocusChangeListener() {
        @Override
        public void onFocusChange(View view, boolean b) {
            // с помощью view.getId() определение с каким виджетом происхлдя действия
            switch (view.getId()) {
                case R.id.solvingOne:
                    if(!b) { // при потери фокуса производим приверку введённого числа
                        // если почитано верно
                        if(Integer.parseInt(solvingOne.getText().toString()) == (equationValue[0] + equationValue[1])) {
                            solvingOne.setBackgroundColor(Color.GREEN); // закашиваем в зелёный цвет
                            right =  true;
                        } else { // иначе
                            solvingOne.setBackgroundColor(Color.RED); // закрашиваем в красный цвет
                            right = false;
                        }
                    }
                    break;
                case R.id.solvingTwo:
                    if(!b) { // при потери фокуса производим приверку введённого числа
                        // если почитано верно
                        if(Integer.parseInt(solvingTwo.getText().toString()) == (equationValue[0] + equationValue[1])) {
                            solvingTwo.setBackgroundColor(Color.GREEN); // закашиваем в зелёный цвет
                            right =  true;
                        } else { // иначе
                            solvingTwo.setBackgroundColor(Color.RED); // закрашиваем в красный цвет
                            right = false;
                        }
                    }
                    break;
                case R.id.solvingThree:
                    if(!b) { // при потери фокуса производим приверку введённого числа
                        // если почитано верно
                        if(Integer.parseInt(solvingThree.getText().toString()) == (equationValue[0] + equationValue[1])) {
                            solvingThree.setBackgroundColor(Color.GREEN); // закашиваем в зелёный цвет
                            right =  true;
                        } else { // иначе
                            solvingThree.setBackgroundColor(Color.RED); // закрашиваем в красный цвет
                            right = false;
                        }
                    }
                    break;
            }
        }
    };

    // метод генерации масива 6 случайных чисел ( для трёх примеров )
    private int[] valueArrayRandom() {
        Random random = new Random(); // создание обьекта класса Random
        int[] arrayValue = new int[6]; // создание массива для заполнения
        for (int i = 0; i < arrayValue.length; i++) { // цикл заполнения массива случайными числами
            arrayValue[i] = random.nextInt(99) + 1;
        }
        return arrayValue;
    }
}