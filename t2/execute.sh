#!/bin/bash

java -cp .:./commons-io-2.5.jar:./commons-codec-1.10.jar DigestCalculator "$@"
