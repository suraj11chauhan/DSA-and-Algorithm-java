package com.test.practices.stack;

import java.util.Stack;

public class StackTest {
    public static void main(String[] args) {

        String exp = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println("Infix Expression: " + exp);
        System.out.println("Postfix Expression: " + infixToPostfix(exp));
        //System.out.println("Postfix Expression: " + infixToPostfix1(exp));
        System.out.println("Prefix Expression: " + infixToPrefix1(exp));
        System.out.println("Prefix to Infix Expression: " + prefixToInfix(infixToPrefix1(exp)));
        System.out.println("Postfix to infix Expression: " + postfixToInfix(infixToPostfix1(exp)));
        System.out.println("Infix to postfix Expression: " + infixToPostfix(postfixToInfix(infixToPostfix1(exp))));

    }

    private static String reverse(String exp) {
        StringBuilder reversed = new StringBuilder();
        for (int i = exp.length() - 1; i >= 0; i--) {
            char c = exp.charAt(i);
            if (c == '(') {
                reversed.append(')');
            } else if (c == ')') {
                reversed.append('(');
            } else {
                reversed.append(c);
            }
        }
        return reversed.toString();
    }
    /*
    * ihg*f+edc^-^b*-a+
    * >> i,h,fg*
    * >> +,
    * */


    public static String prefixToInfix(String exp){
        ///MyStack stack = new MyStack();
        String rev = reverse(exp);
        Stack<String> stack = new Stack();
        for (int i =0;i<rev.length();i++){
            char c = rev.charAt(i);
            if(Character.isLetterOrDigit(c)){
                stack.push(c+"");
            }else {
                String res = "";
                String op1 = "",op2="";
                int count = 0;
                while (!stack.isEmpty() && count<2) {
                    if (count == 1)
                        op2=stack.pop()+"";
                    else
                        op1=stack.pop()+"";
                    count++;
                }
                res=res+"("+op2+c+op1+")";

                stack.push(res);
            }
        }
        return reverse(stack.pop());
    }
    public static String postfixToInfix(String exp){
        ///MyStack stack = new MyStack();
        Stack<String> stack = new Stack();
        for (int i =0;i<exp.length();i++){
            char c = exp.charAt(i);
            if(Character.isLetterOrDigit(c)){
                stack.push(c+"");
            }else {
                String res = "";
                String op1 = "",op2="";
                int count = 0;
                while (!stack.isEmpty() && count<2) {
                    if (count == 1)
                       op2=stack.pop()+"";
                    else
                        op1=stack.pop()+"";
                    count++;
                }
                res=res+"("+op2+c+op1+")";

                stack.push(res);
            }
        }
        return stack.pop();
    }

    // Function to convert infix to prefix
    public static String infixToPrefix(String exp) {
        // Step 1: Reverse the infix expression
        String reversedInfix = reverse(exp);

        // Step 2: Get postfix of reversed infix
        String reversedPostfix = infixToPostfix(reversedInfix);

        // Step 3: Reverse the postfix to get prefix
        return reverse(reversedPostfix);
    }

    /*
    * >> a+b*(c^d-e)^(f+g*h)-i
    * >> reverse         >> i - (h * g + f) ^ (e - d ^ c) * b + a
    * >> result  >> ihg*f+edc^-^b*a+- ==> -+a*b^-^cde+f*ghi
    * >> operators stack >> [-,+,]
    *
    *
    * */

    public static String infixToPrefix1(String exp){
        String reverse = reverse(exp);
        String res = "";
        MyStack<Character> stack = new MyStack<>();
        for (int i =0;i<reverse.length();i++){
            char c = reverse.charAt(i);
            if(Character.isLetterOrDigit(c)){
                res=res+c;
            }else if (c == '('){
                stack.push(c);
            }else if (c == ')'){
                while (!stack.isEmpty() && stack.peek() != '(') {
                    res= res+stack.pop();
                }
                stack.pop();
            }else {
                while (!stack.isEmpty() && precedence(c) < precedence(stack.peek())) {
                    res=res+stack.pop();
                }
                stack.push(c);
            }
        }

        // Pop all the operators from the stack
        while (!stack.isEmpty()) {
            if (stack.peek() == '(') {
                return "Invalid Expression";
            }
            res = res +stack.pop();
        }

        return reverse(res);
    }
    public static String infixToPostfix1(String exp) {
        String res = "";
        MyStack<Character> stack = new MyStack<>();
        for (int i =0;i<exp.length();i++){
            char c = exp.charAt(i);
            if(Character.isLetterOrDigit(c)){
                res=res+c;
            }else if (c == '('){
                stack.push(c);
            }else if (c == ')'){
                while (!stack.isEmpty() && stack.peek() != '(') {
                    res= res+stack.pop();
                }
                stack.pop();
            }else {
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    res=res+stack.pop();
                }
                stack.push(c);
            }
        }

        // Pop all the operators from the stack
        while (!stack.isEmpty()) {
            if (stack.peek() == '(') {
                return "Invalid Expression";
            }
            res = res +stack.pop();
        }

        return res;

    }



    // Function to return precedence of operators
    private static int precedence(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    // Function to convert infix expression to postfix expression
    public static String infixToPostfix(String exp) {
        // Initializing empty String for result
        StringBuilder result = new StringBuilder();

        // Initializing empty stack
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);

            // If the scanned character is an operand, add it to output
            if (Character.isLetterOrDigit(c)) {
                result.append(c);
            }
            // If the scanned character is '(', push it to the stack
            else if (c == '(') {
                stack.push(c);
            }
            // If the scanned character is ')', pop and output from the stack
            // until an '(' is encountered
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                stack.pop();
            }
            // An operator is encountered
            else {
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    result.append(stack.pop());
                }
                stack.push(c);
            }
        }

        // Pop all the operators from the stack
        while (!stack.isEmpty()) {
            if (stack.peek() == '(') {
                return "Invalid Expression";
            }
            result.append(stack.pop());
        }

        return result.toString();
    }
}
