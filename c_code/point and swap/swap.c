#include <stdio.h>
#include <stdlib.h>

void swap_a (int a, int b) {
  int temp;
  temp = a;
  a = b;
  b = temp;
}

void swap_b (int*a, int *b) {
  int temp;
  printf("\nIn swap_b: a = %u, b = %u\n", a, b);
  
  temp = *a;
  *a = *b;
  *b = temp;
}

int main() {
  int arg1 = 15;
  int arg2 = 25;

  printf("before swap_a: arg1 = %d, arg2 = %d\n", arg1,arg2);

  swap_a (arg1, arg2);
  printf("after swap a: arg1 = %d, arg2 = %d\n", arg1, arg2);

  swap_b (&arg1, &arg2);
  printf("after swap a: arg1 = %d, arg2 = %d\n", arg1, arg2);
}
