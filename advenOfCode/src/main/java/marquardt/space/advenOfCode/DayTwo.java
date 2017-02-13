package marquardt.space.advenOfCode;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DayTwo {
	
	enum NumPad{
		ONE,TWO,THREE,FOUR,FIVE,SIX,SEVEN,EIGHT,NINE;

		/* (non-Javadoc)
		 * @see java.lang.Enum#toString()
		 */
		@Override
		public String toString() {
			String buffer;
			switch(this){
			case EIGHT:
				buffer="8";
				break;
			case FIVE:
				buffer="5";
				break;
			case FOUR:
				buffer="4";
				break;
			case NINE:
				buffer="9";
				break;
			case ONE:
				buffer="1";
				break;
			case SEVEN:
				buffer="7";
				break;
			case SIX:
				buffer="6";
				break;
			case THREE:
				buffer="3";
				break;
			case TWO:
				buffer="2";
				break;
			default:
				buffer="";
				break;
			
			}
			
			return buffer;
			
		}
		
		
	}
	
	private static NumPad position=NumPad.FIVE;
	
	public static String getAnswer(String input) {
		List<String> buffer = new ArrayList<>();
		final List<String> values= Stream.of(input.split("\n")).reduce(
				buffer
				,addNumber,add);
		return values.stream().collect(Collectors.joining());
	}
	
	
	static BiFunction<List<String>, String, List<String>> addNumber = (list,string)->{
		for(String s : string.split("")){
			if(s.equals("L")&&position==NumPad.FIVE){
				position=NumPad.FOUR;
			}else  if(s.equals("R")&&position==NumPad.FIVE){
				position=NumPad.SIX;
			}else if(s.equals("U")&&position==NumPad.FIVE){
				position=NumPad.TWO;
			}else if(s.equals("D")&&position==NumPad.FIVE){
				position=NumPad.EIGHT;
			}else if(s.equals("R")&&position==NumPad.ONE){
				position=NumPad.TWO;
			}else if(s.equals("D")&&position==NumPad.ONE){
				position=NumPad.FOUR;
			}else if(s.equals("L")&&position==NumPad.TWO){
				position=NumPad.ONE;
			}else if(s.equals("R")&&position==NumPad.TWO){
				position=NumPad.THREE;
			}else if(s.equals("D")&&position==NumPad.TWO){
				position=NumPad.FIVE;
			}else if(s.equals("L")&&position==NumPad.THREE){
				position=NumPad.TWO;
			}else if(s.equals("D")&&position==NumPad.THREE){
				position=NumPad.SIX;
			}else if(s.equals("U")&&position==NumPad.FOUR){
				position=NumPad.ONE;
			}else if(s.equals("D")&&position==NumPad.FOUR){
				position=NumPad.SEVEN;
			}else if(s.equals("R")&&position==NumPad.FOUR){
				position=NumPad.FIVE;
			}else if(s.equals("L")&&position==NumPad.SIX){
				position=NumPad.FIVE;
			}else if(s.equals("U")&&position==NumPad.SIX){
				position=NumPad.THREE;
			}else if(s.equals("D")&&position==NumPad.SIX){
				position=NumPad.NINE;
			}else if(s.equals("U")&&position==NumPad.SEVEN){
				position=NumPad.FOUR;
			}else if(s.equals("R")&&position==NumPad.SEVEN){
				position=NumPad.EIGHT;
			}else if(s.equals("U")&&position==NumPad.EIGHT){
				position=NumPad.FIVE;
			}else if(s.equals("L")&&position==NumPad.EIGHT){
				position=NumPad.SEVEN;
			}else if(s.equals("R")&&position==NumPad.EIGHT){
				position=NumPad.NINE;
			}else if(s.equals("U")&&position==NumPad.NINE){
				position=NumPad.SIX;
			}else if(s.equals("L")&&position==NumPad.NINE){
				position=NumPad.EIGHT;
			}
			
		}
		list.add(position.toString());
		return list;
		
	};
	
	
	
	static BinaryOperator<List<String>> add = (list,list2)->{
		list.addAll(list2);
		return list;
		
	};
	
	
	
	

}
