#include<stdio.h>
void zui_xiao()
{
	int a[10], i;
	for (i = 0; i < 10; i++)
		scanf_s("%d", &a[i]);
}

//#include<windows.h>
//#include<conio.h>
//int gong_ying(int a,int b)
//{
//	int t,r;
//	if (a < b) {
//		t = a;
//		a = b;
//		b = t;
//	}do {
//		r = a % b;
//		a = b;
//		b = r;
//	} while (r != 0);
//	return a;

	/*int i,num=1;
	for (i = 2; i < a; i++) {
		if (a%i == 0) {
			num = 0;
			break;
		}
	}if (num)
		printf("prime");
	else
		printf("not prime");*/
//}
//int gong_bei(int m,int n)
//{
//	int x,num;
//	x = gong_ying(m,n);
//	num = (n*m) / x;
//	return num;
//}
int main()
{
	int a[10], i, j, t,min;
	for (i = 0; i < 10; i++)
		scanf_s("%d", &a[i]);
	// 选择排序法
	for (i = 0; i < 9; i++) {
		min = i;//先选出第一个元素
		for (j = i + 1; j <= 9; j++) {
			//循环第一个元素后面的其他元素
			if (a[j] < a[min])//把后面的元素和第一个元素比较，
				//如果后面有小的就把小的的索引交换
				min = j;
		}t = a[i];//中间循环结束找到了最小的数，把第一个元素和这个最小的数交换
		a[i] = a[min];
		a[min] = t;
	}for (i = 0; i < 10; i++)
		printf("%d ", a[i]);

	/*int y,i,m,n,z,d;
	scanf_s("%d%d", &y, &i);
	m = y; n = i;
	z = gong_ying(y, i);
	d = gong_bei(m,n);
	printf("%d %d", z, d);*/
	/*char a, b,shu,zhi;
	scanf_s("%c%c", &a,&b);
	shu = (int)a + 1;
	zhi = (int)b + 1;
	printf("%c %c",(char)shu,(char)zhi);*/

	/*int N, i, j, a[10][10], num = 0;
	scanf_s("%d", &N);
	for (i = 0; i < N; i++) {
		for (j = 0; j < N; j++)
			scanf_s("%d", &a[i][j]);
	}
	for (i = 0; i < N; i++) {
		num += a[i][i];
		num += a[i][N - 1 - i];
		if (a[i][i] == a[i][N - 1 - i])
			num -= a[i][i];
	}
	printf("%d", num);*/





//{
//	int a, b, m, n, shu,y;
//	scanf_s("%d %d", &a, &b);
//	m = a; n = b;
//	y = my;
//	shu = (m*n) / y;
//	printf("%d%d", shu, y);
//*/



	/*int a, i, j, x;
	for (i = 1; i <= 9; i++) {
		for (j = 1; j <= i; j++) {
				printf("%d*%d=%-3d", j, i, i*j);
		}printf("\n");
	}*/

	/*int a[20], i, num = 0, shu, j = 1,ge;
	for (i = 0; i < 20; i++) {
		scanf_s("%d", &a[i]);
		if(a[i] > 0) {
			num += a[i];
			shu = j++;
		}
	}ge = 20 - shu;
	printf("%d\n", ge);
	printf("%.2f", (float)num / shu);*/

	/*int i,j,a[3][3], b[3][3];
	for (i = 0; i < 3; i++) {
		for (j = 0; j < 3; j++)
			scanf_s("%d", &a[i][j]);
	}for (i = 0; i < 3; i++) {
		for (j = 0; j < 3; j++)
			b[j][i] = a[i][j];
	}for (i = 0; i < 3; i++) {
		for (j = 0; j < 3; j++)
			printf("%d ", b[i][j]);
		printf("\n");
	}*/

	//i/*nt a, b, c;
	//scanf_s("%d %d %d", &a, &b, &c);
	//if (a < b) {
	//	a = b;
	//	if (a < c) {
	//		a = c;
	//		printf("%d", a);
	//	}
	//	else
	//		printf("%d", a);	
	//}
	//else
	//	if (a < c) {
	//		a = c;
	//		printf("%d", a);
	//	}
	//	else
	//		printf("%d", a);*/
	/*int a, i, j;
	for (i = 1; i <= 5; i++) {
		for (j = 1; j <= 5 - i; j++) 
			printf(" ");
			for (a = 1; a <= 2 * i - 1; a++)
				printf("*");
			printf("\n");
	}*/
	

	/*int i, x,n, shu,num=0;
	scanf_s("%d", &n);
	for (i = 1; i <= n; i++) {
		shu = 1;
		for (x = 1; x <= i; x++)
			shu *= x;
		num += shu;
	}printf("%d", num);*/

	/*int a[10], i,x;
	for (i = 0; i < 10; i++)
		scanf_s("%d", &a[i]);
	for (x = 9; x >= 0&&x<10 ;x--)
		printf("%d ", a[x]);*/

	/*int i, j,sum=0,num;
	int a[3][3];
	for (i = 0; i < 3; i++) 
	{
		for (j = 0; j < 3; j++) 
			scanf_s("%d", &a[i][j]);
	}
	for (i = 0; i < 3; i++)
		sum += a[i][i];
	num = a[0][2] + a[1][1] + a[2][0];
	printf("%d %d\n", sum, num);*/


	/*int a, b, c, x, d;
	for (x = 1; ; x++) {
		scanf_s("%d %d", &a, &b);
		
	}*/

	/*int a[2][3] = { {1,2,3},{4,5,6} };
	int b[3][2];
	int i,j;
	for (i = 0; i < 2; i++) {
		for (j = 0; j < 3; j++)
			b[j][i] = a[i][j];
	}for (i = 0; i < 3; i++) {
		for (j = 0; j < 2; j++)
			printf("%d ",b[i][j]);
		printf("\n");
	}*/



	/*int shuzu[3][4];
	shuzu[0][0] = 1;
	shuzu[3][4] = 9;
	printf("%d %d", shuzu[0][0], shuzu[3][4]);*/

	/*int nums,x=0,i,y, n;
	scanf_s("%d", &n);
	y = n * n*n;
	for (i = 0; i < n; i++) {
		nums = n * n - n + 1+i*2;

	}printf("%d*%d*%d=",n,n,n)*/
	/*int a = 1, b = 2, c = 3;
	printf("%d,%d\n", a = b == c, a == (b == c));*/

	
	/*int i,num, N ,x,shusu=0 ;
	scanf_s("%d", &N);
	for (i = 0; i < N; i++) {
		num = i + 1;
		for (x = 2; x < num; x++) {
			if (num % x == 0) {
				shusu = 0;
				break; 
			}
			else
				shusu = 1;
		}if (num == 2)
			shusu = 1;
		if (shusu)
			printf("%d\n", num);
	}*/
	
	

	/*int shuzu[5] = { 0 };
	int i;
	scanf_s("%d %d %d %d %d", &shuzu[0], &shuzu[1], &shuzu[2], &shuzu[3], &shuzu[4]);
	for (i = 4; i >= 0 && i < 5; i--)
		printf("%d ", shuzu[i]);*/


	/*int verse[5] = { 2,5,3,765,43 };
	int i, max = verse[4];
	for (i = 1; i < 5; i++) {
		if (max < verse[i])
			max = verse[i];
	}printf("%d", max);*/

	/*int hX = 0, hY = 0, len = 4, map[900] = { 0 }, c = 'd', c1 = 'd', i = 0;
	srand((unsigned)malloc(!system("mode con:cols=60 lines=30")));
	for (map[rand() % 900] = -1; 1; Sleep(100)) {
		if (_kbhit() && (c1 = _getch()) && c1 < 97 ? c1 += 32 : 1)
			if (c1 == 'a'&&c != 'd' || c1 == 'd'&&c != 'a' ||
				c1 == 'w'&&c != 's' || c1 == 's'&&c != 'w')c = c1;
		if (c == 'a'&&--hX < 0 || c == 'd'&&++hX == 30 ||
			c == 'w'&&--hY < 0 || c == 's'&&++hY == 30)exit(0);
		if (map[hY * 30 + hX] && (map[hY * 30 + hX] > 0 ? exit(0), 1 : ++len))
			for (i == rand() % 900; map[i] || !(map[i] = -1); i = rand() % 900);
		else for (i = 0; i < 900; i++)map[i] > 0 ? (map[i] -= 1) : 0;
		for (system("cls"), map[hY * 30 + hX] = len, i = 0; i < 900; i++)
			_cputs(map[i] > 0 ? "()" : map[i] ? "00" : "  ");
	}*/

	

	/*int a, b, c, d, m,n;
	scanf_s("%d %d", &a, &b);
	m = a, n = b;
	if (a < b)
	{
		c = a;
		a = b;
		b = c;
	}
	do
	{
		d = a % b;
		a = b;
		b = d;
	} while (d != 0);
	printf("%d ", a);
	printf("%d", m*n / a);
	*/
	/*char a;
	double di_1_shu;
	scanf_s("%lf", &di_1_shu);
	scanf_s("%c", &a);
	double di_2_shu;
	scanf_s("%lf", &di_2_shu);
	switch (a)
	{
	case'+':
		printf("%lf", di_1_shu + di_2_shu); break;
	case'-':
		printf("%lf", di_1_shu - di_2_shu); break;
	case'*':
		printf("%lf", di_1_shu * di_2_shu); break;
	case'/':
		printf("%lf", di_1_shu / di_2_shu); break;
	default:
		break;
	}*/
	

	/*int m;
	for (m = 100; m <= 200; m++)
	{
		if (m % 3 == 0 && m % 7 == 0)
			continue;
		printf("%d ", m);
	}*/
	/*int i, m, p;
	p = 1;
	scanf_s("%d", &m);
	for (i = 2; i < m; i++)
	{
		if (m%i == 0)
		{
			p = 0;
			break;
		}
	}
	if (p)
		printf("%d是素数", m);
	else
		printf("%d不是素数", m);*/


	/*char a, b, c, d, e;
	scanf_s("%c,%c,%c,%c,%c\n", &a, &b, &c, &d, &e);
	c = (int)a + 4;*/
	
	
	/*char a, b, c, d, e;
	int i;
	for (i=1;i<=5;i++)
		a,b,c,d,e = putchar(getchar() + 4)*/
	


	/*int i = 0, n = 0, sum = 1;
	scanf_s("%d", &n);
	for (i = 1; i <= n; i++)
	{
		sum = sum * i;
	}
	  printf("%d\n", sum);*/
	  return 0;
}

	/*int a, b;
	scanf_s("%d%d", &a, &b);
	if (a > b)
		printf("a");
	else
		printf("b");
*/
	/*int x;
	scanf_s("%d", &x);
	if (x <= 0)
		printf("y=3-x");
	else
		printf("y=2/x");*/

	/*float a , b , c ,S,l;
	scanf_s("%f%f%f", &a, &b, &c);
	l = (a + b + c) / 2;
	S = (float)sqrt(l*(l - a)*(l - b)*(l - c));
	printf("%f", S);

*/

	/*char ch1, ch2;
	ch1 = getchar();
	ch2 = getchar();
	ch2 = ch1 - 32;
	putchar(ch2);
	*/

	/*float a, b, c,x1,x2,sum;
	printf("input a,b,c");
	scanf("%f,%f,%f", &a, &b, &c);
	sum = b * b - 4 * a*c;
	x1 = -b + sqrt(sum) / (2 * a);
	x2 = -b - sqrt(sum) / (2 * a);
	printf("x1=%6.2f,x2=%6.2f", x1, x2);
	*/
	
	
	/*
	char ch1, ch2, ch3;
	ch1 = getchar();
	ch2 = getchar();
	ch3 = getchar();
	putchar(ch3), putchar(ch2), putchar(ch1);
	printf("\n");*/

	/*int day = 0;

	switch (day)
	{
	case1:
	case2:
	case3:
	case4:
	case5:
	printf("工作日\n");
		break;
	case7:
	printf("休息日\n");
		break;


	default:
		break;
	}

*/
	











