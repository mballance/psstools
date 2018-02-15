/*
 * generated by Xtext 2.12.0
 */
package net.sf.psstools.lang.ui;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.ui.plugin.AbstractUIPlugin;

import net.sf.psstools.lang.ui.labeling.PSSLabelProvider;

/**
 * Use this class to register components to be used within the Eclipse IDE.
 */
public class PSSUiModule extends AbstractPSSUiModule {

	public PSSUiModule(AbstractUIPlugin plugin) {
		super(plugin);
	}

	@Override
	public Class<? extends ILabelProvider> bindILabelProvider() {
		return PSSLabelProvider.class;
	}
	
	
}
