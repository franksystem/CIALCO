package ec.gob.magap.factory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ec.gob.magap.exception.MagapException;
import ec.gob.magap.service.IMagapService;

public class MagapFactory {

	private static final MagapFactory INSTANCE = new MagapFactory();

	private ApplicationContext context;

	private MagapFactory() {
		try {
			context = new ClassPathXmlApplicationContext(MagapFactoryBean
					.getInstance().getMagapSpringContextPaths());
		} catch (Exception e) {
			throw new MagapException("error al crear el contenedor de spring ",
					e);
		}
	}

	public static MagapFactory getInstance() {
		return INSTANCE;
	}

	public static Object getInt(String idBean) {
		return INSTANCE.context.getBean(idBean);
	}

	public IMagapService getIMagapService() throws MagapException {
		try {
			return context.getBean("magapService", IMagapService.class);
		} catch (Exception e) {
			throw new MagapException(e);
		}
	}
}