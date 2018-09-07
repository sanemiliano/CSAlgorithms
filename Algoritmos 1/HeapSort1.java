//HeapSort
import java.util.Random;

public class HeapSort1
{
	public static void main(String[] args)
	{
		int[] numbers = new int[100]; //Solo cambie este numero para el tamaño del arrelgo maestra, todo esta preparado.

		Random generator = new Random();
		
		//Generando los numeros aleatorios.
		for(int i=1; i<numbers.length; i++)
		{	
			//El objeto random me genera numeros aleatorios y
			//con el método nextInt() me regresa un entero menor que 
			// el argumento que le paso.
			numbers[i]= generator.nextInt(100);
		}
		
		//Imprimiendo los numeros antes del acomodo.
		System.out.printf("\"Antes del acomodo\"\n");
		for(int i=1; i<numbers.length; i++)
		{
			System.out.printf("%d.- %d\n",i,numbers[i]);
		}

		//Enviando al método para ordenarlo.
		HeapSort(numbers);
		System.out.println();

		//Imprimiendo los numeros después del acomodo.
		System.out.printf("\"Despues del acomodo\"\n");
		for(int i=1; i<numbers.length; i++)
		{
			System.out.printf("%d.- %d\n",i,numbers[i]);
		}
	
	}

	public static void HeapSort(int[] toSort)
	{
		Insert(toSort);
		Delete(toSort);

	}
	public static void Insert(int[] toInsert)
	{
		int dad=0;
		int son=0;
		int max=0;
		for(int i=1; i<toInsert.length; i++)
		{
			dad=i;
			son=dad*2;
			while(son<toInsert.length && dad>0)
			{
				if(son+1<toInsert.length)
				{
					if(toInsert[son]>toInsert[son+1])max=son;
						else max = son+1;
				}
					else max = son;
				if(toInsert[max]>toInsert[dad]) Swap(toInsert,dad,max);
					else break;
				son = dad;
				dad =dad/2;
			}
		}
	}
	public static void Delete(int[] toDelete)
	{	
		int lastIndex = toDelete.length;
		int dad =0;
		int son=0;
		int max=0;
		for(int i=1; i<toDelete.length; i++)
		{	
			lastIndex--;
			Swap(toDelete,1,lastIndex);
			dad=1;
			son=2;
			while(son<lastIndex)
			{	
				if(son+1<lastIndex)
				{
					if(toDelete[son+1]>toDelete[son]) max=son+1;
						else max=son;
				}
					else max=son;
				if(toDelete[max]>toDelete[dad]) Swap(toDelete,dad,max);
					else break;
				dad = max;
				son = dad*2;
			}
			
		}
	}

	public static void Swap(int[] numbers, int first, int last)
	{
		int aux = numbers[first];
		numbers[first] = numbers[last];
		numbers[last] = aux;
	}
}