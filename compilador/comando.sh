#!/bin/bash

java -cp antlr-4.13.0-complete.jar:. org.antlr.v4.Tool Grammar.g4 -o ./src/main/java/br/edu/ufabc/compiler/parser -package br.edu.ufabc.compiler.parser
