engTokenizer
============

This projects includes a simple English tokenizer and a vocabulary maker.

How to run the program:

1. Put the English text that need tokenizing in the same directory of the program;

2. Run the command: cat filename | ./eng_tokenizer.sh > filename.tok to get the tokenized text;

3. Run the command: cat filename.tok | ./make_voc.sh > filename.tok.voc to get the vocabulary of the tokenized text;

4. Run the command: cat filename | ./make_voc.sh > filename.voc to get the vocabulary of the original text.
