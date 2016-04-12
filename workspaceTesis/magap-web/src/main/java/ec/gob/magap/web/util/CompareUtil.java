package ec.gob.magap.web.util;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import ec.gob.magap.common.util.MagapLogger;
import ec.gob.magap.dto.CatalogoDTO;

public final class CompareUtil {

	private CompareUtil() {
	}

	public static String findNameCatalogDTO(List<CatalogoDTO> catalogoDTOs,
			Integer idCatalogo) {
		CatalogoDTO catalogoDTO = findCatalogDTO(catalogoDTOs, idCatalogo);
		if (catalogoDTO != null
				&& StringUtils.isNotBlank(catalogoDTO.getElementoCatalogo())) {
			return catalogoDTO.getElementoCatalogo();
		}
		return "";
	}

	public static CatalogoDTO findCatalogDTO(List<CatalogoDTO> catalogoDTOs,
			Integer idCatalogo) {
		if (catalogoDTOs == null || catalogoDTOs.isEmpty()) {
			MagapLogger.log.error("error findCatalogDTOs is empty");
			return null;
		}
		CatalogoDTO key = new CatalogoDTO();
		key.setIdCatalogo(idCatalogo);
		Collections.sort(catalogoDTOs, CompareUtil.compareCatalogDTO());
		Integer index = Collections.binarySearch(catalogoDTOs, key,
				CompareUtil.compareCatalogDTO());
		if (index >= 0) {
			CatalogoDTO catalogoDTO = catalogoDTOs.get(index);
			if (catalogoDTO != null) {
				return catalogoDTO;
			}
		}
		return null;
	}

	private static Comparator<CatalogoDTO> compareCatalogDTO() {
		return new Comparator<CatalogoDTO>() {
			public int compare(CatalogoDTO c1, CatalogoDTO c2) {
				return c1.getIdCatalogo().compareTo(c2.getIdCatalogo());
			}
		};
	}

}
