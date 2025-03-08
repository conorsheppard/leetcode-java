SHELL := /bin/bash

default: test

test:
	./shell/test.sh

.SILENT:
.PHONY: default test
