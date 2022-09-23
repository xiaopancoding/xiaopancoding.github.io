//void shu_ru()
//{
//	int a[10], i;void hou_yi(int n, int a[], int x)
//{
//	int i,t;
//	//if (x % 2 == 0) {
//		for (i = 0; i < n - x; i++) {
//			t = a[n - i - 1];
//			a[n - i - 1] = a[n - x - i - 1];
//			a[n - x - i - 1] = t;
//		}
//	//}else
//
//	for (i = 0; i < n; i++)
//		printf("%d ", a[i]);
//}
//int main()
//{
//	int n, x, i, a[10];
//	scanf_s("%d", &n);
//	for (i = 0; i < n; i++)
//		scanf_s("%d", &a[i]);
//	scanf_s("%d", &x);
//	return 0;
//	hou_yi(n,a, x);
//}
//	for (i = 0; i < 10; i++)
//		scanf_s("%d", &a[i]);
//}
//void chu_li(int a[])
//{
//	int i,j,t,min;
//	for (i = 0; i < 9; i++) {
//		min = i;
//		for (j = i + 1; j < 10;j++) {
//			if (a[j] < a[min])
//				min = j;
//		}t = a[i];
//		a[i] = a[min];
//		a[min] = t;
//	}
//}
//int main()
//{
//	int a[10], i;
//	for (i = 0; i < 10; i++)
//		scanf_s("%d", &a[i]);
//	chu_li(a);
//	for (i = 0; i < 10; i++)
//		printf("%d ", a[i]);
//	return 0;
//}
//int main()
//{
//	int n;
//	scanf_s("%d", &n);
//
//	return 0;
//}
//int main()
//{
//	int i, j, a, b, c;
//	for (i = 100; i <= 1000; i++) {
//		a = i / 100;
//		b = (i - a * 100) / 10;
//		c = i - a * 100 - b * 10;
//		if (i == a * a*a + b * b*b + c * c*c)
//			printf("%d ", i);
//	}
//	return 0;
//}
//int main()
//{
//	int a, b;
//	scanf_s("%d%d", &a, &b);
//	if (a % 4 == 0 || a % 400 == 0 && a % 100 != 0) {
//		printf("是闰年\n");
//		if (b == 1 || b == 3 || b == 5 || b == 7 || b == 8 || b == 10 || b == 12)
//			printf("31天\n");
//		else if (b == 2)
//			printf("29天\n");
//		else
//			printf("30天\n");
//	}
//	else {
//		printf("不是闰年\n");
//		if (b == 4 || b == 6 || b == 9 || b == 11)
//			printf("30天\n");
//		else if (b == 2)
//			printf("28天\n");
//		else
//			printf("31天\n");
//	}
//	return 0;
//}
//int main()
//{
//	
//	int a, b, c;
//	a = getchar(); 
//	b = getchar();
//	c = a - b;
//	if (c % 2 == 0) {
//		putchar(a + 1);
//		putchar(b + 1);
//	}
//	else {
//		putchar(a - 1);
//		putchar(b - 1);
//	}
//	return 0;
//}
//int main()
//{
//	int a[10], i, zhi, shu;
//	for (i = 0; i < 10; i++)
//		scanf_s("%d", &a[i]);
//	for (i = 1; i < 10; i++) {
//		zhi = a[i];//抽取的元素，赋给一个变量，记住这个值
//		shu = i - 1;//表示到的抽取元素的前一个元素的下标
//		while (shu >= 0 && zhi < a[shu]) {//zhi<a[shu]表示抽取到的元素和前一个元素比较
//			a[shu+1] = a[shu];//shu+1把前一个元素赋值到后面一个去
//			shu--;//表示再前一个元素
//		}a[shu+1] = zhi;//如果前面不成立，直接把抽取到的元素原来的下标 相当于不变
//	}for (i = 0; i < 10; i++)
//		printf("%d ", a[i]);
//	return 0;
//}
//#include<string.h>
// int main()
//{
//	
//	char str1[10],str2[10];
//	gets(str1);
//	gets(str2);
//	strcat(str1, str2);
//	puts(str1);
//	return 0;
//}
//
//
//void ti_qu(char a[],int e)
//{
//	int i, j = 0, k, min,t;
//	char b[100] = { '\0' };
//	for (i = 0; i < e; i++){
//		if (a[i] == 'a' || a[i] == 'e' || a[i] == 'i' || a[i] == 'o' || a[i] == 'u') {
//			b[j] = a[i];
//			j++;
//		}
//	}  k = strlen(b);
//	for (i = 0; i < k; i++) {
//		min = 0;
//		for (j = 1; j < k - i; j++) {
//			if (b[j] < b[min]) {
//				t = b[j];
//				b[j] = b[min];
//				b[min] = t;
//			}min = j;
//		}
//	}	
//	printf("%s", b);
//}
//int main()
//{
//	int e;
//	char a[100] = { '\0' };
//	gets(a);
//	e = strlen(a);
//	ti_qu(a, e);
//	return 0;
//}
//void fuzi(int n,char a[])
//{
//	int i,j=0,x;
//	scanf_s("%d", &x);
//	char b[100] = { '\0' };
//	for (i = x - 1; i < n; i++) {
//		b[j] = a[i];
//		j++;
//	}printf("%s", b);
//}
//int main()
//{
//	int n,x,i;
//	char a[100];
//	scanf_s("%d", &n);
//	for (i = 0; i < n; i++)
//		scanf_s("%c", &a[i]);
//	fuzi(n, a);
//	return 0;
//}
//int main()
//{
//	int i,n,j,m,x ,min,t,a[10][10];
//	scanf_s("%d", &n);
//	for (i = 0; i < n; i++) {
//		for (j = 0; j < n; j++)
//			scanf_s("%d", &a[i][j]);
//	}min = fabs(a[0][0]);
//	m = 0;
//	x = 0;
//	for (i = 0; i < n; i++) {
//		for(j=1;j<n;j++)
//			if (min <fabs( a[i][j])) {
//				t = a[i][j];
//				m = i+1; x = j+1;
//			}
//	}printf("%d %d %d ", t, m, x);
//	return 0;
//}
//int main()
//{
//	float x,a,b,c,d;
//	scanf_s("%f", &x);
//	if (x < 0) {
//		a = fabs(x);
//		printf("%.2f", a);
//	}
//	else if (x >= 0 && x < 2) {
//		b = sqrt(x + 1);
//		printf("%.2f", b);
//	}
//	else if (x >= 2 && x < 4) {
//		c = pow(x + 2, 5);
//		printf("%.2f", c);
//	}
//	else {
//		d = 2 * x + 5;
//		printf("%.2f", d);
//	}
//	return 0;
//}
//unsigned long Fack(unsigned int n);
//int main()
//{
//	unsigned int x,sum;
//	scanf_s("%d", &x);
//	sum = Fack(x);
//	printf("%f",sum);
//	return 0;
//}
//int main()
//{
//	double i, a, b, c,sum=0;
//	scanf_s("%d", &a);
//	for ( i = 1; i <= a; i++) {
//		b = 1;
//		for (c = 1; c <= i; c++) 
//			b *= c;
//		(double) sum += 1 / b;
//	}printf("sum=%.5f",sum);
//	return 0;
//}
//int main()
//{
//	int a;
//	scanf_s("%d", &a);
//	printf("%0o", a);
//	return 0;
//}
////int main()
////{
////	int a[10], t,i,min=0;
////	for (i = 0; i < 10; i++)
////		scanf_s("%d", &a[i]);
////	for (i = 1; i < 10; i++) {
////		if (fabs(a[min]) > fabs(a[i]))
////			min = i;
////	}t = a[9];
////	a[9] = a[min];
////	a[min] = t;
////	for (i = 0; i < 10; i++)
////		printf("%d ", a[i]);
////	return 0;
////}

