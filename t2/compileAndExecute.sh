#!/bin/bash

javac *.java -cp .:./commons-io-2.5.jar ; java -cp .:./commons-io-2.5.jar DigestCalculator
