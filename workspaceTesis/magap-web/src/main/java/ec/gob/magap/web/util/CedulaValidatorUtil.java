package ec.gob.magap.web.util;

import org.apache.commons.lang3.StringUtils;

public final class CedulaValidatorUtil {

	private static final int num_provincias = 24;

	private CedulaValidatorUtil() {
	}

	public static Boolean validateCedula(String cedula) {
		if (StringUtils.isBlank(cedula)) {
			return Boolean.FALSE;
		}
		if (cedula.length() == 10) {
			char[] caracteres = new char[cedula.length()];
			for (int i = 0; i < cedula.length(); i++) {
				caracteres[i] = (char) cedula.charAt(i);
				if (!Character.isDigit(caracteres[i])) {
					return Boolean.FALSE;
				}
			}
			// verifica que los dos primeros digitos correspondan a un valor
			// entre 1 y NUMERO_DE_PROVINCIAS
			int prov = Integer.parseInt(cedula.substring(0, 2));
			if (!((prov > 0) && (prov <= num_provincias))) {
				return Boolean.FALSE;
			}
			// verifica que el ultimo digito de la cedula sea valido
			int[] d = new int[10];
			// Asignamos el string a un array
			for (int i = 0; i < d.length; i++) {
				d[i] = Integer.parseInt(cedula.charAt(i) + "");
			}
			int imp = 0;
			int par = 0;
			// sumamos los duplos de posicion impar
			for (int i = 0; i < d.length; i += 2) {
				d[i] = ((d[i] * 2) > 9) ? ((d[i] * 2) - 9) : (d[i] * 2);
				imp += d[i];
			}
			// sumamos los digitos de posicion par
			for (int i = 1; i < (d.length - 1); i += 2) {
				par += d[i];
			}
			// Sumamos los dos resultados
			int suma = imp + par;
			// Restamos de la decena superior
			int d10 = Integer.parseInt(String.valueOf(suma + 10)
					.substring(0, 1) + "0")
					- suma;
			// Si es diez el decimo digito es cero
			d10 = (d10 == 10) ? 0 : d10;
			// si el decimo digito calculado es igual al digitado la cedula es
			// correcta
			if (d10 == d[9]) {
				return Boolean.TRUE;
			} else {
				return Boolean.FALSE;
			}

		} else {
			return Boolean.FALSE;
		}
	}

}
