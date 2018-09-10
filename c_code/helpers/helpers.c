#include <stdio.h>
#include <math.h>
#include <ctype.h>

/* NAN is a constant defined in math.h.  It means Not a Number. 
   There are various calculations that result in NAN, one of which is
   sqrt(-1).  

You can set a float variable to NAN just like you assign it to 5.0. 
*/
void nanDemo ()
{
  double nanDemo;

  /* alternatively, change NAN to sqrt(-1) for the same result. */
  nanDemo = NAN;

  printf ("%f\n", nanDemo);

  if (isnan(nanDemo)) {
    printf ("Yup, it is a nan.\n");
  }
  else {
    printf ("Nope, it is not a nan.\n");
  }
}

void helpers ()
{
  int ch;
  int digits = 0;
  int letters = 0;

  ch = getchar();
  
  while (ch!= '\n') {

    /* isdigit and isalpha are helper functions in ctype.h, 
       which is included by default.
    See page 249 in K & R for similar functions.  */
  
    if (isdigit(ch))
      digits++;
    else if (isalpha(ch))
      letters++;

    ch = getchar();
  }

  printf ("\n\n#Digits: %d\n", digits);
  printf ("#Letters: %d\n", letters);
}

int main ()
{
  nanDemo();
  helpers();
}
  
