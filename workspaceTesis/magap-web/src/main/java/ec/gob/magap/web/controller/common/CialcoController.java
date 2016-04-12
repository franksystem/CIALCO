package ec.gob.magap.web.controller.common;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.AjaxBehaviorEvent;

import ec.gob.magap.common.util.Parameter;
import ec.gob.magap.dto.CantonDTO;
import ec.gob.magap.dto.CatalogoDTO;
import ec.gob.magap.dto.CialcoDTO;
import ec.gob.magap.dto.ParroquiaDTO;
import ec.gob.magap.dto.ProvinciaDTO;
import ec.gob.magap.factory.MagapFactory;
import ec.gob.magap.vo.DiaVO;
import ec.gob.magap.web.util.DateUtil;

@ManagedBean(name = "cialcoController")
@ViewScoped
public class CialcoController {

	private String nombreCialco = "";
	private CialcoDTO cialcoDTO;
	private List<ProvinciaDTO> provinciaDTOs;
	private List<CantonDTO> cantonDTOs;
	private List<ParroquiaDTO> parroquiaDTOs;
	private List<CatalogoDTO> frecuenciaDTOs;
	private List<DiaVO> diaVOs;

	@PostConstruct
	public void init() {
		if (this.cialcoDTO == null) {
			this.cialcoDTO = new CialcoDTO();
		}
		findProvincias();
		findFrecuencias();
		findDays();
	}

	public void newCialco() {
		this.cialcoDTO = new CialcoDTO();
	}

	private void findProvincias() {
		if (this.provinciaDTOs == null || this.provinciaDTOs.isEmpty()) {
			this.provinciaDTOs = MagapFactory.getInstance().getIMagapService()
					.findProvincias();
		}
	}

	public void findCantones(AjaxBehaviorEvent event) {
		this.cantonDTOs = MagapFactory.getInstance().getIMagapService()
				.findCantones(this.cialcoDTO.getIdProvincia());
	}

	public void findParroquias(AjaxBehaviorEvent event) {
		this.parroquiaDTOs = MagapFactory.getInstance().getIMagapService()
				.findParroquias(this.cialcoDTO.getIdCanton());
	}

	private void findFrecuencias() {
		if (this.frecuenciaDTOs == null || this.frecuenciaDTOs.isEmpty()) {
			this.frecuenciaDTOs = MagapFactory
					.getInstance()
					.getIMagapService()
					.findCatalogByType(Parameter.FRECUENCIA,
							Parameter.ESTADO_ACTIVO);
		}
	}

	private void findDays() {
		if (this.diaVOs == null || this.diaVOs.isEmpty()) {
			this.diaVOs = DateUtil.findDias();
		}
	}

	public CialcoDTO getCialcoDTO() {
		return cialcoDTO;
	}

	public void setCialcoDTO(CialcoDTO cialcoDTO) {
		this.cialcoDTO = cialcoDTO;
	}

	public List<ProvinciaDTO> getProvinciaDTOs() {
		return provinciaDTOs;
	}

	public void setProvinciaDTOs(List<ProvinciaDTO> provinciaDTOs) {
		this.provinciaDTOs = provinciaDTOs;
	}

	public List<CantonDTO> getCantonDTOs() {
		return cantonDTOs;
	}

	public void setCantonDTOs(List<CantonDTO> cantonDTOs) {
		this.cantonDTOs = cantonDTOs;
	}

	public List<ParroquiaDTO> getParroquiaDTOs() {
		return parroquiaDTOs;
	}

	public void setParroquiaDTOs(List<ParroquiaDTO> parroquiaDTOs) {
		this.parroquiaDTOs = parroquiaDTOs;
	}

	public List<CatalogoDTO> getFrecuenciaDTOs() {
		return frecuenciaDTOs;
	}

	public void setFrecuenciaDTOs(List<CatalogoDTO> frecuenciaDTOs) {
		this.frecuenciaDTOs = frecuenciaDTOs;
	}

	public List<DiaVO> getDiaVOs() {
		return diaVOs;
	}

	public void setDiaVOs(List<DiaVO> diaVOs) {
		this.diaVOs = diaVOs;
	}

	public String getNombreCialco() {
		return nombreCialco;
	}

	public void setNombreCialco(String nombreCialco) {
		this.nombreCialco = nombreCialco;
	}

}
