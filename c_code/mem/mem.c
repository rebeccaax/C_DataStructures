#include <stdio.h>
#include <string.h>

int main(){
  char str2[16];
  char str1[16];
  int i;

  for (i = 0; i < 16; i++) {
    str1[i] = '?';
    str2[i] = '\0';
  }

  printf("Please enter a string.\n");
  gets(str1);

  i = 0;
  printf("\n\nstr1: len=%d\n", strlen(str1));
  printf("%s\n", str1);

  printf("\n\nstr2: len=%d\n", strlen(str2));
  printf("%s\n", str2);
  
  printf("     i addr:         %x%u\n", &i, &i);
  printf("     str1 addr:      %x%u\n", str1, str1);
  printf("     str1[2] addr:   %x%u\n", &str1[2], &str1[2]);
  printf("     str1[16] addr:  %x%u\n", &str1[16], &str1[16]);
  printf("     str2 addr:      %x%u\n", str2, str2);
}
