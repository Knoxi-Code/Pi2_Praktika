/**
 * Praktikums Aufgaben
 * @Author - Tim Heinsberg (Matrikel Nummer: 11154817)
 *         - Kevin Becker  (Matrikel Nummer: 11158331)
 */
public class Stack {
    protected int[] stack;
    protected int top;

    public Stack(int stackSize) {
        stack = new int[stackSize];
        top = -1;
    }

    /**
     * Pushs the value p on the Top of the Stack
     *
     * @param p
     * @return 0 when push was successful -1 when failed
     */
    public int push(int p) {
        if (top + 1 >= stack.length) {//the is no left space in the Array
            return -1;
        } else {
            top++;
            stack[top] = p;
            return 0;
        }
    }

    /**
     * removes the top Value of stack
     *
     * @return removed value or -1 if there is no value in the stack
     */
    public int pop() {
        if (top >= 0) {
            top--;
            return stack[top + 1];
        } else {
            return -1;
        }
    }

    /**
     * Prints the stack from the value in the top to the last
     */
    public void print() {
        for (int i = top; i >= 0; i--) {
            System.out.println(stack[i]);
        }
    }
}
