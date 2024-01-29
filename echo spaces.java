echo Enter 3 numbers with spaces in between
read a b c
s=$a
if [ $b -lt $s ]
then
s=$b
fi
if [ $c -lt $s ]
then
s=$c
fi
echo Smallest of $a $b $c is $s
