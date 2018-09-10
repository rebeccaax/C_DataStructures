#define STACK_SIZE 100
#include <stdio.h>

char stack[STACK_SIZE];
int sp=0;
/*
 * Pushes character c onto the stack.
 * Returns 0 if successful.
 * Returns -1 if an error occurs.  (Stack full).
 */
int push (char c){
 if (sp == STACK_SIZE) {
   return -1;
 }
 stack[sp++] = c;
 return 0;
}

/*
 * Pops next character off the stack.
 * Returns the char if successful.
 * Returns -1 if an error occurs.  (Stack empty).
 */
int pop (){
  if (sp == 0) {
    return -1;
  }
  return stack[--sp];
  
}

/*
 * Returns the current size of the stack.
 */
int stackSize() {
  return sp;
}

/*
 * Tests if the stack is correctly implemented
 */
int main () {
  int ch = getchar();
  int ch2;
  int pos = 1;
  int line = 1;
  while (ch != EOF) {
    if (ch == '(' || ch == '[' || ch == '{') {
      if (ch == '(') {
	if(push(')')==-1){
	  printf("Error: Stack Full\n");
	  return -1;
	}
      }
      else if (ch == '[') {
	if (push(']') == -1) {
	  printf("Error: Stack Full\n");
	  return -1;
	}
      }
      else {
	if (push('}') == -1) {
	  printf("Error: Stack Full\n");
	  return -1;
	}
      }
    }
    else if (ch == ')' || ch == ']' || ch == '}') {
	ch2 = pop();
       if (ch2 == -1) {
	 printf("Line %d, Char %d: Found %c. No matching character.\n", line, pos, ch);
	 return -1;
       }
       else{
	 if(ch2!=ch){
	   printf("Line %d Char %d: Found %c, expected %c\n", line, pos, ch, ch2);
	   return -1;
	 }
       }
    }

    ch = getchar();
   

    if (ch == '\n') {
      line++;
      pos = 1;
    }
    pos++;
  }
  if(sp!=0){
    ch2=pop();
    printf("Error: Expecting %c, found end of input.\n",ch2);
    return -1;
  }

  printf("Well formatted input.\n");
  return 0;
}