//int main()
//{
//	float x;
//	scanf_s("%f", &x);
//	if (x < 1)
//		printf("%.2f", x);
//	else if (x >= 1 && x < 10)
//		printf("%.2f", 2 * x - 1);
//	else
//		printf("%.2f", 3 * x - 11);
//	return 0;
//}
//int main()
//{
//	int a[13], i, j=0,k=0;
//	for (i = 0; i < 13; i++)
//		scanf_s("%d", a[i]);
//	for (i = 0; i < 13; i++) {
//		if (a[i] >= 85) {
//			j++;
//			printf(">=85:%d", j);
//		}
//		else if (a[i] >= 60 && a[i] <= 84) {
//			k++;
//			printf("60-80:%d", k);
//		}
//		else
//			printf("<60:%d", 13 - k - j);
//	}
//	return 0;
//}
//int main()
//{
//	int n, a[40] = { '\0' }, i, c, b;
//	a[0] = 1, a[1]=1; c = a[0], b = a[1];
//	scanf_s("%d", &n);
//	for (i = 2; i < n; i++) {
//		a[i] = c + b;
//		b = a[i];
//		c = a[i - 1];
//	}for (i = 0; i < n; i++)
//		printf("%d ", a[i]);
//	return 0;
//}
//int main()
//{
//	int a[4], i, j, min, t;
//	for (i = 0; i < 4; i++)
//		scanf_s("%d", &a[i]);
//	for (i = 0; i < 3; i++) {
//		min = i;
//		for (j = i + 1; j < 4; j++) {
//			if (a[min] > a[j])
//				min = j;
//		}t = a[i];
//		a[i] = a[min];
//		a[min] = t;
//	}for (i = 0; i < 4; i++)
//		printf("%d ", a[i]);
//	return 0;
//}
//int main()
//{
//	long long int N,i,j,min,sum=0;
//	scanf_s("%d", &N);
//	for (i = 1; i <= N; i++) {
//		min = 1;
//		for (j = 1; j <= i; j++)
//			min *= j;
//		sum += min;
//	}printf("%lld", sum);
//	return 0;
//}
//int main()
//{
//	int x, y;
//	float z;
//	for (x = 0; x <= 20; x++) {
//		for (y = 0; y <= 33; y++) {
//			z = 100 - x - y ;
//			if (5 * x + 3 * y + z / 3.0 == 100)
//				printf("cock=%d,hen=%d,chicken=%.0f\n", x, y, z);
//		}
//	}
//	return 0;
//}
//int main()
//{
//	int a, b, i,min;
//	scanf_s("%d", &a);
//	for (b = 2; b <= a; b++) {
//		min = 1;
//		for (i = 2; i < b; i++) {
//			if (b%i == 0) {
//				min = 0;
//				break;
//			}
//		}if (a == 2)
//			min = 1;
//		if (min)
//			printf("%d ", b);
//	}
//	
//	return 0;
//}
//int main()
//{
//	int a[10], i, j, min,t;
//	for (i = 0; i < 10; i++)
//		scanf_s("%d", &a[i]);
//	for (i = 0; i < 9; i++) {
//		min = i;
//		for (j = i + 1; j < 10; j++) {
//			if (a[min] < a[j])
//				min = j;
//		}t = a[min];
//		a[min] = a[i];
//		a[i] = t;
//	}for (i = 0; i < 10; i++)
//		printf("%d ", a[i]);
//	return 0;
//}
//int main()
//{
//	int a[] = { '\0' }, x, i, j = 0, min=0;
//	for (i = 0; i < 100; i++) {
//		scanf_s("%d", &a[i]);
//		j++;
//		if (a[i] == -1)
//			break;
//	}
//	for (i = 1; i < j; i++) {
//		if (a[min] < a[i])
//			min = i;
//	}printf("%d", a[min]);
//	return 0;
//}
//void tongji(char a[],int x)
//{
//	int i, j = 0, b = 0, c = 0, d = 0;
//	for (i = 0; i < x; i++) {
//		if (isalpha(a[i]))
//			j++;
//		else if (isdigit(a[i]))
//			b++;
//		else if (a[i] == ' ')
//			c++;
//		else
//			d++;
//	}printf("%d %d %d %d", j, b, c, d);
//}
//int main()
//{
//	char a[100] = { '\0' };
//	gets(a);
//	int x;
//	x = strlen(a);
//	tongji(a,x);
//	return 0;
//}
//void paixu(char a[], int x)
//{
//	int i, t, min,j;
//	for (i = 0; i < x-1; i++) {
//		min = i;
//		for (j = i + 1; j < x; j++) {
//			if (a[min] > a[j])
//				min = j;
//		}t = a[min];
//		a[min] = a[i];
//		a[i] = t;
//	}printf("%s\n", a);
//}
//int main()
//{
//	char a[10] = { '\0' }, b[10] = { '\0' }, c[10] = { '\0' };
//	gets(a);
//	gets(b);
//	gets(c);
//	int x;
//	x = strlen(a);
//	paixu(a, x);
//	paixu(b, x);
//	paixu(c, x);
//	return 0;
//}
//int main()
//{
//	int a[10], i, j, t, min = 0;
//	for (i = 0; i < 10; i++)
//		scanf_s("%d", &a[i]);
//	for (i = 1; j < 10; i++) {
//		if (a[min] < a[i])
//			min = i;
//	}if (a[min] == a[9])
//		
//	else {
//		t = a[9];
//		a[9] = a[min];
//		a[min] = t;
//	}
//	return 0;
//}
//int main()
//{
//	unsigned long  min;
//	int i,j;
//	min = 1;
//	for (j = 1; j <= 1977; j++)
//		min *= j;
//	printf("%lld", min);
//	return 0;
//}
//int main()
//{
//	int a[1024] = { '\0' }, i, j = 0, x = 0, b = 0, c = 0;
//	for (i = 0; i < 1024; i++) {
//		scanf_s("%d", &a[i]);
//		if (a[i] <= 0) {
//			break;
//		}j++;
//	}
//	for (i = 0; i < j; i++) {
//		if (a[i] >= 85) {
//			x++;
//		}
//		else if (a[i] >= 60 && a[i]<=84) {
//			b++;
//		}
//		else
//			c++;
//	}
//	printf(">=85:%d\n60-84:%d\n<60:%d", x, b, c);
//	return 0;
//}
//
//int digui(int n);
//
//int main()
//{
//	int n;
//	while (scanf_s("%d", &n) != EOF)
//		printf("%d", digui(n));
//	return 0;
//}
//int digui(int n)
//{
//	if (n <= 4)
//		return n;
//	else
//		return	digui(n - 1) + digui(n - 3);
//
//}
#include<stdio.h>
#include<string.h>
#include<math.h>
#include<ctype.h>
//int main()
//{
//	int sum, size, i;
//	char a[1024] = { '\0' }, b[50] = { '\0' };
//	gets(a);
//	size = strlen(a);
//	for (i = 0; i < size; i++)
//		b[size - i - 1] = a[i];
//	strcat(a, b);
//		printf("%s", a);
//	return 0;
//}
//int main()
//{
//	int i, j = 0,sum;
//	char a[1024] = { '\0' };
//	gets(a);
//	sum = strlen(a);
//	for (i = 0; i < sum; i++) {
//		if (isalpha(a[i]))
//			j++;
//	}printf("%d", j);
//	return 0;
//}
//int main()
//{
//	int n,a, sum, i;
//	scanf_s("%d", &n);
//	sum = n * n*n;
//	for (i = 1; i <= n; i++) {
//		a = n * n - n + 1 + 2 * i - 2;
//		printf("%d*%d*%d=%d=%d+", n, n, n, sum, );
//	}
//	return 0;
//}
//int main()
//{
//	int n,i;
//	scanf_s("%d", &n);
//	for (i = 1; i <= n; i++)
//		printf("%d ", n*n - n + 1 + 2 * i - 2);
//	return 0;
//}

