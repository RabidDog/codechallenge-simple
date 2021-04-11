# League Standing Printer

## Requirements
Create a command-line application that accepts a file containing match results and 
calculate the ranking table for a league. Once calculated this is to be printed in an ordered fashion to a terminal or console  
(the highest points to the lowest points).

## Input
Match result data will be provided using a text file in the following format:

```
Team 0, Team 0
Team 0, Team 0
```

Where "Team" is the team name and "0" is the team score.

### Assumptions
- A comma will be used to delimit the teams name and score from the opposing team in the match result. 
- Whitespace is used to delimit the team name from score.
- Each match result will reside on a new line.
- There can only be two teams and scores per match result.
- The team name can include whitespace.
- The score will always be numeric.
- The provided file will always be in a valid format _(While it has been assumed that the input file will always be well formatted, defensive programming techniques have been applied in the event that the file data is not well formatted.)_

## Business Rules

The match can result in two outcomes:
- DECISIVE, there is a clear winner and loser
- TIE, there is no clear winner or loser

With the point allocation of each team in the match result being classified as follows:
- A WIN is defined as the team that had the highest score in the match result entry.
- A TIE is defined as both teams having an equal score in the match result entry.
- A LOSS is defined as the team that had the lowest score in the match result entry.

Points to be allocated for the match outcome:

|Result |Points Allocation|
|-------|----------------:|
|WIN    |3                |
|TIE    |1                |
|LOSS   |0                |

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
