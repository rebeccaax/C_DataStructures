#include <stdio.h>
#include "strings.h"

int length (char str[]) {
  int len = 0;
  while (str[len] != '\0') {
    len++;
  }
  return len;
}

int getFile (char s[], int lim) {
  int ch, pos;
  pos = 0;
  ch = getchar();
  while (ch != EOF && pos < lim) {
    s[pos] = ch;
    ch = getchar();
    pos++;
  }
  s[pos] = '\0';
  return pos;
}

int substr (char str[], char srch[]) {
  int strLen = length(str);
  int srchLen = length(srch);
  int i;
  int j;

  for (i = 0; i < strLen - srchLen; i++) {
    int failed = 0;

    for (j = 0; j < srchLen; j++) {
      if (str[i+j] != srch[j]) {
	failed = 1;
	break;
      }
    }
    if (failed == 0)
      return i;
  }
  return -1;
}
