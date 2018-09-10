#include <stdio.h>

struct point;
typedef struct point Point;
point* createPoint (float x, float y);
void translatePoint (Point* p, float dx, float dy);
void dilatePoint (Point *p, float factor);
char* pointToString (Point *p, char out[]);
