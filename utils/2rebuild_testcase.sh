cd testcase

for FILE in $(ls -p | grep -v '/$' | cut -c1-5 | sort -u)
do
    mkdir "$FILE"
    for F in $(ls -p | grep -v '/$' | grep "$FILE")
    do
        mv "$F" "$FILE"
    done
done
