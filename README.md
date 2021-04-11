# League Standing Printer

## Requirements
Create a command-line application that will calculate the ranking table for a league and print it in an ordered fashion to a terminal or console.

## Input
Match result data will be provided using a text file in the following format:

```
Team 0, Team 0
Team 0, Team 0
```

Where "Team" is the team name and "0" is the team score. 
A comma will be used to delimit the teams name and score for the match result. 
Whitespace is used to delimit the team name and score.

## Business Rules

Points are allocated to the teams in the league based on the results of the matches they play. Points are allocated as follows:

|Result |Points Allocation|
|-------|----------------:|
|WIN    |3                |
|TIE    |1                |
|LOSS   |0                |

While it has been stipulated that the input file will always be well formatted, defensive programming rules have been 
applied in the event that the file data is not well formatted.

## Expected Output

The output is expected to be ordered from team with the highest number of points to the lowest number of points. Should
a team have the same number of points, the teams with the same number of points are to be sorted alphabetically.

1. Tarantulas, 6 pts
2. Lions, 5 pts
3. FC Awesome, 1 pt
3. Snakes, 1 pt
5. Grouches, 0 pts

## Usage of the provided solution.

Locate the compiled jar file. Based on the gradle build configuration, the file will be called **codechallenge-simple-1.jar**. 
With the default configuration, this should be located under **$PROJECT ROOT/build/libs**

The following command will read the file from the local file systems or from a remote location over HTTP
```shell
java -jar codechallenge-simple-1.jar <absolute file path | HTTP URL>
```

An example of this, over HTTP, is:
```shell
java -jar codechallenge-simple-1.jar https://raw.githubusercontent.com/RabidDog/codechallenge-simple/main/src/test/resources/resultsinput.txt
```
