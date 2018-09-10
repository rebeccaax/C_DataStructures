#include <stdio.h>
#include "stack.h"
#include <ctype.h>
#include <math.h>

int main(){
  int ch;
  double num = 0;
  int charcount;
  double p1;
  double p2;


  ch = getchar();
    charcount++;

  while (ch != '\n'){
    if (isdigit(ch)){
      num = num * 10 + (ch - '0');

    }

    else if (ch == ' '){
      if (num != 0){
         if (push(num) == -1){
          printf("Stack full when pushing (%.2f) at position %d\n", num, charcount);
          return -1;
         }
       num = 0;
      }
    }

    else if (ch == '+' || ch == '-' ||
       ch == '*' || ch == '/') {
      if (getStackSize() < 2) {
         printf("Input error at character %d (%c); too few arguments on stack.\n", charcount, ch);
         return -1;
      }
       p2 = pop();
       p1 = pop();

       if (ch == '+') {
         push(p1 + p2);
       }
       else if (ch == '-') {
         push(p1 - p2);
       }
       else if (ch == '*') {
         push(p1 * p2);
       }
       else {
         push(p1/p2);
       }
    }

    ch = getchar();
      charcount++;
  }

  if (getStackSize() > 1) {
    printf("There are too few operators in the expression.\n");
  }
  else {
    printf("Result:  %.2f\n", pop());
  }

}