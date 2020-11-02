#!/bin/bash
rm -fr /github/nio/out.*
cd /github/target/classes
strace -ff -o /github/nio/out java com.fly.juc.ThradStateDemo