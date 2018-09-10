#define MAXSIZE 10
#include <stdio.h>

int array[MAXSIZE];
int pos = 0;
int total = 0;

int addNumber (int num) {
  if (pos >= MAXSIZE) {
    return -1;
  }

  array[pos++] = num;
  total += num;
  return 0;
}

void printNumbers() {
  int i;
  printf ("The numbers are: ");

  for (i = 0; i < pos; i++) {
      printf("%d", array[i]);
      
      if (i < pos - 1) {
	printf(", ");
      }
  }
  printf("\n");
}

int main() {
  int ch;
  int currentNum = 0;
  int error = 0;

  ch = getchar();
  while ((ch != EOF) && (error == 0)) {
      if (isdigit(ch)) {
	currentNum = currentNum * 10 + (ch - '0');
      }
      
      else if (currentNum > 0) {
	addNumber(currentNum);
	currentNum = 0;
      }

      ch = getchar();
 }
  if (error == 0) {
    printNumbers();
    printf("sum is: %d\n", total);
  }

  else {
    printf("Error");
  }
}
