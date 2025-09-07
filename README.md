# LOX
Implementation of Lox programming language in JAVA and C programming Languages.

## ChangeLog:
    - Added Support for Multiline Comments (Single Line comments can be nested inside multilines, multilines cannot be nested amongst themselves) (2nd Invalid might give undefined behaviour)
    ```
        Valid:
        1. // This is a comment /* This is second comment */
        2. // /* this is a nested comment
        3. /* This is a multiline comment*/
        4. /* This is a multiline comment
            that goes on to new lines also.*/
        
        Invalid:
        1. // single line comment /* that
            goes on to new line*/
        2. /* multiline comment that /* contains
             another multiline */ comment*/ 
    ```
    - Created helper class to generate ASTs (Partial)
    
