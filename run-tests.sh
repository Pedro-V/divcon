#!/bin/bash

javac -cp bin/:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar -d bin/ src/divcon/*.java && 
javac -cp bin/:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar -d bin/ src/test/*.java &&
java -cp lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar:bin/ org.junit.runner.JUnitCore test.ParticipanteTest test.PagamentoTest test.ContaColetivaTest