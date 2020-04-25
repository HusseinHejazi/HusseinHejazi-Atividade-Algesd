 public class Exercicio3Ordenacao5{
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
   while (vet[j] >= pivo){    // fica em ordem decrescente adicionado o igual aqui
    j--;
   }
   if(i >= j){
    return i;
   }
   aux = vet[i]; 
   vet[i] = vet[j]; 
   vet[j] = aux;
   i++;
   while (vet[i] <= pivo){   // fica em ordem decrescente adicionado o igual aqui
    i++;
   }
   aux = vet[i]; 
   vet[i] = vet[j]; 
   vet[j] = aux;
   j--;
  } 
  return i; 
 }
 }