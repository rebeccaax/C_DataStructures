/*****************************************

  Stack.h and Stack.c implement a stack of doubles.

  A client program accesses the stack via the interface defined below.

*********************************************/ 
typedef struct stack Stack;

Stack* createStack();

/************************
 * Push
 *
 * Pushes "d" onto the stack.
 * Returns 0 if successful.
 * Returns -1 if an error occurs because the stack is full.
 */
int push (Stack *s, double d);


/************************
 * pop
 *
 * Pops next double off the stack.
 * Returns the double if successful.
 * Returns NAN if an error occurs.  (Stack empty).
 */
double pop (Stack *s);


/************************
 * isStackEmpty
 *
 * If the stack is empty, returns 1 (true).  
 * Otherwise, returns 0 (false). 
 */
int isStackEmpty (Stack *s);


/************************
 * isStackEmpty
 *
 * Returns the current size of the stack. 
 */
int getStackSize();


/************************
 * emptyStack
 *
 * Empties the stack entirely.  
 * After this call, getStackSize() should equal 0.
 */
void emptyStack();

