#include <stdio.h>
#include <ctype.h>
#include <string.h>
/*
Write a function calculate that takes a string “str” that is a simple arithmetic expression
in the form “<integer><operator><integer>”. The function returns the result of the calculation.
There will be no spaces or other extraneous characters in “str”. Your program
does not need to check for incorrect input. 
*/

double calculate (char str[])
{
	int pos = 0;
	double n1=0, n2=0;
	char op;
		
	while (isdigit(str[pos])) {
		n1 = n1 * 10 + (str[pos] - '0');
		pos++;		
	}
	
	op = str[pos++];

	while (isdigit(str[pos])) {
		n2 = n2 * 10 + (str[pos] - '0');
		pos++;		
	}
	
	if (op == '+') {
		return n1 + n2;
	}
	else if (op == '-') {
		return n1 - n2;
	}
	else if (op == '*') {
		return n1 * n2;
	}
	else if (op == '/') {
		return n1 / n2;
	}
	else {
		printf ("Error!");
		return -1;
	}
}



int main () {	
	printf ("\n\ncalculate Tests:\n");
	if (calculate ("14+2") == 16)
		printf ("Passed 1\n");
	else
		printf ("Failed 1\n");

	if (calculate ("5-250") == -245)
		printf ("Passed 2\n");
	else
		printf ("Failed 2\n");

	if (calculate ("16*4") == 64)
		printf ("Passed 3\n");
	else
		printf ("Failed 3\n");

	if (calculate ("35/2") == 17.5)
		printf ("Passed 4\n");
	else
		printf ("Failed 4\n");
}
