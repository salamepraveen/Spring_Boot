package StreamDemo;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TerminalOps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Integer> list=Arrays.asList(1,2,3,4,5,6);
		
//		1.collect
		list.stream().skip(1).collect(Collectors.toList());
		list.stream().skip(1).toList();
		
//		2. forEach
		list.stream().forEach(System.out::println);
		
//		3.Reduce - combines elements to produce a single result
		Optional<Integer> OptinalInt=list.stream().reduce((x,y)->x+y);
		list.stream().reduce(Integer::sum);
		
		
//		4.count
		
		
		
//		5.anyMatch,allMatch,noneMatch
		
		boolean b=list.stream().anyMatch(x->x%2==0);
		
		System.out.println(b);
		boolean b1=list.stream().allMatch(x->x>0);
		System.out.println(b1);
		
		boolean b2=list.stream().noneMatch(x->x<0);
		System.out.println(b2);
		
//		6. findFirst,FindAny
		
		System.out.println(list.stream().findFirst().get());
		System.out.println(list.stream().findAny().get());
		
		
		
//		7.To Array
		Object[] array=Stream.of(1,2,3,4).toArray();
		
//		8.min/max
		System.out.println("max"+Stream.of(2,44,69).max(Comparator.naturalOrder()));
		System.out.println("max"+Stream.of(2,44,69).min(Comparator.naturalOrder()));
		
		
//		9.forEachOrdered
		List<Integer> numbers=Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		System.out.println("Using forEach wiht parallel stream");
		numbers.parallelStream().forEach(System.out::println);
		System.out.println("Using forEachOrdered with Parallel Stream");
		numbers.parallelStream().forEachOrdered(System.out::println);
		
		
//		Example: filtering and Collecting Names
		
		List<String> names=Arrays.asList("Anna","Bob","Charlie","David");
		System.out.println(names.stream().filter(x->x.length()>3).toList());
		
//		Example: Squaring and Sorting Numbers
		List<Integer> numbers1=Arrays.asList(5,2,9,1,6);
		System.out.println(numbers1.stream().map(x->x*x).sorted().toList());
		
//		Example: Summing Values
		List<Integer> numbers2 =Arrays.asList(1,2,3,4,5);
		System.out.println(numbers2.stream().reduce(Integer::sum).get());
		
//		Example: Counting Occurrences of a Character
		String sentence="Hello World";
		sentence.toCharArray();
		Stream<String> s1=Stream.of(sentence);
		System.out.println(sentence.chars().filter(x->x=='l').count());
		
//		stateful-sorted(sab khuch pta hona chahiye isse) & stateless-map (mujhe ky mujhe abhi wala value dedo)
		
//		
		
	}

}
