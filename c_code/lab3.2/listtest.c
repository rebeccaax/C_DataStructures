#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <limits.h>
#include "intlist.h"

int main()
{
  int i, val;
  IntList *list1, *list2, *list3;

  list1 = ilCreate();

  printf ("\n\nAppend Test (list 1) (should be 10, 98, 45):\n");
  ilAppend (list1, 10);
  ilAppend (list1, 98);
  ilAppend (list1, 45);

  ilPrint (list1);  
  printf ("List Size: %d\n", ilSize(list1));

	/************************/	
  printf ("\n\nCopy Test (list 2) - should match list1 above:\n");  
  list2 = ilCopy(list1);
  ilPrint (list2);

	/************************/	  
  ilInsert (list1, 1, 20);
  ilInsert (list1, 0, 102);
  ilInsert (list1, 4, -99);
  
  printf ("\n\nInsert Test (should be 102, 10, 20, 98, -99, 45):\n");
  ilPrint (list1);
  printf ("List Size: %d\n", ilSize(list1));


  printf ("\n\nFind Test:\n");
  printf ("Find 102: %d\n", ilFind(list1, 102));
  printf ("Find 98: %d\n", ilFind(list1, 98));
  printf ("Find 45: %d\n", ilFind(list1, 45));

  printf ("\n\nGet Test (should be inverse of above):\n");
  printf ("Get 0: %d\n", ilGet(list1, 0));
  printf ("Get 3: %d\n", ilGet(list1, 3));
  printf ("Get 5: %d\n", ilGet(list1, 5));

  printf ("\n\nDelete Test 1 - Last element (Should be 102, 10, 20, 98, -99):\n");
  ilDelete (list1, 5);
  ilPrint (list1);

  printf ("\n\nDelete Test 1 - pos=2 (Should be 102, 10, 98, -99):\n");
  ilDelete (list1, 2);
  ilPrint (list1);

  printf ("\n\nDelete Test 1 - pos=0 (Should be 10, 98, -99):\n");
  ilDelete (list1, 0);
  ilPrint (list1);

  printf ("\n\nCopy Test (list 2) -- (Should be 10, 98, 45):\n");  
  ilPrint (list2);
  
  
  /****************************/
  printf ("\n\nSize testing\n");
  list3 = ilCreate();
  
  for (i=0; i< 10000; i++) {
    scanf ("%d\n", &val);
    val = (int)(((double)val/RAND_MAX)*100);
    ilAppend (list3, val);
   }

  if (ilFind (list3, 35) == 115)
    printf ("Passed 1.\n");
  else
    printf ("Failed 1.\n");
  
  if (ilGet (list3, 84) == 66)
    printf ("Passed 2.\n");
  else
    printf ("Failed 2.\n");
  
  ilInsert (list3, 14, 21);
  ilInsert (list3, 12, 25);
  
  if ((ilGet (list3, 12) == 25) && (ilGet (list3, 15) == 21))
    printf ("Passed 3.\n");
  else
    printf ("Failed 3.\n");
  
  ilDelete (list3, 2);

  if (ilSize(list3) == 10001)
    printf ("Passed 4.\n");
  else
    printf ("Failed 4.\n");

  if ((ilGet (list3, 11) == 25) && (ilGet (list3, 14) == 21))
    printf ("Passed 5.\n");
  else
    printf ("Failed 5.\n");

  if (ilGet(list3, 50000) == INT_MIN)
    printf ("Passed 6.\n");
  else
    printf ("Failed 6.\n");

  if (ilGet(list3, -10) == INT_MIN)
    printf ("Passed 7.\n");
  else
    printf ("Failed 7.\n");

  if (ilInsert(list3, 50000, 5) == INT_MIN)
    printf ("Passed 8.\n");
  else
    printf ("Failed 8.\n");

  if (ilInsert(list3, -10, 5) == INT_MIN)
    printf ("Passed 9.\n");
  else
    printf ("Failed 9.\n");
  
}
  