//int main()
//{
//	int n, i;
//	float a, sum = 100;
//	scanf_s("%d", &n);
//	if (n == 1)
//		printf("%.4f", sum);
//	else {
//		for (i = 0; i <= n - 2; i++) {
//			a = pow(0.5, i) * 100;
//			sum += a;
//		}
//		printf("%.4f", sum);
//	}
//	return 0;
//}
//
//int main()
//{
//	int n, m, j, i,sum=0;
//	scanf_s("%d", &m);
//	for (i = 1; i <= m; i++) {
//		if (i % 2 != 0) {
//			sum += i;
//		}
//	}printf("%d", sum);
//	return 0;
//}
//int main()
//{
//	int  i, a, n;
//	long long sum, num=0;
//	scanf_s("%d%d", &a, &n);
//	for (i = 1; i <= n; i++) {
//		sum = ((pow(10, i) - 1)*a) / 9;
//		num += sum;
//	}printf("%lld", num);
//	return 0;
//}
//int main()
//{
//	char a[200] = { '\0' };
//	int i, j = 0, c = 0, k = 0, d = 0, sum;
//	gets(a);
//	sum = strlen(a);
//	for (i = 0; i < sum; i++) {
//		if (isalpha(a[i]))
//			j++;
//		else if (a[i] == ' ')
//			c++;
//		else if (isdigit(a[i]))
//			d++;
//		else
//			k++;
//	}printf("%d %d %d %d", j, d, c, k);
//	return 0;
//}
//int main()
//{
//	int k, m, i, j, sum;
//	scanf_s("%d", &m);
//	for (i = 1; i <= m; i++){
//		sum = 0;
//		for (j = 1; j < i; j++) {
//			if (i%j == 0)
//				sum += j;
//		}
//		if (i == sum) {
//			printf("%d its factors are ", i);
//			for (k = 1; k < i; k++) {
//				if (i%k == 0)
//					printf("%d ", k);
//			}printf("\n");
//		}
//	}
//	return 0;
//}
//int main()
//{
//	char a[1024] = { '\0' }, b[1024] = { '\0' };
//	int i, j, n, m, k = 0,sum;
//	scanf_s("%d", &n);
//	for (i = 0; i < n; i++)
//		getchar();
//	scanf_s("%d", &m);
//	for (j = m-1; j < n; j++) {
//		b[k] = a[j];
//		k++;
//	}printf("%s", b);
//	return 0;
//}
//int main()
//{
//	int i, sum;
//	char a[1024] = { '\0' };
//	gets(a);
//	sum = strlen(a);
//	for (i = 0; i < sum; i++) {
//		if (isalpha(a[i])) {
//			if (a[i] == 'Z')
//				a[i] = 'A';
//			else if (a[i] == 'z')
//				a[i] = 'a';
//			else
//				a[i] = a[i] + 1;
//		}
//	}printf("%s", a);
//	return 0;
//}

