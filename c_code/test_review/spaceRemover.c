#include <stdio.h>
#include <ctype.h>
#include <string.h>

/*
Write the function void spaceRemover(char in[], char out[]) which copies the string
from the input parameter “in” to the output parameter “out”, but with all spaces removed.
*/

void spaceRemover(char in[], char out[]) {
	int i = 0;	
	int j = 0;
	while (in[i] != '\0') {
		
		if (in[i] != ' ') {
			out[j++] = in[i];
		}
		i++;
	}
	out[j] = '\0';
}




int main () {	
printf ("\n\nspaceRemover Tests:\n");
	spaceRemover ("Hello, how are you?",out);
	if (strcmp(out, "Hello,howareyou?")==0)
		printf ("Passed 1\n");
	else
		printf ("Failed 1\n");

	spaceRemover ("A    B C  D ",out);
	if (strcmp(out, "ABCD")==0)
		printf ("Passed 2\n");
	else
		printf ("Failed 2\n");	
}