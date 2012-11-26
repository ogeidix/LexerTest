package edu.uci.ics.asterix.external.data.parser.admfast;  


import java.io.IOException;

import com.ogeidix.lexertest.Lexer;


import edu.uci.ics.asterix.external.data.parser.admfast.AdmFastLexerException;

public class AdmFastLexer implements Lexer{

    public static final int
        TOKEN_EOF = 0, TOKEN_AUX_NOT_FOUND = 1 , TOKEN_BOOLEAN_CONS=2 , TOKEN_INT8_CONS=3 , TOKEN_INT16_CONS=4 , TOKEN_INT32_CONS=5 , TOKEN_INT64_CONS=6 , TOKEN_FLOAT_CONS=7 , TOKEN_DOUBLE_CONS=8 , TOKEN_DATE_CONS=9 , TOKEN_DATETIME_CONS=10 , TOKEN_DURATION_CONS=11 , TOKEN_STRING_CONS=12 , TOKEN_POINT_CONS=13 , TOKEN_POINT3D_CONS=14 , TOKEN_LINE_CONS=15 , TOKEN_POLYGON_CONS=16 , TOKEN_RECTANGLE_CONS=17 , TOKEN_CIRCLE_CONS=18 , TOKEN_TIME_CONS=19 , TOKEN_NULL_LITERAL=20 , TOKEN_TRUE_LITERAL=21 , TOKEN_FALSE_LITERAL=22 , TOKEN_CONSTRUCTOR_OPEN=23 , TOKEN_CONSTRUCTOR_CLOSE=24 , TOKEN_START_RECORD=25 , TOKEN_END_RECORD=26 , TOKEN_COMMA=27 , TOKEN_COLON=28 , TOKEN_START_ORDERED_LIST=29 , TOKEN_END_ORDERED_LIST=30 , TOKEN_START_UNORDERED_LIST=31 , TOKEN_END_UNORDERED_LIST=32 , TOKEN_STRING_LITERAL=33 , TOKEN_INT_LITERAL=34 , TOKEN_INT8_LITERAL=35 , TOKEN_INT16_LITERAL=36 , TOKEN_INT32_LITERAL=37 , TOKEN_INT64_LITERAL=38 , TOKEN_aux_EXPONENT=39 , TOKEN_DOUBLE_LITERAL=40 , TOKEN_FLOAT_LITERAL=41 , TOKEN_aux_TIMEZONE=42 , TOKEN_TIME_LITERAL=43 , TOKEN_DATE_LITERAL=44 , TOKEN_aux_DATETIME_PARTIAL=45 , TOKEN_DATETIME_LITERAL=46 , TOKEN_aux_DURATION_DATE_PART=47 , TOKEN_aux_DURATION_TIME_PART=48 , TOKEN_aux_DURATION_PARTIAL=49 , TOKEN_DURATION_LITERAL=50 , TOKEN_POINT_LITERAL=51 , TOKEN_CIRCLE_LITERAL=52 , TOKEN_POINT3D_LITERAL=53 , TOKEN_LINE_LITERAL=54 , TOKEN_RECTANGLE_LITERAL=55 ;

    private static final String[] tokenImage = {
            "<EOF>", "<AUX_NOT_FOUND>" , "<BOOLEAN_CONS>" , "<INT8_CONS>" , "<INT16_CONS>" , "<INT32_CONS>" , "<INT64_CONS>" , "<FLOAT_CONS>" , "<DOUBLE_CONS>" , "<DATE_CONS>" , "<DATETIME_CONS>" , "<DURATION_CONS>" , "<STRING_CONS>" , "<POINT_CONS>" , "<POINT3D_CONS>" , "<LINE_CONS>" , "<POLYGON_CONS>" , "<RECTANGLE_CONS>" , "<CIRCLE_CONS>" , "<TIME_CONS>" , "<NULL_LITERAL>" , "<TRUE_LITERAL>" , "<FALSE_LITERAL>" , "<CONSTRUCTOR_OPEN>" , "<CONSTRUCTOR_CLOSE>" , "<START_RECORD>" , "<END_RECORD>" , "<COMMA>" , "<COLON>" , "<START_ORDERED_LIST>" , "<END_ORDERED_LIST>" , "<START_UNORDERED_LIST>" , "<END_UNORDERED_LIST>" , "<STRING_LITERAL>" , "<INT_LITERAL>" , "<INT8_LITERAL>" , "<INT16_LITERAL>" , "<INT32_LITERAL>" , "<INT64_LITERAL>" , "<aux_EXPONENT>" , "<DOUBLE_LITERAL>" , "<FLOAT_LITERAL>" , "<aux_TIMEZONE>" , "<TIME_LITERAL>" , "<DATE_LITERAL>" , "<aux_DATETIME_PARTIAL>" , "<DATETIME_LITERAL>" , "<aux_DURATION_DATE_PART>" , "<aux_DURATION_TIME_PART>" , "<aux_DURATION_PARTIAL>" , "<DURATION_LITERAL>" , "<POINT_LITERAL>" , "<CIRCLE_LITERAL>" , "<POINT3D_LITERAL>" , "<LINE_LITERAL>" , "<RECTANGLE_LITERAL>" 
          };
    
    private static final char EOF_CHAR = 4;
    protected java.io.Reader inputStream;
    protected int column;
    protected int line;
    protected boolean prevCharIsCR;
    protected boolean prevCharIsLF;
    protected char[] buffer;
    protected int bufsize;
    protected int bufpos;
    protected int tokenBegin;
    protected int endOf_USED_Buffer;
    protected int endOf_UNUSED_Buffer;
    protected int maxUnusedBufferSize;
    
