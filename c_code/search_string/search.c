#include <stdio.h>
#include "strings.h"

int main (int argc, char* argv[]) {
  char f[5000];
  char* srch;
  int pos;
  getFile(f, 5000);
  srch = argv[1];
  
  pos = substr (f, srch);
  
  if (pos == -1) {
    printf("String not found.");
  }
  
  else {
    printf("String found at position %d.\n", pos);
  }
}
