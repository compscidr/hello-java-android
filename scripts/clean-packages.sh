#!/bin/bash

# this is a bit complicated because bash isn't great at handling pipes, all of this just gets the
# number of devices that adb is showing into the NUM_DEVICES variable See:
# https://unix.stackexchange.com/questions/338000/bash-assign-output-of-pipe-to-a-variable
countDevices() {
  timeout 20 adb devices | sed '1d' | sed '$d' | awk '{print $1}' | wc -l
}
{ read -d '' count_device; } < <(countDevices)

NUM_DEVICES=${count_device}
if [ $NUM_DEVICES -lt 1 ]; then
    echo "This test request at least one device, we found $NUM_DEVICES"
    exit 1
fi

for DEVICE in $(adb devices | sed '1d' | sed '$d' | awk '{print $1}'); do
    timeout 20 adb -s $DEVICE wait-for-device
    for i in $(adb -s $DEVICE shell pm list packages -f | grep com.example.myapplication | sed -n 's/^.*\/base.apk=//p'); do
        adb -s $DEVICE uninstall --user 0 $i
    done
done