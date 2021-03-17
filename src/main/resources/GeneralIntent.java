package main.resources;


import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;

import de.ovgu.featureide.fm.core.base.IFeature;
import de.ovgu.featureide.fm.core.base.impl.Feature;

public class GeneralIntent {
	

	
	ArrayList<String> generalinputss;
	
	public ArrayList<String> getGeneralinputss() {
        return generalinputss;
    }

    public void setGeneralinputss(ArrayList<String> generalinputss) {
        this.generalinputss = generalinputss;
    }

    //
    ArrayList<GeneralIntent> generalinputs;
	
	public ArrayList<GeneralIntent> getGeneralinputs() {
        return generalinputs;
    }

    public void setGeneralinputs(ArrayList<GeneralIntent> generalinputs) {
        this.generalinputs = generalinputs;
    }

	public GeneralIntent(ArrayList<String> generalinputs) {
		// TODO Auto-generated constructor stub
		
	}

	
}
