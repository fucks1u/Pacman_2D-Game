current_dir= $(bash pwd)

.PHONY: help

lint: ## Lint the codebase using super linter
	docker run -e RUN_LOCAL=true -e USE_FIND_ALGORITHM=true -e VALIDATE_GOOGLE_JAVA_FORMAT=true -e VALIDATE_JAVA=true -v $(current_dir)/src:/tmp/lint github/super-linter

run: compile execute ## Run program 

compile: ## Compile source code
	javac -d ./dist ./src/main/Main.java

execute: ## Execute main
	java -cp ./dist main.Main

help:
	@echo "T-JAV-501"
	@cat $(MAKEFILE_LIST) | grep -e "^[a-zA-Z_\-]*: *.*## *" | awk 'BEGIN {FS = ":.*?## "}; {printf "\033[36m%-30s\033[0m %s\n", $$1, $$2}'
	@echo ""