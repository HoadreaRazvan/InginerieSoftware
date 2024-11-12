[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/WMkZqAVw)
# Extract and sort the words from a text file

## The assignment

Read all the words from a file whose name is received as a parameter.
Write all the words in lowercase, sorted alphabetically ascending and deduplicated 
in a file whose name is received as a parameter. Write each word on a new line.

Modify only the contents of the "extractWords" method from the Main class. The input and output filenames will be 
received as parameters to that method.

You can run the tests locally to see if the solution is correct before pushing the commit. See the bottom of the 
readme file.

#### Example:

`input.txt`
```
lorem ipsum dolor sit sit 
amet sit amet dolor
lorem sit lorem
```

The expected contents of `output.txt`

```
amet
dolor
ipsum
lorem
sit
```

### Setup command
`N/A`

### Run command
`gradle test`
