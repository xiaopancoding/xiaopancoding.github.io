#include<stdio.h>
#include<graphics.h>
#include<conio.h>
#include<dos.h>
#include<stdlib.h>


void zhuan(int x,int y)
{
	int chang =9;
	int kuai = 9;
	setlinecolor(WHITE);
	line(x, y, x + chang, y);
	line(x, y + 1, x + chang - 1, y + 1);
	line(x, y, x, y + kuai);
	line(x +1, y, x + 1, y + kuai - 1);
	setlinecolor(RED);
	line(x + 1, y + kuai, x + chang, y + kuai - 1);
	line(x + 2, y + kuai - 1, x + chang, y + kuai - 1);
	line(x + chang, y + 2, x + chang - 1, y + kuai - 1);
	line(x + chang, y + 1, x + chang, y + kuai);
	setfillstyle(8,LIGHTRED);
	bar(x + 2, y + 2, x + chang - 2, y + kuai - 2);
	/*setcolor(WHITE);
	line(50, 40, 50 + chang, 40);
	line(50, 40 + 9, 50 + chang - 9, 40 + 9);
	line(50, 40, 50, 40 + kuai);
	line(50 + 9, 40, 50 +91, 40 + kuai - 9);
	setcolor(RED);
	line(50 + 9, 40 + kuai, 50 + chang, 40 + kuai - 9);
	line(50 + 5, 40 + kuai - 9, 50 + chang, 40 + kuai - 9);
	line(50 + chang, 40 + 5, 50 + chang - 9, 40 + kuai - 9);
	line(50 + chang, 40 + 9, 50 + chang, 40 + kuai);
	setfillstyle(BLUE, LIGHTRED);
	bar(50 + 5, 40 + 5, 50 + chang - 5, 40 + kuai - 5);*/


}

void qiang()
{
	int i;
	for (i = 50; i <= 600; i += 20)
	{
		zhuan(i, 40);
		zhuan(i, 451);
	}
	for (i = 40; i <= 450; i += 20)
	{
		zhuan(50, i);
		zhuan(601, i);
	}
		
}


int main()
{
	
	initgraph(800,800);
	
	setbkcolor(BLACK);
	cleardevice();


	qiang();
	
	

	

	getchar();
	closegraph();
	return 0;
}
