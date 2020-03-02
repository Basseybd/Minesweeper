# Minesweeper

#####Minesweeper replica made with java and swing.


We had issues with loading the icons in swing. We deleted the implementation from the boards file because it
would crash the program. An example of where this occurred that is still visible is in the StatusBar.java
where We were going to load a bomb placeholder for the smiley face since We couldn't find the appropriate Icon.
We have the interactive part fleshed out in the Board.java but I wouldn't work because the icons aren't loading.

To make sense of the number shown when the Board.java is run:

initializeBoard fills board with mines at random places (mines are -1)
uncovered FreeCells(0) uncovers all adjacent empty un-clicked fields
click takes in a coordinate and ends the game/clicks the field
printBoard output

The buttons aren't implemented.