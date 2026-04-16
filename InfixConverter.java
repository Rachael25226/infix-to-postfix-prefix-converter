import java.util.Scanner;
import java.util.Stack;

public class InfixConverter {

    // Returns operator precedence
    static int precedence(char op) {
        if (op == '+' || op == '-') return 1;
        if (op == '*' || op == '/') return 2;
        if (op == '^') return 3;
        return 0;
    }

    // Infix to Postfix
    static String toPostfix(String expr) {
        Stack<Character> stack = new Stack<>();
        StringBuilder output = new StringBuilder();

        for (char ch : expr.toCharArray()) {
            if (Character.isLetterOrDigit(ch)) {
                output.append(ch);
            } 
            else if (ch == '(') {
                stack.push(ch);
            } 
            else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(')
                    output.append(stack.pop());
                if (!stack.isEmpty()) stack.pop();
            } 
            else { // operator
                while (!stack.isEmpty() &&
                       precedence(stack.peek()) >= precedence(ch))
                    output.append(stack.pop());
                stack.push(ch);
            }
        }

        while (!stack.isEmpty())
            output.append(stack.pop());

        return output.toString();
    }

    // Infix to Prefix
    static String toPrefix(String expr) {
        StringBuilder reversed = new StringBuilder();

        for (int i = expr.length() - 1; i >= 0; i--) {
            char ch = expr.charAt(i);
            if (ch == '(') reversed.append(')');
            else if (ch == ')') reversed.append('(');
            else reversed.append(ch);
        }

        String postfix = toPostfix(reversed.toString());
        return new StringBuilder(postfix).reverse().toString();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=== Infix Converter ===");
        System.out.print("Enter infix expression: ");
        String expr = sc.nextLine();

        System.out.println("\nChoose conversion:");
        System.out.println("1. Postfix");
        System.out.println("2. Prefix");
        System.out.println("3. Both");
        System.out.print("Enter choice: ");

        int choice = sc.nextInt();

        System.out.println("\nInfix: " + expr);

        switch (choice) {
            case 1:
                System.out.println("Postfix: " + toPostfix(expr));
                break;
            case 2:
                System.out.println("Prefix: " + toPrefix(expr));
                break;
            case 3:
                System.out.println("Postfix: " + toPostfix(expr));
                System.out.println("Prefix: " + toPrefix(expr));
                break;
            default:
                System.out.println("Invalid choice!");
        }

        sc.close();
    }
}