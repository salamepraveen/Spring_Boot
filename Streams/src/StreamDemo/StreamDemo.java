package StreamDemo;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
public class StreamDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		feature introduced in java 8
//		process collections of data in a functional and declarative manner
//		Simplify Data Processing
//		Embrace Functional Programming
//		Improve Readibility and Maintainability
//		Enable Easy Parallelism
//		
		
//		What is a Stream ? - a sequence of elements supporting funcatinal and declarative programmming
		
//		How to Use Streams?
//		Source, intermediate operations & terminal operation
		
		List<Integer> numbers=Arrays.asList(1,2,3,4,5);
		System.out.println(numbers.stream().filter(x->x%2==0).count());
		
//		Creating Streams
//		1.From Collections
		List<Integer> numbers2=Arrays.asList(1,2,3,4,5);
		System.out.println(numbers2.stream().filter(x->x%2==0).count());
		
//		2.From Arrays
		String[] array= {"a","b","c"};
		Stream<String> stream1 = Arrays.stream(array);
//		3.Using Stream.of()
		Stream<String> stream2=Stream.of("a","b");
//		4. Infinite streams
		Stream<Integer> generate=Stream.generate(()->1);//genearate infinite number of streams from 1 can be used limit for user conveninet
		Stream.iterate(1, x->x+1).limit(100).collect(Collectors.toList());
		
		
	}

}
