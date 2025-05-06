#!/usr/bin/env bash

javac -d out src/com/example/Application.java src/com/example/MyIssue.java
java -cp out com.example.Application
