#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <sys/stat.h>
#include <time.h>
#include <unistd.h>
#include <sys/types.h>
#include <fcntl.h>
#include <time.h>

void *my_memcpy(void *dest,void *src,size_t n){
    for(int i=0;i<n;i++){
        *(((char *)dest)+i)=*(((char *)src)+i);
    }
    return dest;
}

void *my_memmove(void* dest,void* src,size_t n){
    char* tmp=malloc(sizeof(char)*n);
    my_memcpy(tmp,src,n);
    my_memcpy(dest,tmp,n);
    return dest;
}

void affichetableau(char** sentence, int nbmot, int max)
{

    int i, j;

    for (i = 0;i < nbmot;i++)
    {
        for (j = 0;j < max;j++)
        {
            printf("%c\n", sentence[i][j]);
        }
        printf("\n");
    }
}


int main(int argc,char* argv[]){
    int inode;
    struct stat structStat;
    stat(argv[1], &structStat);

    printf("%ld %ld\n", structStat.st_ino, structStat.st_ctim.tv_sec);
    return 0;
}

/*
    if(argc!=2){
        perror("Invalid arguments number");
    }
    if(access(argv[1],F_OK)==0){
        printf("FICHIER EXISTE\n");
    }
    else{
        printf("FICHIER INEXISTANT\n");
    }
    if(access(argv[1],R_OK)==0){
        printf("FICHIER PEUT SE LIRE\n");
    }
    else{
        printf("FICHIER NE PEUT PAS SE LIRE\n");
    }
    if(access(argv[1],W_OK)==0){
        printf("FICHIER PEUT ETRE ECRIT\n");
    }
    else{
        printf("FICHIER NE PEUT PAS ETRE ECRIT\n");
    }
    if(access(argv[1],X_OK)==0){
        printf("FICHIER EXECUTABLE\n");
    }
    else{
        printf("FICHIER NON EXECUTABLE\n");
    }
    char** words;
    char sentence[150];
    int i, j, k = 0, max = 0, word = 0;
    printf("Entrez votre phrase:");
    fgets(sentence,150,stdin);
    for (i = 0;i < strlen(sentence);i++)
    {
        if (sentence[i] == ' ')
        {
            word++;
            if (k > max)
            {
                max = k;
            }
            k = 0;
        }
        k++;
    }
    word++;
    words = malloc(sizeof(char*) * word);
    for (i = 0;i < word;i++)
    {
        *(words+i)= malloc(sizeof(char)*max);
    }
    i = 0;
    j = 0;
    k = 0;
    while (sentence[i] != '\0')
    {
        if (sentence[i] != ' ')
        {
            words[j][k] = sentence[i];
            k++;
        }
        else
        {
            words[j][k] = '\0';
            j++;
            k = 0;
        }
        i++;
    }
    affichetableau(words, word, max);
    return 0;

int main(){
char TAB="coucou";
char* tab = malloc(sizeof(char )*8);
my_memcpy(tab, TAB, 7);
char* dest=malloc(sizeof(char)*8);
//my_memcpy(dest,tab,3);
my_memmove(tab,tab,3);
printf("%s",tab);


    return 0;
}
*/
