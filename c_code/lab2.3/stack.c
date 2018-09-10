#include <stdio.h>
#include <math.h>
#define STACK_SIZE 100

double stack[STACK_SIZE];
int sp = 0;
//int i = 0;
//int num = 0;

/*
Pushes "d" onto the stack.
 * Returns 0 if successful.
 * Returns -1 if an error occurs because the stack is full.
*/
int push (double d){
  if (sp == STACK_SIZE){
    return -1;
  }
  stack[sp++] = d;
  return 0;
}

/*
Pops next double off the stack.
 * Returns the double if successful.
 * Returns NAN if an error occurs.  (Stack empty).
*/
double pop(){
  if (sp == 0){
    return NAN;
  }
  return stack[--sp];
}

/*
 *If the stack is empty, returns 1 (true).  
 * Otherwise, returns 0 (false). 
*/
int isStackEmpty(){
  if (sp == 0){
    return 1;
  }
  else {
    return 0;
  }
}

/*
 * Returns the current size of the stack. 
*/
int getStackSize(){
  return sp;
}

/*
 * Empties the stack entirely.  
 * After this call, getStackSize() should equal 0.
*/
void emptyStack(){
  sp = 0;
}

/*void printstackc(){
  for (int i = 0; i < sp; i++) {
    printf("%.2f ", stack[i]);
  }
  printf("\n");
}
*/