package reader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.Paths;


import de.ovgu.featureide.fm.core.base.IFeatureModel;
import de.ovgu.featureide.fm.core.base.impl.*;
import de.ovgu.featureide.fm.core.io.IPersistentFormat;
import de.ovgu.featureide.fm.core.io.manager.SimpleFileHandler;

public class FMReader {
	private String featureModelFile;
	private IFeatureModel fm;
	
	public FMReader (String inputFile) {
		this.featureModelFile = inputFile;
	}
	
	public IFeatureModel get() {
		if (this.fm==null) this.createFeatureModel();
		return this.fm;
	}
	
	private void createFeatureModel() {
		IPersistentFormat<IFeatureModel> format = FMFormatManager.getDefaultFormat(); //FMFormatManager.getInstance().getFormatByContent(contents, this.featureModelFile);
				
		DefaultFeatureModelFactory dfmf = DefaultFeatureModelFactory.getInstance();
		FMFactoryManager.getInstance().addExtension(dfmf);

		this.fm = dfmf.create();
		fm.setSourceFile(Paths.get(this.featureModelFile));
		try {
			SimpleFileHandler.load(new FileInputStream(this.featureModelFile), this.fm, format);
		} catch (final FileNotFoundException e) {
			System.err.println(e);
		}
	}
}
