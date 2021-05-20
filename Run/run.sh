#!/bin/bash

NC='tput sgr0'
Red='tput setaf 1'
Green='tput setaf 2'
Yellow='tput setaf 3'
Blue='tput setaf 4'

for i in $(ls -d TC/*.in)
do
    i=${i%%.in}
    echo -e "===== $i ====="

    # echo -e "=====  Results  ====="
    output=$(python3 solve.py < $i.in)
    expected=$(cat $i.out)
    if [ $output -eq $expected ]
    then
        echo ": Correct"
    else
        echo ": Wrong"
        echo -e "===== Input ====="
        echo "$(cat $i.in)"
        echo -e "===== Output ===="
        echo "Expected output was '$($Red)$expected$(${NC})', but your output was '$($Blue)$output$(${NC})'."
    fi

    echo ""
done