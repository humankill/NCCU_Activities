import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//hw1 answer 體重(公斤) 身高(公尺)
public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in)); 
		System.out.print("Please enter your weight(kg) and height(cm): "); 
		String text = buf.readLine(); 
		String[] data = text.split(" ");
		double res = getBMI(data);
		String dia = getDiagnosis(res);
		System.out.println(dia + " BMI: " + res); 
               
	}
	
	public static double getBMI(String[] data) {
		double weight=Double.parseDouble(data[0]);
		double height=Double.parseDouble(data[1])/100;
		double bmi=weight/(height*height);
		// 1. calculate the bmi 
		// result weight(kg) height(m) 
		return bmi;
	}
	
	public static String getDiagnosis(double bmi) {
		// give comments depending on bmi
		String result="";
		if(bmi>=30) {
			result="You are not in shape. Actually, you are not even close.";
		}else if(bmi>=26&&bmi<30) {
			result="To be honest, you are not in shape.";
		}
		else if(bmi>=20&&bmi<26) {
			result="You are in shape.";
		}
		else if(bmi<20) {
			result="You are under shape.";
		}else if(bmi<0) {
			result="wrong.";
		}
        return result;
	}
}
