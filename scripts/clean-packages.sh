#!/bin/bash
set -e

timeout 20 adb wait-for-device

for DEVICE in $(adb devices | sed '1d' | sed '$d' | awk '{print $1}'); do
    timeout 20 adb -s $DEVICE wait-for-device
    for i in $(adb -s $DEVICE shell pm list packages -f | grep com.example.myapplication | sed -n 's/^.*\/base.apk=//p'); do
        adb -s $DEVICE uninstall --user 0 $i
    done
done