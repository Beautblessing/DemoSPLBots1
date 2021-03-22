package reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;
import java.util.StringJoiner;

import org.sat4j.specs.TimeoutException;
import org.xtext.botGenerator.generator.BotPlatformStandAlone;

import de.ovgu.featureide.fm.core.FeatureModelAnalyzer;
import de.ovgu.featureide.fm.core.analysis.cnf.formula.FeatureModelFormula;
import de.ovgu.featureide.fm.core.base.*;
import de.ovgu.featureide.fm.core.base.impl.ConfigurationFactoryManager;
import de.ovgu.featureide.fm.core.base.impl.DefaultConfigurationFactory;
import de.ovgu.featureide.fm.core.configuration.Configuration;
import de.ovgu.featureide.fm.core.configuration.ConfigurationAnalyzer;
//import edu.smu.tspell.wordnet.Synset;
//import edu.smu.tspell.wordnet.WordNetDatabase;
import edu.smu.tspell.wordnet.*;
import main.resources.*;


public class BotDef {
	private static FMReader fmr = new FMReader("p1b.xml");
	static String name;


	public static void main(String[] args) throws FileNotFoundException {
		IFeatureModel model = fmr.get();

		IFeature fileName = model.getStructure().getRoot().getFeature();
		String outName = fileName.toString().replaceAll(" ", "");
		PrintStream outFile = new PrintStream(new File(outName+"Bot.bot")); 

		// Assign o to output stream 
		System.setOut(outFile);

		//print Bot name and language
		System.out.println("Chatbot " +outName+"Bot language: en \n\n intents:");
		//instantiate object
		BotDef botDef=new BotDef();
		//general_query intents
		botDef.GreetingIntent();
		botDef.HelpIntent();
		botDef.ConfigureIntent();
		botDef.NoConfigureIntent();
		botDef.HelpYesIntent();
		botDef.HelpNoIntent();
		botDef.SaveConfigIntent();
		botDef.SaveConfig_Yes();
		botDef.SaveConfig_No();
		//
		botDef.QueryFeatureNoIntent();
		botDef.QueryOptionalIntent();
		botDef.QueryConfigurationIntent();
		botDef.QueryCoreIntent();
		botDef.MandatoryIntent();
		botDef.OptionalIntent();

		//Specific
		botDef.OAnd();
		botDef.AndIntent();
		botDef.OrIntent();
		botDef.AltIntent();
		//entities
		botDef.printEntity();
		//actions
		botDef.printActions();
		//flows
		botDef.printFlow();

		//pass file to Bot generator

		//		BotPlatformStandAlone generator = BotPlatformStandAlone.getBotPlatformStandAlone();
		//		generator.runGenerator("/Users/usuario/Documents/eclipse4/DemoSPLBot1/"+outName, "src-gen");
		//	
		//	
	}

	//*********************************************Intents Definition*********************************************//

	//**************general intents********************//
	public void GreetingIntent() {
		ArrayList<String> greetinputs= new ArrayList<String>();

		//standard greeting phrases
		greetinputs.add("\n\t\"Howdy\"");
		greetinputs.add("\n\t\"Hi\"");
		greetinputs.add("\n\t\"Hello\"");
		greetinputs.add("\n\t\"Hey\"");
		greetinputs.add("\n\t\"Heya\"");
		greetinputs.add("\n\t\"hey there\"");
		greetinputs.add("\n\t\"good morning\"");
		greetinputs.add("\n\t\"good afternoon\"");
		greetinputs.add("\n\t\"good evening\"");

		System.out.println("Greeting: \n inputs {"+greetinputs.toString().substring(1, greetinputs.toString().length() - 1)+" \n} " );

	} 

	public void ConfigureIntent() {
		ArrayList<String> configureinputs= new ArrayList<String>();

		//standard configuration confirmation phrases
		configureinputs.add("\n\t\"Yes\"");
		configureinputs.add("\n\t\"yes I want to select a configuration\"");
		configureinputs.add("\n\t\"yes I would like to choose a configuration\"");
		configureinputs.add("\n\t\"ys what features do you have\"");
		configureinputs.add("\n\t\"yes what features are available\"");
		configureinputs.add("\n\t\"yes I´d love to\"");
		configureinputs.add("\n\t\"why not\"");
		configureinputs.add("\n\t\"yes I do\"");

		System.out.println("ConfigureIntent: \n inputs {"+configureinputs.toString().substring(1, configureinputs.toString().length() - 1)+" \n} " );

	} 

	public void NoConfigureIntent() {
		ArrayList<String> noconfigureinputs= new ArrayList<String>();

		//standard no configuration phrases
		noconfigureinputs.add("\n\t\"Thanks, but no\"");
		noconfigureinputs.add("\n\t\"No\"");
		noconfigureinputs.add("\n\t\"nah,I´m good\"");
		noconfigureinputs.add("\n\t\"not at all\""); 
		noconfigureinputs.add("\n\t\"never\"");
		noconfigureinputs.add("\n\t\"no way\"");

		System.out.println("NoConfigureIntent: \n inputs {"+noconfigureinputs.toString().substring(1, noconfigureinputs.toString().length() - 1)+" \n} " );

	}
	public void HelpIntent() {
		ArrayList<String> helpinputs= new ArrayList<String>();

		//standard help phrases
		helpinputs.add("\n\t\"Can you help me\"");
		helpinputs.add("\n\t\"I need help\"");
		helpinputs.add("\n\t\"what can I do\"");
		helpinputs.add("\n\t\"what can you do\"");

		System.out.println("Help: \n inputs {"+helpinputs.toString().substring(1, helpinputs.toString().length() - 1)+" \n} " );

	} 
	public void HelpYesIntent() {
		ArrayList<String> helpyesinputs= new ArrayList<String>();

		//standard help confirmation phrases
		helpyesinputs.add("\n\t\"Yes\"");
		helpyesinputs.add("\n\t\"yes I´d love to\"");
		helpyesinputs.add("\n\t\"why not\"");
		helpyesinputs.add("\n\t\"yes I do\"");

		System.out.println("Help_yes: \n inputs {"+helpyesinputs.toString().substring(1, helpyesinputs.toString().length() - 1)+" \n} " );

	} 
	public void HelpNoIntent() {
		ArrayList<String> helpnoinputs= new ArrayList<String>();

		//standard no help phrases
		helpnoinputs.add("\n\t\"Thanks, but no\"");
		helpnoinputs.add("\n\t\"No\"");
		helpnoinputs.add("\n\t\"nah,I´m good\"");
		helpnoinputs.add("\n\t\"not at all\"");
		helpnoinputs.add("\n\t\"never\"");
		helpnoinputs.add("\n\t\"no way\"");

		System.out.println("Help_no: \n inputs {"+helpnoinputs.toString().substring(1, helpnoinputs.toString().length() - 1)+" \n} " );

	} 

	public void SaveConfigIntent() {
		ArrayList<String> saveinputs= new ArrayList<String>();

		//standard confirmation
		saveinputs.add("\n\t\"download\"");
		saveinputs.add("\n\t\"save\"");

		System.out.println("SaveConfigIntent: \n inputs {"+saveinputs.toString().substring(1, saveinputs.toString().length() - 1)+" \n} " );

	}

	public void SaveConfig_Yes() {

		ArrayList<String> saveyesinputs= new ArrayList<String>();

		//standard save configuration confirmation phrases
		saveyesinputs.add("\n\t\"Yes\"");
		saveyesinputs.add("\n\t\"yes I´d love to\"");
		saveyesinputs.add("\n\t\"yes I do\"");

		System.out.println("SaveConfig_Yes: \n inputs {"+saveyesinputs.toString().substring(1, saveyesinputs.toString().length() - 1)+" \n} " );

	}
	public void SaveConfig_No() {
		ArrayList<String> savenoinputs= new ArrayList<String>();

		//dont save phrases
		savenoinputs.add("\n\t\"Thanks, but no\"");
		savenoinputs.add("\n\t\"No\"");

		System.out.println("SaveConfig_No: \n inputs {"+savenoinputs.toString().substring(1, savenoinputs.toString().length() - 1)+" \n} " );

	}
	//*****************/general intents*****************//

	//mandatory intent
	public void MandatoryIntent() {

		System.out.println("MandatoryIntent: \n inputs {\"Mandatory\" \n} " );

	}

