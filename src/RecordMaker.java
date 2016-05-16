import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;


public class RecordMaker {
	public static void main(String args[]){
		
		if(args.length!=1){
			System.out.println("사용 법 : java RecordMaker.class [Count]");
		}else{

			HashMap<String, Integer> users = new HashMap<String, Integer>();

			int count = Integer.parseInt(args[0]);
			int counter = 0;
			while(counter < count){
				
				String temp_id = getRandomId();
				
				if(!users.containsKey(temp_id)){		
					users.put(temp_id, getRandomScore());
					counter++;
				}
			}
			
			Set<Entry<String, Integer>> set = users.entrySet();
			Iterator<Entry<String, Integer>> iterator = set.iterator();
			
			while(iterator.hasNext()){
				Map.Entry<String, Integer> e = (Map.Entry<String, Integer>)iterator.next();
				System.out.println("사원 id : "+ e.getKey() +", 점수 : " + e.getValue());
			}
			
			
			
		}

		
	}
	public static String getRandomId(){
		return "NT"+String.format("%05d", (new Random().nextInt(99999)));
	}
	
	public static int getRandomScore(){
		//0 - 99 리턴
		return new Random().nextInt(99);
	}

}
