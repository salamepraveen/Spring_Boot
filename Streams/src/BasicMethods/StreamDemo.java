package BasicMethods;
import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;


@FunctionalInterface
interface Operations{
	public int operate(int a,int b);
}

public class StreamDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Operations sum=(int a,int b)->{
			return a+b;
		};
		System.out.println(sum.operate(2,3));
		
		Predicate<Integer> isEven=x->x%2==0;
		isEven.test(22);
		Function<Integer,Integer> doubleIt=x->2*x;
		
		Function<Integer,Integer> tripleIt=x->3*x;
		
		
	
		System.out.println(doubleIt.andThen(tripleIt).apply(4));
		System.out.println(doubleIt.compose(tripleIt).apply(4));
		
		Function<Integer,Integer> identity=Function.identity();
		Integer res2=identity.apply(5);
		System.out.println(res2);
		
		Consumer<Integer> consumer2=(x) ->System.out.println(x);
		consumer2.accept(29);
		
		List<Integer> list=Arrays.asList(1,2,3);
		
		Consumer<List<Integer>> printList=x->{
			for(int i:x) {
				System.out.println(i);
			}
		};
		
		printList.accept(list);
		
		Supplier<String> giveHelloWorld=()->"Hello World";
		
		giveHelloWorld.get();
		
		//Combined Example
		Predicate<Integer> predicate=x->x%2==0;
		Function<Integer,Integer> function = x->x*x;
		Consumer<Integer> consumer=x->System.out.println(x);
		Supplier<Integer> supplier=()->100;
		
		if(predicate.test(supplier.get())) {
			consumer.accept(function.apply(supplier.get()));
		}
		
//		BiPredicate,BiFunction,BiConsumer
		
		BiPredicate<Integer,Integer> biPred=(x,y)->(x+y)%2==0;
		System.out.println(biPred.test(2,3));
		BiConsumer<Integer,Integer> biCons=(x,y)->{
			System.out.println(x);
			System.out.println(y);
		};
		biCons.accept(2, 3);
		BiFunction<String,String,Integer> biFunc=(x,y)->(x+y).length();
		System.out.println(biFunc.apply("a", "bc"));
		
		Function<Integer,Integer> a=(x)-> x+2;
//		Function ka hae bas easy way mein
		UnaryOperator<Integer> ab=x->2*x;
		BinaryOperator<Integer> b=(x,y)->x+y;
		
//		Method reference-->use method without invoking & in place of lambda
		List<String> students =Arrays.asList("Ram","Shayam","Ghanshaym");
		students.forEach(x->System.out.println(x));
		students.forEach(System.out::println);
		
//		Constructor reference
		List<String> names=Arrays.asList("A","B","C");
		
		List<MobilePhone> mobilePhoneList=names.stream().map(MobilePhone::new).collect(Collectors.toList());
		
		
	}

}
