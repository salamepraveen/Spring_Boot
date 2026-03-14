package StreamDemo;

import java.util.*;
import java.util.stream.Stream;

public class IntermediateOps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Intermediate operations transform a stream into another stream
//		They are lazy, meaning they dont execute until a terminal operation is inovked
		
		
//		1.Filter
		List<String> list=Arrays.asList("Akshit","Ram","Shyam","Ghanshyam");
		Stream<String> filteredList=list.stream().filter(x->x.startsWith("A"));
//		not filtering at this point 
		long res=list.stream().filter(x->x.startsWith("A")).count();
		System.out.println(res);
		
//		2.Map
		Stream<String> stringStream=list.stream().map(String::toUpperCase);
		
//		3.Sorted
		Stream<String> sortStream=list.stream().sorted();
		Stream<String> sortedStreamUsingComparator=list.stream().sorted((a,b)-> a.length()-b.length());
		
//		4.distinct
		System.out.println(list.stream().filter(x->x.startsWith("A")).distinct().count());
		
//		5.limit
		
		Stream.iterate(1, x->x+1).limit(10);
		
//		6.skip
		System.out.println(Stream.iterate(1,x->x+1).skip(10).limit(100));
		
//		7.peek - performs an action oneach element as it  is consumed
		Stream.iterate(1, x->x+1).limit(20).peek(System.out::println).count();
		
		
//		8.flatMap - 
//		Handle Streams of Collection, list or array where eac
		
		List<List<String>> listofList=Arrays.asList(
				Arrays.asList("apple1","banana1"),
				Arrays.asList("apple2","banana2"),
				Arrays.asList("apple2","banana2")
				
				
				);
		System.out.println(listofList.get(1).get(1));
		;
		System.out.println(listofList.stream().flatMap(x->x.stream()).map(String::toUpperCase).toList());
		

	}

}