    private int parse_POINT_LITERAL(char currentChar) throws IOException, AdmFastLexerException{
if (currentChar=='P'){
currentChar = readNextChar();
if (parse_DOUBLE_LITERAL(currentChar)==TOKEN_DOUBLE_LITERAL){
currentChar = readNextChar();
if (currentChar==','){
currentChar = readNextChar();
if (parse_DOUBLE_LITERAL(currentChar)==TOKEN_DOUBLE_LITERAL){
currentChar = readNextChar();
if (currentChar=='R'){
currentChar = readNextChar();
if (parse_DOUBLE_LITERAL(currentChar)==TOKEN_DOUBLE_LITERAL){
currentChar = readNextChar();
return TOKEN_CIRCLE_LITERAL;
}return parseError(TOKEN_CIRCLE_LITERAL);
}if (currentChar==','){
currentChar = readNextChar();
if (parse_DOUBLE_LITERAL(currentChar)==TOKEN_DOUBLE_LITERAL){
currentChar = readNextChar();
return TOKEN_POINT3D_LITERAL;
}return parseError(TOKEN_POINT3D_LITERAL);
}if (parse_POINT_LITERAL(currentChar)==TOKEN_POINT_LITERAL){
currentChar = readNextChar();
if (parse_POINT_LITERAL(currentChar)==TOKEN_POINT_LITERAL){
currentChar = readNextChar();
return TOKEN_RECTANGLE_LITERAL;
}return TOKEN_LINE_LITERAL;
}return TOKEN_POINT_LITERAL;
}return parseError(TOKEN_LINE_LITERAL,TOKEN_RECTANGLE_LITERAL,TOKEN_POINT3D_LITERAL,TOKEN_POINT_LITERAL,TOKEN_CIRCLE_LITERAL);
}return parseError(TOKEN_LINE_LITERAL,TOKEN_RECTANGLE_LITERAL,TOKEN_POINT3D_LITERAL,TOKEN_POINT_LITERAL,TOKEN_CIRCLE_LITERAL);
}return parseError(TOKEN_LINE_LITERAL,TOKEN_RECTANGLE_LITERAL,TOKEN_POINT3D_LITERAL,TOKEN_POINT_LITERAL,TOKEN_CIRCLE_LITERAL);
}return TOKEN_AUX_NOT_FOUND;

}

private int parse_aux_DURATION_TIME_PART(char currentChar) throws IOException, AdmFastLexerException{
if(currentChar >= '0' && currentChar<='9'){
currentChar = readNextChar();
while(currentChar >= '0' && currentChar<='9'){
currentChar = readNextChar();
}

currentChar = readNextChar();
switch(currentChar){
case 'H':
currentChar = readNextChar();
return TOKEN_aux_DURATION_TIME_PART;
case 'M':
currentChar = readNextChar();
return TOKEN_aux_DURATION_TIME_PART;
case 'S':
currentChar = readNextChar();
return TOKEN_aux_DURATION_TIME_PART;
}
return parseError(TOKEN_aux_DURATION_TIME_PART);

}return TOKEN_AUX_NOT_FOUND;

}

private int parse_DOUBLE_LITERAL(char currentChar) throws IOException, AdmFastLexerException{
switch(currentChar){
case '+':
currentChar = readNextChar();
if (currentChar=='.'){
currentChar = readNextChar();
if(currentChar >= '0' && currentChar<='9'){
currentChar = readNextChar();
while(currentChar >= '0' && currentChar<='9'){
currentChar = readNextChar();
}

currentChar = readNextChar();
if (currentChar=='f'){
currentChar = readNextChar();
return TOKEN_FLOAT_LITERAL;
}if (currentChar=='F'){
currentChar = readNextChar();
return TOKEN_FLOAT_LITERAL;
}return TOKEN_DOUBLE_LITERAL;

}return parseError(TOKEN_DOUBLE_LITERAL,TOKEN_FLOAT_LITERAL);
}if(currentChar >= '0' && currentChar<='9'){
currentChar = readNextChar();
while(currentChar >= '0' && currentChar<='9'){
currentChar = readNextChar();
}

currentChar = readNextChar();
if (currentChar=='.'){
currentChar = readNextChar();
if(currentChar >= '0' && currentChar<='9'){
currentChar = readNextChar();
while(currentChar >= '0' && currentChar<='9'){
currentChar = readNextChar();
}

currentChar = readNextChar();
if (parse_aux_EXPONENT(currentChar)==TOKEN_aux_EXPONENT){
currentChar = readNextChar();
if (currentChar=='f'){
currentChar = readNextChar();
return TOKEN_FLOAT_LITERAL;
}if (currentChar=='F'){
currentChar = readNextChar();
return TOKEN_FLOAT_LITERAL;
}return TOKEN_DOUBLE_LITERAL;
}return TOKEN_DOUBLE_LITERAL;

}return parseError(TOKEN_DOUBLE_LITERAL,TOKEN_FLOAT_LITERAL);
}if (parse_aux_EXPONENT(currentChar)==TOKEN_aux_EXPONENT){
currentChar = readNextChar();
if (currentChar=='f'){
currentChar = readNextChar();
return TOKEN_FLOAT_LITERAL;
}if (currentChar=='F'){
currentChar = readNextChar();
return TOKEN_FLOAT_LITERAL;
}return TOKEN_DOUBLE_LITERAL;
}return parseError(TOKEN_DOUBLE_LITERAL);

}return parseError(TOKEN_DOUBLE_LITERAL);
case '-':
currentChar = readNextChar();
if (currentChar=='.'){
currentChar = readNextChar();
if(currentChar >= '0' && currentChar<='9'){
currentChar = readNextChar();
while(currentChar >= '0' && currentChar<='9'){
currentChar = readNextChar();
}

currentChar = readNextChar();
if (currentChar=='f'){
currentChar = readNextChar();
return TOKEN_FLOAT_LITERAL;
}if (currentChar=='F'){
currentChar = readNextChar();
return TOKEN_FLOAT_LITERAL;
}return TOKEN_DOUBLE_LITERAL;

}return parseError(TOKEN_DOUBLE_LITERAL,TOKEN_FLOAT_LITERAL);
}if(currentChar >= '0' && currentChar<='9'){
currentChar = readNextChar();
while(currentChar >= '0' && currentChar<='9'){
currentChar = readNextChar();
}

currentChar = readNextChar();
if (currentChar=='.'){
currentChar = readNextChar();
if(currentChar >= '0' && currentChar<='9'){
currentChar = readNextChar();
while(currentChar >= '0' && currentChar<='9'){
currentChar = readNextChar();
}

currentChar = readNextChar();
if (parse_aux_EXPONENT(currentChar)==TOKEN_aux_EXPONENT){
currentChar = readNextChar();
if (currentChar=='f'){
currentChar = readNextChar();
return TOKEN_FLOAT_LITERAL;
}if (currentChar=='F'){
currentChar = readNextChar();
return TOKEN_FLOAT_LITERAL;
}return TOKEN_DOUBLE_LITERAL;
}return TOKEN_DOUBLE_LITERAL;

}return parseError(TOKEN_DOUBLE_LITERAL,TOKEN_FLOAT_LITERAL);
}if (parse_aux_EXPONENT(currentChar)==TOKEN_aux_EXPONENT){
currentChar = readNextChar();
if (currentChar=='f'){
currentChar = readNextChar();
return TOKEN_FLOAT_LITERAL;
}if (currentChar=='F'){
currentChar = readNextChar();
return TOKEN_FLOAT_LITERAL;
}return TOKEN_DOUBLE_LITERAL;
}return parseError(TOKEN_DOUBLE_LITERAL);

}return parseError(TOKEN_DOUBLE_LITERAL);
case '.':
currentChar = readNextChar();
if(currentChar >= '0' && currentChar<='9'){
currentChar = readNextChar();
while(currentChar >= '0' && currentChar<='9'){
currentChar = readNextChar();
}

currentChar = readNextChar();
if (currentChar=='f'){
currentChar = readNextChar();
return TOKEN_FLOAT_LITERAL;
}if (currentChar=='F'){
currentChar = readNextChar();
return TOKEN_FLOAT_LITERAL;
}return TOKEN_DOUBLE_LITERAL;

}return parseError(TOKEN_DOUBLE_LITERAL,TOKEN_FLOAT_LITERAL);
}
if(currentChar >= '0' && currentChar<='9'){
currentChar = readNextChar();
while(currentChar >= '0' && currentChar<='9'){
currentChar = readNextChar();
}

currentChar = readNextChar();
if (currentChar=='.'){
currentChar = readNextChar();
if(currentChar >= '0' && currentChar<='9'){
currentChar = readNextChar();
while(currentChar >= '0' && currentChar<='9'){
currentChar = readNextChar();
}

currentChar = readNextChar();
if (parse_aux_EXPONENT(currentChar)==TOKEN_aux_EXPONENT){
currentChar = readNextChar();
if (currentChar=='f'){
currentChar = readNextChar();
return TOKEN_FLOAT_LITERAL;
}if (currentChar=='F'){
currentChar = readNextChar();
return TOKEN_FLOAT_LITERAL;
}return TOKEN_DOUBLE_LITERAL;
}return TOKEN_DOUBLE_LITERAL;

}return parseError(TOKEN_DOUBLE_LITERAL,TOKEN_FLOAT_LITERAL);
}if (parse_aux_EXPONENT(currentChar)==TOKEN_aux_EXPONENT){
currentChar = readNextChar();
if (currentChar=='f'){
currentChar = readNextChar();
return TOKEN_FLOAT_LITERAL;
}if (currentChar=='F'){
currentChar = readNextChar();
return TOKEN_FLOAT_LITERAL;
}return TOKEN_DOUBLE_LITERAL;
}return parseError(TOKEN_DOUBLE_LITERAL);

}return TOKEN_AUX_NOT_FOUND;

}

private int parse_aux_EXPONENT(char currentChar) throws IOException, AdmFastLexerException{
if (currentChar=='e'){
currentChar = readNextChar();
if (currentChar=='+'){
currentChar = readNextChar();
if(currentChar >= '0' && currentChar<='9'){
currentChar = readNextChar();
while(currentChar >= '0' && currentChar<='9'){
currentChar = readNextChar();
}

currentChar = readNextChar();
return TOKEN_aux_EXPONENT;

}return parseError(TOKEN_aux_EXPONENT);
}if (currentChar=='-'){
currentChar = readNextChar();
if(currentChar >= '0' && currentChar<='9'){
currentChar = readNextChar();
while(currentChar >= '0' && currentChar<='9'){
currentChar = readNextChar();
}

currentChar = readNextChar();
return TOKEN_aux_EXPONENT;

}return parseError(TOKEN_aux_EXPONENT);
}if(currentChar >= '0' && currentChar<='9'){
currentChar = readNextChar();
while(currentChar >= '0' && currentChar<='9'){
currentChar = readNextChar();
}

currentChar = readNextChar();
return TOKEN_aux_EXPONENT;

}return parseError(TOKEN_aux_EXPONENT);
}if (currentChar=='E'){
currentChar = readNextChar();
if (currentChar=='+'){
currentChar = readNextChar();
if(currentChar >= '0' && currentChar<='9'){
currentChar = readNextChar();
while(currentChar >= '0' && currentChar<='9'){
currentChar = readNextChar();
}

currentChar = readNextChar();
return TOKEN_aux_EXPONENT;

}return parseError(TOKEN_aux_EXPONENT);
}if (currentChar=='-'){
currentChar = readNextChar();
if(currentChar >= '0' && currentChar<='9'){
currentChar = readNextChar();
while(currentChar >= '0' && currentChar<='9'){
currentChar = readNextChar();
}

currentChar = readNextChar();
return TOKEN_aux_EXPONENT;

}return parseError(TOKEN_aux_EXPONENT);
}if(currentChar >= '0' && currentChar<='9'){
currentChar = readNextChar();
while(currentChar >= '0' && currentChar<='9'){
currentChar = readNextChar();
}

currentChar = readNextChar();
return TOKEN_aux_EXPONENT;

}return parseError(TOKEN_aux_EXPONENT);
}return TOKEN_AUX_NOT_FOUND;

}

private int parse_aux_DURATION_DATE_PART(char currentChar) throws IOException, AdmFastLexerException{
if(currentChar >= '0' && currentChar<='9'){
currentChar = readNextChar();
while(currentChar >= '0' && currentChar<='9'){
currentChar = readNextChar();
}

currentChar = readNextChar();
switch(currentChar){
case 'Y':
currentChar = readNextChar();
return TOKEN_aux_DURATION_DATE_PART;
case 'M':
currentChar = readNextChar();
return TOKEN_aux_DURATION_DATE_PART;
case 'D':
currentChar = readNextChar();
return TOKEN_aux_DURATION_DATE_PART;
}
return parseError(TOKEN_aux_DURATION_DATE_PART);

}return TOKEN_AUX_NOT_FOUND;

}

private int parse_aux_TIMEZONE(char currentChar) throws IOException, AdmFastLexerException{
switch(currentChar){
case 'Z':
currentChar = readNextChar();
return TOKEN_aux_TIMEZONE;
case '+':
currentChar = readNextChar();
if(currentChar >= '0' && currentChar<='9'){
currentChar = readNextChar();
while(currentChar >= '0' && currentChar<='9'){
currentChar = readNextChar();
}

currentChar = readNextChar();
if (currentChar==':'){
currentChar = readNextChar();
if(currentChar >= '0' && currentChar<='9'){
currentChar = readNextChar();
while(currentChar >= '0' && currentChar<='9'){
currentChar = readNextChar();
}

currentChar = readNextChar();
return TOKEN_aux_TIMEZONE;

}return parseError(TOKEN_aux_TIMEZONE);
}return parseError(TOKEN_aux_TIMEZONE);

}return parseError(TOKEN_aux_TIMEZONE);
case '-':
currentChar = readNextChar();
if(currentChar >= '0' && currentChar<='9'){
currentChar = readNextChar();
while(currentChar >= '0' && currentChar<='9'){
currentChar = readNextChar();
}

currentChar = readNextChar();
if (currentChar==':'){
currentChar = readNextChar();
if(currentChar >= '0' && currentChar<='9'){
currentChar = readNextChar();
while(currentChar >= '0' && currentChar<='9'){
currentChar = readNextChar();
}

currentChar = readNextChar();
return TOKEN_aux_TIMEZONE;

}return parseError(TOKEN_aux_TIMEZONE);
}return parseError(TOKEN_aux_TIMEZONE);

}return parseError(TOKEN_aux_TIMEZONE);
}
return TOKEN_AUX_NOT_FOUND;

}



