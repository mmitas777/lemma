/*
 * generated by Xtext 2.25.0
 */
package de.fhdo.lemma.data.ui.tests;

import com.google.inject.Injector;
import de.fhdo.lemma.data.datadsl.ui.internal.DatadslActivator;
import org.eclipse.xtext.testing.IInjectorProvider;

public class DataDslUiInjectorProvider implements IInjectorProvider {

	@Override
	public Injector getInjector() {
		return DatadslActivator.getInstance().getInjector("de.fhdo.lemma.data.DataDsl");
	}

}
