find . -name "*.class" -type f -delete && javac -d ./dist $(find ./src/main -name '*.java') && java -cp ./dist src.main.Main
