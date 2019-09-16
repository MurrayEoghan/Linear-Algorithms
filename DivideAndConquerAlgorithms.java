
/**
 * The class contains the Divide and Conquer-based Algorithms we are using. 
 */
public class DivideAndConquerAlgorithms {

	//----------------------------------------------
	// Class constructor
	//----------------------------------------------	
	/**
	 * Constructor of the class. Do not edit it.
	 */
	public DivideAndConquerAlgorithms(){}
		
	//-------------------------------------------------------------------
	// 0. iterativeDisplayElements --> Displays all elements of a MyList 
	//-------------------------------------------------------------------	
	/**
	 * Given a concrete MyList, this iterative algorithm displays its elements by screen (if any).
	 * @param m: The MyList we want to display its elements.	  
	 */	
	public void iterativeDisplayElements(MyList<Integer> m){
		//-----------------------------
		//SET OF OPS
		//-----------------------------

		//-----------------------------
		// I. SCENARIO IDENTIFICATION
		//-----------------------------
		int scenario = 0; 
		
		//Rule 1. MyList is empty
		if (m.length() == 0) 
			scenario = 1;
		//Rule 2. MyList is non-empty
		else
			scenario = 2;

		//-----------------------------
		// II. SCENARIO IMPLEMENTATION 
		//-----------------------------
		switch(scenario){	
				
		//Rule 1. MyList is empty
		case 1: 
			//1. We print the empty message
			System.out.println("Empty MyList");
			
			break;
			
		//Rule 2. MyList is non-empty
		case 2: 
			//1. We print the initial message
			int size = m.length();
			System.out.println("MyList Contains the following " + size + " items: ");
			
			//2. We traverse the items
			for (int i = 0; i < size; i++)
				System.out.println("Item " + i + ": " + m.getElement(i));
			
			break;
	
		}
		
	}

	//-------------------------------------------------------------------
	// 1. recursiveDisplayElements --> Displays all elements of a MyList  
	//-------------------------------------------------------------------	
	/**
	 * Given a concrete MyList, this recursive algorithm displays its elements by screen (if any).
	 * @param m: The MyList we want to display its elements.	  
	 */	
	public void recursiveDisplayElements(MyList<Integer> m){
		if(m.length() > 0) {
			int value = m.getElement(0);
				m.removeElement(0);
				System.out.print(value);
				recursiveDisplayElements(m);

		
			m.addElement(0, value);
		}
		
	/*	else {
			System.out.println("List Empty");
		}*/
	}

	//-------------------------------------------------------------------
	// 2. smallerMyList --> Filters all elements in MyList smaller than e
	//-------------------------------------------------------------------	
	/**
	 * The function filters all elements of MyList being smaller than 'e'  
	 * @param m: The MyList we want to check.
	 * @param e: The number 'e' we want to compare each element of MyList to.
	 * @return: The new MyList containing just the elements being smaller than 'e'  
	 */	
	public MyList<Integer> smallerMyList(MyList<Integer> m, int e){
		int valToAdd = 0;
		MyList<Integer> res = new MyDynamicList<Integer>();
		if(m.length() > 0) {
			int value = m.getElement(0);
			if(e > value) {
				valToAdd = value;
				m.removeElement(0);
			}
			else{
				m.removeElement(0);
				}
			res = smallerMyList(m, e);
			if(valToAdd > 0) {
					    res.addElement(0, valToAdd);
			}
			m.addElement(0, value);
		}
		else {
			return res;// Says List Empty two more times than needed because once the remove method empties the string, the recursion causes the list empty to print again each time
		}
		return res;	
		}
	

	//-------------------------------------------------------------------
	// 3. biggerMyList --> Filters all elements in MyList bigger than e
	//-------------------------------------------------------------------	
	/**
	 * The function filters all elements of MyList being bigger than 'e'  
	 * @param m: The MyList we want to check.
	 * @param e: The number 'e' we want to compare each element of MyList to.
	 * @return: The new MyList containing just the elements being bigger or equal than 'e'  
	 */	
	public MyList<Integer> biggerEqualMyList(MyList<Integer> m, int e){
		int valToAdd = 0;
		MyList<Integer> res = new MyDynamicList<Integer>();
		if (m.length() <= 0) {
			return res;// Says List Empty two more times than needed because once the remove method empties the string, the recursion causes the list empty to print again each time
		}
		else {
			int value = m.getElement(0);
			if(e <= value) {
				valToAdd = value;
				m.removeElement(0);
			}
			else{
				m.removeElement(0);
				}
			res = biggerEqualMyList(m, e);
			if(valToAdd > 0) {
				res.addElement(0, valToAdd);
			}
			m.addElement(0, value);
		}
		return res;	
	}
		
	//-------------------------------------------------------------------
	// 3. concatenate --> It concatenates 2 MyList   
	//-------------------------------------------------------------------	
	/**
	 * The function concatenates the content of 2 MyList.   
	 * @param m1: The first MyList.
	 * @param m2: The second MyList.
	 * @return: The new MyList resulting of concatenate the other 2 MyList
	 */	
	public MyList<Integer> concatenate(MyList<Integer> m1, MyList<Integer> m2){

		MyList<Integer> res = new MyDynamicList<Integer>();
		int val0 = 0;
		int temp = 0;
		if (m1.length() == 0) {
			int size = m2.length() - 1;
			while (size >= 0) {
				temp = m2.getElement(size);
				res.addElement(0, temp);
				size--;
			}
			System.out.println();
		}
		
		else { 
			if(m2.length() == 0) {
			int size = m1.length() - 1;
			while (size >= 0) {
				temp = m1.getElement(size);
				res.addElement(0, temp);
				size--;
			}
			System.out.println();
		}
		else {
			int e1 = m1.getElement(0);
			int e2 = m2.getElement(0);
			if(e1 < e2) {
				val0 = m1.getElement(0);
				m1.removeElement(0);
				res = concatenate(m1, m2);
				res.addElement(0, val0);
				m1.addElement(0, val0);
			}
			else {
				val0 = m2.getElement(0);
				m2.removeElement(0);
				res = concatenate(m1, m2);
				res.addElement(0, val0);
				m2.addElement(0, val0);
			}
			
		}		}
			return res;	
	}
	
	//-------------------------------------------------------------------
	// 4. quickSort --> Sort a MyList using the method quick sort
	//-------------------------------------------------------------------	
	/**
	 * Given a concrete MyList, it computes a new sorted list using the method Quick Sort.
	 * @param m: The MyList we want to sort.
	 * @return: The new MyList being sorted.	  	  
	 */	  
	public MyList<Integer> quickSort(MyList<Integer> m){
		
		MyList<Integer> res = new MyDynamicList<Integer>();
		MyList<Integer> a = new MyDynamicList<Integer>();
		MyList<Integer> b = new MyDynamicList<Integer>();
		if (m.length() <= 0) {
			return res;
		}
		else {
			if (m.length() == 1) {
				res.addElement(0, m.getElement(0));
				return res;
			}
		else {
				int halfLength = m.length() / 2;
				while (halfLength > 0) {
					a.addElement(0, m.getElement(0));
					m.removeElement(0);
					halfLength--;
				}
				a = quickSort(a);
				b = quickSort(m);
				res = concatenate(a, b);
				m.addElement(0, m.getElement(0));
				return res;			
		}
	}	
	
}
}