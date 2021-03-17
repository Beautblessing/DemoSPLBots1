package main.resources;


import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;

import de.ovgu.featureide.fm.core.base.IFeature;
import de.ovgu.featureide.fm.core.base.impl.Feature;

public class GreetIntent {
	

	
	ArrayList<String> greetinputss;
	
	public ArrayList<String> getGreetinputss() {
        return greetinputss;
    }

    public void setGreetinputss(ArrayList<String> greetinputss) {
        this.greetinputss = greetinputss;
    }

    //
    ArrayList<GreetIntent> greetinputs;
	
	public ArrayList<GreetIntent> getGreetinputs() {
        return greetinputs;
    }

    public void setGreetinputs(ArrayList<GreetIntent> greetinputs) {
        this.greetinputs = greetinputs;
    }

	public GreetIntent(ArrayList<String> greetinputs) {
		// TODO Auto-generated constructor stub
		
	}

	
}
