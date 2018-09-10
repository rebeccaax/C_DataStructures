#include <math.h>
#include <stdio.h>
#include <stdlib.h>
#include <limits.h>
#include "stack.h"

typedef struct node {
  int val;
  struct node* next;
} Node;

struct stack {
  int stackSize;
  Node* head;
};

Stack* createStack () {	
	Stack *s = malloc(sizeof(Stack));
	s->head = NULL;
	s->stackSize = 0;
	return s;
}

void push (Stack *s, int val) {
	Node *n = malloc(sizeof(Node));
	n->val = val;
	n->next = s->head;
	s->head = n; 
	s->stackSize++;
}

int pop (Stack *s) {
	Node *n = malloc(sizeof(Node));
 	int val;

  	val = s->head->val;
  	n = s->head;
  	s->head = s->head->next;
  	s->stackSize--;
  	return val;
  	
  	if (s->stackSize == 0) {
    	return INT_MIN;
  	}
}

int isStackEmpty (Stack *s) {
	if (s->stackSize == 0) {
		return 1;
	}
	return 0;
}

int getStackSize(Stack *s) {
	return s->stackSize;
}

