package com.ogeidix.lexertest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.ogeidix.lexertest.Lexer;

import edu.uci.ics.asterix.adm.parser.nontagged.AdmLexerWrapper;
import edu.uci.ics.asterix.external.data.parser.admfast.AdmFastLexer;

public class LexerSpeedTest {

    
    public static void main(String[] args) throws Exception {
        if (args.length == 1 && args[0]=="--help"){
            System.out.println("Usage: LexerSpeedTest <file-to-parse>");
            System.out.println("File already available: ");
            System.out.println("  1M - data/eventBig.adm");
            System.out.println("100M - data/eventBigger.adm  *default");
            System.out.println("  1G - data/eventBiggest.adm");
            return;
        }
        
        String file;  

        if (args.length > 0){
            file = args[0];
        } else {
            file = "data/eventBigger.adm";
        }
        
        long admJavaCC = testSpeedOfLexer(new AdmLexerWrapper(new FileReader(file)));
        System.out.println("AdmLexer by JavaCC: ");
        printResult(admJavaCC);
        
        long admFast   = testSpeedOfLexer(new AdmFastLexer(new FileReader(file)));
        System.out.println("AdmLexer by LexerGenerator: ");
        printResult(admFast);        
    }
    
    private static long testSpeedOfLexer(Lexer lexer) throws Exception {
        cleanFSCache();
        int token=-1;
        long start = System.currentTimeMillis(); 
        while(token != AdmFastLexer.TOKEN_EOF){
            token = lexer.next();
            //System.out.println(AdmFastLexer.tokenKindToString(token));
        }
        long time = System.currentTimeMillis() - start;
        return time;
    }

    private static void printResult(long time) {
        System.out.print(time);
        System.out.println(" ms");
    }

    private static void cleanFSCache() throws IOException{
        System.out.println("sudo clean_fs_cache.sh");
        Runtime rt = Runtime.getRuntime();
        Process pr = rt.exec("sudo clean_fs_cache.sh");
        BufferedReader input = new BufferedReader(new InputStreamReader(pr.getInputStream()));
        String line=null;
        while((line=input.readLine()) != null) {
            System.out.println(line);
        }
        return;
    }
}
