import java.util.LinkedList;


public class Shelter
{
	
	/*
	 * 
	 * An animal shelter holds only dogs and cats, and operates on a
	 * strictly "first in, first out" basis. People must adopt either
	 * the "oldest" (based on arrival time) of all animals at the shelter,
	 * or they can select whether they would prefer a dog or a cat (and will receive
	 * the oldest animal of that type). They cannot select which specificanimal
	 * they would like. Create the data structures to maintain this system and
	 * implement operations such as enqueue, dequeueAny,
	 * dequeueDog and dequeueCat.You mayusethe built-in LinkedList data structure.
	 * 
	 */
	
	
	LinkedList<Animal> animals = new LinkedList<Animal>();
	
	
	public void enqueue(AnimalType type, String name)
	{
		animals.addLast(new Animal(type,name));
	}
	
	public Animal dequeueAny()
	{
		Animal out = null;
		
		if(animals.size()>0)
			out = animals.removeFirst();
		
		return out;
	}
	
	public Animal dequeueDog()
	{
		return getFirstAnimal(AnimalType.DOG);
	}
	
	public Animal dequeueCat()
	{
		return getFirstAnimal(AnimalType.CAT);
	}
	
	private Animal getFirstAnimal(AnimalType type)
	{
		Animal out = null;
		
		for (int i = 0; i < animals.size(); i++)
		{
			Animal current = animals.get(i);
			if(current.type == type)
			{	
				animals.remove(i);
				return current;		
			}
		}
		return out;
	}
}

class Animal
{
	AnimalType type;
	String name;
	
	public Animal( AnimalType type,String name)
	{
		this.name = name;
		this.type = type;
	}
	
}