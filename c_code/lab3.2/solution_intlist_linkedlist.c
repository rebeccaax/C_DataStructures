#include <math.h>
#include <stdio.h>
#include <stdlib.h>
#include <limits.h>
#include "intlist.h"

typedef struct node {
  int val;
  struct node* next;
} Node;

struct intlist {
  Node *head;
  Node *tail;
  int listSize;
};

IntList* ilCreate()
{
  IntList *il = malloc (sizeof (IntList));
  il->head = NULL;
  il->tail = NULL;
  il->listSize = 0;

  return il;
}

IntList* ilCopy(IntList *il)
{
  IntList *cl = malloc (sizeof (IntList));
  Node *n;
  
  cl->head = NULL;
  cl->tail = NULL;
  cl->listSize = 0;
  
  n = il->head;
  while (n != NULL) {
	ilAppend(cl, n->val);
	n = n->next;
  }		
  
  return cl;
}


void ilAppend (IntList *il, int val)
{
  Node *n;

  n = malloc (sizeof (Node));
  n->val = val;
  n->next = NULL;
  
  if (il->tail == NULL)
    {
      il->tail = n;
      il->head = n;
    }
  else{
    il->tail->next = n;
    il->tail = n;
  }

  il->listSize += 1;
}

void ilPrint (IntList *il)
{
  Node *n;
  int i = 0;

  n = il->head;

  while (n!= NULL) {
    printf ("%d: %d\n", i, n->val);
    n = n->next;
    i++;
  }
}  
   
int ilFind (IntList *il, int val)
{
  Node *n;
  int i = 0;

  n = il->head;

  while (n!= NULL) {
    if (n->val == val)
      return i;
    
    n = n->next;
    i++;
  }

  return -1;
}

int ilGet (IntList *il, int pos)
{
  Node *n;
  int i = 0;

  if ((pos< 0) || (pos >= il->listSize))
    return INT_MIN;

  n = il->head;

  for (i=0; i<pos; i++)
    n = n->next;

  return n->val;
}
 
int ilInsert (IntList *il, int pos, int val)
{
  Node *newNode, *n;
  int i;

  if ((pos< 0) || (pos >= il->listSize))
    return INT_MIN;

  newNode = malloc (sizeof (Node));
  newNode->val = val;
  
  if (pos == 0) {
    newNode->next = il->head;
    il->head = newNode;
  }
  else {
    n = il->head;

    for (i=0; i< pos-1; i++)
      n=n->next;

    newNode->next = n->next;
    n->next = newNode;
  }

  il->listSize++;
  return 0;
}

int ilSize (IntList *il)
{
  return il->listSize;
}
 
int ilDelete (IntList *il, int pos)
{
  Node *n, *del;
  int i;
  
  if ((pos< 0) || (pos >= il->listSize))
    return -1;

  if (il->listSize == 1) {
    il->head = NULL;
    il->tail = NULL;
  }

  else if (pos == 0) {
    il->head = il->head->next;
  }

  else {
    n = il->head;

    for (i=0; i< pos-1; i++)
      n=n->next;
    
    del = n->next;
    n->next = n->next->next;
    free (del);

    // if we just deleted the last element, then update the tail reference.
    if (n->next == NULL)
      il->tail = n;    
  }

  il->listSize--;
  return 0;
}




  


  