	//optional intent
	public void OptionalIntent() {

		System.out.println("OptionalIntent: \n inputs {\"Optional\" \n} " );

	}
	//**************query intents********************//

	//phrases to query for optional features
	public void QueryOptionalIntent() {
		ArrayList<String> queryopt= new ArrayList<String>();

		//standard phrases
		queryopt.add("\n\t\"What are the optional features?\"");
		queryopt.add("\n\t\"list the optional features\"");
		queryopt.add("\n\t\"what optional features do you have\"");
		queryopt.add("\n\t\"what features are optional\"");
		System.out.println("QueryOptionalIntent: \n inputs {"+queryopt.toString().substring(1, queryopt.toString().length() - 1)+" \n} " );
	}

	//phrases to query for core features
	public void QueryCoreIntent() {
		ArrayList<String> querycore= new ArrayList<String>();

		//standard phrases
		querycore.add("\n\t\"What are the mandatory features?\"");
		querycore.add("\n\t\"list the core features?\"");
		querycore.add("\n\t\"what mandatory features do you have?\"");
		querycore.add("\n\t\"what features are automatically selected?\"");
		System.out.println("QueryCoreIntent: \n inputs {"+querycore.toString().substring(1, querycore.toString().length() - 1)+" \n} " );
	}

	//phrases to query for number of features
	public void QueryFeatureNoIntent() {
		ArrayList<String> queryfeat= new ArrayList<String>();

		//standard phrases
		queryfeat.add("\n\t\"What is the total number of features?\"");
		queryfeat.add("\n\t\"How many features are available?\"");
		queryfeat.add("\n\t\"How many features do you have\"");
		queryfeat.add("\n\t\"How many features?\"");
		System.out.println("QueryFeatureNoIntent: \n inputs {"+queryfeat.toString().substring(1, queryfeat.toString().length() - 1)+" \n} " );
	}

	//phrases to query for the possible configurations
	public void QueryConfigurationIntent() {
		ArrayList<String> queryconfig= new ArrayList<String>();

		//standard phrases
		queryconfig.add("\n\t\"What is the possible number of configuration?\"");
		queryconfig.add("\n\t\"How many configurations are possible?\"");
		queryconfig.add("\n\t\"How many configurations can I get?\"");
		queryconfig.add("\n\t\"How many configurations?\"");
		System.out.println("QueryConfigurationIntent: \n inputs {"+queryconfig.toString().substring(1, queryconfig.toString().length() - 1)+" \n} " );
	}

	//********************************************specific intents***********************************************//

	public void AndIntent() {
		//Display And and And children only

		IFeatureModel model = fmr.get();

		Intents intents = new Intents();

		for (final IFeature feat : model.getFeatures()) {
			if (feat.getStructure().isAnd()&&(!feat.getStructure().isRoot())&&(feat.getStructure().hasChildren())){


				if(!feat.getStructure().isOr() && (!feat.getStructure().isAlternative())){

					List<String> inputs = new ArrayList<String>();

					// Add training phrases or feature options
					inputs.add("\n\t\"I want to know the type of " +feat+" that is available\"");
					inputs.add("\n\t\""+feat+"\"");
					inputs.add("\n\t\"See available " +feat+"\"");
					inputs.add("\n\t\"what " +feat+" type is available\"");

					intents.setInputs(inputs);

					List<String> inputsYes = new ArrayList<String>();
					// phases for feature selection confirmation
					inputsYes.add("\n\t\"yes\"");
					inputsYes.add("\n\t\"yes I do\"");

					intents.setInputs(inputsYes);

					List<String> inputsNo = new ArrayList<String>();
					// Add training phrases for or no selection
					inputsNo.add("\n\t\"Thanks, but no\"");
					inputsNo.add("\n\t\"no\"");
					inputsNo.add("\n\t\"nah,I´m good\"");

					intents.setInputs(inputsNo);

					//Add Parameters

					Parameters parameters = new Parameters(feat, feat, "isList", "required", "prompts");  
					List<String> paramss = new ArrayList<String>(); 
					String entityName = feat.toString().toLowerCase();
					paramss.add("parameters: \n"+ feat+"_type: "+ "entity " +entityName +", " + "isList" +", " + "required" +", "+ "prompts"+" [\"What type of " +feat+"?\"];");       

					parameters.setParamss(paramss);
					if (feat.getStructure().hasChildren()) {

						final List<IFeature> children = FeatureUtils.convertToFeatureList(feat.getStructure().getChildren());
						ArrayList<String> selectfeature= new ArrayList<String>();

						for(IFeature child: FeatureUtils.convertToFeatureList(feat.getStructure().getChildren())) {
							selectfeature.add("\n\t(\""+child+"\")["+feat+"_type]");
							selectfeature.add("\n\t\"I want\" "+"(\""+child+"\")["+feat+"_type]");
							selectfeature.add("\n\t\"I´ll go with\" "+"(\""+child+"\")["+feat+"_type]");
							selectfeature.add("\n\t\"Give me\" "+"(\""+child+"\")["+feat+"_type]");

						}

						String result = "\n";
						if (!feat.getStructure().isMandatory()) {
							result += "Select_" +feat+"_yes: \n ";
							result += "inputs {"+inputsYes.toString().substring(1, inputsYes.toString().length() - 1)+" \n} " + "\n";
							result += "Select_" +feat+"_no: \n ";
							result += "inputs {"+inputsNo.toString().substring(1, inputsNo.toString().length() - 1)+" \n} " + "\n";

						}

						result += feat+": \n inputs {"+inputs.toString().substring(1, inputs.toString().length() - 1)+" \n} " + "\n";

						result += "Select_" +feat+": \n ";
						result += "inputs {\n"+selectfeature.toString().substring(1, selectfeature.toString().length() - 1)+" \n} "+" \n ";
						result += "\n"+ paramss.toString().substring(1, paramss.toString().length() - 1);

						System.out.println(result);
					}
				}
			}

		}
	}

	public void OAnd() {
		IFeatureModel model = fmr.get();

		//// 
		for (final IFeature feature : model.getFeatures()) {

			if (feature.getStructure().isRoot()&&(feature.getStructure().hasChildren())){

				for(IFeature child: FeatureUtils.convertToFeatureList(feature.getStructure().getChildren())) {
					if (!child.getStructure().isAlternative() && !child.getStructure().isOr()) {
						//if (!child.getStructure().isAlternative() && !child.getStructure().isOr() && (!feature.getStructure().isAnd())) {
						if(!child.getStructure().hasChildren()) {
							//System.out.println(child);

							Intents intents = new Intents();
							ArrayList<String> selectfeat= new ArrayList<String>();

							selectfeat.add("\n\t\""+child+"\"");
							selectfeat.add("\n\t\"I want " +child+ "\"");
							selectfeat.add("\n\t\"I´ll go with "+child+"\"");
							selectfeat.add("\n\t\"Give me "+child+"\"");
							intents.setInputs(selectfeat);

							ArrayList<String> selectfeature= new ArrayList<String>();

							selectfeature.add("\n\t(\""+child+"\")["+child+"_type]");
							selectfeature.add("\n\t\"I want\" "+"(\""+child+"\")["+child+"_type]");
							selectfeature.add("\n\t\"I´ll go with\" "+"(\""+child+"\")["+child+"_type]");
							selectfeature.add("\n\t\"Give me\" "+"(\""+child+"\")["+child+"_type]");


							List<String> inputsYes = new ArrayList<String>();
							// Add training phrases for or yes confirmation

							inputsYes.add("\n\t\"yes\"");


							intents.setInputs(inputsYes);

							List<String> inputsNo = new ArrayList<String>();
							// Add training phrases for or no selection

							inputsNo.add("\n\t\"no\"");

							//Add	Parameters

							ParametersAlt parameters = new ParametersAlt(child, child, "required", "prompts");  
							List<String> paramss = new ArrayList<String>(); 
							String entityName = child.toString().toLowerCase();
							paramss.add("parameters: \n"+ child+"_type: "+ "entity " +entityName  +", " + "required" +", "+ "prompts"+" [\"enter " +child+"\"];");       

							parameters.setParamss(paramss);


							String result = "\n";
							if (!child.getStructure().isMandatory()) {
								result += "Select_" +child+"_yes: \n ";
								result += "inputs {"+inputsYes.toString().substring(1, inputsYes.toString().length() - 1)+" \n} " + "\n";
								result += "Select_" +child+"_no: \n ";
								result += "inputs {"+inputsNo.toString().substring(1, inputsNo.toString().length() - 1)+" \n} " + "\n";
							}

							result += child+": \n inputs {"+selectfeat.toString().substring(1, selectfeat.toString().length() - 1)+" \n} " + "\n";
							result += "Select_" +child+": \n inputs {"+selectfeature.toString().substring(1, selectfeature.toString().length() - 1)+" \n} " + "\n";

							result += "\n"+ paramss.toString().substring(1, paramss.toString().length() - 1);

							System.out.println(result);

						}
					}
				}
			}

		}

	}




