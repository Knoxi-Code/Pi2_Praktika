import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Stack stack = new Stack(readValue("geben Sie die größe des Arrays an"));
        int selected;
        loop:
        while(true){
            selected = readValue("Wählen Sie eine Der Möglichkeiten:\n1) Push\n2) Pop\n3) Print\n4) Beenden",1,4);
            switch (selected){
                case 1:
                    System.out.println(stack.push(readValue("geben Sie den zu Pushenden Wert ein: ")));
                    break;
                case 2:
                    System.out.println(stack.pop());
                    break;
                case 3:
                    stack.print();
                    break;
                case 4:
                    break loop;
            }
        }
    }

    /**
     * reads a Value from the console
     * @return
     */
    private static int readValue(String text){
        int output = 0;

        try {
            System.out.println(text);

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(System.in)
            );
            String input = in.readLine();
            output = Integer.valueOf(input);
        }
        catch(IOException e) {
        }
        catch(NumberFormatException e) {
            System.out.println("Da ist wohl etwas schiefgelaufen\nprobieren Sie es erneut");
            System.out.println();
            output = readValue(text);
        }
        return output;
    }
    private static int readValue(String text, int min, int max){
        int value = readValue(text);
        if(value >= min && value <= max){
            return value;
        }else{
            System.err.println("geben Sie einen Wert zwischen " +min+" und "+ max+" ein");
            return readValue(text,min,max);
        }
    }
}