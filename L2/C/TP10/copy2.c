#include <stdio.h>
#include <malloc.h>
#include <time.h>

void copy2(FILE* fic1,FILE* fic2){
    fseek(fic1,0,SEEK_END);
    long size=ftell(fic1);
    char* t=malloc(sizeof(char)*size);
    fseek(fic1,0,SEEK_SET);
    fread(t,sizeof(char),size,fic1);
    fputs(t,fic2);
}

int main(int argc,char* argv[]){
    FILE* fic1=fopen(argv[1],"r");
    FILE* fic2=fopen(argv[2],"w");
    time_t begin;
    time_t end;
    if(fic1!=NULL && fic2!=NULL){
        begin=time(NULL);
        copy2(fic1,fic2);
        end=time(NULL);
    }
    printf("Finished in %f sec\n", difftime(end,begin));
}