#include <stdio.h>
#include <stdlib.h>
#include "point.h"

int main() {
	Point *p1;
	Point *p2;
	char temp1[15];

	p1 = createPoint (10, 12);
	p2 = createPoint (5, 7);

	translatePoint(p1, 10, 3);
	dilatePoint(p2, .5);
	pointToString(p1, temp1);
	printf("%s\n", temp1);

	printf("%s\n", pointToString(p2, temp1));
	



}