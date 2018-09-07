//HeapSort.java
//Algoritmo de Ordenamiento
import java.util.Random;

public class HeapSort
{
	public static void main(String[] args)
	{
		Random number = new Random();

		int[] toOrder = new int[20];

		for(int i = 1; i<20; i++)
		{
			toOrder[i] = number.nextInt(21);
		}

		int[] toSave = new int[20];
		int dad =0;
		int[] saved = new int[20];

		//Insertar
		for(int i= 1; i<20; i++)
		{
			toSave[i] = toOrder[i];
			if(i!=1)
			{	
				int son =i;
				dad = i;
				boolean det = true;
				while(det)
				{	
					dad /= 2;
					if(dad==0)det=false;
						else
						{
							if(toSave[son]>toSave[dad])
							{	
								int aux = toSave[dad];
								toSave[dad] = toSave[son];
								toSave[son] = aux;
								son = dad;
							}
							else
							{
								det = false;
							}
							
						}
				}
			}
		}
		for(int i=1; i<20; i++)
		{
			System.out.printf("%d.- %d\n",i,toSave[i]);
		}
		int auxi=0;
		int hijo=0; 
		int papa=0;
		int place=toSave.length-1;
		for(int i=1; i<20; i++)
		{	

			saved[i] = toSave[1];
			auxi= toSave[place];
			toSave[place] = toSave[1];
			toSave[1]=auxi;
			place--;
			papa=1;
			boolean dets=true;
			while(dets)
			{	
					if(papa*2+1<=place)
					{
						if(toSave[papa*2]>toSave[papa*2+1])
						{
							if(toSave[papa*2]>toSave[papa])
							{
								int gg = 0;
								gg=toSave[papa*2];
								toSave[papa*2]=toSave[papa];
								toSave[papa]=gg;
							}
						}
							else
							{
								if(toSave[papa*2+1]>toSave[papa])
								{
									int ff = 0;
									ff=toSave[papa*2+1];
									toSave[papa*2+1]=toSave[papa];
									toSave[papa]=ff;
								}
							}
					}
					else
					{
						if(papa*2<=place)
						{
							if(toSave[papa*2]>toSave[papa])
							{
								int hh =0;
								hh=toSave[papa*2];
								toSave[papa*2]=toSave[papa];
								toSave[papa]=hh;
							}
							else dets=false;
						}
						else dets=false;	
					}
				papa++;
			}
		}

		System.out.println();
		for(int i=1; i<20; i++)
		{
			System.out.printf("%d.- %d\n",i,saved[i]);
			
		}

	}
}