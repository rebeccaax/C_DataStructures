#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include "intlist.h"

struct intlist{
  int *array;
  int num;
  int arraySize;
};

IntList* ilCreate () {
	IntList* intList = malloc (sizeof(IntList));
	intList->num = 0;
	intList->arraySize = 5;
	intList->array = malloc(sizeof(int) * intList->arraySize);
	return intList;
}

void ilExpand(IntList *intList) {
	int *newArray;
	int newSize = s->arraySize + 10;
	int i;

	newArray = malloc(sizeof(int) * newSize);
	for (i = 0; i < s->arraySize; i++){
    	newSize[i] = s->array[i];
  	}
  	intList->array = newArray;
  	intList->arraySize = newSize;
}

IntList* ilCopy (IntList *il) {
	int i;
	IntList newIntList* = malloc (sizeof(IntList));
	newIntList->num = il->num;
	newIntList->arraySize = il->arraySize;
	newIntList->array = malloc(sizeof(int) * intList->arraySize);
	for (int i = 0; i < il->listSize; i++) {
		newIntList->array[i] = il->array[i];
	}
}

void ilAppend (IntList *il, int val) {
	if (il->listSize == il->arraySize) {
		ilExpand(il);
	}

	il->array[il->listSize] = val;
		il->listSize++;
}

/******************************
 * Appends "val" to the end of the list.
 */
void ilPrint (IntList *il) {
	int i;
	for (int i = 0; i < il->listSize; i++) {
		printf("%d: %d\n", i, il->array[i]);
	}
}

/*****************************
 * Prints the list to stdout for debugging.
 */
int ilDelete (IntList *il, int pos) {
	
	
}
/******************************
 * Deletes the specified element from the list.
 * "pos" represents the position in the list.  
 * Returns 0 if succcessful.
 * Returns -1 if the "pos" is not in the list.
 */ 
int ilFind (IntList *il, int val);
/******************************
 * Returns the position of first element in the list with
 * a value that equals "val". 
 * Returns -1 if the element is not found.
 */ 
int ilGet (IntList *il, int pos) {
	if ((pos < 0) || (pos >= il->listSize)) {
		return INT_MIN;
	}
	return il->array[pos];

}
/******************************
 * Returns the value of the "pos" element in the list.
 * Returns INT_MIN (as defined in limits.h) if "pos" 
 * is not in the list.
 */ 
int ilInsert (IntList *il, int pos, int val); 
/******************************
 * Inserts "val" into the list at position "pos".
 * Returns 0 if succcessful.
 * Returns INT_MIN (as defined in limits.h) if "pos" 
 * is not in the list.
 */ 
int ilSize (IntList *il);
/*******************************
 * Returns the size of the list.
 */