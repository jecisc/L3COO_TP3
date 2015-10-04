DES = -d classes
DESDOC= -d docs
CHE = -classpath classes
CC = javac
COMPIL= -classpath src src/**/*.java
RUN = java -cp classes
RUNJAR=java -jar 
DOC = javadoc -classpath src -subpackages 
JAR = jar cvfm
MANIFEST= manifest-ex . -C classes .
TST= java -jar test.jar
CCTST= -classpath test.jar test/test/*.java
TP1= v1
TP2= v2
TP3= v3
SRC= v1 v2 v3
ALL= compil doc tst jar runJar
ARG=

all: $(ALL)

doc:  
	@mkdir -p docs
	$(DOC) $(SRC) $(DESDOC)

compil:
	$(CC) $(DES) $(COMPIL)


jar: 	
	@make compil
	$(JAR) $(TP1).jar $(MANIFEST)
	
tst:
	$(CC) $(CCTST)
	$(TST) test.*Test

run:
	$(RUN) run.Pool

runJar:
	$(RUNJAR) $(TP).jar $(ARG)

help: 
	@echo "You can use :"
	@echo "compil : compil all the .java of the project."
	@echo "doc : product the doc of the project."
	@echo "tst : /!\ USE compil BEFORE tst !! /!\ compile the test an launch all the test."
	@echo "jar : /!\ USE compil BEFORE jar !! /!\ product a jar of the project. You can execut this jar with the command \"make runJar\"."
	@echo "run : /!\ USE compil BEFORE runJar !! /!\ execut the jar. 
	@echo "runJar : /!\ USE jar BEFORE runJar !! /!\ execut the jar. 
	@echo "help : help with the Make file."
	@echo "clean : Clean all the folders. (.class, Project.jar, temp files, doc...)"

.PHONY: clean

clean:
	@rm -rf classes/* docs/* test/test/*.class *~ */*~ */*/*~ */*/*/*~ $(TP1).jar $(TP2).jar $(TP3).jar
