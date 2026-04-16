Infix to Postfix and Prefix Converter (Java)

 Overview
This project is a Java-based application that converts mathematical expressions written in **infix notation** (the common human-readable format) into both:

- **Postfix notation (Reverse Polish Notation)**
- **Prefix notation (Polish Notation)**

The program uses a **stack data structure** to manage operators and ensures that the correct order of operations (operator precedence) is maintained during conversion.

This project demonstrates how stacks are applied in expression parsing and evaluation.

 Objectives 
- To implement stack operations in Java
- To understand and apply operator precedence
- To convert infix expressions to postfix expressions
- To convert infix expressions to prefix expressions
- To demonstrate problem-solving using data structures

 Features 
- Converts infix expressions to postfix notation
- Converts infix expressions to prefix notation
- Supports standard arithmetic operators:
  - Addition (+)
  - Subtraction (-)
  - Multiplication (*)
  - Division (/)
  - Exponentiation (^)
- Handles operator precedence correctly
- Uses stack-based logic for efficient processing
- Simple and easy-to-understand implementation

 Technologies Used 
- Java (Core Java)
- Stack (via `java.util.Stack`)

How to Run the Program
Step 1: Compile the Program
```bash
javac InfixConverter.java
java InfixConverter
