##
## KhalidCEU, 2024
## Makefile
## File description:
## Makefile
##

MAIN_DIR	=	app

MAIN_CLASS	=	$(MAIN_DIR).Main

SRC_DIR		=	./src

NAME		=	a.out

OUT_DIR		=	bin

LIB_DIR		=	./lib

DOC_DIR		=	html

JAR_FILE	=	$(MAIN_DIR).jar

all: executable

compile: clean
	mkdir $(OUT_DIR)
	find $(SRC_DIR) -name *.java | xargs javac -cp $(OUT_DIR):$(LIB_DIR) -d $(OUT_DIR)

executable: compile
	@echo '#!/bin/sh' > ./a.out
	@echo 'java -cp $(OUT_DIR) $(MAIN_CLASS) "$$@"' >> $(NAME)
	@chmod +x $(NAME)

manifest:
	@echo "Manifest-Version: 1.0" > manifest.txt
	@echo "Main-Class: $(MAIN_CLASS)" >> manifest.txt
	@echo "Class-Path: ." >> manifest.txt
	@echo "" >> manifest.txt

jar: manifest compile
	mkdir -p $(dir $(JAR_FILE))
	jar cvfm $(JAR_FILE) manifest.txt -C $(OUT_DIR) .

runjar: jar
	java -jar $(JAR_FILE)

javadoc: compile
	find . -type f -name "*.java" | xargs javadoc -d $(DOC_DIR) -encoding utf-8 -docencoding utf-8 -charset utf-8

debug: compile
	find $(SRC_DIR) -name *.java | xargs javac -g -cp $(OUT_DIR):$(LIB_DIR) -d $(OUT_DIR)
	cd bin; jdb -sourcepath ../src

re: clean all

clean:
	rm -rf $(OUT_DIR)
	rm -rf $(DOC_DIR)
	rm -f $(JAR_FILE)
	rm -f *.dat

fclean: clean
	rm -f $(NAME)