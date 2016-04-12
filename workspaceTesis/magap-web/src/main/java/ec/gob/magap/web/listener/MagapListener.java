package ec.gob.magap.web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import ec.gob.magap.common.util.MagapLogger;
import ec.gob.magap.exception.MagapException;
import ec.gob.magap.factory.MagapFactory;

public class MagapListener implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void contextInitialized(ServletContextEvent arg0) {
		try {
			MagapFactory.getInstance().getIMagapService();
		} catch (MagapException e) {
			MagapLogger.log.error(
					"Error al iniciar la aplicacion, los factory no funcionan",
					e);
			throw new MagapException(
					"Error al iniciar la aplicacion, los factory no funcionan",
					e);
		}

	}

}
