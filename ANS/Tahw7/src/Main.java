
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		KeywordHeap heap = new KeywordHeap();
		
		File file = new File("input.txt");
		Scanner scanner = new Scanner(file);
		while(scanner.hasNextLine()){
			String operation = scanner.next();
			
			switch (operation){
				case "add":
					String name = scanner.next();
					int count = scanner.nextInt();
					double weight = scanner.nextDouble();					
					heap.add(new Keyword(name, count, weight));
					break;
				case "peek":					
					heap.peek();
					break;
				case "removeMin":
					heap.removeMin();
					break;
				case "output":
					heap.output();
					break;
				default:
					System.out.println("InvalidOperation");
					break;
			}	
		}
		scanner.close();
	}

}

//add Fang 3 1.2
//add Yu 5 1.8
//add NCCU 2 0.6
//add UCSB 1 11.9
//peek
//add MIS 4 2.2
//removeMin
//add Badminton 5 0.6
//output