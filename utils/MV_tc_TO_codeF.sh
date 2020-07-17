cd testcase

for Folder in $(ls)
do
    for FILE in $(ls "$Folder")
    do
        mv "$Folder/$FILE" "../solved/10001-20000/$Folder/"
    done
done