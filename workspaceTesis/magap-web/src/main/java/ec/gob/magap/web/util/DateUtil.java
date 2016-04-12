package ec.gob.magap.web.util;

import java.util.ArrayList;
import java.util.List;

import ec.gob.magap.vo.DiaVO;

public final class DateUtil {

	private DateUtil() {
	}

	public static List<DiaVO> findDias() {
		List<DiaVO> dias = new ArrayList<>();

		DiaVO lunes = new DiaVO();
		lunes.setId(1);
		lunes.setNombre("Lunes");

		DiaVO martes = new DiaVO();
		martes.setId(2);
		martes.setNombre("Martes");

		DiaVO miercoles = new DiaVO();
		miercoles.setId(3);
		miercoles.setNombre("Miercoles");

		DiaVO jueves = new DiaVO();
		jueves.setId(4);
		jueves.setNombre("Jueves");

		DiaVO viernes = new DiaVO();
		viernes.setId(5);
		viernes.setNombre("Viernes");

		DiaVO sabado = new DiaVO();
		sabado.setId(6);
		sabado.setNombre("Sabado");

		DiaVO domingo = new DiaVO();
		domingo.setId(7);
		domingo.setNombre("Domingo");

		dias.add(lunes);
		dias.add(martes);
		dias.add(miercoles);
		dias.add(jueves);
		dias.add(viernes);
		dias.add(sabado);
		dias.add(domingo);

		return dias;
	}
}
