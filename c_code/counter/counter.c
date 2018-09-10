#include <stdio.h>
#define MAX 128

int main() {
  int count[MAX];
  int ch;
  int i;

  for (i = 0; i < MAX; i++) {
    count[i] = 0;
  }

  ch = getchar();
  while (ch != '\n') {
    /* printf("%c" , ch, ch);*/
      count[ch]++;
    ch = getchar();
  }
  
  for (i = 0; i < MAX; i++) {
    if (count[i] > 0) {
      printf("%c; %d\n", i, count[i]);
    }
  }
}