//int main(void)
//{
//	int a,n,i,b;
//	for (i = 1; i < 10000; i++) {
//		if (i % 8 == 1 && (i / 8) % 8 == 1 && ((i / 8) / 8) % 8 == 7) {
//			a = (((i / 8) / 8) / 8);
//			if (i % 17 == 4 && (i / 17) % 17 == 15) {
//				b = ((i / 17) / 17);
//					if (b == 2 * a)
//						printf("%d", i);
//			}
//		}
//	}
//	return 0;
//}
//int main(void)
//{
//	int i, j, a, b, sum , num ;
//	for(a = 1,b=1; a <= 3000||b<=3000; a++,b++)  {
//		sum = 0, num = 0;
//		for (j = 1; j < a; j++) {
//			if (a%j == 0)
//				sum += j;
//		}
//		for (i = 1; i < b; i++) {
//			if (b%i == 0)
//				num += i;
//		}
//		if (sum == b && num == a)
//			printf("(%d,%d)", a, b);
//		
//	}
//	return 0;
//}
//int main()
//{
//	int n,x, i,j=0, a[1024] = {'\0'},min;
//	for (i = 0; i < 1024; i++) {
//		scanf_s("%d", &a[i]);
//		if (a[i] == -1)
//			break;
//		j++;
//	}
//	min = 0;
//	for (x = 1; x < j; x++) {
//		if (a[min] < a[x])
//			min = x;
//	}printf("%d", a[min]);
//	return 0;
//}
//int main()
//{
//	int i;
//	long double sum = 0,PI;
//	for (i = 1; i < 1000000; i++) {
//		sum += (pow(-1, i + 1)) / (long double)(2 * i - 1);
//		if (fabs((pow(-1, i + 1)) / (long double)(2 * i - 1)) < 1e-6) {
//			printf("%.6lf", 4 * sum);
//			break;
//		}
//	}
//	return 0;
//}
//int main()
//{
//	char a[1024] = { '\0' };
//	int i,sum;
//	gets(a);
//	sum = strlen(a);
//	for (i = 0; i < sum; i++) {
//		if (a[i]>=65&&a[i]<97)
//			a[i] = a[i] + 32;
//	}printf("%s", a);
//	return 0;
//int main()
//{
//	int i, x, j, a;
//	for (i = 1; i < 40; i++) {
//		if (i == 1)
//			printf("%d/%d,", i, 40);
//		if (40 % i != 0) {
//			if (i % 2 == 0||i%5==0) 
//				continue;
//			else
//			{
//				printf("%d/%d,", i, 40);
//			}
//		}
//	}
//	return 0;
//}
//int main()
//{
//	char a[80] = { '\0' }, b[80] = { '\0' };
//	int i, j=0,sum;
//	gets(a);
//	sum = strlen(a);
//	for (i = 0; i < sum; i++) {
//		if (isalpha(a[i])) {
//			b[j] = a[i];
//			j++;
//		}
//	}printf("%s", b);
//	return 0;
//}
//int main()
//{
//	char a[1024] = {'\0'};
//	long long i, j = 0, sum, size;
//	for (i = 0; i < 200000; i++) {
//		if (i == 0)
//			printf("%d  ", i);
//		else {
//			sum = pow(i, 2);
//			a[j] = i;
//			size = strlen(a);
//			if (size < 4) {
//				if (i == sum % 10) {
//					printf("%d  ", i);
//					j++;
//				}
//			}
//			else if (size>=4&&size < 6) {
//				if (i == sum % 100) {
//					printf("%d  ", i);
//					j++;
//				}
//			}
//			else if (size <8&&size>=6) {
//				if (i == sum % 1000) {
//					printf("%d  ", i);
//					j++;
//				}
//			}
//			else if (size==8 ) {
//				if (i == sum % 10000) {
//					printf("%d  ", i);
//					j++;
//				}
//			}
//			else if (size == 9) {
//				if (i == sum % 100000) {
//					printf("%d  ", i);
//					j++;
//				}
//			}
//			else{
//				if (i == sum % 1000000)
//					printf("%d", i);
//			}
//		}
//	}
//	return 0;
//}
//int main()
//{
//	int n;
//	scanf_s("%d", &n);
//	double i, t, sum=0;
//	for (i = 1; i <= n; i++) {
//		t = 1.0 / i;
//		sum += t;
//	}printf("%.6f", sum);
//	return 0;
//}
//int main()
//{
//	int m;
//	scanf_s("%d", &m);
//	double i, t, sum = 1;
//	for (i = 1; i <= m; i++) {
//		t = 1.0 / (i * i);
//		sum -= t;
//	}
//	printf("%.6f", sum);
//	return 0;
//}
//int main()
//{
//	int a, b, c, d, e;
//	scanf_s("%d", &a);
//	b = a / 1000;
//	c = (a - b * 1000) / 100;
//	d = (a - b * 1000 - c * 100) / 10;
//	e = a - b * 1000 - c * 100 - d * 10;
//	b = (b + 9) % 10;
//	c= (c + 9) % 10;
//	d= (d + 9) % 10;
//	e= (e + 9) % 10;
//	a = d * 1000 + e * 100 + b * 10 + c;
//	printf("%d", a);
//	return 0;
//}
//#include<stdio.h>
//int main()
//{
//	int a = 1234;
//	printf("%#O \n", a);
//	printf("%#0X", a);
//	return 0;
//}
//int main()
//{
//	char a[1024] = { '\0' };
//	int i,size,j=0,k=0;
//	for (i = 0; i < 1024; i++) {
//		a[i] = getchar();
//		if (a[i] == '#')
//			break;
//	}
//	size = strlen(a);
//	for (i = 0; i < size; i++) 
//	{
//		if (isalpha(a[i]))
//		{
//			if (a[i] >= 65 && a[i] < 90)
//				j++;
//			else if (a[i] >= 97 && a[i] <= 122)
//				k++;
//		}
//	}printf("%d %d", j, k);
//	return 0;
//}
//int main()
//{
//	int a = 0, b = 0;
//	char ch;
//	while (ch = getchar() != '#') {
//		if (ch >= 'a'&&ch <= 'z')
//			a = a + 1;
//		else if (ch >= 'A'&&ch <= 'Z')
//			b = b + 1;
//	}printf("%d %d", a, b);
//	return 0;
//}
//int main()
//{
//	int a, b, sum;
//	scanf_s("%0x%0", &a, &b);
//	switch (switch_on)
//	{
//	default:
//		break;
//	}
//	sum = a + b;
//	printf("%d", sum);
//	return 0;
//}
//#include<stdio.h>
//int main()
//{
//	int a, i, j, k, x;
//	while (scanf_s("%d", &a) != EOF)
//	{
//		for (i = 1; i <= a; i++) {
//			//for(j=1;j<=a-i;j++)
//			   // printf("  ");
//			for (k = 1; k = i; k++)
//				printf("* ");
//			printf("\n");
//		}
//	}
//	return 0;
//}
//void fun(int a[],int n)
//{
//	int *pa = a;
//	if (n >= 0 && n < 10)
//	{
//		printf("%d ", *(pa+n));
//		fun(a, n- 1);
//	}
//}
//int main()
//{
//	int a[1024], n, i;
//	scanf("%d", &n);
//	for (i = 0; i < n; i++)
//		scanf("%d", &a[i]);
//	fun(a,n);
//	return 0;
//}有n人围成一圈，顺序排号。从第1个人开始报数（从1到3报数）
//，凡报到3的人退出圈子，问最后留下的是原来的第几号的那位。
//int main()
//{
//	int  i, n, k = 0, m;
//	scanf_s("%d", &n);
//	for (i = 1; i <= n; i++)
//	{
//		m = i;
//		while (m != 0)
//		{
//			if (m % 10 == 3)
//			{
//				k++;
//				break;
//			}
//			else
//				m = m / 10;
//		}
//	}
//	printf("%d", n - k);
//	return 0;
//}
//}定义一个带参的宏，使两个参数的值互换，
//并写出程序，输入两个数作为使用宏时的实参。输出已交换后的两个值。
//#define M(x,y) t=y,y=x,x=t
//int main()
//{
//	int x, y, t;
//	scanf_s("%d%d", &x, &y);
//	M(x, y);
//	printf("%d %d", x,y);
//	return 0;
//}输入两个整数，求他们相除的余数。用带参的宏来实现，编程序。
//#define YU(a,b) (a)%(b)
//int main()
//{
//	int a, b;
//	scanf_s("%d%d", &a, &b);
//	printf("%d", YU(a, b));
//	return 0;
//}三角形面积=SQRT(S*(S-a)*(S-b)*(S-c)) 其中S=(a+b+c)/2，a、b、c为三角形的三边。 
//定义两个带参的宏
//，一个用来求area， 另一个宏用来求S。 写程序，在程序中用带实参的宏名来求面积area。
//#include<math.h>
//#define S(a,b,c) ((a)+(b)+(c))/2
//#define AREA sqrt((S(a,b,c))*(S(a,b,c)-a)*(S(a,b,c)-b)*(S(a,b,c)-c))
//int main()
//{
//	float a, b, c;
//	scanf_s("%f%f%f", &a, &b, &c);
//	S(a, b, c);
//	printf("%.3f", AREA);
//	return 0;
//}给年份year，定义一个宏，以判别该年份是否闰年。提示：
//宏名可以定义为LEAP_YEAR，形参为y，既定义宏的形式为 
//#define LEAP_YEAR(y) （读者设计的字符串）
//#define LEAP_YEAR(y) y % 4 == 0 || y % 400 == 0 && y % 100 != 0
//int main()
//{
//	int y;
//	scanf_s("%d", &y);
//	if (LEAP_YEAR(y))
//		printf("L");
//	else
//		printf("N");
//	return 0;
//}
//分别用函数和带参的宏，从三个数中找出最大的数。
//#define MAX(a,b,c) (t=(a>b?a:b))>c?t:c
//void max(float a, float b, float c)
//{
//	float t;
//	printf("%.3f\n", MAX(a,b,c));
//}
//int main()
//{
//	float a, b, c, t;
//	scanf_s("%f%f%f", &a, &b, &c);
//	max(a, b, c);
//	printf("%.3f\n", MAX(a, b, c));
//	return 0;
//}
//int main()
//{
//	int a[4] = { 1,2,3,4 }, i;
//	int *pa = a;
//	for (i = 0; i < 4; i++)
//	{
//		printf("%d", *(pa++));
//	}printf("\n");
//	int arr[4] = { 1,2,3,4 };
//	int *p = arr;
//	for (i = 0; i < 3; i++)
//	{
//		printf("%d", *(++p));
//	}
//	return 0;
//}
//int main()
//{
//	char a[3] = { "abc" }, b[3] = { "abc" };
//	int min;
//	min = strcmp(a, b);
//	printf("%d", min);
//}
#include<stdlib.h>
#include<time.h>
//int main()
//{
//	int a;
//	//srand((unsigned)time(NULL));
//	a = 1 + rand() % 10;
//	printf("%d", a);
//	return 0;
//void main()
//{
//	int i;
//	int * a = (int *) malloc(10);
//	if (a == NULL)
//	{
//		printf("1");
//	}
//	for (i = 0; i < 4; i++)
//		scanf_s("%d", &a[i]);
//	for (i = 0; i < 4; i++)
//		printf("%d", a[i]);
	/*char *p=(char *)malloc(4);
	if (p != NULL)
	{
		 printf("1");
	}
	int i;
	for (i = 0; i < 4; i++)
		scanf_s("%c", &p[i]);
	for (i = 0; i < 4; i++)
	定义一个结构体变量（包括年、月、日）。计算该日在本年中是第几天，注意闰年问题。
	printf("%d", p);*/
