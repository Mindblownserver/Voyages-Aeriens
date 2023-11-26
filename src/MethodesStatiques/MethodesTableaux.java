package MethodesStatiques;

public class MethodesTableaux<T> {
    public static <E> void decalage(E tab[], int indiceDeDepart,int taille){
        for(int i=indiceDeDepart;i<taille-1;i++){
            tab[i] = tab[i+1];
        }
    }
    //taille(tabDst)>=taille(tabSrc)
    public static <E> void copierTableaux(E tabDst[], E tabSrc[],int capaciteSrc){
        for(int i=0;i<capaciteSrc;i++)
            tabDst[i]=tabSrc[i];
        
    }
}