	///selection response for first level terminal nodes

	public void OAndResp() {
		IFeatureModel model = fmr.get();

		////
		for (final IFeature feature : model.getFeatures()) {

			if (feature.getStructure().isRoot()&&(feature.getStructure().hasChildren())){

				for(IFeature child: FeatureUtils.convertToFeatureList(feature.getStructure().getChildren())) {
					if (!child.getStructure().isAlternative() && !child.getStructure().isOr()) {
						//if (!child.getStructure().isAlternative() && !child.getStructure().isOr() && (!feature.getStructure().isAnd())) {
						if(!child.getStructure().hasChildren()) {
							//System.out.println(child);

							Intents intents = new Intents();
							ArrayList<String> selectfeat= new ArrayList<String>();

							//selectfeat.add("text response "+child+"Response: \n inputs {\n \""+"Selected feature: \"" +"\n [\""+ "Select_" +child+"."+child+"_type\"]\n");
							selectfeat.add("text response "+child+"Response: \n inputs {\n \""+"Selected feature: \"" +"\n [\""+ "Select_" +child+"."+child+"_type\"]");

							intents.setInputs(selectfeat);

							List<String> inputsPrompt = new ArrayList<String>();
							inputsPrompt.add("text response "+child+"Prompt: \n inputs {\n \""+"enter " + child + " to select\"\n}\n");

							intents.setInputs(inputsPrompt);

							String result = "";
							if (!child.getStructure().isMandatory()) {

								//result += inputsPrompt.toString().substring(1, inputsPrompt.toString().length() - 1)+" \n}\n";
								result += inputsPrompt.toString().substring(1, inputsPrompt.toString().length() - 1)+" \n";

							}

							result += selectfeat.toString().substring(1, selectfeat.toString().length() - 1)+" \n} " + "\n";


							System.out.println(result);

						}
					}
				}
			}

		}

	}


	///selection response for And other levels

	public void AndResp() {
		IFeatureModel model = fmr.get();

		////
		for (final IFeature feature : model.getFeatures()) {

			if (feature.getStructure().isRoot()&&(feature.getStructure().hasChildren())){

				for(IFeature child: FeatureUtils.convertToFeatureList(feature.getStructure().getChildren())) {
					if (!child.getStructure().isAlternative() && !child.getStructure().isOr()) {
						//if (!child.getStructure().isAlternative() && !child.getStructure().isOr() && (!feature.getStructure().isAnd())) {
						if(child.getStructure().hasChildren()) {
							//System.out.println(child);

							Intents intents = new Intents();
							//										ArrayList<String> selectfeat= new ArrayList<String>();
							//										
							//selectfeat.add("text response "+child+"Response: \n inputs {\n \""+"Selected feature: \"" +"\n [\""+ "Select_" +child+"."+child+"_type\"]");

							//										intents.setInputs(selectfeat);

							List<String> inputsPrompt = new ArrayList<String>();
							// Add training phrases for or yes confirmation

							// inputsPrompt.add("text response "+child+"Prompt: \n inputs {\n \""+"enter " + child + " to select\"\n");
							inputsPrompt.add("text response "+child+"Prompt: \n inputs {\n \""+"enter " + child + " to select\"");


							intents.setInputs(inputsPrompt);

							//String result = "\n";
							String result = "";
							if (!child.getStructure().isMandatory()) {

								//result += inputsPrompt.toString().substring(1, inputsPrompt.toString().length() - 1)+" \n} " + "\n";
								result += inputsPrompt.toString().substring(1, inputsPrompt.toString().length() - 1)+" \n} " ;

							}

							//result += selectfeat.toString().substring(1, selectfeat.toString().length() - 1)+" \n} " + "\n";


							System.out.println(result);

						}
					}
				}
			}

		}

	}



	// Or features Intents
	public void OrIntent() {

		IFeatureModel model = fmr.get();

		Intents intents = new Intents();

		//int or1 = 0;
		for (final IFeature feat : model.getFeatures()) {
			if (feat.getStructure().isOr() && (!feat.getStructure().isRoot())){
				//or1++;

				//added
				List<String> inputs = new ArrayList<String>();

				// Add training phrases or feature options
				inputs.add("\n\t\"I want to know the type of " +feat+" that is available\"");
				inputs.add("\n\t\""+feat+"\"");
				inputs.add("\n\t\"See available " +feat+"\"");
				inputs.add("\n\t\"what " +feat+" type is available\"");

				intents.setInputs(inputs);

				List<String> inputsYes = new ArrayList<String>();
				// Add training phrases for or yes confirmation
				//						inputsYes.add("\n\t\"yes, I want " +feat+"\"");
				//						inputsYes.add("\n\t\""+feat+"\"");
				inputsYes.add("\n\t\"yes\"");
				///				inputsYes.add("\n\t\"yes, what " + feat + " is available\"" );
				inputsYes.add("\n\t\"yes I do\"");

				intents.setInputs(inputsYes);

				List<String> inputsNo = new ArrayList<String>();
				// Add training phrases for or no selection
				//						inputsNo.add("\n\t\"Thanks, I do not want " +feat+"\"");
				inputsNo.add("\n\t\"Thanks, but no\"");
				inputsNo.add("\n\t\"no\"");
				inputsNo.add("\n\t\"nah,I´m good\"");

				intents.setInputs(inputsNo);

				//						Add	Parameters

				Parameters parameters = new Parameters(feat, feat, "isList", "required", "prompts");  
				List<String> paramss = new ArrayList<String>(); 
				// paramss.add("parameters: \n"+ pName +": "+ "entity " +name +", " + "required" +", "+ "prompts"+" [\"What type of " +name+"?\"]");
				//paramss.add("parameters: \n"+ feat+"_type: "+ "entity " +feat.toLowerCase() +", " + "isList" +", " + "required" +", "+ "prompts"+" [\"What type of " +feat+"?\"];");       
				String entityName = feat.toString().toLowerCase();
				paramss.add("parameters: \n"+ feat+"_type: "+ "entity " +entityName +", " + "isList" +", " + "required" +", "+ "prompts"+" [\"What type of " +feat+"?\"];");       

				parameters.setParamss(paramss);

				//System.out.println(inputs.toString().substring(1, inputs.toString().length() - 1)+" \n}");
				//System.out.println( or1 +" Or - "+  feat  );	
				if (feat.getStructure().hasChildren()) {

					//System.out.println(feat.getStructure().getChildren().toString());
					final List<IFeature> children = FeatureUtils.convertToFeatureList(feat.getStructure().getChildren());
					//System.out.println(children);


					// Feature select phrases
					ArrayList<String> selectfeature= new ArrayList<String>();

					for(IFeature child: FeatureUtils.convertToFeatureList(feat.getStructure().getChildren())) {
						selectfeature.add("\n\t(\""+child+"\")["+feat+"_type]");
						selectfeature.add("\n\t\"I want\" "+"(\""+child+"\")["+feat+"_type]");
						selectfeature.add("\n\t\"I´ll go with\" "+"(\""+child+"\")["+feat+"_type]");
						selectfeature.add("\n\t\"Give me\" "+"(\""+child+"\")["+feat+"_type]");

					}

					String result = "\n";
					if (!feat.getStructure().isMandatory()) {
						result += "Select_" +feat+"_yes: \n ";
						result += "inputs {"+inputsYes.toString().substring(1, inputsYes.toString().length() - 1)+" \n} " + "\n";
						result += "Select_" +feat+"_no: \n ";
						result += "inputs {"+inputsNo.toString().substring(1, inputsNo.toString().length() - 1)+" \n} " + "\n";

					}

					result += feat+": \n inputs {"+inputs.toString().substring(1, inputs.toString().length() - 1)+" \n} " + "\n";

					result += "Select_" +feat+": \n ";
					result += "inputs {\n"+selectfeature.toString().substring(1, selectfeature.toString().length() - 1)+" \n} "+" \n ";
					result += "\n"+ paramss.toString().substring(1, paramss.toString().length() - 1);

					System.out.println(result);
				}
			}

		}
	}

