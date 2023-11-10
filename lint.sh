sudo docker run -e RUN_LOCAL=true -e USE_FIND_ALGORITHM=true -e VALIDATE_GOOGLE_JAVA_FORMAT=true -e VALIDATE_JAVA=true -v $(pwd)/src/:/tmp/lint github/super-linter