    public int next() throws AdmFastLexerException, IOException{
        char currentChar = buffer[bufpos];
        while (currentChar == ' ' || currentChar=='\t' || currentChar == '\n' || currentChar=='\r')
            currentChar = readNextChar(); 
        tokenBegin = bufpos;
        if (currentChar==EOF_CHAR) return TOKEN_EOF;

        switch(currentChar){
case 'b':
currentChar = readNextChar();
if (currentChar=='o'){
currentChar = readNextChar();
if (currentChar=='o'){
currentChar = readNextChar();
if (currentChar=='l'){
currentChar = readNextChar();
if (currentChar=='e'){
currentChar = readNextChar();
if (currentChar=='a'){
currentChar = readNextChar();
if (currentChar=='n'){
currentChar = readNextChar();
return TOKEN_BOOLEAN_CONS;
}return parseError(TOKEN_BOOLEAN_CONS);
}return parseError(TOKEN_BOOLEAN_CONS);
}return parseError(TOKEN_BOOLEAN_CONS);
}return parseError(TOKEN_BOOLEAN_CONS);
}return parseError(TOKEN_BOOLEAN_CONS);
}return parseError(TOKEN_BOOLEAN_CONS);
case 'i':
currentChar = readNextChar();
if (currentChar=='n'){
currentChar = readNextChar();
if (currentChar=='t'){
currentChar = readNextChar();
switch(currentChar){
case '8':
currentChar = readNextChar();
return TOKEN_INT8_CONS;
case '1':
currentChar = readNextChar();
if (currentChar=='6'){
currentChar = readNextChar();
return TOKEN_INT16_CONS;
}return parseError(TOKEN_INT16_CONS);
case '3':
currentChar = readNextChar();
if (currentChar=='2'){
currentChar = readNextChar();
return TOKEN_INT32_CONS;
}return parseError(TOKEN_INT32_CONS);
case '6':
currentChar = readNextChar();
if (currentChar=='4'){
currentChar = readNextChar();
return TOKEN_INT64_CONS;
}return parseError(TOKEN_INT64_CONS);
}
return parseError(TOKEN_INT8_CONS,TOKEN_INT32_CONS,TOKEN_INT16_CONS,TOKEN_INT64_CONS);
}return parseError(TOKEN_INT8_CONS,TOKEN_INT32_CONS,TOKEN_INT16_CONS,TOKEN_INT64_CONS);
}return parseError(TOKEN_INT8_CONS,TOKEN_INT32_CONS,TOKEN_INT16_CONS,TOKEN_INT64_CONS);
case 'f':
currentChar = readNextChar();
if (currentChar=='l'){
currentChar = readNextChar();
if (currentChar=='o'){
currentChar = readNextChar();
if (currentChar=='a'){
currentChar = readNextChar();
if (currentChar=='t'){
currentChar = readNextChar();
return TOKEN_FLOAT_CONS;
}return parseError(TOKEN_FLOAT_CONS);
}return parseError(TOKEN_FLOAT_CONS);
}return parseError(TOKEN_FLOAT_CONS);
}if (currentChar=='a'){
currentChar = readNextChar();
if (currentChar=='l'){
currentChar = readNextChar();
if (currentChar=='s'){
currentChar = readNextChar();
if (currentChar=='e'){
currentChar = readNextChar();
return TOKEN_FALSE_LITERAL;
}return parseError(TOKEN_FALSE_LITERAL);
}return parseError(TOKEN_FALSE_LITERAL);
}return parseError(TOKEN_FALSE_LITERAL);
}return parseError(TOKEN_FALSE_LITERAL,TOKEN_FLOAT_CONS);
case 'd':
currentChar = readNextChar();
switch(currentChar){
case 'o':
currentChar = readNextChar();
if (currentChar=='u'){
currentChar = readNextChar();
if (currentChar=='b'){
currentChar = readNextChar();
if (currentChar=='l'){
currentChar = readNextChar();
if (currentChar=='e'){
currentChar = readNextChar();
return TOKEN_DOUBLE_CONS;
}return parseError(TOKEN_DOUBLE_CONS);
}return parseError(TOKEN_DOUBLE_CONS);
}return parseError(TOKEN_DOUBLE_CONS);
}return parseError(TOKEN_DOUBLE_CONS);
case 'a':
currentChar = readNextChar();
if (currentChar=='t'){
currentChar = readNextChar();
if (currentChar=='e'){
currentChar = readNextChar();
if (currentChar=='t'){
currentChar = readNextChar();
if (currentChar=='i'){
currentChar = readNextChar();
if (currentChar=='m'){
currentChar = readNextChar();
if (currentChar=='e'){
currentChar = readNextChar();
return TOKEN_DATETIME_CONS;
}return parseError(TOKEN_DATETIME_CONS);
}return parseError(TOKEN_DATETIME_CONS);
}return parseError(TOKEN_DATETIME_CONS);
}return TOKEN_DATE_CONS;
}return parseError(TOKEN_DATETIME_CONS,TOKEN_DATE_CONS);
}return parseError(TOKEN_DATETIME_CONS,TOKEN_DATE_CONS);
case 'u':
currentChar = readNextChar();
if (currentChar=='r'){
currentChar = readNextChar();
if (currentChar=='a'){
currentChar = readNextChar();
if (currentChar=='t'){
currentChar = readNextChar();
if (currentChar=='i'){
currentChar = readNextChar();
if (currentChar=='o'){
currentChar = readNextChar();
if (currentChar=='n'){
currentChar = readNextChar();
return TOKEN_DURATION_CONS;
}return parseError(TOKEN_DURATION_CONS);
}return parseError(TOKEN_DURATION_CONS);
}return parseError(TOKEN_DURATION_CONS);
}return parseError(TOKEN_DURATION_CONS);
}return parseError(TOKEN_DURATION_CONS);
}return parseError(TOKEN_DURATION_CONS);
}
return parseError(TOKEN_DATETIME_CONS,TOKEN_DATE_CONS,TOKEN_DOUBLE_CONS,TOKEN_DURATION_CONS);
case 's':
currentChar = readNextChar();
if (currentChar=='t'){
currentChar = readNextChar();
if (currentChar=='r'){
currentChar = readNextChar();
if (currentChar=='i'){
currentChar = readNextChar();
if (currentChar=='n'){
currentChar = readNextChar();
if (currentChar=='g'){
currentChar = readNextChar();
return TOKEN_STRING_CONS;
}return parseError(TOKEN_STRING_CONS);
}return parseError(TOKEN_STRING_CONS);
}return parseError(TOKEN_STRING_CONS);
}return parseError(TOKEN_STRING_CONS);
}return parseError(TOKEN_STRING_CONS);
case 'p':
currentChar = readNextChar();
if (currentChar=='o'){
currentChar = readNextChar();
if (currentChar=='i'){
currentChar = readNextChar();
if (currentChar=='n'){
currentChar = readNextChar();
if (currentChar=='t'){
currentChar = readNextChar();
if (currentChar=='3'){
currentChar = readNextChar();
if (currentChar=='d'){
currentChar = readNextChar();
return TOKEN_POINT3D_CONS;
}return parseError(TOKEN_POINT3D_CONS);
}return TOKEN_POINT_CONS;
}return parseError(TOKEN_POINT_CONS,TOKEN_POINT3D_CONS);
}return parseError(TOKEN_POINT_CONS,TOKEN_POINT3D_CONS);
}if (currentChar=='l'){
currentChar = readNextChar();
if (currentChar=='y'){
currentChar = readNextChar();
if (currentChar=='g'){
currentChar = readNextChar();
if (currentChar=='o'){
currentChar = readNextChar();
if (currentChar=='n'){
currentChar = readNextChar();
return TOKEN_POLYGON_CONS;
}return parseError(TOKEN_POLYGON_CONS);
}return parseError(TOKEN_POLYGON_CONS);
}return parseError(TOKEN_POLYGON_CONS);
}return parseError(TOKEN_POLYGON_CONS);
}return parseError(TOKEN_POINT_CONS,TOKEN_POLYGON_CONS,TOKEN_POINT3D_CONS);
}return parseError(TOKEN_POINT_CONS,TOKEN_POLYGON_CONS,TOKEN_POINT3D_CONS);
case 'l':
currentChar = readNextChar();
if (currentChar=='i'){
currentChar = readNextChar();
if (currentChar=='n'){
currentChar = readNextChar();
if (currentChar=='e'){
currentChar = readNextChar();
return TOKEN_LINE_CONS;
}return parseError(TOKEN_LINE_CONS);
}return parseError(TOKEN_LINE_CONS);
}return parseError(TOKEN_LINE_CONS);
case 'r':
currentChar = readNextChar();
if (currentChar=='e'){
currentChar = readNextChar();
if (currentChar=='c'){
currentChar = readNextChar();
if (currentChar=='t'){
currentChar = readNextChar();
if (currentChar=='a'){
currentChar = readNextChar();
if (currentChar=='n'){
currentChar = readNextChar();
if (currentChar=='g'){
currentChar = readNextChar();
if (currentChar=='l'){
currentChar = readNextChar();
if (currentChar=='e'){
currentChar = readNextChar();
return TOKEN_RECTANGLE_CONS;
}return parseError(TOKEN_RECTANGLE_CONS);
}return parseError(TOKEN_RECTANGLE_CONS);
}return parseError(TOKEN_RECTANGLE_CONS);
}return parseError(TOKEN_RECTANGLE_CONS);
}return parseError(TOKEN_RECTANGLE_CONS);
}return parseError(TOKEN_RECTANGLE_CONS);
}return parseError(TOKEN_RECTANGLE_CONS);
}return parseError(TOKEN_RECTANGLE_CONS);
case 'c':
currentChar = readNextChar();
if (currentChar=='i'){
currentChar = readNextChar();
if (currentChar=='r'){
currentChar = readNextChar();
if (currentChar=='c'){
currentChar = readNextChar();
if (currentChar=='l'){
currentChar = readNextChar();
if (currentChar=='e'){
currentChar = readNextChar();
return TOKEN_CIRCLE_CONS;
}return parseError(TOKEN_CIRCLE_CONS);
}return parseError(TOKEN_CIRCLE_CONS);
}return parseError(TOKEN_CIRCLE_CONS);
}return parseError(TOKEN_CIRCLE_CONS);
}return parseError(TOKEN_CIRCLE_CONS);
case 't':
currentChar = readNextChar();
if (currentChar=='i'){
currentChar = readNextChar();
if (currentChar=='m'){
currentChar = readNextChar();
if (currentChar=='e'){
currentChar = readNextChar();
return TOKEN_TIME_CONS;
}return parseError(TOKEN_TIME_CONS);
}return parseError(TOKEN_TIME_CONS);
}if (currentChar=='r'){
currentChar = readNextChar();
if (currentChar=='u'){
currentChar = readNextChar();
if (currentChar=='e'){
currentChar = readNextChar();
return TOKEN_TRUE_LITERAL;
}return parseError(TOKEN_TRUE_LITERAL);
}return parseError(TOKEN_TRUE_LITERAL);
}return parseError(TOKEN_TRUE_LITERAL,TOKEN_TIME_CONS);
case 'n':
currentChar = readNextChar();
if (currentChar=='u'){
currentChar = readNextChar();
if (currentChar=='l'){
currentChar = readNextChar();
if (currentChar=='l'){
currentChar = readNextChar();
return TOKEN_NULL_LITERAL;
}return parseError(TOKEN_NULL_LITERAL);
}return parseError(TOKEN_NULL_LITERAL);
}return parseError(TOKEN_NULL_LITERAL);
case '(':
currentChar = readNextChar();
return TOKEN_CONSTRUCTOR_OPEN;
case ')':
currentChar = readNextChar();
return TOKEN_CONSTRUCTOR_CLOSE;
case '{':
currentChar = readNextChar();
if (currentChar=='{'){
currentChar = readNextChar();
return TOKEN_START_UNORDERED_LIST;
}return TOKEN_START_RECORD;
case '}':
currentChar = readNextChar();
if (currentChar=='}'){
currentChar = readNextChar();
return TOKEN_END_UNORDERED_LIST;
}return TOKEN_END_RECORD;
case ',':
currentChar = readNextChar();
return TOKEN_COMMA;
case ':':
currentChar = readNextChar();
return TOKEN_COLON;
case '[':
currentChar = readNextChar();
return TOKEN_START_ORDERED_LIST;
case ']':
currentChar = readNextChar();
return TOKEN_END_ORDERED_LIST;
case '"':
currentChar = readNextChar();
boolean escaped = false;while (currentChar!='"' || escaped){
if(!escaped && currentChar=='\\'){escaped=true;}
else {escaped=false;}
currentChar = readNextChar();
}
if (currentChar=='"'){
currentChar = readNextChar();
return TOKEN_STRING_LITERAL;
}
return parseError(TOKEN_STRING_LITERAL);
case '+':
currentChar = readNextChar();
if(currentChar >= '0' && currentChar<='9'){
currentChar = readNextChar();
while(currentChar >= '0' && currentChar<='9'){
currentChar = readNextChar();
}

currentChar = readNextChar();
if (currentChar=='i'){
currentChar = readNextChar();
switch(currentChar){
case '8':
currentChar = readNextChar();
return TOKEN_INT8_LITERAL;
case '1':
currentChar = readNextChar();
if (currentChar=='6'){
currentChar = readNextChar();
return TOKEN_INT16_LITERAL;
}return parseError(TOKEN_INT16_LITERAL);
case '3':
currentChar = readNextChar();
if (currentChar=='2'){
currentChar = readNextChar();
return TOKEN_INT32_LITERAL;
}return parseError(TOKEN_INT32_LITERAL);
case '6':
currentChar = readNextChar();
if (currentChar=='4'){
currentChar = readNextChar();
return TOKEN_INT64_LITERAL;
}return parseError(TOKEN_INT64_LITERAL);
}
return parseError(TOKEN_INT16_LITERAL,TOKEN_INT64_LITERAL,TOKEN_INT8_LITERAL,TOKEN_INT32_LITERAL);
}if (currentChar=='.'){
currentChar = readNextChar();
if(currentChar >= '0' && currentChar<='9'){
currentChar = readNextChar();
while(currentChar >= '0' && currentChar<='9'){
currentChar = readNextChar();
}

currentChar = readNextChar();
if (parse_aux_EXPONENT(currentChar)==TOKEN_aux_EXPONENT){
currentChar = readNextChar();
if (currentChar=='f'){
currentChar = readNextChar();
return TOKEN_FLOAT_LITERAL;
}if (currentChar=='F'){
currentChar = readNextChar();
return TOKEN_FLOAT_LITERAL;
}return TOKEN_DOUBLE_LITERAL;
}return TOKEN_DOUBLE_LITERAL;

}return parseError(TOKEN_DOUBLE_LITERAL,TOKEN_FLOAT_LITERAL);
}if (parse_aux_EXPONENT(currentChar)==TOKEN_aux_EXPONENT){
currentChar = readNextChar();
if (currentChar=='f'){
currentChar = readNextChar();
return TOKEN_FLOAT_LITERAL;
}if (currentChar=='F'){
currentChar = readNextChar();
return TOKEN_FLOAT_LITERAL;
}return TOKEN_DOUBLE_LITERAL;
}return TOKEN_INT_LITERAL;

}if (currentChar=='.'){
currentChar = readNextChar();
if(currentChar >= '0' && currentChar<='9'){
currentChar = readNextChar();
while(currentChar >= '0' && currentChar<='9'){
currentChar = readNextChar();
}

currentChar = readNextChar();
if (currentChar=='f'){
currentChar = readNextChar();
return TOKEN_FLOAT_LITERAL;
}if (currentChar=='F'){
currentChar = readNextChar();
return TOKEN_FLOAT_LITERAL;
}return TOKEN_DOUBLE_LITERAL;

}return parseError(TOKEN_DOUBLE_LITERAL,TOKEN_FLOAT_LITERAL);
}return parseError(TOKEN_INT16_LITERAL,TOKEN_DOUBLE_LITERAL,TOKEN_INT64_LITERAL,TOKEN_INT_LITERAL,TOKEN_INT8_LITERAL,TOKEN_INT32_LITERAL,TOKEN_FLOAT_LITERAL);
case '-':
currentChar = readNextChar();
if(currentChar >= '0' && currentChar<='9'){
currentChar = readNextChar();
while(currentChar >= '0' && currentChar<='9'){
currentChar = readNextChar();
}

currentChar = readNextChar();
switch(currentChar){
case 'i':
currentChar = readNextChar();
switch(currentChar){
case '8':
currentChar = readNextChar();
return TOKEN_INT8_LITERAL;
case '1':
currentChar = readNextChar();
if (currentChar=='6'){
currentChar = readNextChar();
return TOKEN_INT16_LITERAL;
}return parseError(TOKEN_INT16_LITERAL);
case '3':
currentChar = readNextChar();
if (currentChar=='2'){
currentChar = readNextChar();
return TOKEN_INT32_LITERAL;
}return parseError(TOKEN_INT32_LITERAL);
case '6':
currentChar = readNextChar();
if (currentChar=='4'){
currentChar = readNextChar();
return TOKEN_INT64_LITERAL;
}return parseError(TOKEN_INT64_LITERAL);
}
return parseError(TOKEN_INT16_LITERAL,TOKEN_INT64_LITERAL,TOKEN_INT8_LITERAL,TOKEN_INT32_LITERAL);
case '.':
currentChar = readNextChar();
if(currentChar >= '0' && currentChar<='9'){
currentChar = readNextChar();
while(currentChar >= '0' && currentChar<='9'){
currentChar = readNextChar();
}

currentChar = readNextChar();
if (parse_aux_EXPONENT(currentChar)==TOKEN_aux_EXPONENT){
currentChar = readNextChar();
if (currentChar=='f'){
currentChar = readNextChar();
return TOKEN_FLOAT_LITERAL;
}if (currentChar=='F'){
currentChar = readNextChar();
return TOKEN_FLOAT_LITERAL;
}return TOKEN_DOUBLE_LITERAL;
}return TOKEN_DOUBLE_LITERAL;

}return parseError(TOKEN_DOUBLE_LITERAL,TOKEN_FLOAT_LITERAL);
case '-':
currentChar = readNextChar();
if(currentChar >= '0' && currentChar<='9'){
currentChar = readNextChar();
while(currentChar >= '0' && currentChar<='9'){
currentChar = readNextChar();
}

currentChar = readNextChar();
if (currentChar=='-'){
currentChar = readNextChar();
if(currentChar >= '0' && currentChar<='9'){
currentChar = readNextChar();
while(currentChar >= '0' && currentChar<='9'){
currentChar = readNextChar();
}

currentChar = readNextChar();
if (parse_aux_TIMEZONE(currentChar)==TOKEN_aux_TIMEZONE){
currentChar = readNextChar();
return TOKEN_DATE_LITERAL;
}if (currentChar=='T'){
currentChar = readNextChar();
if(currentChar >= '0' && currentChar<='9'){
currentChar = readNextChar();
while(currentChar >= '0' && currentChar<='9'){
currentChar = readNextChar();
}

currentChar = readNextChar();
if (currentChar==':'){
currentChar = readNextChar();
if(currentChar >= '0' && currentChar<='9'){
currentChar = readNextChar();
while(currentChar >= '0' && currentChar<='9'){
currentChar = readNextChar();
}

currentChar = readNextChar();
if (currentChar==':'){
currentChar = readNextChar();
if(currentChar >= '0' && currentChar<='9'){
currentChar = readNextChar();
while(currentChar >= '0' && currentChar<='9'){
currentChar = readNextChar();
}

currentChar = readNextChar();
if (parse_aux_TIMEZONE(currentChar)==TOKEN_aux_TIMEZONE){
currentChar = readNextChar();
return TOKEN_DATETIME_LITERAL;
}if (currentChar==':'){
currentChar = readNextChar();
if(currentChar >= '0' && currentChar<='9'){
currentChar = readNextChar();
while(currentChar >= '0' && currentChar<='9'){
currentChar = readNextChar();
}

currentChar = readNextChar();
if (parse_aux_TIMEZONE(currentChar)==TOKEN_aux_TIMEZONE){
currentChar = readNextChar();
return TOKEN_DATETIME_LITERAL;
}return parseError(TOKEN_DATETIME_LITERAL);

}return parseError(TOKEN_DATETIME_LITERAL);
}return parseError(TOKEN_DATETIME_LITERAL);

}return parseError(TOKEN_DATETIME_LITERAL);
}return parseError(TOKEN_DATETIME_LITERAL);

}return parseError(TOKEN_DATETIME_LITERAL);
}return parseError(TOKEN_DATETIME_LITERAL);

}return parseError(TOKEN_DATETIME_LITERAL);
}return parseError(TOKEN_DATETIME_LITERAL,TOKEN_DATE_LITERAL);

}return parseError(TOKEN_DATETIME_LITERAL,TOKEN_DATE_LITERAL);
}return parseError(TOKEN_DATETIME_LITERAL,TOKEN_DATE_LITERAL);

}return parseError(TOKEN_DATETIME_LITERAL,TOKEN_DATE_LITERAL);
}
if (parse_aux_EXPONENT(currentChar)==TOKEN_aux_EXPONENT){
currentChar = readNextChar();
if (currentChar=='f'){
currentChar = readNextChar();
return TOKEN_FLOAT_LITERAL;
}if (currentChar=='F'){
currentChar = readNextChar();
return TOKEN_FLOAT_LITERAL;
}return TOKEN_DOUBLE_LITERAL;
}return TOKEN_INT_LITERAL;

}if (currentChar=='.'){
currentChar = readNextChar();
if(currentChar >= '0' && currentChar<='9'){
currentChar = readNextChar();
while(currentChar >= '0' && currentChar<='9'){
currentChar = readNextChar();
}

currentChar = readNextChar();
if (currentChar=='f'){
currentChar = readNextChar();
return TOKEN_FLOAT_LITERAL;
}if (currentChar=='F'){
currentChar = readNextChar();
return TOKEN_FLOAT_LITERAL;
}return TOKEN_DOUBLE_LITERAL;

}return parseError(TOKEN_DOUBLE_LITERAL,TOKEN_FLOAT_LITERAL);
}if (currentChar=='D'){
currentChar = readNextChar();
if (parse_aux_DURATION_DATE_PART(currentChar)==TOKEN_aux_DURATION_DATE_PART){
currentChar = readNextChar();
if (parse_aux_DURATION_DATE_PART(currentChar)==TOKEN_aux_DURATION_DATE_PART){
currentChar = readNextChar();
if (parse_aux_DURATION_DATE_PART(currentChar)==TOKEN_aux_DURATION_DATE_PART){
currentChar = readNextChar();
if (currentChar=='T'){
currentChar = readNextChar();
if (parse_aux_DURATION_TIME_PART(currentChar)==TOKEN_aux_DURATION_TIME_PART){
currentChar = readNextChar();
if (parse_aux_DURATION_TIME_PART(currentChar)==TOKEN_aux_DURATION_TIME_PART){
currentChar = readNextChar();
if (parse_aux_DURATION_TIME_PART(currentChar)==TOKEN_aux_DURATION_TIME_PART){
currentChar = readNextChar();
return TOKEN_DURATION_LITERAL;
}return parseError(TOKEN_DURATION_LITERAL);
}return parseError(TOKEN_DURATION_LITERAL);
}return parseError(TOKEN_DURATION_LITERAL);
}return TOKEN_DURATION_LITERAL;
}return parseError(TOKEN_DURATION_LITERAL);
}return parseError(TOKEN_DURATION_LITERAL);
}return parseError(TOKEN_DURATION_LITERAL);
}return parseError(TOKEN_INT16_LITERAL,TOKEN_DOUBLE_LITERAL,TOKEN_DATETIME_LITERAL,TOKEN_INT64_LITERAL,TOKEN_INT_LITERAL,TOKEN_DURATION_LITERAL,TOKEN_DATE_LITERAL,TOKEN_INT8_LITERAL,TOKEN_INT32_LITERAL,TOKEN_FLOAT_LITERAL);
case '.':
currentChar = readNextChar();
if(currentChar >= '0' && currentChar<='9'){
currentChar = readNextChar();
while(currentChar >= '0' && currentChar<='9'){
currentChar = readNextChar();
}

currentChar = readNextChar();
if (currentChar=='f'){
currentChar = readNextChar();
return TOKEN_FLOAT_LITERAL;
}if (currentChar=='F'){
currentChar = readNextChar();
return TOKEN_FLOAT_LITERAL;
}return TOKEN_DOUBLE_LITERAL;

}return parseError(TOKEN_DOUBLE_LITERAL,TOKEN_FLOAT_LITERAL);
case 'D':
currentChar = readNextChar();
if (parse_aux_DURATION_DATE_PART(currentChar)==TOKEN_aux_DURATION_DATE_PART){
currentChar = readNextChar();
if (parse_aux_DURATION_DATE_PART(currentChar)==TOKEN_aux_DURATION_DATE_PART){
currentChar = readNextChar();
if (parse_aux_DURATION_DATE_PART(currentChar)==TOKEN_aux_DURATION_DATE_PART){
currentChar = readNextChar();
if (currentChar=='T'){
currentChar = readNextChar();
if (parse_aux_DURATION_TIME_PART(currentChar)==TOKEN_aux_DURATION_TIME_PART){
currentChar = readNextChar();
if (parse_aux_DURATION_TIME_PART(currentChar)==TOKEN_aux_DURATION_TIME_PART){
currentChar = readNextChar();
if (parse_aux_DURATION_TIME_PART(currentChar)==TOKEN_aux_DURATION_TIME_PART){
currentChar = readNextChar();
return TOKEN_DURATION_LITERAL;
}return parseError(TOKEN_DURATION_LITERAL);
}return parseError(TOKEN_DURATION_LITERAL);
}return parseError(TOKEN_DURATION_LITERAL);
}return TOKEN_DURATION_LITERAL;
}return parseError(TOKEN_DURATION_LITERAL);
}return parseError(TOKEN_DURATION_LITERAL);
}return parseError(TOKEN_DURATION_LITERAL);
case 'P':
currentChar = readNextChar();
if (parse_DOUBLE_LITERAL(currentChar)==TOKEN_DOUBLE_LITERAL){
currentChar = readNextChar();
if (currentChar==','){
currentChar = readNextChar();
if (parse_DOUBLE_LITERAL(currentChar)==TOKEN_DOUBLE_LITERAL){
currentChar = readNextChar();
if (currentChar=='R'){
currentChar = readNextChar();
if (parse_DOUBLE_LITERAL(currentChar)==TOKEN_DOUBLE_LITERAL){
currentChar = readNextChar();
return TOKEN_CIRCLE_LITERAL;
}return parseError(TOKEN_CIRCLE_LITERAL);
}if (currentChar==','){
currentChar = readNextChar();
if (parse_DOUBLE_LITERAL(currentChar)==TOKEN_DOUBLE_LITERAL){
currentChar = readNextChar();
return TOKEN_POINT3D_LITERAL;
}return parseError(TOKEN_POINT3D_LITERAL);
}if (parse_POINT_LITERAL(currentChar)==TOKEN_POINT_LITERAL){
currentChar = readNextChar();
if (parse_POINT_LITERAL(currentChar)==TOKEN_POINT_LITERAL){
currentChar = readNextChar();
return TOKEN_RECTANGLE_LITERAL;
}return TOKEN_LINE_LITERAL;
}return TOKEN_POINT_LITERAL;
}return parseError(TOKEN_LINE_LITERAL,TOKEN_RECTANGLE_LITERAL,TOKEN_POINT3D_LITERAL,TOKEN_POINT_LITERAL,TOKEN_CIRCLE_LITERAL);
}return parseError(TOKEN_LINE_LITERAL,TOKEN_RECTANGLE_LITERAL,TOKEN_POINT3D_LITERAL,TOKEN_POINT_LITERAL,TOKEN_CIRCLE_LITERAL);
}return parseError(TOKEN_LINE_LITERAL,TOKEN_RECTANGLE_LITERAL,TOKEN_POINT3D_LITERAL,TOKEN_POINT_LITERAL,TOKEN_CIRCLE_LITERAL);
}
if(currentChar >= '0' && currentChar<='9'){
currentChar = readNextChar();
while(currentChar >= '0' && currentChar<='9'){
currentChar = readNextChar();
}

currentChar = readNextChar();
switch(currentChar){
case 'i':
currentChar = readNextChar();
switch(currentChar){
case '8':
currentChar = readNextChar();
return TOKEN_INT8_LITERAL;
case '1':
currentChar = readNextChar();
if (currentChar=='6'){
currentChar = readNextChar();
return TOKEN_INT16_LITERAL;
}return parseError(TOKEN_INT16_LITERAL);
case '3':
currentChar = readNextChar();
if (currentChar=='2'){
currentChar = readNextChar();
return TOKEN_INT32_LITERAL;
}return parseError(TOKEN_INT32_LITERAL);
case '6':
currentChar = readNextChar();
if (currentChar=='4'){
currentChar = readNextChar();
return TOKEN_INT64_LITERAL;
}return parseError(TOKEN_INT64_LITERAL);
}
return parseError(TOKEN_INT16_LITERAL,TOKEN_INT64_LITERAL,TOKEN_INT8_LITERAL,TOKEN_INT32_LITERAL);
case '.':
currentChar = readNextChar();
if(currentChar >= '0' && currentChar<='9'){
currentChar = readNextChar();
while(currentChar >= '0' && currentChar<='9'){
currentChar = readNextChar();
}

currentChar = readNextChar();
if (parse_aux_EXPONENT(currentChar)==TOKEN_aux_EXPONENT){
currentChar = readNextChar();
if (currentChar=='f'){
currentChar = readNextChar();
return TOKEN_FLOAT_LITERAL;
}if (currentChar=='F'){
currentChar = readNextChar();
return TOKEN_FLOAT_LITERAL;
}return TOKEN_DOUBLE_LITERAL;
}return TOKEN_DOUBLE_LITERAL;

}return parseError(TOKEN_DOUBLE_LITERAL,TOKEN_FLOAT_LITERAL);
case ':':
currentChar = readNextChar();
if(currentChar >= '0' && currentChar<='9'){
currentChar = readNextChar();
while(currentChar >= '0' && currentChar<='9'){
currentChar = readNextChar();
}

currentChar = readNextChar();
if (currentChar==':'){
currentChar = readNextChar();
if(currentChar >= '0' && currentChar<='9'){
currentChar = readNextChar();
while(currentChar >= '0' && currentChar<='9'){
currentChar = readNextChar();
}

currentChar = readNextChar();
if (parse_aux_TIMEZONE(currentChar)==TOKEN_aux_TIMEZONE){
currentChar = readNextChar();
return TOKEN_TIME_LITERAL;
}if (currentChar==':'){
currentChar = readNextChar();
if(currentChar >= '0' && currentChar<='9'){
currentChar = readNextChar();
while(currentChar >= '0' && currentChar<='9'){
currentChar = readNextChar();
}

currentChar = readNextChar();
if (parse_aux_TIMEZONE(currentChar)==TOKEN_aux_TIMEZONE){
currentChar = readNextChar();
return TOKEN_TIME_LITERAL;
}return parseError(TOKEN_TIME_LITERAL);

}return parseError(TOKEN_TIME_LITERAL);
}return parseError(TOKEN_TIME_LITERAL);

}return parseError(TOKEN_TIME_LITERAL);
}return parseError(TOKEN_TIME_LITERAL);

}return parseError(TOKEN_TIME_LITERAL);
case '-':
currentChar = readNextChar();
if(currentChar >= '0' && currentChar<='9'){
currentChar = readNextChar();
while(currentChar >= '0' && currentChar<='9'){
currentChar = readNextChar();
}

currentChar = readNextChar();
if (currentChar=='-'){
currentChar = readNextChar();
if(currentChar >= '0' && currentChar<='9'){
currentChar = readNextChar();
while(currentChar >= '0' && currentChar<='9'){
currentChar = readNextChar();
}

currentChar = readNextChar();
if (parse_aux_TIMEZONE(currentChar)==TOKEN_aux_TIMEZONE){
currentChar = readNextChar();
return TOKEN_DATE_LITERAL;
}if (currentChar=='T'){
currentChar = readNextChar();
if(currentChar >= '0' && currentChar<='9'){
currentChar = readNextChar();
while(currentChar >= '0' && currentChar<='9'){
currentChar = readNextChar();
}

currentChar = readNextChar();
if (currentChar==':'){
currentChar = readNextChar();
if(currentChar >= '0' && currentChar<='9'){
currentChar = readNextChar();
while(currentChar >= '0' && currentChar<='9'){
currentChar = readNextChar();
}

currentChar = readNextChar();
if (currentChar==':'){
currentChar = readNextChar();
if(currentChar >= '0' && currentChar<='9'){
currentChar = readNextChar();
while(currentChar >= '0' && currentChar<='9'){
currentChar = readNextChar();
}

currentChar = readNextChar();
if (parse_aux_TIMEZONE(currentChar)==TOKEN_aux_TIMEZONE){
currentChar = readNextChar();
return TOKEN_DATETIME_LITERAL;
}if (currentChar==':'){
currentChar = readNextChar();
if(currentChar >= '0' && currentChar<='9'){
currentChar = readNextChar();
while(currentChar >= '0' && currentChar<='9'){
currentChar = readNextChar();
}

currentChar = readNextChar();
if (parse_aux_TIMEZONE(currentChar)==TOKEN_aux_TIMEZONE){
currentChar = readNextChar();
return TOKEN_DATETIME_LITERAL;
}return parseError(TOKEN_DATETIME_LITERAL);

}return parseError(TOKEN_DATETIME_LITERAL);
}return parseError(TOKEN_DATETIME_LITERAL);

}return parseError(TOKEN_DATETIME_LITERAL);
}return parseError(TOKEN_DATETIME_LITERAL);

}return parseError(TOKEN_DATETIME_LITERAL);
}return parseError(TOKEN_DATETIME_LITERAL);

}return parseError(TOKEN_DATETIME_LITERAL);
}return parseError(TOKEN_DATETIME_LITERAL,TOKEN_DATE_LITERAL);

}return parseError(TOKEN_DATETIME_LITERAL,TOKEN_DATE_LITERAL);
}return parseError(TOKEN_DATETIME_LITERAL,TOKEN_DATE_LITERAL);

}return parseError(TOKEN_DATETIME_LITERAL,TOKEN_DATE_LITERAL);
}
if (parse_aux_EXPONENT(currentChar)==TOKEN_aux_EXPONENT){
currentChar = readNextChar();
if (currentChar=='f'){
currentChar = readNextChar();
return TOKEN_FLOAT_LITERAL;
}if (currentChar=='F'){
currentChar = readNextChar();
return TOKEN_FLOAT_LITERAL;
}return TOKEN_DOUBLE_LITERAL;
}return TOKEN_INT_LITERAL;

}return parseError(TOKEN_INT8_CONS,TOKEN_RECTANGLE_LITERAL,TOKEN_RECTANGLE_CONS,TOKEN_STRING_LITERAL,TOKEN_CONSTRUCTOR_OPEN,TOKEN_DATETIME_LITERAL,TOKEN_INT_LITERAL,TOKEN_DATE_LITERAL,TOKEN_INT16_CONS,TOKEN_FALSE_LITERAL,TOKEN_CIRCLE_LITERAL,TOKEN_LINE_LITERAL,TOKEN_END_UNORDERED_LIST,TOKEN_TRUE_LITERAL,TOKEN_POINT3D_LITERAL,TOKEN_INT64_LITERAL,TOKEN_POLYGON_CONS,TOKEN_START_RECORD,TOKEN_DURATION_CONS,TOKEN_BOOLEAN_CONS,TOKEN_CIRCLE_CONS,TOKEN_LINE_CONS,TOKEN_INT32_LITERAL,TOKEN_FLOAT_LITERAL,TOKEN_DOUBLE_LITERAL,TOKEN_START_ORDERED_LIST,TOKEN_COLON,TOKEN_TIME_CONS,TOKEN_TIME_LITERAL,TOKEN_END_RECORD,TOKEN_POINT3D_CONS,TOKEN_FLOAT_CONS,TOKEN_END_ORDERED_LIST,TOKEN_INT16_LITERAL,TOKEN_COMMA,TOKEN_DATETIME_CONS,TOKEN_START_UNORDERED_LIST,TOKEN_POINT_CONS,TOKEN_DATE_CONS,TOKEN_INT32_CONS,TOKEN_POINT_LITERAL,TOKEN_DURATION_LITERAL,TOKEN_DOUBLE_CONS,TOKEN_INT8_LITERAL,TOKEN_NULL_LITERAL,TOKEN_CONSTRUCTOR_CLOSE,TOKEN_STRING_CONS,TOKEN_INT64_CONS);

    }

// ================================================================================
//  Public interface
// ================================================================================
    
