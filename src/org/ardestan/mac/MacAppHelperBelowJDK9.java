package org.ardestan.mac;

import java.awt.Image;


import com.apple.eawt.Application;
import com.apple.eawt.ApplicationAdapter;
import com.apple.eawt.ApplicationEvent;

/**
 * @author hiroki
 *
 */
public class MacAppHelperBelowJDK9
{
	/**
	 * @param listener
	 * @param dockIconImage
	 */
	/**
	 * @param listener
	 */
	public static void addMacAppHelperListener(MacAppHelperListener listener)
	{
		Application app = Application.getApplication();
			
		app.setEnabledAboutMenu(true);
		app.setEnabledPreferencesMenu(true);
		
		app.addApplicationListener(new ApplicationAdapter() {
			public void handleAbout(ApplicationEvent arg0) {
				listener.handleAbout();
				arg0.setHandled(true);
			}
			
			public void handleQuit(ApplicationEvent arg0) {
				listener.handleQuit();
//				arg0.setHandled(true);
				arg0.setHandled(false);
			}
			
			public void handlePreferences(ApplicationEvent arg0) {
				listener.handlePreferences();
				arg0.setHandled(true);
			}
		});
		return;
	}
	
	/**
	 * @param dockIconImage
	 */
	public static void setMacDockIconImage(Image dockIconImage) 
	{
		Application app = Application.getApplication();
		app.setDockIconImage(dockIconImage);
		return;
	}
}
