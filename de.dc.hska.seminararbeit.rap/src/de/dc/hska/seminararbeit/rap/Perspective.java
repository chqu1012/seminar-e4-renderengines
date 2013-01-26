package de.dc.hska.seminararbeit.rap;

import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

/**
 * Configures the perspective layout. This class is contributed through the
 * plugin.xml.
 */
public class Perspective implements IPerspectiveFactory {

	public void createInitialLayout(IPageLayout layout) {
		String editorArea = layout.getEditorArea();
		layout.setEditorAreaVisible(false);
		layout.setFixed(true);

		layout.addView(StudentView.ID, IPageLayout.LEFT, 1.0f,
				editorArea);
		layout.addView(View.ID, IPageLayout.RIGHT, 1.0f,
				editorArea);
	}
}
