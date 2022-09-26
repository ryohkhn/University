#include <stdio.h>
#include <time.h>

void copy(FILE* fic1,FILE* fic2){
    int c;
    while((c=fgetc(fic1))!=EOF){
        if(fputc(c,fic2)==EOF){
            printf("erreur écriture\n");
            break;
        }
    }
}

int main(int argc,char* argv[]){
    FILE* fic1=fopen(argv[1],"r");
    FILE* fic2=fopen(argv[2],"w");
    time_t begin;
    time_t end;
    if(fic2==NULL){
        FILE* fic3=fopen(argv[1],"w");
        begin=time(NULL);
        copy(stdin,fic3);
        end=time(NULL);
    }
    else if(fic1!=NULL){
        begin=time(NULL);
        copy(fic1,fic2);
        end=time(NULL);
    }
    printf("Finished in %f sec\n", difftime(end,begin));
}