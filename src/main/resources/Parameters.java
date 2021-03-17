package main.resources;


import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;

import de.ovgu.featureide.fm.core.base.IFeature;
import de.ovgu.featureide.fm.core.base.impl.Feature;

public class Parameters {
	

    IFeature feat3;
    IFeature feat4;
	String isList;
	String required;
	String prompts;

	List<String> paramss;
	
	public List<String> getParamss() {
        return paramss;
    }

    public void setParamss(List<String> paramss) {
        this.paramss = paramss;
    }
    
    
	List<Parameters> params;
	
	public List<Parameters> getParams() {
        return params;
    }

    public void setParams(List<Parameters> params) {
        this.params = params;
    }

	public Parameters(IFeature feat3, IFeature feat4, String isList, String required, String prompts) {
		// TODO Auto-generated constructor stub
		this.feat3 = feat3;
		this.feat4 = feat4;
		 this.isList = isList;
		 this.required = required;
		 this.prompts = prompts;
	}

	public String getIsList ()
    {
        return isList;
    }

	public void setIsList (String isList)
    {
        this.isList = isList;
    }
	
    public String getRequired ()
    {
        return required;
    }

    public void setRequired (String required)
    {
        this.required = required;
    }

    public String getPrompts ()
    {
        return prompts;
    }

    public void setPrompts (String prompts)
    {
        this.prompts = prompts;
    }

    public IFeature getIFeature3() {
		return feat3;
	}

	public void setFeature3(IFeature feat3) {
		this.feat3 = feat3;
	}
	
	public IFeature getIFeature4() {
		return feat4;
	}

	public void setFeature4(IFeature feat4) {
		this.feat4 = feat4;
	}
	
}
