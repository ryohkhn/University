public class Rodriguez_Lucas{
    public Couple[] tas;
    public int size;

    public Rodriguez_Lucas(int size){
        tas=new Couple[size];
        this.size=0;
    }

    public void insert(Couple couple){
        if(tas.length!=size){
            tas[size++]=couple;
        }
        int tmpSize=size;
        while(tmpSize>0 && tas[tmpSize].priorite<tas[(tmpSize-1)/2].priorite){
            Couple coupleTmp=tas[(tmpSize-1)/2];
            tas[(tmpSize-1)/2]=coupleTmp;
            tas[tmpSize]=coupleTmp;
            tmpSize=(tmpSize-1)/2;
        }
    }

    public void remove(){
        tas[0]=tas[size-1];
        size--;
        int tmpSize=0;
        while((tmpSize+1)/2<size){

            tmpSize++;
        }
    }

}
