package StreamDemo;

import java.util.stream.Stream;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ParallelStream {
	
	private static long factorial(int n) {
		long result=1;
		for(int i=2;i<=n;i++) {
			result*=i;
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
// Parallel Stream is a type of Stream that enables parallel processing of elements
//		Allowing multiple threads to process parts of the stream simultaneously
//		This can significantly improve performance for large data sets
//		workload is distributed across multiple threads
		
		Long startTime=System.currentTimeMillis();
		List<Integer> list=Stream.iterate(1,x->x+1).limit(20000).toList();
		
		List<Long> factList=list.stream().map(ParallelStream::factorial).toList();
		Long EndTime=System.currentTimeMillis();
		
		System.out.println(EndTime-startTime);
		
		
		Long startTime1=System.currentTimeMillis();
		List<Integer> list1=Stream.iterate(1,x->x+1).limit(20000).toList();
		
		List<Long> factList1=list.parallelStream().map(ParallelStream::factorial).toList();
		Long EndTime1=System.currentTimeMillis();
		
		System.out.println(EndTime1-startTime1);
		
		
//		Parallel Streams are most effective for CPU-intensive or large datasets where tasks are independent
//		They may add overhead for simple tasks or small datasets
		
//		cumulative sum
		
		
		
		
		List<Integer> numbers=Arrays.asList(1,2,3,4,5);
		AtomicInteger sum= new AtomicInteger(0);
		List<Integer> cumSum=numbers.parallelStream().map(sum::addAndGet).sequential().toList();
		System.out.println(cumSum);
		
	}

}