//struct date {
//	int nian;
//	int yue;
//	int ri;
//};
//int main()
//{
//	struct date time;
//	int shijian[12] = { 31,28,31,30,31,30,31,31,30,31,30,31 }, i,sum=0,num=0;
//	scanf_s("%d%d%d", &time.nian, &time.yue, &time.ri);
//	if ((time.nian % 4 == 0 && time.nian % 100 != 0) || time.nian % 400 == 0)
//	{
//		for (i = 0; i < time.yue-1; i++)
//		{
//			if (i == 1)
//				sum += 1;
//			sum += shijian[i];
//		}
//		sum += time.ri;
//		printf("%d", sum);
//	}
//	else
//	{
//		for (i = 0; i < time.yue-1; i++)
//		{
//			
//			num += shijian[i];
//		}
//		num += time.ri;
//		printf("%d", num);
//	}
//	return 0;
//}
//现有有N个学生的数据记录，每个记录包括学号、姓名、三科成绩。
//编写一个函数input, 用来输入一个学生的数据记录。 
//编写一个函数print, 打印一个学生的数据记录。 
//在主函数调用这两个函数，读取N条记录输入，再按要求输出。 N < 100
//struct xue {
//	char xuehao[10];
//	char name[10];
//	int math;
//	int english;
//	int chinese;
//};
//struct sheng {
//	struct xue stu [100];
//}sheng;
//void input(int i)
//{
//	scanf_s("%s %s %d %d %d", sheng.stu[i].xuehao, sheng.stu[i].name, &(sheng.stu[i].math), &(sheng.stu[i].english), &(sheng.stu[i].chinese));
//}
//void print(int i)
//{
//		printf("%s,%s,%d,%d,%d\n",sheng.stu[i].xuehao, sheng.stu[i].name, sheng.stu[i]. math, sheng.stu[i].english, sheng.stu[i].chinese);	
//}
//int main()
//{
//	int N,i;
//	scanf_s("%d", &N);
//	getchar();
//	for (i = 0; i < N; i++)
//	{
//		input(i);
//	}
//	for (i = 0; i < N; i++)
//	{
//		print(i);
//	}
//	return 0;
//}
//struct stu
//{
//	char num[100];
//	char name[100];
//	int score[3];
//};
//void input(struct stu* a, int n);
//void output(struct stu* a, int n);
//int main(void)
//{
//	int n;
//	scanf_s("%d", &n);
//	struct stu a[100];
//	input(a, n);
//	output(a, n);
//
//	return 0;
//}
//
//void input(struct stu * a, int n)
//{
//	int i;
//	for (i = 0; i < n; i++)
//	{
//		scanf_s("%s%s%d%d%d", &(a[i].num), &(a[i].name), &(a[i].score[0]), &(a[i].score[1]), &(a[i].score[2]));
//	}
//}
//
//void output(struct stu* a, int n)
//{
//	int i;
//	for (i = 0; i < n; i++)
//	{
//		printf("%s,%s,%d,%d,%d\n", a[i].num, a[i].name, a[i].score[0], a[i].score[1], a[i].score[2]);
//	}
//}
//int main()
//{
//	int *p =(int *)malloc(2003);
//	if (p == NULL)
//	{
//		exit(1);
//	}
//	for (int i = 0; i < 100; i++)
//	{
//		*(p + i) = i;
//	}
//	for (int i = 0; i < 100; i++)
//	{
//		printf("%d ",*(p++));
//	}
//	return 0;
//}
//int main()
//{
	//int a[10];
	//for (int i = 0; i < 10; i++)
	//	a[i] = i;
	//int(*p)[10] = &a;//表示是p是数组指针
	//for (int i = 0; i < 10; i++)
	//	printf("%d", (*p)[i]);
	/*int i, j, a[10][10];
	for (i = 0; i < 4; i++)
	{
		for (j = 0; j < 4; j++)
			scanf_s("%d", &a[i][j]);
	}
	int* p[4] = { a };
	for (i = 0; i < 4; i++)
	{
		for (j = 0; j < 4; j++)
		{
			printf("%d ", *(p[i] + j));
		}
		printf("\n");
	}*/
