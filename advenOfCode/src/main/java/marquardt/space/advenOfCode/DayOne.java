package marquardt.space.advenOfCode;

import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Stream;

public class DayOne {
	
	enum Direction{
		NORTH,
		SOUTH,
		EAST,
		WEST
	};
	
	private static Direction currentCirection = Direction.NORTH;
	
	
	
	public static int getAnswer(String input) {
		int[] buffer= Stream.of(input.split(", ")).map(s->s.trim()).reduce(new int[2],add,count);
		return Math.abs(buffer[0])+Math.abs(buffer[1]);
	}
	
	
	private static Function<String, int[]> getBlock = s->{
		int coordinate;
		int[] buffer = new int[2];
		coordinate=Integer.parseInt(s.substring(1));
		if(s.charAt(0)=='R'&&currentCirection==Direction.NORTH){
			buffer[0]=coordinate;
			changeCurrent(Direction.EAST);
		}else if(s.charAt(0)=='L'&&currentCirection==Direction.NORTH){
			buffer[0]=-coordinate;
			changeCurrent(Direction.WEST);
		}else if(s.charAt(0)=='R'&&currentCirection==Direction.SOUTH){
			buffer[0]=-coordinate;
			changeCurrent(Direction.WEST);
		}else if(s.charAt(0)=='L'&&currentCirection==Direction.SOUTH){
			buffer[0]=coordinate;
			changeCurrent(Direction.EAST);
		}else if(s.charAt(0)=='R'&&currentCirection==Direction.WEST){
			buffer[1]=coordinate;
			changeCurrent(Direction.NORTH);
		}else if(s.charAt(0)=='L'&&currentCirection==Direction.WEST){
			buffer[1]=-coordinate;
			changeCurrent(Direction.SOUTH);
		}else if(s.charAt(0)=='R'&&currentCirection==Direction.EAST){
			buffer[1]=-coordinate;
			changeCurrent(Direction.SOUTH);
		}else if(s.charAt(0)=='L'&&currentCirection==Direction.EAST){
			buffer[1]=coordinate;
			changeCurrent(Direction.NORTH);
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
	
	private static void changeCurrent(Direction current) {
		currentCirection=current;
	}
	

}
