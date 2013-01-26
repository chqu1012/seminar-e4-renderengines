/*******************************************************************************
 * Copyright (c) 2010 BestSolution.at, Siemens AG and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl <tom.schindl@bestsolution.at> - initial API and implementation
 *     Kai Tödter - Adoption to contacts demo
 ******************************************************************************/
package de.dc.hska.seminararbeit;

import javax.inject.Inject;
import javax.inject.Named;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.commands.MCommand;
import org.eclipse.e4.ui.model.application.commands.MParameter;
import org.eclipse.e4.ui.model.application.ui.menu.MHandledMenuItem;
import org.eclipse.e4.ui.model.application.ui.menu.MMenu;
import org.eclipse.e4.ui.model.application.ui.menu.MMenuFactory;
import org.eclipse.emf.ecore.EObject;

public class MenuThemeProcessor extends AbstractThemeProcessor {

	private static final String BUNDLE_ID = "platform:/plugin/de.dc.hska.seminararbeit"; //$NON-NLS-1$

	@Inject
	@Named("menu:org.eclipse.ui.main.menu")
	private MMenu menu;
	private MMenu themesMenu;

	@Override
	protected boolean check() {
		return menu != null;
	}

	@Override
	protected void preprocess() {
		themesMenu = MMenuFactory.INSTANCE.createMenu();
		themesMenu.setLabel("%switchThemeMenu"); //$NON-NLS-1$
		themesMenu.setContributorURI(BUNDLE_ID);
	}

	@Override
	protected void processTheme(String name, MCommand switchCommand, MParameter themeId, String iconURI) {
		MHandledMenuItem menuItem = MMenuFactory.INSTANCE.createHandledMenuItem();
		menuItem.setLabel(name);
		menuItem.setCommand(switchCommand);
		menuItem.getParameters().add(themeId);
		menuItem.setContributorURI(BUNDLE_ID);
		if (iconURI != null) {
			menuItem.setIconURI(iconURI);
		}
		themesMenu.getChildren().add(menuItem);
	}

	@Override
	protected void postprocess() {
		menu.getChildren().add(themesMenu);
	}

	@Override
	protected MApplication getApplication() {
		return (MApplication) (((EObject) menu).eContainer()).eContainer();
	}
}
