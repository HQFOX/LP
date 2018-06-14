# alterar para o caminho onde estao os ficheiros
TOOLS=~/

JAVA = java
JAVAFLAGS =
JAVAC = javac
JAVACFLAGS =

JCLASSPATH = .:$(TOOLS)

CUP = java -classpath $(JCLASSPATH) java_cup/Main
CUPFLAGS =

JLEX = java -classpath $(JCLASSPATH) JLex/Main
JLEXFLAGS =

CLASSES = parser.class Yylex.class \
	  Main.class CIMS.class
	  # etc ...

INTERMEDIATE_FILES = CIMS.lex.java sym.java parser.java Yylex.java

.INTERMEDIATE: sym.java
.SECONDARY: CIMS.lex.java Yylex.java

.PHONY: all clean run

%.class: %.java
	CLASSPATH=$(JCLASSPATH) $(JAVAC) $(JAVACFLAGS) $<

all: $(CLASSES)

Main.class: Main.java CIMS.class parser.class

parser.java sym.java: CIMS.cup
	$(CUP) $(CUPFLAGS) $<
	@[ -s $@ ] || { rm -f $@; exit 1; }

parser.class: parser.java Yylex.class
	CLASSPATH=$(JCLASSPATH) $(JAVAC) $(JAVACFLAGS) $<

sym.class: sym.java

CIMS.lex.java: CIMS.lex
	$(JLEX) $(JLEXFLAGS) $<
	
Yylex.java:
	ln -sf CIMS.lex.java $@

Yylex.class: Yylex.java CIMS.lex.java sym.class
	CLASSPATH=$(JCLASSPATH) $(JAVAC) $(JAVACFLAGS) $<

tools:
	javac JLex/Main.java
	javac java_cup/Main.java

cleantools:
	$(RM) JLex/*.class java_cup/*.class java_cup/runtime/*.class

clean:
	$(RM) $(INTERMEDIATE_FILES)
	$(RM) *.class *~

run:
	CLASSPATH=$(JCLASSPATH) $(JAVA) $(JAVAFLAGS) Main
