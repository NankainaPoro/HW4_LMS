package vakulenko.hw4_lms;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;
import java.util.Arrays;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultTextView = findViewById(R.id.resultTextView);

        // Дано число пи с большим числом цифр после запятой
        String piString = "3.141592653589793238462643383279502884197169399375105820974944592307816406286208998628034825342117067982148";

        // Преобразование строки числа пи в массив цифр
        int[] piArray = convertStringToArray(piString);

        // Анализ массива
        int countDigit3 = countDigit(piArray, 3);
        int countDigit5 = countDigit(piArray, 5);
        int rarestDigit = findRarestDigit(piArray);
        int[] reversedArray = reverseArray(piArray);

        // Формирование результата
        StringBuilder result = new StringBuilder();
        result.append("Количество цифр 3: ").append(countDigit3).append("\n");
        result.append("Количество цифр 5: ").append(countDigit5).append("\n");
        result.append("Самая редкая цифра: ").append(rarestDigit).append("\n");
        result.append("Массив в обратном порядке: ").append(Arrays.toString(reversedArray));

        // Вывод результатов на экран
        resultTextView.setText(result.toString());
    }

    private int[] convertStringToArray(String piString) {
        // Удаление точки и преобразование строки в массив цифр
        String digits = piString.replace(".", "");
        int[] piArray = new int[digits.length()];
        for (int i = 0; i < digits.length(); i++) {
            piArray[i] = Character.getNumericValue(digits.charAt(i));
        }
        return piArray;
    }

    private int countDigit(int[] array, int digit) {
        // Подсчет количества заданной цифры в массиве
        int count = 0;
        for (int value : array) {
            if (value == digit) {
                count++;
            }
        }
        return count;
    }

    private int findRarestDigit(int[] array) {
        // Поиск самой редкой цифры в массиве
        int[] countArray = new int[10];
        for (int value : array) {
            countArray[value]++;
        }

        int rarestDigit = -1;
        int minCount = Integer.MAX_VALUE;
        for (int i = 0; i < countArray.length; i++) {
            if (countArray[i] < minCount && countArray[i] > 0) {
                minCount = countArray[i];
                rarestDigit = i;
            }
        }

        return rarestDigit;
    }

    private int[] reverseArray(int[] array) {
        // Сортировка массива в обратном порядке
        int[] reversedArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            reversedArray[i] = array[array.length - 1 - i];
        }
        return reversedArray;
    }
}