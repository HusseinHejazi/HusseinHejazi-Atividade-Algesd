import java.util.Arrays;
public class Exercicio4Ordenacao5{
public static void mergeSort(int vet[])
      {
         int vetaux[] = new int[vet.length];
         mergeSort(vet, 0, vet.length-1, vetaux);  
      }
      
      public  static void mergeSort(int vet[], int inicio, int fim, int vetaux[])
      {
         if(fim-inicio >= 1)   
         {
            int meio = (inicio + fim)/2;
            mergeSort(vet, inicio, meio, vetaux);
            mergeSort(vet, meio+1, fim, vetaux);
            mescla(vet, inicio, meio, fim, vetaux);
         }

         
       }
    
      public  static void mescla(int vet[], int inicio, int meio, int fim, int vetaux[])
      {
         int i=inicio;
         int j=meio+1;
         int k=inicio;
    
         while(k <= fim)   
         {
            if(i <= meio && j <= fim)
            {
               if(vet[i] < vet[j])
               {
                  vetaux[k] = vet[i];
                  i++; k++;
               }
               else
               {
                  vetaux[k] = vet[j];
                  j++; k++;
               }
            }
            else if(i > meio)
            {
               vetaux[k] = vet[j];
               j++; k++;
            }
            else
            {
               vetaux[k] = vet[i];
               i++; k++;
            }
         }
       
         for(i=inicio; i <= fim; i++)  
            vet[i] = vetaux[i];
      }
      public static void quickSort(int vet[]) {
  quickSort(vet, 0, vet.length-1); 
 } 

 private static void quickSort(int vet[], int esquerda, int direita) { 
  int indice = particao(vet, esquerda, direita); 
  if (esquerda < indice - 1) 
   quickSort(vet, esquerda, indice - 1); 
  if (indice < direita - 1) 
   quickSort(vet, indice + 1, direita); 
 }    

 private static int particao(int vet[], int esquerda, int direita) {
  int i = esquerda, j = direita, aux; 
  int pivo = vet[esquerda];     
  while (i < j) { 
   while (vet[j] > pivo){
    j--;
   }
   if(i >= j){
    return i;
   }
   aux = vet[i]; 
   vet[i] = vet[j]; 
   vet[j] = aux;
   i++;
   while (vet[i] < pivo){
    i++;
   }
   aux = vet[i]; 
   vet[i] = vet[j]; 
   vet[j] = aux;
   j--;
  } 
  return i; 
 }
public static void main(String args[])
      {
         String saida1="\nMetodo de mergeSort\n";
         String saida2="\nMetodo de Arrays.sort\n";
         String saida3="\nMetodo de quickSort\n";         
               
         for(int tam=10000; tam <= 100000; tam=tam+10000)
         {
            int vet1[] = new int [tam];
            int vet2[] = new int [tam];
            int vet3[] = new int [tam];               
                    
            for(int i=0; i<tam; i++)
               vet1[i] = vet2[i] = vet3[i] = (int) (Math.random() * 1000);
            
            long tempoAntes = System.currentTimeMillis();
            mergeSort(vet1);
            long tempoDepois = System.currentTimeMillis();
            saida1+= "Tamanho = " + tam + "  => Tempo = " + (tempoDepois-tempoAntes) + " ms\n";
            
            tempoAntes = System.currentTimeMillis();
            Arrays.sort(vet2);
            tempoDepois = System.currentTimeMillis();
            saida2+= "Tamanho = " + tam + "  => Tempo = " + (tempoDepois-tempoAntes) + " ms\n";
            
            tempoAntes = System.currentTimeMillis();
            quickSort(vet3);
            tempoDepois = System.currentTimeMillis();
            saida3+= "Tamanho = " + tam + "  => Tempo = " + (tempoDepois-tempoAntes) + " ms\n";
                     
         }

         System.out.println(saida1);
         System.out.println(saida2); 
         System.out.println(saida3);        
      }
}      