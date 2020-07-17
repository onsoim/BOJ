cd cpp/01000-10000

for FILE in $(ls -p | grep -v '/$' | cut -c1-5)
do
    mkdir "$FILE"
    mv "$FILE.py" "$FILE/$FILE.py"
done

cd ../../

##################################################

cd cpp/10001-20000

for FILE in $(ls -p | grep -v '/$' | cut -c1-5)
do
    mkdir "$FILE"
    mv "$FILE.cpp" "$FILE/$FILE.cpp"
done

cd ../../

##################################################

cd python/01000-10000

for FILE in $(ls -p | grep -v '/$' | cut -c1-5)
do
    mkdir "$FILE"
    mv "$FILE.py" "$FILE/$FILE.py"
done

cd ../../

##################################################

cd python/10001-20000

for FILE in $(ls -p | grep -v '/$' | cut -c1-5)
do
    mkdir "$FILE"
    mv "$FILE.py" "$FILE/$FILE.py"
done

cd ../../