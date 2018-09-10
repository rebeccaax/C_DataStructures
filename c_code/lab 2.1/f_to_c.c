#include <stdio.h>
#define FREEZING 32
#define BOILING 212

double f_to_c(double f) {
  return ((f - 32) * (5.0/9)); 
}

int main() {
  printf("%10s %12s\n","Fahrenheit", "Celsius");
  
  for (int f = FREEZING; f <= BOILING; f+=10) {
    printf("%10d %12.1f\n", f, f_to_c(f));   

  }   
}