	//Alternative features intents//
	public void AltIntent() {
		//				FMReader fmr = new FMReader("p1.xml");
		IFeatureModel model = fmr.get();

		Intents intents = new Intents();

		//int or1 = 0;
		for (final IFeature feat : model.getFeatures()) {
			if (feat.getStructure().isAlternative() && (!feat.getStructure().isRoot())){
				//or1++;

				//added
				List<String> inputs = new ArrayList<String>();

				// Add training phrases or feature options
				inputs.add("\n\t\"I want to know the type of " +feat+" that is available\"");
				inputs.add("\n\t\""+feat+"\"");
				inputs.add("\n\t\"See available " +feat+"\"");
				inputs.add("\n\t\"what " +feat+" type is available\"");

				intents.setInputs(inputs);

				List<String> inputsYes = new ArrayList<String>();
				// Add training phrases for or yes confirmation
				//						inputsYes.add("\n\t\"yes, I want " +feat+"\"");
				//						inputsYes.add("\n\t\""+feat+"\"");
				inputsYes.add("\n\t\"yes\"");
				//						inputsYes.add("\n\t\"yes, what " + feat + " is available\"" );
				inputsYes.add("\n\t\"yes I do\"");

				intents.setInputs(inputsYes);

				List<String> inputsNo = new ArrayList<String>();
				// Add training phrases for or no selection
				//						inputsNo.add("\n\t\"Thanks, I do not want " +feat+"\"");
				inputsNo.add("\n\t\"Thanks, but no\"");
				inputsNo.add("\n\t\"no\"");
				inputsNo.add("\n\t\"nah,I´m good\"");

				intents.setInputs(inputsNo);

				//						Add	Parameters

				ParametersAlt parameters = new ParametersAlt(feat, feat, "required", "prompts");  
				List<String> paramss = new ArrayList<String>(); 
				String entityName = feat.toString().toLowerCase();
				paramss.add("parameters: \n"+ feat+"_type: "+ "entity " +entityName  +", " + "required" +", "+ "prompts"+" [\"What type of " +feat+"?\"];");       

				parameters.setParamss(paramss);

				if (feat.getStructure().hasChildren()) {
					// Feature select phrases
					ArrayList<String> selectfeature= new ArrayList<String>();

					for(IFeature child: FeatureUtils.convertToFeatureList(feat.getStructure().getChildren())) {
						selectfeature.add("\n\t(\""+child+"\")["+feat+"_type]");
						selectfeature.add("\n\t\"I want\" "+"(\""+child+"\")["+feat+"_type]");
						selectfeature.add("\n\t\"I´ll go with\" "+"(\""+child+"\")["+feat+"_type]");
						selectfeature.add("\n\t\"Give me\" "+"(\""+child+"\")["+feat+"_type]");

					}

					String result = "\n";
					if (!feat.getStructure().isMandatory()) {
						result += "Select_" +feat+"_yes: \n ";
						result += "inputs {"+inputsYes.toString().substring(1, inputsYes.toString().length() - 1)+" \n} " + "\n";
						result += "Select_" +feat+"_no: \n ";
						result += "inputs {"+inputsNo.toString().substring(1, inputsNo.toString().length() - 1)+" \n} " + "\n";

					}

					result += feat+": \n inputs {"+inputs.toString().substring(1, inputs.toString().length() - 1)+" \n} " + "\n";

					result += "Select_" +feat+": \n ";
					result += "inputs {\n"+selectfeature.toString().substring(1, selectfeature.toString().length() - 1)+" \n} "+" \n ";
					result += "\n"+ paramss.toString().substring(1, paramss.toString().length() - 1);

					System.out.println(result);
				}
			}

		}
	}

	//******************************************************/specific intents*************************************************************//


	//****************************************************/Entity Definition*************************************************************//
	public void printEntity() {


		IFeatureModel model = fmr.get();

		Entity entity = new Entity();

		System.out.println("\n entities:");
		//alternative entities
		for (final IFeature feat : model.getFeatures()) {
			//if (feat.getStructure().isAlternative() && (!feat.getStructure().isRoot())){
			if (feat.getStructure().isAlternative()){

				List<String> inputs = new ArrayList<String>();

				inputs.add("Simple entity \"" +feat.toString().toLowerCase()+"\":\n inputs in en{ ");

				entity.setInputs(inputs);
				String result = inputs.toString().substring(1, inputs.toString().length() - 1);
				System.out.println(result);

				//System.out.println("Simple entity \"" +feat.toString().toLowerCase()+"\":\n inputs in en{ ");

				if (feat.getStructure().hasChildren()) {

					for(IFeature child: FeatureUtils.convertToFeatureList(feat.getStructure().getChildren())) {
						name = child.toString();
						System.out.println("\""+child+"\" synonyms \"" +printSynonymn()+"\"");
					}
					System.out.println("}\n");	
				}
			}
		}

		//Or entities
		for (final IFeature feat : model.getFeatures()) {
			//if (feat.getStructure().isOr() && (!feat.getStructure().isRoot())){
			if (feat.getStructure().isOr()){

				List<String> inputs = new ArrayList<String>();

				inputs.add("Simple entity \"" +feat.toString().toLowerCase()+"\":\n inputs in en{ ");

				entity.setInputs(inputs);
				String result = inputs.toString().substring(1, inputs.toString().length() - 1);
				System.out.println(result);

				//System.out.println("Simple entity \"" +feat.toString().toLowerCase()+"\":\n inputs in en{ ");

				if (feat.getStructure().hasChildren()) {

					for(IFeature child: FeatureUtils.convertToFeatureList(feat.getStructure().getChildren())) {
						name = child.toString();
						System.out.println("\""+child+"\" synonyms \"" +printSynonymn()+"\"");
					}
					System.out.println("}\n");	
				}
			}
		}

		//And groups
		//Display And and only children

		for (final IFeature feat : model.getFeatures()) {
			//					
			//if ((feat.getStructure().isAnd() &&(feat.getStructure().hasChildren()))){
			if ((feat.getStructure().isAnd() &&(feat.getStructure().hasChildren()) &&(!feat.getStructure().isRoot()))){

				if(!feat.getStructure().isOr() && (!feat.getStructure().isAlternative())){

					List<String> inputs = new ArrayList<String>();

					inputs.add("Simple entity \"" +feat.toString().toLowerCase()+"\":\n inputs in en{ ");

					entity.setInputs(inputs);
					String result = inputs.toString().substring(1, inputs.toString().length() - 1);
					System.out.println(result);
				}
				if (feat.getStructure().hasChildren()) {

					for(IFeature child: FeatureUtils.convertToFeatureList(feat.getStructure().getChildren())) {
						name = child.toString();
						System.out.println("\""+child+"\" synonyms \"" +printSynonymn()+"\"");
					}
					System.out.println("}\n");	
				}
			}
		}


		//terminal nodes from roots
		for (final IFeature feature : model.getFeatures()) {

			if (feature.getStructure().isRoot()&&(feature.getStructure().hasChildren())){

				for(IFeature child: FeatureUtils.convertToFeatureList(feature.getStructure().getChildren())) {
					if (!child.getStructure().isAlternative() && !child.getStructure().isOr()) {
						//if (!child.getStructure().isAlternative() && !child.getStructure().isOr() && (!feature.getStructure().isAnd())) {
						if(!child.getStructure().hasChildren()) {
							//System.out.println(child);

							List<String> inputs = new ArrayList<String>();

							inputs.add("Simple entity \"" +child.toString().toLowerCase()+"\":\n inputs in en{ ");

							entity.setInputs(inputs);
							String result = inputs.toString().substring(1, inputs.toString().length() - 1);
							System.out.println(result);

							name = child.toString();
							System.out.println("\""+child+"\" synonyms \"" +printSynonymn()+"\"\n}\n");
						}

					}
				}
			}
		}

		//
	}	





