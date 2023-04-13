import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
/**
 * Praktikums Aufgaben
 * @Author - Tim Heinsberg (Matrikel Nummer: 11154817)
 *         - Kevin Becker  (Matrikel Nummer: 11158331)
 */
public class Main {
    public static void main(String[] args) {
        ChildStack stack = new ChildStack(6, 10);
        int selected;
        loop:
        while (true) {
            selected = readValue("Wählen Sie eine Der Möglichkeiten:\n1) Push\n2) Push Array\n3) Pop\n4) Print\n5) Stack leer\n6) Beenden", 1, 6);
            switch (selected) {
                case 1:
                    System.out.println(stack.push(readValue("geben Sie den zu Pushenden Wert ein: ")));
                    break;
                case 2:
                    System.out.println(stack.push(readArray())) ;
                    break;
                case 3:
                    System.out.println(stack.pop());
                    break;
                case 4:
                    stack.print();
                    break;
                case 5:
                    System.out.println(stack.stackEmpty());
                    break ;
                case 6:
                    break loop;
            }
        }
    }

    private static int[] readArray() {
        int[] outPut = new int[readValue("Wie groß soll das Array sein?", 0, Integer.MAX_VALUE)];
        for (int i = 1; i <= outPut.length; i++) {
            outPut[i - 1] = readValue("geben Sie den " + i + ". Wert des arrays ein");
            System.out.println();
        }
        return outPut;
    }

    /**
     * reads a Value from the console
     *
     * @return
     */
    private static int readValue(String text) {
        int output = 0;

        try {
            System.out.println(text);

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(System.in)
            );
            String input = in.readLine();
            output = Integer.valueOf(input);
        } catch (IOException e) {
        } catch (NumberFormatException e) {
            System.out.println("Da ist wohl etwas schiefgelaufen\nprobieren Sie es erneut");
            System.out.println();
            output = readValue(text);
        }
        return output;
    }

    private static int readValue(String text, int min, int max) {
        int value = readValue(text);
        if (value >= min && value <= max) {
            return value;
        } else {
            System.err.println("geben Sie einen Wert zwischen " + min + " und " + max + " ein");
            return readValue(text, min, max);
        }
    }
}
