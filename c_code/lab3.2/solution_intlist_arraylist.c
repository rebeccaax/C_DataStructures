#include <math.h>
#include <stdio.h>
#include <stdlib.h>
#include <limits.h>
#include "intlist.h"

struct intlist {
  int arraySize;
  int listSize;
  int* list;
};

IntList* ilCreate()
{
  IntList *il = malloc (sizeof (IntList));
  il->listSize = 0;
  il->arraySize = 5;
  il->list = malloc (sizeof (int) * il->arraySize);
  
  return il;
}

IntList* ilCopy (IntList *il)
{
  int i;
  
  IntList *newList = malloc (sizeof (IntList));
  newList->listSize = il->listSize;
  newList->arraySize = il->listSize;
  newList->list = malloc (sizeof (int) * newList->arraySize);

  for (i=0; i<newList->listSize; i++)
    newList->list[i] = il->list[i];
  
  return newList;
}

void ilExpand (IntList *il)
{
  int *newList;
  int newSize = il->arraySize * 2;
  int i;

  newList = malloc (newSize * sizeof(int));

  for (i=0; i<il->arraySize; i++)
    newList[i] = il->list[i];

  free (il->list);
  il->arraySize = newSize;
  il->list = newList;
}
  

void ilAppend (IntList *il, int val)
{
  if (il->listSize >= il->arraySize)
    ilExpand (il);

  il->list[(il->listSize)++] = val;
}

void ilPrint (IntList *il)
{
	int i;
	for (i=0; i<il->listSize; i++) {
		printf ("%d: %d\n", i, il->list[i]);
	}
}


int ilDelete (IntList *il, int pos)
{
  int i;
  
  if ((pos< 0) || (pos >= il->listSize))
    return -1;

  for (i=pos; i<il->listSize-1; i++)
    il->list[i] = il->list[i+1];

  il->listSize--;

  return 0;
}

int ilFind (IntList *il, int val)
{
  int i;

  for (i=0; i<il->listSize; i++)
    if (il->list[i] == val)
      return i;

  return -1;
}

int ilGet (IntList *il, int pos)
{
  if ((pos< 0) || (pos >= il->listSize))
    return INT_MIN;

  return il->list[pos];
}

int ilInsert (IntList *il, int pos, int val)
{
  int i;

  if ((pos< 0) || (pos >= il->listSize))
    return INT_MIN;
  
  if (il->listSize >= il->arraySize)
    ilExpand (il);

  for (i=il->listSize; i>pos; i--)
    il->list[i] = il->list[i-1];
    
  il->list[pos] = val;
  il->listSize++;
}

int ilSize (IntList *il)
{
  return il->listSize;
}


  


  
