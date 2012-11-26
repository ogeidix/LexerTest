package edu.uci.ics.asterix.adm.parser.nontagged;

import com.ogeidix.lexertest.Lexer;

public class AdmLexerWrapper implements Lexer{
    AdmLexer lexer;
    
    public AdmLexerWrapper(java.io.Reader stream) throws Exception {
        lexer = new AdmLexer(stream);        
    }
    
    @Override
    public int next() throws ParseException {
        Token nextToken = lexer.getNextToken();
        if (nextToken.kind == AdmLexerConstants.EOF){
            return 0;
        }
        return 100;
    }

}
