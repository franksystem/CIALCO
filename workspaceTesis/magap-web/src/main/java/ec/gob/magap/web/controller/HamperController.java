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
import ec.gob.magap.dto.InstitucionApoyoDTO;
import ec.gob.magap.dto.LugarEntregaCanastaDTO;
import ec.gob.magap.dto.OrganizacionDTO;
import ec.gob.magap.dto.ParroquiaDTO;
import ec.gob.magap.dto.PersonaDTO;
import ec.gob.magap.dto.ProvinciaDTO;
import ec.gob.magap.factory.MagapFactory;
import ec.gob.magap.vo.DiaVO;
import ec.gob.magap.web.controller.common.CommonController;
import ec.gob.magap.web.controller.common.ConsumerController;
import ec.gob.magap.web.controller.common.OrgController;
import ec.gob.magap.web.controller.common.SupportController;
import ec.gob.magap.web.util.CompareUtil;
import ec.gob.magap.web.util.DateUtil;

@ManagedBean(name = "hamperController")
@ViewScoped
public class HamperController extends CommonController {

	@ManagedProperty(value = "#{orgController}")
	private OrgController orgController;

	@ManagedProperty(value = "#{consumerController}")
	private ConsumerController consumerController;

	@ManagedProperty(value = "#{supportController}")
	private SupportController supportController;

	private CialcoDTO cialcoDTO;

	private InstitucionApoyoDTO institucionApoyoDTO;
	private PersonaDTO personaDTO;
	private LugarEntregaCanastaDTO lugarEntregaCanastaDTO;

	private List<ProvinciaDTO> provinciaDTOs;
	private List<CantonDTO> cantonDTOs;
	private List<ParroquiaDTO> parroquiaDTOs;

	private List<CatalogoDTO> etniaDTOs;
	private List<CatalogoDTO> generoDTOs;
	private List<CatalogoDTO> escolaridadDTOs;
	private List<CatalogoDTO> frecuenciaDTOs;
	private List<CatalogoDTO> tipoEntregaDTOs;
	private List<CatalogoDTO> productoDTOs;
	private List<DiaVO> diaVOs;
	private List<String> idTipoEntregas;
	private List<LugarEntregaCanastaDTO> lugarEntregaCanastaDTOs;

	private Boolean chekConcentrada = Boolean.FALSE;

	@PostConstruct
	public void init() {
		setCialcoDTO(new CialcoDTO());
		setPersonaDTO(new PersonaDTO());
		setInstitucionApoyoDTO(new InstitucionApoyoDTO());
		findProvincias();
		findGeneros();
		findFrecuencia();
		findTipoEntrega();
		findProducts();
		consumerController.setPersonaDTOs(new ArrayList<PersonaDTO>());
		this.diaVOs = DateUtil.findDias();
	}

	public void findProvincias() {
		this.provinciaDTOs = MagapFactory.getInstance().getIMagapService()
				.findProvincias();
	}

	public void findCantones(AjaxBehaviorEvent event) {
		this.cantonDTOs = MagapFactory.getInstance().getIMagapService()
				.findCantones(this.cialcoDTO.getIdProvincia());
	}

	public void findParroquias(AjaxBehaviorEvent event) {
		this.parroquiaDTOs = MagapFactory.getInstance().getIMagapService()
				.findParroquias(this.cialcoDTO.getIdCanton());
	}

	public void findGeneros() {
		this.generoDTOs = MagapFactory.getInstance().getIMagapService()
				.findCatalogByType(Parameter.GENERO, Parameter.ESTADO_ACTIVO);

		this.etniaDTOs = MagapFactory.getInstance().getIMagapService()
				.findCatalogByType(Parameter.ETNIA, Parameter.ESTADO_ACTIVO);

		this.escolaridadDTOs = MagapFactory
				.getInstance()
				.getIMagapService()
				.findCatalogByType(Parameter.ESCOLARIDAD,
						Parameter.ESTADO_ACTIVO);
	}

