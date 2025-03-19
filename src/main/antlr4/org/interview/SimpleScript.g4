grammar SimpleScript;

script: (command '\n')* EOF;

command: printCmd | addCmd | subtractCmd | exitCmd;

printCmd: 'print' (WORD | 'result')+            # Print
;
addCmd: 'add' NUMBER NUMBER                     # Addition
;
subtractCmd: 'subtract' NUMBER NUMBER           # Subtraction
;
exitCmd: 'exit'                                 # Exit
;

WORD: [a-zA-Z]+;
NUMBER: [0-9]+;
WHITESPACE: [ \t\r\n]+ -> skip;
