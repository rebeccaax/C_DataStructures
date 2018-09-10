#include <stdio.h>
#include <stdlib.h> 
#include "rect.h"

Rect* createRect (float x1, float y1, float x2, float y2) {
	Rect *r = malloc (sizeof(Rect));
	r->pt1.x = x1;
	r->pt1.y = y1;
	r->pt2.x = x2;
	r->pt2.y = y2;
	return r;
}
   
Rect* copyRect (Rect* r){
	Rect *n = malloc (sizeof(Rect));
	n->pt1.x = r->pt1.x;
	n->pt1.y = r->pt1.y ;
	n->pt2.x = r->pt2.x;
	n->pt2.y = r->pt2.y;
	return n;
}

void move (Rect *r, float dx, float dy) {
	r->pt1.x += dx;
	r->pt1.y += dy;
	r->pt2.x += dx;
	r->pt2.y += dy;
}

void dilate (Rect *r, float factor) {
	r->pt1.x *= factor;
	r->pt1.y *= factor;
	r->pt2.x *= factor;
	r->pt2.y *= factor;
}
	
float getWidth (Rect *r) {
	if(r->pt1.x > r->pt2.x) {
		return r->pt1.x - r->pt2.x;
	}
	return r->pt2.x - r->pt1.x;
}
	

float getHeight (Rect *r) {
	if(r->pt1.y > r->pt2.y) {
		return r->pt1.y - r->pt2.y;
	} 
	return r->pt2.y - r->pt1.y;
}
	

float getArea (Rect *r) {
	return (getWidth(r) * getHeight(r));
}

float getPerimeter (Rect *r) {
	return 2 * (getWidth(r) + getHeight(r));
}

char* toString (Rect *r, char out[]) {
	sprintf(out, "Rectangle: (%.1f, %.1f);(%.1f, %.1f)", r->pt1.x, r->pt1.y, r->pt2.x, r->pt2.y);
		return out;
}

