#!/usr/bin/env sh
first_device=`adb devices | awk  'NR==2' | awk  '{print $1}'`
packageName="com.example.jetpackcompose"
echo "apk will install to "$first_device
adb -s $first_device uninstall $packageName
sleep 1
gradle -q app:installDebug -x lint --parallel --offline --continue &&
adb -s $first_device shell am start $packageName/.MainActivity
