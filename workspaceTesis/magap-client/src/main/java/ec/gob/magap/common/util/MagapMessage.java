package ec.gob.magap.common.util;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class MagapMessage {
	private static MagapMessage _instance;
	private ResourceBundle RESOURCE_BUNDLE;
	private String BUNDLE_NAME = "magap";

	public MagapMessage() {
		Locale localeEs = new Locale("es", "ES");
		RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME, localeEs);
	}

	public static synchronized MagapMessage getInstance() {
		if (_instance == null) {
			_instance = new MagapMessage();
		}
		return _instance;
	}

	public String getMessageForKey(String key, Object... placeHolders) {
		try {
			String value = RESOURCE_BUNDLE.getString(key);
			if (placeHolders.length > 0) {
				return MessageFormat.format(value, placeHolders);
			}
			return value;

		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}

	public int getInteger(String key) {
		try {
			return Integer.valueOf(RESOURCE_BUNDLE.getString(key));
		} catch (MissingResourceException e) {
			return -1;
		}
	}

	public long getLong(String key) {
		try {
			return Long.valueOf(RESOURCE_BUNDLE.getString(key));
		} catch (MissingResourceException e) {
			return -1;
		}
	}

	public String getString(String key) {
		try {
			return RESOURCE_BUNDLE.getString(key);
		} catch (MissingResourceException e) {
			return "";
		}
	}
}