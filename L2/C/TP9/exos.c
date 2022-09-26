#include <stdio.h>
#include "afficheur.c"
#include <math.h>

node* cons_tree(int val,node* tl, node* tr){
    node* res= malloc(sizeof(node));
    assert(res!=NULL);
    res->val=val;
    res->left=tl;
    res->right=tr;
    return res;
}

void free_tree(node* t){
    if(t!=NULL){
        free_tree(t->left);
        free_tree(t->right);
        free(t);
    }
}

int size_tree(node* t){
    if(t==NULL) return 0;
    int res=1;
    res+=size_tree(t->left);
    res+=size_tree(t->right);
    return res;
}

int sum_tree(node* t){
    if(t==NULL) return 0;
    int res=t->val;
    res+=sum_tree(t->left);
    res+=sum_tree(t->right);
    return res;
}

int depth_tree(node* t){
    if(t==NULL) return 0;
    if(t->left==NULL && t->right==NULL) return 0;
    double depthLeft=1+depth_tree(t->left);
    double depthRight=1+depth_tree(t->right);
    return fmax(depthLeft,depthRight);
}

void print_abr(node* t){
    if(t!=NULL){
        print_abr(t->left);
        printf("%d",t->val);
        print_abr(t->right);
    }
}

int main(void) {
    node* t;
    t=cons_tree(1, cons_tree(3,NULL,NULL), cons_tree(6, cons_tree(4,NULL,NULL),NULL));
    pretty_print(t);
    //printf("%d\n",size_tree(t));
    //printf("%d\n",sum_tree(t));
    //printf("%d\n",depth_tree(t));
    print_abr(t);
}