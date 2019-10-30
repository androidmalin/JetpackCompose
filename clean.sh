#!/usr/bin/env sh
#gradle wrapper --gradle-version 5.6.3 --distribution-type all
rm -rf .idea/ .gradle/ 
find . -name "build" -type d | xargs rm -rf
find . -name "*.iml" -type f | xargs rm -rf