	//********************************************************actions Definition****************************************************//
	public void GreetingResponse() {
		ArrayList<String> greetresponse= new ArrayList<String>();

		//greeting responses
		greetresponse.add("\"Hello there! I am here to help you with configuring your software product line. Would you like to proceed?\"");
		greetresponse.add("\"Hi, welcome to SPLBot! Would you like to select a configuration?\"");

		System.out.println("text response GreetingResponse: \n inputs {\n\t"+greetresponse.toString().substring(1, greetresponse.toString().length() - 1)+" \n}\n " );

	} 

	public void HelpResponse() {
		ArrayList<String> helpresponse= new ArrayList<String>();

		//Help response
		helpresponse.add("\"yes, I can help you with configuring your software product line. Would you like to proceed?\"");
		helpresponse.add("\"I can help you with configuring your software product line. Would you like to proceed?\"");

		System.out.println("text response HelpResponse: \n inputs {\n\t"+helpresponse.toString().substring(1, helpresponse.toString().length() - 1)+" \n}\n " );

	} 

	public void HelpNoResponse() {
		ArrayList<String> helpnoresponse= new ArrayList<String>();

		//No help response
		helpnoresponse.add("\"Thank you for using SPLBot!\"");

		System.out.println("text response Help_noResponse: \n inputs {\n\t"+helpnoresponse.toString().substring(1, helpnoresponse.toString().length() - 1)+" \n}\n " );

	}   

	public void NoConfigureIntentResponse() {
		ArrayList<String> noconfigresponse= new ArrayList<String>();

		//No configuration response
		noconfigresponse.add("\"Thank you for using SPLBot!\"");

		System.out.println("text response NoConfigureIntentResponse: \n inputs {\n\t"+noconfigresponse.toString().substring(1, noconfigresponse.toString().length() - 1)+" \n}\n " );

	}   

	public void SaveConfigResponse() {
		ArrayList<String> saveconfig= new ArrayList<String>();

		//save configuration response
		saveconfig.add("\"You are done with your configuration. Would like to save the configuration?\"");
		saveconfig.add("\"save the configuration?\"");
		saveconfig.add("\"view the configuration?\"");

		System.out.println("text response SaveConfigResponse: \n inputs {\n\t"+saveconfig.toString().substring(1, saveconfig.toString().length() - 1)+" \n}\n " );
	}

	//print action definition
	public void printActions() {

		System.out.println("actions:");
		GreetingResponse();
		HelpResponse();
		HelpNoResponse();
		NoConfigureIntentResponse();
		SaveConfigResponse();

		////////////

		BotDef bDef = new BotDef();

		System.out.println("text response ConfigureResponse: \n inputs {\n \""+"Great! ");

		bDef.startConfig();
		//
		bDef.QueryNoOfFeatResponse();
		bDef.QueryCoreFeatResponse();
		bDef.QueryOptFeatResponse();
		bDef.QueryConfigurationResponse();
		//
		bDef.CoreFeatSelectResponse();
		bDef.OptSelectResponse();
		bDef.Type();
		//
		bDef.MandatoryResp();
		bDef.OPtionalResp();
		bDef.OAndResp();

	}	

	// print flow definition
	public void printFlow() {
		System.out.println("flows:");
		UserGreeting();
		UserHelp();
		//					FlowMand();
		//					FlowOpt();
		//					FlowTermOpt();
		//					
		UserQueryNoFeat();
		UserQueryOptFeat();
		UserQueryCoreFeat(); 
		UserQueryConfiguration(); 


	}
	//begin configuration
	public void startConfig() {
		//show list of mandatory features
		//Intro1();
		//show list of optional features
		//Intro2();

		System.out.println("Please note that the \"Root\" and \"Core features\" are automatically selected, but you will have the liberty to select from the optional features. ");

		System.out.println("\"\n } \n");
	}

	public void Intro1() {
		IFeatureModel model = fmr.get();

		System.out.println("Please note that the \"Root\" and \"Core features\" are automatically selected, but you will have the liberty to select from the optional features. ");
		final Iterable<IFeature> features = model.getFeatures();
		for (final IFeature feature : features) {
			StringJoiner joiner = new StringJoiner(", ");	
			if (feature.getStructure().isMandatorySet()&&feature.getStructure().hasChildren() ){

				if (feature.getStructure().isAnd()) {
					//System.out.println("Root: \"" + feature+"\"\nAutomatic selections if any:");

					for (final IFeatureStructure child : feature.getStructure().getChildren()) {
						if (child.isMandatory()) {
							final IFeature childFeature = child.getFeature();
							joiner.add(childFeature.toString());
						}
					}
					//System.out.println(joiner.toString());

				}else if (feature.getStructure().isOr()) {
					//								System.out.println("You can select one or more features from " + feature + " group");
					for (final IFeatureStructure child : feature.getStructure().getChildren()) {
						if (child.isMandatory()) {
							final IFeature childFeature = child.getFeature();
							joiner.add(childFeature.toString());
						}
					}
					//								System.out.println(joiner.toString());
				}else if (feature.getStructure().isAlternative()) {
					//								System.out.println("You can select only one of these features from \"" + feature + "\" group");

					for (final IFeatureStructure child : feature.getStructure().getChildren()) {
						if (child.isMandatory()) {
							final IFeature childFeature = child.getFeature();
							//System.out.println(childFeature + " -> " + feature);
							joiner.add(childFeature.toString());
						}
					}
					//								System.out.println(joiner.toString());
				}

			}	

		}	

	}


	public void Intro2() {

		IFeatureModel model = fmr.get();
		System.out.println("You can choose any of these optional features. ");
		final Iterable<IFeature> features = model.getFeatures();
		StringJoiner joiner = new StringJoiner(", ");
		for (final IFeature feature : features) {

			//System.out.println(feature.getStructure().getRelevantConstraints());

			if (!feature.getStructure().isMandatory()){
				//System.out.println(feature);
				joiner.add(feature.toString());

			}
		}System.out.println("Optional Features: "+ joiner.toString());

	}

	//mandatory prompt
	public void Mandatory() {
		IFeatureModel model = fmr.get();

		System.out.println("Please note that the \"Root\" and \"Core features\" are automatically selected: ");
		final Iterable<IFeature> features = model.getFeatures();
		for (final IFeature feature : features) {
			StringJoiner joiner = new StringJoiner(", ");	
			if (feature.getStructure().isMandatorySet()&&feature.getStructure().hasChildren() ){

				if (feature.getStructure().isAnd()) {
					//System.out.println("Automatic selections: \"" + feature+"\"");
					System.out.println("Root: \"" + feature+"\"\nAutomatic selections if any:");

					for (final IFeatureStructure child : feature.getStructure().getChildren()) {
						if (child.isMandatory()) {
							final IFeature childFeature = child.getFeature();
							//System.out.println(childFeature + " -> "+ feature);
							joiner.add(childFeature.toString());
						}
					}System.out.println(joiner.toString());
					//System.out.println();
				}else if (feature.getStructure().isOr()) {
					System.out.println("You can select one or more features from " + feature + " group");
					for (final IFeatureStructure child : feature.getStructure().getChildren()) {
						if (child.isMandatory()) {
							final IFeature childFeature = child.getFeature();
							//System.out.println(childFeature + " ->" + feature);
							joiner.add(childFeature.toString());
						}
					}System.out.println(joiner.toString());
				}else if (feature.getStructure().isAlternative()) {
					System.out.println("You can select only one of these features from \"" + feature + "\" group");

					for (final IFeatureStructure child : feature.getStructure().getChildren()) {
						if (child.isMandatory()) {
							final IFeature childFeature = child.getFeature();
							//System.out.println(childFeature + " -> " + feature);
							joiner.add(childFeature.toString());
						}
					}System.out.println(joiner.toString());
				}

			}	

		}	


	}

