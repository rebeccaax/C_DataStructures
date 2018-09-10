#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <limits.h>
#include "intlist.h"

int main()
{
  IntList *list1;
  IntList *list2;
  IntList *list3;

  printf ("\n\nTest 1 -- Should print 6, 12, 2, 19, -7:\n");
  list1 = ilCreate();
  ilAppend (list1, 6);
  ilAppend (list1, 12);
  ilAppend (list1, 2);
  ilAppend (list1, 19);  
  ilAppend (list1, -7);
  ilPrint (list1);

  printf ("\n\nTest 2 -- Should print -7, 2, 6, 12, 19\n");
  list2 = ilCreate();
  ilInsertSorted (list2, 6);
  ilInsertSorted (list2, 12);
  ilInsertSorted (list2, 2);
  ilInsertSorted (list2, 19);  
  ilInsertSorted (list2, -7);
  ilPrint (list2);

  printf ("\n\nTest 3 -- Should print -7, 2, 6, 12, 19\n");
  list3 = ilSort(list1);
  ilPrint(list3);
}
