
import java.util.Comparator;

public class KeywordComparator implements Comparator<Keyword>{//決定o1的關係 和o2比較 o1父
	@Override
	public int compare(Keyword o1, Keyword o2){
		if(o1==null || o2==null) throw new NullPointerException();
		//count 值小的放前面(變成父)  min heap [count 值大的放前面(變成父) max heap]
		if(o1.count<o2.count){ 
			return -1;
		}else if(o1.count>o2.count){
			return 1;
		}
		return 0;
	}
}
