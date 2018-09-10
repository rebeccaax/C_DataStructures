#include <stdio.h>
#include <string.h>

void reverse (char* before, char* after) {
  int i;
  int j;
  int len;

  len = strlen(before);

  for (j = len - 1, i = 0; j >= 0; j--, i++)
    after[i] = before[j];
 
  after[len] = 0;
}

main() {
  char str_in[50];
  char str_out[50];

  printf("Please enter a string and I will reverse it!\n");

  gets (str_in);

  reverse (str_in, str_out);
  printf("Original String: %s\n", str_in);
  printf("Reversed String: %s\n", str_out);
}
