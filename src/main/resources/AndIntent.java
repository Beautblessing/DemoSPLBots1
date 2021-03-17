package main.resources;

import java.util.ArrayList;

public class AndIntent {
//	 public GreetingIntent() {
//		 ArrayList<String> greetinputs= new ArrayList<String>();
//
//			//standard greeting
//			greetinputs.add("\n\t\"Howdy\"");
//			greetinputs.add("\n\t\"Hi\"");
//			greetinputs.add("\n\t\"Hello\"");
//			greetinputs.add("\n\t\"Hey\"");
//			greetinputs.add("\n\t\"Heya\"");
//			greetinputs.add("\n\t\"hey there\"");
//			greetinputs.add("\n\t\"good morning\"");
//			greetinputs.add("\n\t\"good afternoon\"");
//			greetinputs.add("\n\t\"good evening\"");
//			
//			
//			System.out.println("Greeting: \n inputs {"+greetinputs.toString().substring(1, greetinputs.toString().length() - 1)+" \n} " );
//
//		} 
	
	private ArrayList<String> greetinputs= new ArrayList<String>();

	@Override
    public String toString()
    { Intents intents = new Intents();
		greetinputs.add("\n\t\"Howdy\"");
		greetinputs.add("\n\t\"Hi\"");
		greetinputs.add("\n\t\"Hello\"");
		greetinputs.add("\n\t\"Hey\"");
		greetinputs.add("\n\t\"Heya\"");
		greetinputs.add("\n\t\"hey there\"");
		greetinputs.add("\n\t\"good morning\"");
		greetinputs.add("\n\t\"good afternoon\"");
		greetinputs.add("\n\t\"good evening\"");
		
		intents.setInputs(greetinputs);
		
		return "Greeting: \n inputs {"+greetinputs.toString().substring(1, greetinputs.toString().length() - 1)+" \n} " ;

    }
		//public String getGreetInputs(){
			//ArrayList<String> greetinputs= new ArrayList<String>();

	
	
//	public ArrayList<String> getGreetInputs(){
//		Intents intents = new Intents();
//			//standard greeting
//			greetinputs.add("\n\t\"Howdy\"");
//			greetinputs.add("\n\t\"Hi\"");
//			greetinputs.add("\n\t\"Hello\"");
//			greetinputs.add("\n\t\"Hey\"");
//			greetinputs.add("\n\t\"Heya\"");
//			greetinputs.add("\n\t\"hey there\"");
//			greetinputs.add("\n\t\"good morning\"");
//			greetinputs.add("\n\t\"good afternoon\"");
//			greetinputs.add("\n\t\"good evening\"");
//			intents.setInputs(greetinputs);
//			
//			return greetinputs;
//			//return "Greeting: \n inputs {"+greetinputs.toString().substring(1, greetinputs.toString().length() - 1)+" \n} " ;
//
//		
//		}
}
