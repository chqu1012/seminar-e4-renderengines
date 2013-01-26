/*******************************************************************************
 * Copyright (c) 2012 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl - initial API and implementation
 *******************************************************************************/
package de.dc.hska.seminararbeit.schindl.handlers;

import java.lang.reflect.InvocationTargetException;
import java.util.UUID;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.services.events.IEventBroker;

@SuppressWarnings("restriction")
public class OpenHandler {
	public static final String OPEN_EVENT = "media/open";
	@Execute
	public void execute(IEventBroker broker)
			throws InvocationTargetException, InterruptedException {
		broker.send(OPEN_EVENT, UUID.randomUUID().toString());
	}
}