	//mandatory prompt responses
	public void MandatoryResp() {
		IFeatureModel model = fmr.get();			

		//					System.out.println("Please note that the \"root\" and \"core features\" are automatically selected: ");
		final Iterable<IFeature> features = model.getFeatures();
		for (final IFeature feature : features) {

			StringJoiner joiner = new StringJoiner(", ");

			if (feature.getStructure().isMandatorySet()&&feature.getStructure().hasChildren() ){

				if (feature.getStructure().isAnd()&& !feature.getStructure().isRoot()) {

					System.out.println("text response "+feature+"Response: \n inputs {\n \""+"Selected feature: \"" +"\n [\""+ "Select_" +feature+"."+feature+"_type\"]\n}\n");


					//System.out.println("Automatic selections: \"" + feature+"\"");
					System.out.println("text response " +feature+"Type:\n inputs{ ");
					//System.out.println("\"feature is automatically selected:");
					System.out.println("\"You can choose one or more of the following features in this group:");


					for (final IFeatureStructure child : feature.getStructure().getChildren()) {
						if (!child.isMandatory()) {
							final IFeature childFeature = child.getFeature();
							joiner.add(childFeature.toString());
							//System.out.println(childFeature);
						}
					}System.out.println(joiner.toString());
					System.out.println("\"\n } ");
				}else
					if (feature.getStructure().isOr()) {


						System.out.println("text response "+feature+"Response: \n inputs {\n \""+"Selected feature: \"" +"\n [\""+ "Select_" +feature+"."+feature+"_type\"]\n}\n");

						//System.out.println("You can select one or more features from " + feature + " group");
						System.out.println("text response " +feature+"Type:\n inputs{ ");
						System.out.println("\"You can choose one or more of the following features:");

						for (final IFeatureStructure child : feature.getStructure().getChildren()) {
							if (child.isMandatory()) {
								final IFeature childFeature = child.getFeature();
								joiner.add(childFeature.toString());
								//System.out.println(childFeature);
							}
						}	System.out.println(joiner.toString());
						System.out.println("\"\n } ");
						//response selection

					}else if (feature.getStructure().isAlternative()) {


						System.out.println("text response "+feature+"Response: \n inputs {\n \""+"Selected feature: \"" +"\n [\""+ "Select_" +feature+"."+feature+"_type\"]\n}\n");


						//System.out.println("You can select only one of these features from \"" + feature + "\" group");
						System.out.println("text response " +feature+"Type:\n inputs{ ");
						//System.out.println("\"You can only select one of the following features:");
						System.out.println("\"You have to configure " +feature+". Please you can only select one of the following features:");

						//StringJoiner joiner = new StringJoiner(", ");
						for (final IFeatureStructure child : feature.getStructure().getChildren()) {
							if (child.isMandatory()) {
								final IFeature childFeature = child.getFeature();
								joiner.add(childFeature.toString());

								//System.out.println(childFeature);

							}

						}	System.out.println(joiner.toString());
						System.out.println("\"\n } ");
					}


			}	

		}	


	}


	//optional features responses
	public void OPtionalResp() {
		IFeatureModel model = fmr.get();

		//					System.out.println("Please note that the \"root\" and \"core features\" are automatically selected: ");
		final Iterable<IFeature> features = model.getFeatures();
		for (final IFeature feature : features) {
			StringJoiner joiner = new StringJoiner(", ");

			if (!feature.getStructure().isMandatorySet()&&feature.getStructure().hasChildren() ){

				//And
				if (feature.getStructure().isAnd()&& !feature.getStructure().isRoot()) {
					//prompt
					System.out.println("text response "+feature+"Prompt: \n inputs {\n \""+"enter " + feature + " to select\"\n}\n");
					//Selected Response
					System.out.println("text response "+feature+"Response: \n inputs {\n \""+"Selected feature: \"" +"\n [\""+ "Select_" +feature+"."+feature+"_type\"]\n}\n");

					//selected Type Response
					//System.out.println("Automatic selections: \"" + feature+"\"");
					System.out.println("text response " +feature+"Type:\n inputs{ ");
					//System.out.println("\"feature is automatically selected:");
					System.out.println("\"You can choose one or more of the following features:");


					for (final IFeatureStructure child : feature.getStructure().getChildren()) {
						if (!child.isMandatory()) {
							final IFeature childFeature = child.getFeature();
							//System.out.println(childFeature);
							joiner.add(childFeature.toString());
						}
					}System.out.println(joiner.toString());
					System.out.println("\"\n } ");

					//Or
				}else
					if (feature.getStructure().isOr()) {

						System.out.println("text response "+feature+"Response: \n inputs {\n \""+"Selected feature: \"" +"\n [\""+ "Select_" +feature+"."+feature+"_type\"]\n}\n");


						//System.out.println("You can select one or more features from " + feature + " group");
						System.out.println("text response " +feature+"Type:\n inputs{ ");
						System.out.println("\"You can choose one or more of the following features:");

						for (final IFeatureStructure child : feature.getStructure().getChildren()) {
							if (child.isMandatory()) {
								final IFeature childFeature = child.getFeature();
								joiner.add(childFeature.toString());
								//System.out.println(childFeature);
							}
						}	System.out.println(joiner.toString());
						System.out.println("\"\n } ");

						//Alternative
					}else if (feature.getStructure().isAlternative()) {

						System.out.println("text response "+feature+"Response: \n inputs {\n \""+"Selected feature: \"" +"\n [\""+ "Select_" +feature+"."+feature+"_type\"]\n}\n");


						//System.out.println("You can select only one of these features from \"" + feature + "\" group");
						System.out.println("text response " +feature+"Type:\n inputs{ ");
						System.out.println("\"You can only select one of the following features:");

						for (final IFeatureStructure child : feature.getStructure().getChildren()) {
							if (child.isMandatory()) {
								final IFeature childFeature = child.getFeature();
								joiner.add(childFeature.toString());
								//System.out.println(childFeature);

							}
						}	System.out.println(joiner.toString());
						System.out.println("\"\n } ");
					}


			}	

		}	


	}



	//Optional features

	public void Optional(){

		IFeatureModel model = fmr.get();
		System.out.println("You can choose any of these optional features. ");
		final Iterable<IFeature> features = model.getFeatures();
		StringJoiner joiner = new StringJoiner(", ");
		for (final IFeature feature : features) {

			//System.out.println(feature.getStructure().getRelevantConstraints());

			if (!feature.getStructure().isMandatory()){
				//System.out.println(feature);
				joiner.add(feature.toString());

			}
		}System.out.println("Optional Features: "+ joiner.toString());
	}


	//optional responses
	public void OptionalRes(){

		IFeatureModel model = fmr.get();
		System.out.println("You can choose any of these optional features: ");
		final Iterable<IFeature> features = model.getFeatures();
		StringJoiner joiner = new StringJoiner(", ");
		for (final IFeature feature : features) {
			//System.out.println(feature.getStructure().getRelevantConstraints());

			if (!feature.getStructure().isMandatory()){
				joiner.add(feature.toString());
				//System.out.println(feature);
			}
		}System.out.println(joiner.toString());
	}

	/////////////prompt for type of features to begin configuration 
	public void Type(){

		System.out.println("text response Type: \n inputs {\n \""+"Enter (mandatory or optional) to begin\"\n}\n");

	}


	//Feature analysis

	//Query response for number of features

	public void QueryNoOfFeatResponse(){

		IFeatureModel model = fmr.get();

		System.out.println("text response QueryNoOfFeatResponse: \n inputs {\n \""+"There are " + model.getNumberOfFeatures() + " features in the feature model\"\n}\n");

	}
	//Core features response
	public void QueryCoreFeatResponse(){

		IFeatureModel model = fmr.get();
		//StringJoiner joiner = new StringJoiner(", ");

		FeatureModelAnalyzer anl = new FeatureModelAnalyzer(model);		// We create an analyzer for the feature model
		//joiner.add(anl.getCoreFeatures(null).toString());
		//System.out.println("text response QueryCoreFeatResponse: \n inputs {\n \""+"The following features are automatically selected: " + joiner.toString() + "\"\n}\n");
		System.out.println("text response QueryCoreFeatResponse: \n inputs {\n \""+"The following features are automatically selected: " + anl.getCoreFeatures(null).toString().substring(1, anl.getCoreFeatures(null).toString().length() - 1) + "\"\n}\n");


	}

