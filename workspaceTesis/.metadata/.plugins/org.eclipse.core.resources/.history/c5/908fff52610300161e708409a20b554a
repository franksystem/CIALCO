package ec.gob.magap.factory;

import java.util.ArrayList;
import java.util.List;

public class MagapFactoryBean {

	// path de spring del proyecto
	private String[] magapSpringContextPaths;
	// conjunto de archivos orm q utiliza session factory
	private String[] pathOrm;

	/**
	 * @return the archivosOrm
	 */
	public String[] getArchivosOrm() {
		return pathOrm;
	}

	// instancia singleton de transport
	private final static MagapFactoryBean INSTANCE = new MagapFactoryBean();

	private MagapFactoryBean() {
		List<String> pathOrmList = new ArrayList<String>();
		List<String> magapSpringContextPathList = new ArrayList<String>();
		pathOrmList.add("/META-INF/ormMagap.xml");

		// rutas de archivos de configuracion de spring requeridos por el
		// sistema transport
		magapSpringContextPathList.add(MagapFactoryContexPath.PATH_SESSION_FACTORY);
		magapSpringContextPathList.add(MagapFactoryContexPath.PATH_GESTOR);
		magapSpringContextPathList.add(MagapFactoryContexPath.PATH_TRANSACTION);
		magapSpringContextPathList.add(MagapFactoryContexPath.PATH_SERVICE);
		magapSpringContextPathList.add(MagapFactoryContexPath.PATH_RESOLVER);
		magapSpringContextPathList.add(MagapFactoryContexPath.PATH_DATASOURCE);
		this.pathOrm = pathOrmList.toArray(new String[0]);
		this.magapSpringContextPaths = magapSpringContextPathList.toArray(new String[0]);
	}

	public static MagapFactoryBean getInstance() {
		return INSTANCE;
	}

	public String[] getMagapSpringContextPaths() {
		return magapSpringContextPaths;
	}
}