/* Generated By:JavaCC: Do not edit this line. AdmLexerConstants.java */
package edu.uci.ics.asterix.adm.parser.nontagged;


/**
 * Token literal values and constants.
 * Generated by org.javacc.parser.OtherFilesGen#start()
 */
public interface AdmLexerConstants {

  /** End of File. */
  int EOF = 0;
  /** RegularExpression Id. */
  int NULL_LITERAL = 1;
  /** RegularExpression Id. */
  int TRUE_LITERAL = 2;
  /** RegularExpression Id. */
  int FALSE_LITERAL = 3;
  /** RegularExpression Id. */
  int BOOLEAN_CONS = 4;
  /** RegularExpression Id. */
  int CONSTRUCTOR_OPEN = 5;
  /** RegularExpression Id. */
  int CONSTRUCTOR_CLOSE = 6;
  /** RegularExpression Id. */
  int INT8_LITERAL = 7;
  /** RegularExpression Id. */
  int INT8_CONS = 8;
  /** RegularExpression Id. */
  int INT16_LITERAL = 9;
  /** RegularExpression Id. */
  int INT16_CONS = 10;
  /** RegularExpression Id. */
  int INT32_LITERAL = 11;
  /** RegularExpression Id. */
  int INT32_CONS = 12;
  /** RegularExpression Id. */
  int INT64_LITERAL = 13;
  /** RegularExpression Id. */
  int INT64_CONS = 14;
  /** RegularExpression Id. */
  int INT_LITERAL = 15;
  /** RegularExpression Id. */
  int CIRCLE_LITERAL = 16;
  /** RegularExpression Id. */
  int CIRCLE_CONS = 17;
  /** RegularExpression Id. */
  int TIMEZONE_LITERAL = 18;
  /** RegularExpression Id. */
  int DATE_LITERAL = 19;
  /** RegularExpression Id. */
  int DATE_CONS = 20;
  /** RegularExpression Id. */
  int TIME_LITERAL = 21;
  /** RegularExpression Id. */
  int TIME_CONS = 22;
  /** RegularExpression Id. */
  int DATETIME_LITERAL = 23;
  /** RegularExpression Id. */
  int DATETIME_CONS = 24;
  /** RegularExpression Id. */
  int DURATION_LITERAL = 25;
  /** RegularExpression Id. */
  int DURATION_CONS = 26;
  /** RegularExpression Id. */
  int DIGIT = 27;
  /** RegularExpression Id. */
  int DOUBLE_LITERAL = 28;
  /** RegularExpression Id. */
  int EXPONENT = 29;
  /** RegularExpression Id. */
  int INTEGER = 30;
  /** RegularExpression Id. */
  int FLOAT_LITERAL = 31;
  /** RegularExpression Id. */
  int FLOAT_CONS = 32;
  /** RegularExpression Id. */
  int DOUBLE_CONS = 33;
  /** RegularExpression Id. */
  int STRING_LITERAL = 34;
  /** RegularExpression Id. */
  int EscapeQuot = 35;
  /** RegularExpression Id. */
  int STRING_CONS = 36;
  /** RegularExpression Id. */
  int POINT_LITERAL = 37;
  /** RegularExpression Id. */
  int POINT_CONS = 38;
  /** RegularExpression Id. */
  int POINT3D_LITERAL = 39;
  /** RegularExpression Id. */
  int POINT3D_CONS = 40;
  /** RegularExpression Id. */
  int LINE_LITERAL = 41;
  /** RegularExpression Id. */
  int LINE_CONS = 42;
  /** RegularExpression Id. */
  int POLYGON_LITERAL = 43;
  /** RegularExpression Id. */
  int POLYGON_CONS = 44;
  /** RegularExpression Id. */
  int RECTANGLE_CONS = 45;
  /** RegularExpression Id. */
  int RECTANGLE_LITERAL = 46;
  /** RegularExpression Id. */
  int START_RECORD = 47;
  /** RegularExpression Id. */
  int END_RECORD = 48;
  /** RegularExpression Id. */
  int COMMA = 49;
  /** RegularExpression Id. */
  int COLON = 50;
  /** RegularExpression Id. */
  int START_ORDERED_LIST = 51;
  /** RegularExpression Id. */
  int END_ORDERED_LIST = 52;
  /** RegularExpression Id. */
  int START_UNORDERED_LIST = 53;
  /** RegularExpression Id. */
  int END_UNORDERED_LIST = 54;

  /** Lexical state. */
  int DEFAULT = 0;

  /** Literal token values. */
  String[] tokenImage = {
    "<EOF>",
    "\"null\"",
    "\"true\"",
    "\"false\"",
    "\"boolean\"",
    "\"(\"",
    "\")\"",
    "<INT8_LITERAL>",
    "\"int8\"",
    "<INT16_LITERAL>",
    "\"int16\"",
    "<INT32_LITERAL>",
    "\"int32\"",
    "<INT64_LITERAL>",
    "\"int64\"",
    "<INT_LITERAL>",
    "<CIRCLE_LITERAL>",
    "\"circle\"",
    "<TIMEZONE_LITERAL>",
    "<DATE_LITERAL>",
    "\"date\"",
    "<TIME_LITERAL>",
    "\"time\"",
    "<DATETIME_LITERAL>",
    "\"datetime\"",
    "<DURATION_LITERAL>",
    "\"duration\"",
    "<DIGIT>",
    "<DOUBLE_LITERAL>",
    "<EXPONENT>",
    "<INTEGER>",
    "<FLOAT_LITERAL>",
    "\"float\"",
    "\"double\"",
    "<STRING_LITERAL>",
    "\"\\\\\\\"\"",
    "\"string\"",
    "<POINT_LITERAL>",
    "\"point\"",
    "<POINT3D_LITERAL>",
    "\"point3d\"",
    "<LINE_LITERAL>",
    "\"line\"",
    "<POLYGON_LITERAL>",
    "\"polygon\"",
    "\"rectangle\"",
    "<RECTANGLE_LITERAL>",
    "\"{\"",
    "\"}\"",
    "\",\"",
    "\":\"",
    "\"[\"",
    "\"]\"",
    "\"{{\"",
    "\"}}\"",
    "\" \"",
    "\"\\t\"",
    "\"\\r\"",
    "\"\\n\"",
  };

}