#include <stdio.h>

/*
Write a program that reads a file from stdin and finds the longest line in the file.
The program then prints:
a) The number of the longest line in the file.
b) The count of characters in that line.
Rules:
1) You must use getchar for getting input from the file.
2) You may only import stdio.h and ctype.h.
Watch-out!
1) Newline and EOF do not count toward the length of the line.
2) Be sure to consider the special cases of the first line being longest or
the last line being longest.
*/

int main()
{
  int longestLine = 1;
  int currentLine = 1;
  int longest = 0;
  int current = 0;
  int ch;

  ch = getchar();

  while (ch != EOF)
  {
    if (ch == '\n') {
      if (current > longest) {
		    longest = current;
		    longestLine = currentLine;
      }

      current = 0;
      currentLine++;
    }
    else {
      current++;
    }
    ch = getchar();
  }
  if (current > longest) {
    longest = current;
    longestLine = currentLine;
  }

  printf ("Line %d is longest, with %d characters\n", longestLine, longest);
}

    