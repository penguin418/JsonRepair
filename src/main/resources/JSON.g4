grammar JSON;

// Tokens
BEGIN_ARRAY     : '[';
BEGIN_OBJECT    : '{';
END_OBJECT      : '}';
END_ARRAY       : ']';
VALUE_SEPARATOR : ',';
NAME_SEPARATOR  : ':';
FALSE           : 'false';
TRUE            : 'true';
NULL            : 'null';

// 주요 규칙
json : value ;

object : BEGIN_OBJECT pair (VALUE_SEPARATOR pair)* END_OBJECT
       | BEGIN_OBJECT END_OBJECT ;

pair : STRING NAME_SEPARATOR value ;

array : BEGIN_ARRAY value (VALUE_SEPARATOR value)* END_ARRAY
       | BEGIN_ARRAY END_ARRAY ;

value : FALSE
      | NULL
      | TRUE
      | object
      | array
      | NUMBER
      | STRING
      ;

STRING : '"' ( '\\' . | ~["\\] )* '"' ;
NUMBER : '-'? INT '.' [0-9]+ EXP? | '-'? INT EXP | '-'? INT ;
fragment INT : '0' | [1-9] [0-9]* ;
fragment EXP : [Ee] [+\-]? INT ;

WS : [ \t\r\n]+ -> skip ;
