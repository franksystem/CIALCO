package ec.gob.magap.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;

import ec.gob.magap.common.util.Parameter;
import ec.gob.magap.dto.CantonDTO;
import ec.gob.magap.dto.CatalogoDTO;
import ec.gob.magap.dto.CialcoDTO;
import ec.gob.magap.dto.ParroquiaDTO;
import ec.gob.magap.dto.PersonaDTO;
import ec.gob.magap.dto.ProveedorDTO;
import ec.gob.magap.dto.ProvinciaDTO;
import ec.gob.magap.factory.MagapFactory;
import ec.gob.magap.vo.DiaVO;
import ec.gob.magap.web.controller.common.CommonController;
import ec.gob.magap.web.controller.common.ConsumerController;
import ec.gob.magap.web.util.DateUtil;

@ManagedBean(name = "storeController")
@ViewScoped
public class StoreController extends CommonController {

	@ManagedProperty(value = "#{consumerController}")
	private ConsumerController consumerController;

	private CialcoDTO cialcoDTO;
	private ProveedorDTO proveedorDTO;
	private PersonaDTO personaDTO;

	private List<ProvinciaDTO> provinciaDTOs;
	private List<CantonDTO> cantonDTOs;
	private List<ParroquiaDTO> parroquiaDTOs;
	private List<CatalogoDTO> frecuenciaDTOs;
	private List<CatalogoDTO> rubroDTOs;

	private List<DiaVO> diaVOs;

	private List<String> idRubros;
	private List<ProveedorDTO> proveedorDTOs;

	@PostConstruct
	public void init() {

		this.setCialcoDTO(new CialcoDTO());
		findProvicncias();
		findFrecuencias();

		this.diaVOs = DateUtil.findDias();

		this.rubroDTOs = MagapFactory.getInstance().getIMagapService()
				.findCatalogByType(Parameter.RUBROS, Parameter.ESTADO_ACTIVO);

		initProveedor();
		initPersona();
	}

	public void findProvicncias() {
		this.provinciaDTOs = MagapFactory.getInstance().getIMagapService()
				.findProvincias();
	}

	public void findFrecuencias() {
		this.frecuenciaDTOs = MagapFactory
				.getInstance()
				.getIMagapService()
				.findCatalogByType(Parameter.FRECUENCIA,
						Parameter.ESTADO_ACTIVO);
	}

	public void findCantones(AjaxBehaviorEvent event) {
		this.cantonDTOs = MagapFactory.getInstance().getIMagapService()
				.findCantones(this.cialcoDTO.getIdProvincia());
	}

	public void findParroquias(AjaxBehaviorEvent event) {
		this.parroquiaDTOs = MagapFactory.getInstance().getIMagapService()
				.findParroquias(this.cialcoDTO.getIdCanton());
	}

	public void guardarCialco() {

		String ids = StringUtils.join(this.cialcoDTO.getIdDias(), ",");
		this.cialcoDTO.setIdCatalogoDias(ids);
		this.cialcoDTO.setProveedorDTOs(this.proveedorDTOs);
		this.cialcoDTO.setPersonaDTOs(this.consumerController.getPersonaDTOs());
		this.cialcoDTO.setTipo(Parameter.ID_CIALCO_TIENDA);
		MagapFactory.getInstance().getIMagapService()
				.transSaveCialco(this.cialcoDTO);

		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "",
						"Cialco feria guardado correctamente"));

		setCialcoDTO(new CialcoDTO());
		setIdRubros(new ArrayList<String>());
		setProveedorDTOs(new ArrayList<ProveedorDTO>());
	}

	public void newProveedor() {
		ProveedorDTO proveedorDTO = new ProveedorDTO();
		proveedorDTO.setIdRubrosOfrece(new ArrayList<String>());
		setProveedorDTO(new ProveedorDTO());
		if (this.proveedorDTOs == null) {
			setProveedorDTOs(new ArrayList<ProveedorDTO>());
		}
	}

	public void initProveedor() {
		setProveedorDTO(new ProveedorDTO());
	}

	public void initPersona() {
		setPersonaDTO(new PersonaDTO());
		this.consumerController.setPersonaDTOs(new ArrayList<PersonaDTO>());

	}

	public void addProveedor() {

		String ids = StringUtils.join(this.proveedorDTO.getIdRubrosOfrece(),
				",");
		this.proveedorDTO.setIdCatalogoRubros(ids);
		this.proveedorDTO.setIdUsuarioCreacion(this.getSessionUser()
				.getUsuarioDTO().getIdUsuario());
		if (!BooleanUtils.toBoolean(this.proveedorDTO.getSelected())) {
			this.proveedorDTOs.add(this.proveedorDTO);
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "",
							"Proveedor agregado correctamente"));
		} else {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "",
							"Proveedor editado correctamente"));
		}
		this.proveedorDTO.setSelected(Boolean.TRUE);
		ProveedorDTO proveedorDTO = new ProveedorDTO();
		proveedorDTO.setIdRubrosOfrece(new ArrayList<String>());
		setProveedorDTO(new ProveedorDTO());
	}

	public void deleteProveedor(ProveedorDTO proveedorDTO) {
		this.proveedorDTOs.remove(proveedorDTO);

	}

	public void newPersona() {
		setPersonaDTO(new PersonaDTO());
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

	public CialcoDTO getCialcoDTO() {
		return cialcoDTO;
	}

	public void setCialcoDTO(CialcoDTO cialcoDTO) {
		this.cialcoDTO = cialcoDTO;
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

	public List<String> getIdRubros() {
		return idRubros;
	}

	public void setIdRubros(List<String> idRubros) {
		this.idRubros = idRubros;
	}

	public List<CatalogoDTO> getRubroDTOs() {
		return rubroDTOs;
	}

	public void setRubroDTOs(List<CatalogoDTO> rubroDTOs) {
		this.rubroDTOs = rubroDTOs;
	}

	public ProveedorDTO getProveedorDTO() {
		return proveedorDTO;
	}

	public void setProveedorDTO(ProveedorDTO proveedorDTO) {
		this.proveedorDTO = proveedorDTO;
	}

	public List<ProveedorDTO> getProveedorDTOs() {
		return proveedorDTOs;
	}

	public void setProveedorDTOs(List<ProveedorDTO> proveedorDTOs) {
		this.proveedorDTOs = proveedorDTOs;
	}

	public PersonaDTO getPersonaDTO() {
		return personaDTO;
	}

	public void setPersonaDTO(PersonaDTO personaDTO) {
		this.personaDTO = personaDTO;
	}

	public ConsumerController getConsumerController() {
		return consumerController;
	}

	public void setConsumerController(ConsumerController consumerController) {
		this.consumerController = consumerController;
	}

}