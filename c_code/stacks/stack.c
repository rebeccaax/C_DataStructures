#include <math.h>
#include <stdio.h>
#include <stdlib.h>
#include "stack.h"

struct stack{
  double *stack;
  int sp;
  int arraySize;
};

Stack* createStack() {
  Stack *s = malloc (sizeof(Stack));
  s->sp = 0;
  s->arraySize = 5;
  s->stack = malloc(sizeof(double) * s->arraySize);
  return s;
}

void expand(Stack *s) {
  double *newStack;
  int newSize = s->arraySize + 10;
  int i;
  printf("Expanding: newSize = %d\n", s->arraySize);
  newStack = malloc(sizeof(double) * newSize);
  for (i = 0; i <s->arraySize; i++){
    newStack[i] = s->stack[i];
  }
  if (s->stack != NULL) {
    free(s->stack);
  }
  s->stack = newStack;
  s->arraySize = newSize;
}

int push (Stack *s, double d)
{
  /*  printf ("\nPushing %f.\n", d);*/
  if (s->sp == s->arraySize) {
    expand(s);
  }

  s->stack[s->sp] = d;
  s->sp++;

  return 0;
}

double pop (Stack *s)
{
  double pop;
  if (s->sp == 0) {
    return NAN;
  }
  pop = s->stack[--(s->sp)];
  /*printf("\nPopping %f.\n", pop);*/
  
  return pop;
}


int isStackEmpty (Stack *s)
{
  if (s->sp == 0)
    return 1;
  else
    return 0;
}

int getStackSize(Stack *s)
{
  return s->sp;
}

void emptyStack(Stack *s)
{
  s->sp=0;
}
