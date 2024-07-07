# WC Tool

This is a Java implementation of the `wc` (word count) tool, developed as part of a coding challenge from [Coding Challenges](https://codingchallenges.fyi/challenges/challenge-wc#step-one).

## Features

- Count the number of lines, words, and bytes in a file.
- Read input from a file specified as a command-line argument.

## Learning Outcomes

During the development of this project, I learned the following:

- How to use `BufferedReader` for efficient reading of text files.
- How to use `FileInputStream` for reading files at the byte level.
- Handling command-line arguments in Java.

## Usage

### Compile

To compile the program, run:

```sh
javac Main.java
```
### Command

To count lines, words, and bytes in a file, specify the filename as a command-line argument:

```sh
java Main ccwc <path to your file>
```



## Performance Considerations

### BufferedReader

`BufferedReader` reads data from the disk and stores it in a buffer (RAM memory).

Pros: Fast for reading text data because it minimizes disk I/O operations by reading larger chunks of data at once.

Cons: Not suitable for counting the exact number of bytes, as it reads data as characters, which can vary in size depending on the character encoding.

### FileInputStream 

`FileInputStream` reads data from the disk byte by byte.

Pros: Accurate for counting the exact number of bytes.

Cons: Slower for reading large text files compared to BufferedReader because it performs more disk I/O operations.

### Reason for Choice
We used FileInputStream instead of BufferedReader to count the number of bytes to ensure precise byte counting, despite the slower performance for large files.

## Acknowledgements
Thanks to [Coding Challenges](https://codingchallenges.fyi) for providing the challenge and guidance for this project.





