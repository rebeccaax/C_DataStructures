
typedef struct intlist IntList;


/******************************
 * Creates a new instance of IntList and returns a reference to
 * that instance.
 */
IntList* ilCreate ();


/******************************
 * Creates a new instance of IntList, copying the contents of
 * the passed list "il".  This function returns a reference to
 * the new list.
 */
IntList* ilCopy (IntList *il); 


/******************************
 * Appends "val" to the end of the list.
 */
void ilAppend (IntList *il, int val);


/*****************************
 * Prints the list to stdout for debugging.
 */
void ilPrint (IntList *il);


/******************************
 * Deletes the specified element from the list.
 * "pos" represents the position in the list.  
 * Returns 0 if succcessful.
 * Returns -1 if the "pos" is not in the list.
 */ 
int ilDelete (IntList *il, int pos);


/******************************
 * Returns the position of first element in the list with
 * a value that equals "val". 
 * Returns -1 if the element is not found.
 */ 
int ilFind (IntList *il, int val);


/******************************
 * Returns the value of the "pos" element in the list.
 * Returns INT_MIN (as defined in limits.h) if "pos" 
 * is not in the list.
 */ 
int ilGet (IntList *il, int pos);


/******************************
 * Inserts "val" into the list at position "pos".
 * Returns 0 if succcessful.
 * Returns INT_MIN (as defined in limits.h) if "pos" 
 * is not in the list.
 */ 
int ilInsert (IntList *il, int pos, int val); 


/*******************************
 * Returns the size of the list.
 */
int ilSize (IntList *il);