//	int a = 2;
//	int *p = &a;
//	int* *pa = &p;
//	printf("%d", *(*pa));
//	return 0;
//}

//int main()
//{
//	int arr1[5] = { 1,2,3,4,5 };
//	int arr2[5] = { 2,3,4,5,6 };
//	int arr3[5] = { 3,4,5,6,7 };
//	int* p[3] = { arr1,arr2,arr3 };
//	int(*pa)[5] = &arr1;
//	for (int i = 0; i < 5; i++)
//	{
//		printf("%d ", (*pa)[i]);//pa=&arr1,所以*pa->arr1
//		printf("%d ", *(*pa + i));
//	}
//	printf("\n");
//
//	for (int i = 0; i < 3; i++)
//	{
//		for (int j = 0; j < 5; j++)
//		{
//			printf("%d ", *(p[i] + j));
//			printf("%d ", p[i][j]);
//		}
//		printf("\n");
//	}
//	return 0;
//}
//int main()
//{
//	int a = 1, b = 0;
//	if (!a)//首先你要知道！a是什么意思是吧，！a就是非的意思，一开始a=1，所以非就是0，
//		b++;//所以就是假，这个语句不会执行
//	else if (a == 0)//然后就是这个了，a=1；这个也不会执行是吧
//	{
//		if (a)
//			b += 2;
//		else         //你肯定疑惑这else是吧 这个是这样的就是最后一个else和他前面最近的一个if结合
//			b += 3;
//	}
//		       //相当于就近原则
//	printf("%d", b);//所以就是0咯
//	return 0;
//}
//int main()
//{
//	int i, n, k=0, a=10;
//	for (i = 1; i <= 10; i++)
//	{
//		if (i > 0)
//		{
//			if (i == 0)
//			{
//				k++;
//			}
//			else
//				break;
//		}
//		printf("%d", i);
//	}
//	printf("%d", a );
//	return 0;
//}
//#include<stdio.h>
//int main()
//{
//	int k, n, i, a[128], num, j, b[128], x = 0, mun;
//	scanf_s("%d", &n);
//	for (i = 0; i < n; i++)
//		scanf_s("%d", &a[i]);
//	for (i = 0; i < n - 1; i++)
//	{
//		num = i;
//		k = 0;
//		for (j = 1 + i; j < n; j++)
//		{
//			if (a[num] < a[j])
//			{
//				if (a[j] - a[num] == 1)
//				{
//					k++;
//				}
//				else
//					break;
//			}
//			i++;
//			num = j;
//			b[x] = k;
//			x++;
//			
//		}
//	}
//	mun = b[0];
//	for (i = 0; i < x; i++)
//	{
//		if (mun < b[i])
//			mun = b[i];
//	}
//	printf("%d", mun+1);
//	return 0;
//}
//#include<stdio.h>
//int main()
//{
//	int n, i, j, num, a[128], k = 0;
//	scanf_s("%d", &n);
//	for (i = 0; i < n; i++)
//	{
//		scanf_s("%d", &a[i]);
//	}
//	for (i = 0; i < n - 1; i++)
//	{
//		num = a[i];
//		for (j = i + 1; j < n; j++)
//		{
//			if (num == a[j])
//			{
//				printf("ture");
//				k++;
//				break;
//			}
//		}
//		if (k == 1)
//			break;
//	}
//	if (k == 0)
//		printf("false");
//	return 0;
//}
//int main()
//{
//	int i, j, a = 0, k, s = 0;
//	scanf_s("%d", &k);
//	for (i = 1; a != k; i++)
//	{
//		for (j = 1; j <= i; j++)
//		{
//			a= a+1;
//			s=s+ i;
//			if (a == k)
//			{
//				break;
//			}
//		}
//	}
//	printf("%d", s);
//	return 0;
//}

