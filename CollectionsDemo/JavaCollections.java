import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class JavaCollections {

	public static void main(String[] args) {
		String str[] = new String[5];
		str[0] = "SAT";
		str[4] = "RAT";
		for(int i=0; i<str.length; i++) {
			System.out.println(str[i]);
		}
		
		//Collections
		/**
		 * 1. no size limit
		 * 2. no restriction on same data type of elements
		 * 
		 * VECTOR
		 * 
		 * LIST, SET, MAP
		 * 
		 * roll_no, name
		 * 
		 * 
		 */
		Person p1= new Person("satya", "1234","sat@gmail.com");
		Person p5= new Person("raju", "2345","rat@gmail.com");
		Person p2= new Person("cutiepie", "3456","cat@gmail.com");
		Person p4= new Person("bharath", "4566","bat@gmail.com");
		
		
		Person ptemp= new Person("satya", "1234","sat@gmail.com");
		
		System.out.println("obejct memory locations");
		System.out.println(p1);
		System.out.println(ptemp);
		
		List strList = new ArrayList();
		strList.add(p1);
		
		
		
		
		if(p1.equals(ptemp)) {
			System.out.println("both are same with equals()");
		}else {
			System.out.println("both are not same with equals()");
		}
		
		if(p1 == ptemp) {
			System.out.println("both are same with ==");
		}else {
			System.out.println("both are not same with ==");
		}

		if(p1.compareTo(p4) > 0) {
			System.out.println("P1 is bigger than p4");
		}else if(p1.compareTo(p4) < 0) {
			System.out.println("P1 is smaller than p4");
		}else {
			System.out.println("both are same");
		}
		
		for(int i=0;i<strList.size();i++) {
			System.out.println( strList.get(i));
		}
		
		for(Object x:strList) {
			System.out.println(x.getClass());
		}
		
		
		List<Person> genList = new ArrayList<Person>();
		
		genList.add(p1);
		genList.add(p2);
		genList.add(p5);
		genList.add(p4);
		genList.add(ptemp);
		
		Set<Person> personSet = new LinkedHashSet<Person>();
		personSet.add(p1);
		personSet.add(p2);
		personSet.add(p5);
		personSet.add(p4);
		personSet.add(ptemp);
		
		Set<Person> tempSet = new LinkedHashSet<Person>();
		System.out.println("From SET:");
//		for(Person x: personSet) {
//			if(tempSet.size()==0) {
//				tempSet.add(x);
//			}else {
//				for(Person p:tempSet) {
//					if(x.compareTo(p) == 0 ) {
//						
//					}else {
//						tempSet.add(x);
//					}	
//				}
//			}
//		}
		
		Collections.sort(genList);
		
		System.out.println("From list:");
		for(Person x:genList) {
			System.out.println(x.toString());
		}
		
		Map<String,Person> personMap = new HashMap<String,Person>();
		personMap.put(p1.phNo, p1);
		personMap.put(p5.phNo, p5);
		personMap.put(p4.phNo, p4);
		personMap.putIfAbsent(p2.phNo, p4);
		
		personMap.replace(p5.phNo, null);
				
		System.out.println("MAP SIZE:"+personMap.size());
		
		System.out.println("MAP VALUES:");
		for(String keyObj: personMap.keySet()) {
			
			System.out.println(keyObj+"::"+personMap.get(keyObj));
		}
		
		List<Person> pList = null;
		
//		System.out.println(pList.isEmpty());
		
		
	}

}

class Person implements Comparable<Person>{
	String name;
	String phNo;
	String email;
	
	Person(String name, String phNo, String email){
		this.name = name;
		this.phNo = phNo;
		this.email = email;
	}
	
	

	@Override
	public String toString() {
		return(this.name+"::"+this.phNo+"::"+this.email);
	}



	@Override
	public int compareTo(Person o) {
		if(this.name.length() > o.name.length() ) {
			return 1;
		}else if(this.name.length() < o.name.length()) {
			return -1;
		}else {
			return 0;
		}
	}
	
	public boolean equals(Person o) {
		
		return false;
		
	}

	
}