	/*
	 * public void newOrganizacion() { this.setOrganizacionDTO(new
	 * OrganizacionDTO()); if (this.organizacionDTOs == null) {
	 * this.setOrganizacionDTOs(new ArrayList<OrganizacionDTO>()); } }
	 * 
	 * public void deleteOrg(OrganizacionDTO organizacionDTO) {
	 * this.organizacionDTOs.remove(organizacionDTO); }
	 * 
	 * public void addOrg() { if
	 * (!BooleanUtils.toBoolean(this.organizacionDTO.getSelected())) {
	 * this.organizacionDTOs.add(this.organizacionDTO);
	 * FacesContext.getCurrentInstance().addMessage( null, new
	 * FacesMessage(FacesMessage.SEVERITY_INFO, "",
	 * "Organizacion agregada correctamente")); } else {
	 * FacesContext.getCurrentInstance().addMessage( null, new
	 * FacesMessage(FacesMessage.SEVERITY_INFO, "",
	 * "Organizacion editada correctamente")); }
	 * this.organizacionDTO.setSelected(Boolean.TRUE); setOrganizacionDTO(new
	 * OrganizacionDTO()); }
	 */

	public void guardarCialco() {

		String ids = StringUtils.join(this.cialcoDTO.getIdDias(), ",");
		this.cialcoDTO.setIdCatalogoDias(ids);

		this.cialcoDTO.setTipo(Parameter.ID_CIALCO_CANASTA);
		MagapFactory.getInstance().getIMagapService()
				.transSaveCialco(this.cialcoDTO);

		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "",
						"Cialco canasta guardado correctamente"));

		init();
		this.orgController
				.setOrganizacionDTOs(new ArrayList<OrganizacionDTO>());
		setLugarEntregaCanastaDTOs(new ArrayList<LugarEntregaCanastaDTO>());
		setIdTipoEntregas(new ArrayList<String>());
		this.chekConcentrada = Boolean.FALSE;
	}

	public void valitadePersonaDTO() {
		if (this.personaDTO.getCedulaPersona().toString().length() == 10) {
			PersonaDTO personaDTO = MagapFactory.getInstance()
					.getIMagapService()
					.findPersonaByCedula(this.personaDTO.getCedulaPersona());
			if (personaDTO != null) {
				this.personaDTO = personaDTO;
			}
		}
	}

	private void findFrecuencia() {
		this.frecuenciaDTOs = MagapFactory
				.getInstance()
				.getIMagapService()
				.findCatalogByType(Parameter.FRECUENCIA,
						Parameter.ESTADO_ACTIVO);

		this.diaVOs = DateUtil.findDias();
	}

	private void findTipoEntrega() {
		this.tipoEntregaDTOs = MagapFactory
				.getInstance()
				.getIMagapService()
				.findCatalogByType(Parameter.TIPO_ENTREGA,
						Parameter.ESTADO_ACTIVO);
	}

	public void selectedTipo() {
		this.chekConcentrada = Boolean.FALSE;
		if (this.idTipoEntregas.contains(Parameter.ID_TIPO_ENTREGA_CONCENTRADA
				.toString())) {
			this.chekConcentrada = Boolean.TRUE;
		}

	}

	public void newLugar() {
		this.setLugarEntregaCanastaDTO(new LugarEntregaCanastaDTO());
		if (this.lugarEntregaCanastaDTOs == null) {
			this.setLugarEntregaCanastaDTOs(new ArrayList<LugarEntregaCanastaDTO>());
		}
	}

	public void deleteLugar(LugarEntregaCanastaDTO lugarEntregaCanastaDTO) {
		this.lugarEntregaCanastaDTOs.remove(lugarEntregaCanastaDTO);
	}

	public void addLugar() {
		if (!BooleanUtils.toBoolean(this.lugarEntregaCanastaDTO.getSelected())) {
			CatalogoDTO catalogoDTO = CompareUtil.findCatalogDTO(
					this.frecuenciaDTOs,
					this.lugarEntregaCanastaDTO.getIdcatalogoFrecuencia());

			this.lugarEntregaCanastaDTO.setNameFrecuencia(catalogoDTO
					.getElementoCatalogo());

			this.lugarEntregaCanastaDTOs.add(this.lugarEntregaCanastaDTO);
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "",
							"Lugar agregado correctamente"));
		} else {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "",
							"Lugar editado correctamente"));
		}
		this.lugarEntregaCanastaDTO.setSelected(Boolean.TRUE);
		setLugarEntregaCanastaDTO(new LugarEntregaCanastaDTO());
	}

	private void findProducts() {
		if (this.productoDTOs == null || this.productoDTOs.isEmpty()) {
			this.productoDTOs = MagapFactory
					.getInstance()
					.getIMagapService()
					.findCatalogByType(Parameter.PRODUCTO,
							Parameter.ESTADO_ACTIVO);
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

	public InstitucionApoyoDTO getInstitucionApoyoDTO() {
		return institucionApoyoDTO;
	}

	public void setInstitucionApoyoDTO(InstitucionApoyoDTO institucionApoyoDTO) {
		this.institucionApoyoDTO = institucionApoyoDTO;
	}

	public PersonaDTO getPersonaDTO() {
		return personaDTO;
	}

	public void setPersonaDTO(PersonaDTO personaDTO) {
		this.personaDTO = personaDTO;
	}

	public List<CatalogoDTO> getEtniaDTOs() {
		return etniaDTOs;
	}

	public void setEtniaDTOs(List<CatalogoDTO> etniaDTOs) {
		this.etniaDTOs = etniaDTOs;
	}

	public List<CatalogoDTO> getGeneroDTOs() {
		return generoDTOs;
	}

	public void setGeneroDTOs(List<CatalogoDTO> generoDTOs) {
		this.generoDTOs = generoDTOs;
	}

	public List<CatalogoDTO> getEscolaridadDTOs() {
		return escolaridadDTOs;
	}

	public void setEscolaridadDTOs(List<CatalogoDTO> escolaridadDTOs) {
		this.escolaridadDTOs = escolaridadDTOs;
	}

	public List<CatalogoDTO> getFrecuenciaDTOs() {
		return this.frecuenciaDTOs;
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

	public List<String> getIdTipoEntregas() {
		return idTipoEntregas;
	}

	public void setIdTipoEntregas(List<String> idTipoEntregas) {
		this.idTipoEntregas = idTipoEntregas;
	}

	public List<CatalogoDTO> getTipoEntregaDTOs() {
		return tipoEntregaDTOs;
	}

	public void setTipoEntregaDTOs(List<CatalogoDTO> tipoEntregaDTOs) {
		this.tipoEntregaDTOs = tipoEntregaDTOs;
	}

	public Boolean getChekConcentrada() {
		return chekConcentrada;
	}

	public void setChekConcentrada(Boolean chekConcentrada) {
		this.chekConcentrada = chekConcentrada;
	}

	public LugarEntregaCanastaDTO getLugarEntregaCanastaDTO() {
		return lugarEntregaCanastaDTO;
	}

	public void setLugarEntregaCanastaDTO(
			LugarEntregaCanastaDTO lugarEntregaCanastaDTO) {
		this.lugarEntregaCanastaDTO = lugarEntregaCanastaDTO;
	}

	public List<LugarEntregaCanastaDTO> getLugarEntregaCanastaDTOs() {
		return lugarEntregaCanastaDTOs;
	}

	public void setLugarEntregaCanastaDTOs(
			List<LugarEntregaCanastaDTO> lugarEntregaCanastaDTOs) {
		this.lugarEntregaCanastaDTOs = lugarEntregaCanastaDTOs;
	}

	public List<CatalogoDTO> getProductoDTOs() {
		return productoDTOs;
	}

	public void setProductoDTOs(List<CatalogoDTO> productoDTOs) {
		this.productoDTOs = productoDTOs;
	}

	public OrgController getOrgController() {
		return orgController;
	}

	public void setOrgController(OrgController orgController) {
		this.orgController = orgController;
	}

	public ConsumerController getConsumerController() {
		return consumerController;
	}

	public void setConsumerController(ConsumerController consumerController) {
		this.consumerController = consumerController;
	}

	public SupportController getSupportController() {
		return supportController;
	}

	public void setSupportController(SupportController supportController) {
		this.supportController = supportController;
	}

}