    public AdmFastLexer(java.io.Reader stream) throws IOException{
        reInit(stream);
    }

    public void reInit(java.io.Reader stream) throws IOException{
        done();
        inputStream    = stream;
        bufsize        = 4096;
        line           = 1;
        column         = 0;
        bufpos         = -1;
        endOf_UNUSED_Buffer = bufsize;
        endOf_USED_Buffer = 0;
        prevCharIsCR   = false;
        prevCharIsLF   = false;
        buffer         = new char[bufsize];
        tokenBegin     = -1;
        maxUnusedBufferSize = 4096/2;
        readNextChar();
    }

    public String getLastTokenImage() {
        if (bufpos >= tokenBegin)
            return new String(buffer, tokenBegin, bufpos - tokenBegin);
          else
            return new String(buffer, tokenBegin, bufsize - tokenBegin) +
                                  new String(buffer, 0, bufpos);
    }
    
    public static String tokenKindToString(int token) {
        return tokenImage[token]; 
    }

    public void done(){
        buffer = null;
    }

// ================================================================================
//  Parse error management
// ================================================================================    
    
    protected int parseError(String reason) throws AdmFastLexerException {
        StringBuilder message = new StringBuilder();
        message.append(reason).append("\n");
        message.append("Line: ").append(line).append("\n");
        message.append("Row: ").append(column).append("\n");
        throw new AdmFastLexerException(message.toString());
    }

