//AlgortimosDeOrdenamiento
// BubbleSort, InsertionSort, SelectionSort.
import java.util.Random;

public class AlgoritmosDeOrdenamiento
{
	public static void main(String[]args)
	{	
		Random generator = new Random();

		int[] toOrder1 = new int[20];
		int[] toOrder2 = new int[20];
		int[] toOrder3 = new int[20];

		System.out.printf("\"Sin Ordenar\"\n");
		for(int i=0; i<toOrder1.length; i++)
		{
			toOrder1[i] = generator.nextInt(30);
			toOrder2[i] = toOrder1[i];
			toOrder3[i] = toOrder1[i];
			System.out.println(toOrder1[i]);
		}

		long executionTime = Burbuja(toOrder1);
		System.out.printf("\"\\Ordenamiento Burbuja\\\"\n");
		for(int a: toOrder1) System.out.println(a);
		System.out.printf("Tiempo de ejecucion: ");
		System.out.println(executionTime);

		executionTime = Seleccion(toOrder2);
		System.out.printf("\"\\Ordenamiento Seleccion\\\"\n");
		for(int a: toOrder2)System.out.println(a);
		System.out.printf("Tiempo de ejecucion: ");
		System.out.println(executionTime);
		
		executionTime = Insercion(toOrder3);
		System.out.printf("\"\\Ordenamiento Insercion\\\"\n");
		for(int a: toOrder3) System.out.println(a);
		System.out.printf("Tiempo de ejecucion: ");
		System.out.println(executionTime);

	}

	public static long Burbuja(int[] recieved1)
	{	
		long start = System.nanoTime(); 
		int cont=1;
		int aux =0;
		while(cont!=0)
		{	
			cont=0;
			for(int i=0; i<recieved1.length-1; i++)
			{
				if(recieved1[i]>recieved1[i+1])
				{
					aux = recieved1[i];
					recieved1[i] = recieved1[i+1];
					recieved1[i+1] = aux;
					cont++;
				}
			}
		}
		long end = System.nanoTime();
		return end-start;

	}

	public static long Seleccion(int[] recieved2)
	{	
		int aux = 11;
		int index =0;
		int aux2=0;	

		long start = System.nanoTime();
		for(int i=0; i<recieved2.length; i++)
		{	

			aux=31; // aux debe ser mayor que el numero mayor del arreglo.
			for(int e = i; e<recieved2.length; e++)
			{
				if(recieved2[e]<aux)
				{
					aux = recieved2[e];
					index = e;
				}
			}
			if(i!= recieved2.length-1)
			{
				aux2 = recieved2[i];
				recieved2[i] = recieved2[index];
				recieved2[index] = aux2; 
			}
		}
		long end = System.nanoTime();
		return end-start;
	}

	public static long Insercion(int[] toSort)
	{			
		long start = System.nanoTime();
		boolean det;
		int value = 0;
		int place = 0;
		for(int i=1; i<toSort.length; i++)
		{
			value = toSort[i];
			place=i;
			while(place>0 && toSort[place-1]>value)
			{
				toSort[place] = toSort[place-1];
				place--;
			}
			toSort[place] = value;
		}
		long end = System.nanoTime();
		return end-start;
	}
}