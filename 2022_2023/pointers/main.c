/*
 * File:   main.c
 * Author: ESTG
 */

#include <stdio.h>
#include <string.h>

void swap(int *x, int *y) { 
    int tmp;
    
    printf("\n//swap()\n");
    printf("x\t(%p): %p -> %d\n", &x, x, *x);
    printf("y\t(%p): %p -> %d\n", &y, y, *y);
    printf("tmp\t(%p): %d\n", &tmp, tmp);
    
    tmp = *x;
    printf("\n//tmp = *x;\n");
    printf("x\t(%p): %p -> %d\n", &x, x, *x);
    printf("y\t(%p): %p -> %d\n", &y, y, *y);
    printf("tmp\t(%p): %d\n", &tmp, tmp);
    
    *x = *y;
    printf("\n//*x = *y;\n");
    printf("x\t(%p): %p -> %d\n", &x, x, *x);
    printf("y\t(%p): %p -> %d\n", &y, y, *y);
    printf("tmp\t(%p): %d\n", &tmp, tmp);

    *y = tmp; 
    printf("\n// *y = tmp;\n");
    printf("x\t(%p): %p -> %d\n", &x, x, *x);
    printf("y\t(%p): %p -> %d\n", &y, y, *y);
    printf("tmp\t(%p): %d\n", &tmp, tmp);

    printf("...\n");
}

void swap_pointers(char *x, char *y) { 
    char *tmp = NULL;

    printf("\n//swap_pointers()\n");
    printf("x\t(%p): %p -> %c\n", &x, x, *x);
    printf("y\t(%p): %p -> %c\n", &y, y, *y);
    printf("tmp\t(%p): %p -> \n", &tmp, tmp);

    tmp = x;
    printf("\n//tmp = x;\n");
    printf("x\t(%p): %p -> %c\n", &x, x, *x);
    printf("y\t(%p): %p -> %c\n", &y, y, *y);
    printf("tmp\t(%p): %p -> %c\n", &tmp, tmp, *tmp);

    x = y;
    printf("\n//x = y;\n");
    printf("x\t(%p): %p -> %c\n", &x, x, *x);
    printf("y\t(%p): %p -> %c\n", &y, y, *y);
    printf("tmp\t(%p): %p -> %c\n", &tmp, tmp, *tmp);
    
    y = tmp;
    printf("\n//y = tmp;\n");
    printf("x\t(%p): %p -> %c\n", &x, x, *x);
    printf("y\t(%p): %p -> %c\n", &y, y, *y);
    printf("tmp\t(%p): %p -> %c\n", &tmp, tmp, *tmp);
}

void swap_pointers_(char **x, char **y) { 
    char *tmp = NULL;

    printf("\n//swap_pointers_()\n");
    printf("x\t(%p): %p -> %p -> %c\n", &x, x, *x, **x);
    printf("y\t(%p): %p -> %p -> %c\n", &y, y, *y, **y);
    printf("tmp\t(%p): %p -> \n", &tmp, tmp);

    tmp = *x;
    printf("\n//tmp = *x;\n");
    printf("x\t(%p): %p -> %p -> %c\n", &x, x, *x, **x);
    printf("y\t(%p): %p -> %p -> %c\n", &y, y, *y, **y);
    printf("tmp\t(%p): %p -> %c\n", &tmp, tmp, *tmp);

    *x = *y;
    printf("\n//*x = *y;\n");
    printf("x\t(%p): %p -> %p -> %c\n", &x, x, *x, **x);
    printf("y\t(%p): %p -> %p -> %c\n", &y, y, *y, **y);
    printf("tmp\t(%p): %p -> %c\n", &tmp, tmp, *tmp);
    
    *y = tmp;
    printf("\n//*y = tmp;\n");
    printf("x\t(%p): %p -> %p -> %c\n", &x, x, *x, **x);
    printf("y\t(%p): %p -> %p -> %c\n", &y, y, *y, **y);
    printf("tmp\t(%p): %p -> %c\n", &tmp, tmp, *tmp);
}

void func(){
    int local = 99;
    printf("\n//func()\n");
    printf("...\n");
    printf("local\t(%p): %d\n", &local, local);
    printf("...\n");
}

int global = 99;

int main() {


    int a = 0, b = 1, i;
    char *s1 = "da programaÃ§Ã£o", *s2 = "Fundamentos";
    char arr[4] = {'a','b','c','d'};

    printf("\n\n");

    printf("//This program intends to show how memory is allocated and some caveats about pointers\n");
    printf("//local variables and statically allocated arrays are allocated in the Stack (larger addresses)\n");
    printf("//global variables and dynamically allocated arrays are allocated in the Heap (shorter addresses)\n");
    printf("//For more info head to https://craftofcoding.wordpress.com/2015/12/07/memory-in-c-the-stack-the-heap-and-static/\n\n");
    
    printf("//main()\n");
    printf("global\t(%p): %d\n", &global, global);
    printf("a\t(%p): %d\n", &a, a);
    printf("b\t(%p): %d\n", &b, b);
    printf("i\t(%p): %d\n", &i, i);
    printf("s1\t(%p): %p\n", &s1, s1);
    printf("s2\t(%p): %p\n", &s2, s2);
    for (i=3; i>=0; i--)
        printf("arr[%d]\t(%p): %c\n", i, &(arr[i]), arr[i]);

    func();

    printf("\n//back to main()\n");
    printf("...\n");

    char *ptr = s2 + strlen(s2);
    while(ptr != s1-1)
    {
        printf("\t(%p): %c\n", ptr, *ptr);
        ptr--;
    }

    swap(&a, &b); 
    
    printf("\n//back to main()\n");
    printf("a\t(%p): %d\n", &a, a);
    printf("b\t(%p): %d\n", &b, b);
    printf("...\n");

    //swap_pointers(s1, s2); 
    swap_pointers_(&s1, &s2); 

    printf("\n//back to main()\n");
    printf("...\n");

    printf("a\t(%p): %d\n", &a, a);
    printf("b\t(%p): %d\n", &b, b);
    printf("s1\t(%p): %p\n", &s1, s1);
    printf("s2\t(%p): %p\n", &s2, s2);
    
    ptr = s1 + strlen(s1);
    while(ptr != s2-1)
    {
        printf("\t(%p): %c\n", ptr, *ptr);
        ptr--;
    }   

    printf("%s %s\n", s1, s2);

    return 0; 
}


/*
void incrementa(int *var) {
    (*var)++;
}

void atualiza_apontador(char **ptr, char *b) {
    *ptr = b;
}

int main() {
    int a = 3;
    incrementa(&a);
    printf("%d\n\n", a);

    char *s1 = "hello", *s2 = "world";
    char *ptr = s1;
    printf("%s\n", ptr);
    printf("A trocar...\n");
    atualiza_apontador(&ptr, s2);
    printf("%s\n", ptr);
}

*/