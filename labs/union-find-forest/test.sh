#!/usr/bin/env bash

name=union-find-forest
files="main.cpp tree/tree_node.cpp"
cc=g++

$cc -Ofast $files -o $name

tests=$(find ./../../$name/ -name *.in)
tests=$(echo $tests | tr " " "\n" | sort)

for test in $tests
do
    test=${test%.in}
    test_name=${test##*/}
    ./$name < "${test}.in" > "${name}.out"
    error=$(diff "${test}.out" "${name}.out")
    if [[ -n $error ]]; then
        echo "test ${test_name} failed"
        echo "input:"
        cat "${test}.in"
        echo "output must be:"
        cat "${test}.out"
        echo "got:"
        cat "${name}.out"
        break
    else
        echo "test ${test_name} passed"
    fi
done

rm "${name}.out"
rm $name