    protected int parseError(int ... tokens) throws AdmFastLexerException {
        StringBuilder message = new StringBuilder();
        message.append("Error while parsing. ");
        message.append(" Line: ").append(line);
        message.append(" Row: ").append(column);
        message.append(" Expecting:");
        for (int tokenId : tokens){
            message.append(" ").append(AdmFastLexer.tokenKindToString(tokenId));
        }
        throw new AdmFastLexerException(message.toString());
    }
    
    protected void updateLineColumn(char c){
        column++;
    
        if (prevCharIsLF)
        {
            prevCharIsLF = false;
            line += (column = 1);
        }
        else if (prevCharIsCR)
        {
            prevCharIsCR = false;
            if (c == '\n')
            {
                prevCharIsLF = true;
            }
            else
            {
                line += (column = 1);
            }
        }
        
        if (c=='\r') {
            prevCharIsCR = true;
        } else if(c == '\n') {
            prevCharIsLF = true;
        }
    }
    
// ================================================================================
//  Read data buffer management
// ================================================================================    

    protected char readNextChar() throws IOException {
        if (++bufpos >= endOf_USED_Buffer)
            fillBuff();
        char c = buffer[bufpos];
        updateLineColumn(c);
        return c;
    }

    protected boolean fillBuff() throws IOException {
        if (endOf_UNUSED_Buffer == endOf_USED_Buffer) // If no more unused buffer space 
        {
          if (endOf_UNUSED_Buffer == bufsize)         // -- If the previous unused space was
          {                                           // -- at the end of the buffer
            if (tokenBegin > maxUnusedBufferSize)     // -- -- If the first N bytes before
            {                                         //       the current token are enough
              bufpos = endOf_USED_Buffer = 0;         // -- -- -- setup buffer to use that fragment 
              endOf_UNUSED_Buffer = tokenBegin;
            }
            else if (tokenBegin < 0)                  // -- -- If no token yet
              bufpos = endOf_USED_Buffer = 0;         // -- -- -- reuse the whole buffer
            else
              ExpandBuff(false);                      // -- -- Otherwise expand buffer after its end
          }
          else if (endOf_UNUSED_Buffer > tokenBegin)  // If the endOf_UNUSED_Buffer is after the token
            endOf_UNUSED_Buffer = bufsize;            // -- set endOf_UNUSED_Buffer to the end of the buffer
          else if ((tokenBegin - endOf_UNUSED_Buffer) < maxUnusedBufferSize)
          {                                           // If between endOf_UNUSED_Buffer and the token
            ExpandBuff(true);                         // there is NOT enough space expand the buffer                          
          }                                           // reorganizing it
          else 
            endOf_UNUSED_Buffer = tokenBegin;         // Otherwise there is enough space at the start
        }                                             // so we set the buffer to use that fragment
        int i;
        if ((i = inputStream.read(buffer, endOf_USED_Buffer, endOf_UNUSED_Buffer - endOf_USED_Buffer)) == -1)
        {
            inputStream.close();
            buffer[endOf_USED_Buffer]=(char)EOF_CHAR;
            endOf_USED_Buffer++;
            return false;
        }
            else
                endOf_USED_Buffer += i;
        return true;
    }


    protected void ExpandBuff(boolean wrapAround)
    {
      char[] newbuffer = new char[bufsize + maxUnusedBufferSize];

      try {
        if (wrapAround) {
          System.arraycopy(buffer, tokenBegin, newbuffer, 0, bufsize - tokenBegin);
          System.arraycopy(buffer, 0, newbuffer, bufsize - tokenBegin, bufpos);
          buffer = newbuffer;
          endOf_USED_Buffer = (bufpos += (bufsize - tokenBegin));
        }
        else {
          System.arraycopy(buffer, tokenBegin, newbuffer, 0, bufsize - tokenBegin);
          buffer = newbuffer;
          endOf_USED_Buffer = (bufpos -= tokenBegin);
        }
      } catch (Throwable t) {
          throw new Error(t.getMessage());
      }

      bufsize += maxUnusedBufferSize;
      endOf_UNUSED_Buffer = bufsize;
      tokenBegin = 0;
    }    
}
