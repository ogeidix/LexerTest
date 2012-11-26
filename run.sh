
 #!/bin/bash
echo "Compiling..."
javac $(find ./src/* | grep .java)
echo "Executing..."
java -classpath src/ com.ogeidix.lexertest.LexerSpeedTest