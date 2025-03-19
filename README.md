# ANTLR4 Task
This project serves as a solution to a professional test. I created it to demonstrate my technical skills and expertise. The original task description is provided below.

## Part 3: Malware Analysis Emulation Scenario
Task: Create a simple script emulator in Java

### Example Scenario
- Develop a Java program that can parse and execute a very simple custom script language.
- The script language has only a few commands: ```print```, ```add```, ```subtract```, and ```exit```.
- The script is in plain text, with one command per line.

### Example Script
```
print Hello World
add 5 3
print result
subtract 2 1
print result
exit
```

### Instructions
- Use ANTLR4 or similar tools to create a parser for this script language.
- Your Java program should safely execute the script commands.
- Ensure the program can handle unknown commands or malformed inputs gracefully.

### Example Grammar for ANTLR4 (simplified)
```
grammar SimpleScript;

script: (command '\n')* EOF;

command: printCmd | addCmd | subtractCmd | exitCmd;

printCmd: 'print' (WORD | 'result');
addCmd: 'add' NUMBER NUMBER;
subtractCmd: 'subtract' NUMBER NUMBER;
exitCmd: 'exit';

WORD: [a-zA-Z]+;
NUMBER: [0-9]+;
WHITESPACE: [ \t\r\n]+ -> skip;
```

## Parser generation
Before running please generate the ANTLR4 related classes with these commands:
```
mvn clean antlr4:antlr4
mvn package
```