	//possible configuration response
	public void QueryConfigurationResponse(){

		IFeatureModel model = fmr.get();
		FeatureModelFormula fmf = new FeatureModelFormula(model);		// We obtain the corresponding logic formulae from the model
		ConfigurationFactoryManager.getInstance().addExtension(DefaultConfigurationFactory.getInstance());
		Configuration cfg = new Configuration(fmf);						// We create an empty configuration


		ConfigurationAnalyzer cfga = new ConfigurationAnalyzer(fmf, cfg);		// We create a configuration analyser

		try {
			System.out.println("text response QueryConfigurationResponse: \n inputs {\n \""+"There are " + cfga.number() + " possible configurations.\n The possible solutions are: " + cfga.getSolutions(1000).toString().substring(1, cfga.getSolutions(1000).toString().length() - 1) + "\"\n}\n");

		} catch (TimeoutException e) {
			e.printStackTrace();
			System.err.println("Time out!");
		}	

	}
	// view optional  features response
	public void QueryOptFeatResponse(){
		IFeatureModel model = fmr.get();
		final Iterable<IFeature> features = model.getFeatures();
		StringJoiner joiner = new StringJoiner(", ");
		for (final IFeature feature : features) {	
			if (!feature.getStructure().isMandatory()){
				joiner.add(feature.toString());

			}
		}System.out.println("text response QueryOptFeatResponse: \n inputs {\n \""+"You can select any of these Optional Features: " + joiner.toString() + "\"\n}\n");
	}

	// view Core features requiring subfeatures selection
	//	public void CoreFeatSelectResponse(){
	//		IFeatureModel model = fmr.get();
	//		final Iterable<IFeature> features = model.getFeatures();
	//		StringJoiner joiner = new StringJoiner(", ");
	//		for (final IFeature feature : features) {	
	//			if (feature.getStructure().isMandatory()){
	//				joiner.add(feature.toString());
	//
	//			}
	//		}System.out.println("text response CoreFeatSelectResponse: \n inputs {\n \""+"You have to configure the Feature(s): " + joiner.toString() + "\"\n}\n");
	//	}
	//


	// view Core features requiring subfeatures selection
	public void CoreFeatSelectResponse(){

		IFeatureModel model = fmr.get();
		System.out.println("text response CoreFeatSelectResponse: \n inputs {\n \""+"You have to configure the Feature(s): \n");

		final Iterable<IFeature> features = model.getFeatures();
		for (final IFeature feature : features) {
			//StringJoiner joiner = new StringJoiner(", ");	
			if (feature.getStructure().isMandatorySet()&&feature.getStructure().hasChildren() ){

				if (feature.getStructure().isAnd()&&!feature.getStructure().isRoot()) {
					System.out.println("\t"+feature);

					//					for (final IFeatureStructure child : feature.getStructure().getChildren()) {
					//						if (child.isMandatory()) {
					//							final IFeature childFeature = child.getFeature();
					//							joiner.add("=> chatbot "+childFeature.toString()+ "Type");
					//						}
					//					}
				}else if (feature.getStructure().isOr()) {
					System.out.println("\t"+feature);

					//					for (final IFeatureStructure child : feature.getStructure().getChildren()) {
					//						if (child.isMandatory()) {
					//							final IFeature childFeature = child.getFeature();
					//							joiner.add(childFeature.toString());
					//						}
					//					}
				}else if (feature.getStructure().isAlternative()) {

					System.out.println("\t"+feature);

					//					for (final IFeatureStructure child : feature.getStructure().getChildren()) {
					//						if (child.isMandatory()) {
					//							final IFeature childFeature = child.getFeature();
					//							joiner.add("=> chatbot "+childFeature.toString()+ "Type");
					//
					//						}
					//					}

				}
			}
		}System.out.println("\"}\n");
	}

	// view Optional features 
	public void OptSelectResponse(){
		IFeatureModel model = fmr.get();
		final Iterable<IFeature> features = model.getFeatures();
		StringJoiner joiner = new StringJoiner(", ");
		for (final IFeature feature : features) {	
			if (!feature.getStructure().isMandatory()){
				joiner.add(feature.toString());

			}
		}System.out.println("text response OptSelectResponse: \n inputs {\n \""+"Please enter name to select any of these Optional Features: " + joiner.toString() + "\"\n}\n");
	}
	//**************/actions********************//



	public void AltResponse() {
		//				FMReader fmr = new FMReader("p1.xml");
		IFeatureModel model = fmr.get();

		Intents intents = new Intents();

		//int or1 = 0;
		for (final IFeature feat : model.getFeatures()) {
			if (feat.getStructure().isAlternative() && (!feat.getStructure().isRoot())){
				//or1++;

				//added
				List<String> inputs = new ArrayList<String>();

				// Add training phrases or feature options
				inputs.add("\n\t\"I want to know the type of " +feat+" that is available\"");
				inputs.add("\n\t\""+feat+"\"");
				inputs.add("\n\t\"See available " +feat+"\"");
				inputs.add("\n\t\"what " +feat+" type is available\"");

				intents.setInputs(inputs);

				List<String> inputsYes = new ArrayList<String>();
				// Add training phrases for or yes confirmation
				inputsYes.add("\n\t\"yes, I want " +feat+"\"");
				inputsYes.add("\n\t\""+feat+"\"");
				inputsYes.add("\n\t\"yes\"");
				inputsYes.add("\n\t\"yes, what " + feat + " is available\"" );
				inputsYes.add("\n\t\"yes I do\"");

				intents.setInputs(inputsYes);

				List<String> inputsNo = new ArrayList<String>();
				// Add training phrases for or no selection
				inputsNo.add("\n\t\"Thanks, I do not want " +feat+"\"");
				inputsNo.add("\n\t\"Thanks, but no\"");
				inputsNo.add("\n\t\"no\"");
				inputsNo.add("\n\t\"nah,I´m good\"");

				intents.setInputs(inputsNo);

				//						Add	Parameters

				ParametersAlt parameters = new ParametersAlt(feat, feat, "required", "prompts");  
				List<String> paramss = new ArrayList<String>(); 
				String entityName = feat.toString().toLowerCase();
				paramss.add("parameters: \n"+ feat+"_type: "+ "entity " +entityName  +", " + "required" +", "+ "prompts"+" [\"What type of " +feat+"?\"];");       

				parameters.setParamss(paramss);

				if (feat.getStructure().hasChildren()) {
					// Feature select phrases
					ArrayList<String> selectfeature= new ArrayList<String>();

					for(IFeature child: FeatureUtils.convertToFeatureList(feat.getStructure().getChildren())) {
						selectfeature.add("\n\t(\""+child+"\")["+feat+"_type]");
						selectfeature.add("\n\t\"I want\" "+"(\""+child+"\")["+feat+"_type]");
						selectfeature.add("\n\t\"I´ll go with\" "+"(\""+child+"\")["+feat+"_type]");
						selectfeature.add("\n\t\"Give me\" "+"(\""+child+"\")["+feat+"_type]");

					}

					String result = "\n";
					if (!feat.getStructure().isMandatory()) {
						result += "Select_" +feat+"_yes: \n ";
						result += "inputs {"+inputsYes.toString().substring(1, inputsYes.toString().length() - 1)+" \n} " + "\n";
						result += "Select_" +feat+"_no: \n ";
						result += "inputs {"+inputsNo.toString().substring(1, inputsNo.toString().length() - 1)+" \n} " + "\n";

					}

					result += feat+": \n inputs {"+inputs.toString().substring(1, inputs.toString().length() - 1)+" \n} " + "\n";

					result += "Select_" +feat+": \n ";
					result += "inputs {\n"+selectfeature.toString().substring(1, selectfeature.toString().length() - 1)+" \n} "+" \n ";
					result += "\n"+ paramss.toString().substring(1, paramss.toString().length() - 1);

					System.out.println(result);
				}
			}

		}
	}


	//*********************************************flows Definition**********************************************//

	//			public void UserGreeting() {
	//				BotDef4 bDef = new BotDef4();
	//
	//				//greeting flow
	//				ArrayList<String> usergreeting= new ArrayList<String>();
	//				usergreeting.add("- user Greeting => chatbot GreetingResponse{ \n"
	//						+ "=> user ConfigureIntent => chatbot ConfigureResponse, QueryCoreFeatResponse{\n" 
	//						
	//						
	//						+ "=> user NoConfigureIntent => chatbot NoConfigureIntentResponse;\n"
	//						+ "\n};");
	//
	//				System.out.println(usergreeting.toString().substring(1, usergreeting.toString().length() - 1)+" \n " );
	//
	//			} 

