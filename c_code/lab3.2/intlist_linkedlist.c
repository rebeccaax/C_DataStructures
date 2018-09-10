#include <stdio.h>
#include <math.h>
#include <stdlib.h>
#include <limits.h>
#include "intlist.h"

struct node {
	int val;
	struct node* next;
};

typedef struct node Node;

struct intlist {
	Node* head;
	Node *tail;
	int listSize;

};

IntList* ilCreate() {
	IntList* il = malloc(sizeof(IntList));
	il->head = NULL;
	il->tail = NULL;
	il->listSize = 0;  
	return il;
}

IntList* ilCopy(IntList* il) {
	IntList* copy = ilCreate();
	Node* n = il->head;

	while (n != NULL) {
		ilAppend(copy, n->val);
		n = n->next;
	} 
	return copy;
}

int ilFind(IntList* il, int val) {
	Node *n = il->head;
	int i = 0;

	while (n != NULL) {
		if (n->val == val) {
			return i;
		}
		n = n->next;
		i++;
	}
	return -1;
}

void ilPrint(IntList *il) {
	Node *n;
	int i = 0;
	n = il->head;
	while (n != NULL) {
		printf("%d: %d\n", i, n->val);
		n = n->next;
		i++;
	}
}

void ilAppend (IntList *il, int val) {
	Node* n = malloc(sizeof(Node));
	n->val = val;
	n->next = NULL;

	if (il->listSize == 0) {
		il->head = n;
		il->tail = n;
	}
	else {
		il->tail->next = n;
		il->tail = n;
	}
	il->listSize++;
}
void ilAppend (IntList *il, int val){
  Node *n;

  n = malloc (sizeof (Node));
  n->val = val;
  n->next = NULL;
  
  if (il->tail == NULL){
      il->tail = n;
      il->head = n;
  }
  
  else{
    il->tail->next = n;
    il->tail = n;
  }

  il->listSize += 1;
}

int ilGet (IntList *il, int pos) {
	Node *n;
	int i = 0;
	if ((pos < 0) || (pos >= il->listSize)) {
		return INT_MIN;
	}

	n = il->head;
	for (int i = 0; i < pos; i++) {
		n = n->next;
	}
	return n->val;
}

int ilSize  (IntList *il) {
	return il->listSize;
}

int ilInsert(IntList *il, int pos, int val) {
	Node *newNode, *prior;
	int i;

	if ((pos < 0) || (pos > il->listSize)) {
		return INT_MIN;
	}
	if (pos == il->listSize) {
		ilAppend(il, val);
		return 0;
	}

	newNode = malloc (sizeof(Node));
	newNode->val = val;
	
	if (pos == 0) {
		newNode->next = il->head;
		il->head = newNode;
	}

	else {
		prior = il->head;
		for (i = 0; i < pos-1; i++) {
			prior = prior->next;
		}
		newNode->next = prior->next;
		prior->next = newNode;
	}
	il->listSize++;
	return 0;
}

int ilDelete(IntList* il, int pos) {
	int i;
	Node *prior, *delete;
	if ((pos < 0) || (pos > il->listSize)) {
		return -1;
	}

	if (il->listSize == 1) {
		il->head = NULL;
		il->tail = NULL;
	}
	else if (pos == 0) {
		il->head = il->head->next;
	}
	else {
		prior = il->head;
		for (int i = 0; i < pos-1; i++) {
			prior = prior->next;
		}
		delete = prior->next;
		prior->next = delete->next;

		if (delete == il->tail) {
			il->tail = prior;
		}
	}
	il->listSize--;
		return 0;

		
}


