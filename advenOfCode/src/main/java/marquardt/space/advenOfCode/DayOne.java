package marquardt.space.advenOfCode;

import java.nio.Buffer;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Stream;

public class DayOne {
	
	private static String current = "N";
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Typ your input");
		String input = in.nextLine();
		in.close();
		int[] buffer= Stream.of(input.split(", ")).map(s->s.trim()).reduce(new int[2],add,count);
		System.out.println(buffer[0]+""+buffer[1]);
		System.out.println(Math.abs(buffer[0])+Math.abs(buffer[1]));
		
		
		
	}
	private static Function<String, int[]> getBlock = s->{
		int coordinate;
		int[] buffer = new int[2];
		coordinate=Integer.parseInt(s.substring(1));
		if(s.charAt(0)=='R'&&current.equals("N")){
			buffer[0]=coordinate;
			current="E";
		}else if(s.charAt(0)=='L'&&current.equals("N")){
			buffer[0]=-coordinate;
			current="W";
		}else if(s.charAt(0)=='R'&&current.equals("S")){
			buffer[0]=-coordinate;
			current="W";
		}else if(s.charAt(0)=='L'&&current.equals("S")){
			buffer[0]=coordinate;
			current="E";
		}else if(s.charAt(0)=='R'&&current.equals("W")){
			buffer[1]=coordinate;
			current="N";
		}else if(s.charAt(0)=='L'&&current.equals("W")){
			buffer[1]=-coordinate;
			current="S";
		}else if(s.charAt(0)=='R'&&current.equals("E")){
			buffer[1]=-coordinate;
			current="S";
		}else if(s.charAt(0)=='L'&&current.equals("E")){
			buffer[1]=coordinate;
			current="N";
		}
		return buffer;
	};
	
	private static BinaryOperator<int[]> count = (i1,i2)->{
		int[] buffer = new int[2];
		buffer[0]= i1[0]+i2[0];
		buffer[1]= i1[1]+i2[1];
		return buffer;
	};
	
	private static BiFunction<int[],String, int[]> add= (s1,s2)->{
		int [] string = getBlock.apply(s2);
		int [] buffer = new int[2];
		buffer[0]= string[0]+s1[0];
		buffer[1]= string[1]+s1[1];
		return buffer;
		
	};
	
	

}