	public void UserGreeting() {

		//greeting flow
		System.out.println("- user Greeting => chatbot GreetingResponse{ \n => user ConfigureIntent => chatbot ConfigureResponse, QueryCoreFeatResponse,Type{\n" 
				);
		UserMandatory();
		FlowMand();
		System.out.println("\n};");

		UserOptional();
		FlowOpt();
		FlowTermOpt();
		System.out.println("\n};");

		System.out.println("\n};");
		System.out.println("=> user NoConfigureIntent => chatbot NoConfigureIntentResponse;\n"
				+ "\n};");

	} 

	public void UserHelp() {
		// help flow
		ArrayList<String> userhelp= new ArrayList<String>();
		userhelp.add("- user Help => chatbot HelpResponse{ \n"
				+ "=> user Help_yes => chatbot ConfigureResponse;\n"
				+ "=> user Help_no => chatbot Help_noResponse;\n"
				+ "\n};");

		System.out.println(userhelp.toString().substring(1, userhelp.toString().length() - 1)+" \n " );

	}
	//number of features
	public void UserQueryNoFeat() {
		System.out.println("- user \"QueryFeatureNoIntent\" => chatbot QueryNoOfFeatResponse;\n");
	}
	//optional features
	public void UserQueryOptFeat() {
		System.out.println("- user \"QueryOptionalIntent\" => chatbot QueryOptFeatResponse;\n");
	}
	//core features
	public void UserQueryCoreFeat() {
		System.out.println("- user QueryCoreIntent => chatbot QueryCoreFeatResponse;\n");
	}
	//configuration
	public void UserQueryConfiguration() {
		System.out.println("- user QueryConfigurationIntent => chatbot QueryConfigurationResponse;\n");
	}

	//optional features selection
	public void UserOptional() {
		System.out.println("\t=>  user OptionalIntent => chatbot OptSelectResponse\n{");
	}//optional features selection
	public void UserMandatory() {
		System.out.println("\t=>  user MandatoryIntent => chatbot CoreFeatSelectResponse\n{");
	}


	//mandatory features conversation flow
	public void FlowMand() { 
		IFeatureModel model = fmr.get();
		final Iterable<IFeature> features = model.getFeatures();
		for (final IFeature feature : features) {
			StringJoiner joiner = new StringJoiner(", ");	
			if (feature.getStructure().isMandatorySet()&&feature.getStructure().hasChildren() ){

				if (feature.getStructure().isAnd()&&!feature.getStructure().isRoot()) {
					//							
					System.out.println("\t=> user " +feature+"  => chatbot "+feature+"Type{ \n"
							+ "\t=> user \"Select_"+feature+"\" => chatbot "+feature+"Response;" 

				            		  + "\n\t};");

					for (final IFeatureStructure child : feature.getStructure().getChildren()) {
						if (child.isMandatory()) {
							final IFeature childFeature = child.getFeature();
							//System.out.println(childFeature + " -> "+ feature);
							joiner.add("=> chatbot "+childFeature.toString()+ "Type");
						}
					}

				}else if (feature.getStructure().isOr()) {
					//							
					System.out.println("\t=> user " +feature+"  => chatbot "+feature+"Type{ \n"
							+ "\t=> user \"Select_"+feature+"\" => chatbot "+feature+"Response;" 

				            		  + "\n\t};");

					for (final IFeatureStructure child : feature.getStructure().getChildren()) {
						if (child.isMandatory()) {
							final IFeature childFeature = child.getFeature();
							//System.out.println(childFeature + " ->" + feature);
							joiner.add(childFeature.toString());
						}
					}
					//System.out.println(joiner.toString());
				}else if (feature.getStructure().isAlternative()) {
					//						
					System.out.println("\t=> user " +feature+"  => chatbot "+feature+"Type{ \n"
							+ "\t=> user \"Select_"+feature+"\" => chatbot "+feature+"Response;" 

				            		  + "\n\t};");

					for (final IFeatureStructure child : feature.getStructure().getChildren()) {
						if (child.isMandatory()) {
							final IFeature childFeature = child.getFeature();
							//System.out.println(childFeature + " -> " + feature);
							//joiner.add(childFeature.toString());
							joiner.add("=> chatbot "+childFeature.toString()+ "Type");

						}
					}
					//System.out.println(joiner.toString());
				}


			}		


		}	


	}


	//optional features flow
	public void FlowOpt() {
		IFeatureModel model = fmr.get();

		final Iterable<IFeature> features = model.getFeatures();
		for (final IFeature feature : features) {
			StringJoiner joiner = new StringJoiner(", ");	
			if (!feature.getStructure().isMandatorySet()&&feature.getStructure().hasChildren() ){

				if (feature.getStructure().isAnd()&&!feature.getStructure().isRoot()) {
					//							
					System.out.println("\t=> user " +feature+"  => chatbot "+feature+"Type{ \n"
							+ "\t=> user \"Select_"+feature+"\" => chatbot "+feature+"Response;" 

				            		  + "\n\t};");

					for (final IFeatureStructure child : feature.getStructure().getChildren()) {
						if (child.isMandatory()) {
							final IFeature childFeature = child.getFeature();
							//System.out.println(childFeature + " -> "+ feature);
							joiner.add("=> chatbot "+childFeature.toString()+ "Type");
						}
					}
				}else if (feature.getStructure().isOr()) {
					//							
					System.out.println("\t=> user " +feature+"  => chatbot "+feature+"Type{ \n"
							+ "\t=> user \"Select_"+feature+"\" => chatbot "+feature+"Response;" 

				            		  + "\n\t};");

					for (final IFeatureStructure child : feature.getStructure().getChildren()) {
						if (child.isMandatory()) {
							final IFeature childFeature = child.getFeature();
							//System.out.println(childFeature + " ->" + feature);
							joiner.add(childFeature.toString());
						}
					}
				}else if (feature.getStructure().isAlternative()) {
					//						
					System.out.println("\t=> user " +feature+"  => chatbot "+feature+"Type{ \n"
							+ "\t=> user \"Select_"+feature+"\" => chatbot "+feature+"Response;" 

				            		  + "\n\t};");

					for (final IFeatureStructure child : feature.getStructure().getChildren()) {
						if (child.isMandatory()) {
							final IFeature childFeature = child.getFeature();
							joiner.add("=> chatbot "+childFeature.toString()+ "Type");

						}
					}
				}



			}		


		}	
	}

	//first level terminal optional features 
	public void FlowTermOpt() {

		IFeatureModel model = fmr.get();

		for (final IFeature feature : model.getFeatures()) {

			if (feature.getStructure().isRoot()&&(feature.getStructure().hasChildren())){

				for(IFeature child: FeatureUtils.convertToFeatureList(feature.getStructure().getChildren())) {
					if (!child.getStructure().isAlternative() && !child.getStructure().isOr()) {
						if(!child.getStructure().hasChildren()) {	
							if (!child.getStructure().isMandatory()) {

							}

							System.out.println("=> user \"Select_" +child+"\"  => chatbot "+child+"Response;");
							//System.out.println(child);

						}
					}
				}
			}

		}

	}




	//**************/Synonyms with wordnet********************//


	public static String printSynonymn() {
		String listSynonymns;
		System.setProperty("wordnet.database.dir", "/Users/usuario/Documents/eclipse4/DemoSPLBots1/src/dict");
		WordNetDatabase wordNetDatabase = WordNetDatabase.getFileInstance();
		ArrayList<String> synonyms=new ArrayList<String>();
		String wordForm = name;
		Synset[] synsets1 = wordNetDatabase.getSynsets(wordForm);
		if (synsets1.length > 0) {
			for (int i = 0; i < synsets1.length; i++) {
				String[] wordForms = synsets1[i].getWordForms();
				for (int j = 0; j < wordForms.length; j++) {
					if(!synonyms.contains(wordForms[j])){
						synonyms.add(wordForms[j]); 
					}

				}

			}
			//System.out.println(synonyms);
			listSynonymns = Arrays.toString(synonyms.toArray()).replace("[", "").replace("]", "").replace(",", "\", \"");
			//System.out.println(listSynonymns);

		}else {
			listSynonymns= name;

		}

		return listSynonymns;



	}
}
