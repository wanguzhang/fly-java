#!/bin/bash
a=$1
b=0
port=$2
if [ $a  ] && [ $a -gt 0 ]
then
  echo "循环次数${a}"
else
  echo "没有合法的循环次数"
  exit 1
fi

if [ $port ] && [ $port -gt 0 ]
then
  echo "端口${a}"
else
  echo "没有传合法的端口"
  exit 1
fi

for((integer = 1; integer <= $a ; integer++))
do
     open -a iTerm ./nc-test.sh
done