//int fun(long long n)
//{
//	long long k = 0, i;
//	for (i = 1; i <= n; i++)
//		k += i;
//	return k;
//}
//int main()
//{
//	long long i, j = 0, k = 0, n, m = 0;
//	scanf_s("%lld", &n);
//	for (i = 1; fun(i) <= n; i++)
//		j = fun(i);
//	k = n - j;
//	i--;
//	m = ((i * i + i) * (2 * i + 1) / 6) + k * (i + 1);
//	printf("%lld\n", m);
//	return 0;
//}*/
//int main()
//{
//	int n, i, j, k, a[128];
//	scanf_s("%d", &n);
//	for (i = 0; i < n; i++)
//		a[i] = 0;
//	printf("%d", n);
//	printf("\n");
//	for (i = 0; i < n; i++)
//	{
//		for (j = 0; j < n; j++)
//		{
//			if (j == i)
//				continue;
//			if (a[j] == 0)
//				a[j] = 1;
//			else
//				a[j] = 0;
//		}
//		for (k = 0; k < n; k++)
//		{
//			printf("%d", a[k]);
//		}
//		printf("\n");
//	}
//	return 0;
//}
//#define MAXSIZE 100
//typedef int datatype;
//typedef struct
//{
//	datatype data[MAXSIZE];
//	int length;
//}sqlist;
//int main()
//{
//	sqlist L;
//	L.length = 0;
//	for (int i = 0; i < MAXSIZE; i++)
//	{
//		scanf_s("%d", &L.data[i]);
//	}
//	return 0;
//}
int main()
{
	int a[100] = { 0 }, b[100] = { 0 }, c[100] = { 0 };
	char s1[100] = { '\0' }, s2[100] = { '\0' };
	int i, j, k,pa;
	gets(s1);
	gets(s2);
	for (i = 0; i < strlen(s1); i++)
	{
		a[i] = s1[strlen(s1) - 1 - i] - '0';//把字符串变成整型
	}
	for (i = 0; i < strlen(s2); i++)
	{
		b[i] = s2[strlen(s2) - 1 - i] - '0';//把字符串变成整型
	}
	if (strlen(s1) > strlen(s2))//最大的位数
		pa = strlen(s1);
	else
		pa = strlen(s2);
	for (i = 0; i < pa; i++)
	{
		c[i] = c[i] + a[i] + b[i];//再加个c[i]表示要进位
		c[i + 1] = c[i] / 10;
		c[i] = c[i] % 10;
	}
	//去前导零
	pa++;
	while (c[pa - 1] == 0)
	{
		if (pa == 1)
			break;
		pa--;
	}
	for (i = pa - 1; i >= 0; i--)
	{
		printf("%d", c[i]);
	}
	return 0;
}