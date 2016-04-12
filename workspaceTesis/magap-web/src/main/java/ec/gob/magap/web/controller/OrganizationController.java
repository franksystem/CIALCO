package ec.gob.magap.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.commons.lang3.BooleanUtils;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

import ec.gob.magap.common.util.Parameter;
import ec.gob.magap.dto.CatalogoDTO;
import ec.gob.magap.dto.OrganizacionDTO;
import ec.gob.magap.dto.PersonaDTO;
import ec.gob.magap.factory.MagapFactory;
import ec.gob.magap.vo.ProductoSocioVO;

@ManagedBean(name = "organizationController")
@ViewScoped
public class OrganizationController {

	private OrganizacionDTO organizacionDTO;
	private String tipoDocumento;
	private ProductoSocioVO productoSocioVO;
	private List<ProductoSocioVO> productoSocioVOs;
	private List<CatalogoDTO> tipoSistemaDTOs;
	private List<CatalogoDTO> productDTOs;
	private List<CatalogoDTO> destinoProDTOs;
	private List<CatalogoDTO> cedeDTOs;
	private List<CatalogoDTO> centroDTOs;
	private List<CatalogoDTO> equipamientoDTOs;

	private List<String> idProducts;
	private List<String> idProdSocio;
	private List<String> idTipoSistema;
	private List<String> idDestinosPro;
	private List<String> idCedes;
	private List<String> idCentros;
	private List<String> idEquipamientos;
	private List<String> idPracticas;
	private List<String> idOrganica;

	// variables popup
	private List<PersonaDTO> personaDTOs;

	private List<PersonaDTO> socioDTOs;

	@PostConstruct
	public void init() {
		newOrganizacion();
		findProducts();
		findTipoSistema();
		findDestinos();
		findSede();
		findCetro();
		findEquipamiento();
	}

	private void findProducts() {

		this.productDTOs = MagapFactory.getInstance().getIMagapService()
				.findCatalogByType(Parameter.PRODUCTO, Parameter.ESTADO_ACTIVO);

	}

	private void findTipoSistema() {

		this.tipoSistemaDTOs = MagapFactory
				.getInstance()
				.getIMagapService()
				.findCatalogByType(Parameter.TIPO_SISTEMA,
						Parameter.ESTADO_ACTIVO);

	}

	private void findDestinos() {

		this.destinoProDTOs = MagapFactory
				.getInstance()
				.getIMagapService()
				.findCatalogByType(Parameter.DESTINO_PRODUCCION,
						Parameter.ESTADO_ACTIVO);

	}

	private void findSede() {

		this.cedeDTOs = MagapFactory
				.getInstance()
				.getIMagapService()
				.findCatalogByType(Parameter.SEDE_ORGANIZAION,
						Parameter.ESTADO_ACTIVO);
	}

	private void findCetro() {

		this.centroDTOs = MagapFactory
				.getInstance()
				.getIMagapService()
				.findCatalogByType(Parameter.CENTRO_ACOPIO,
						Parameter.ESTADO_ACTIVO);
	}

	private void findEquipamiento() {

		this.equipamientoDTOs = MagapFactory
				.getInstance()
				.getIMagapService()
				.findCatalogByType(Parameter.EQUIPAMIENTO_PROCESAMIENTO,
						Parameter.ESTADO_ACTIVO);
	}

	public void newOrganizacion() {
		this.setOrganizacionDTO(new OrganizacionDTO());
		this.tipoDocumento = "1";
	}

	public void newSocioProductos() {
		this.productoSocioVO = new ProductoSocioVO();
		this.productoSocioVO.setSelectedPersonaDTO(new PersonaDTO());
	}

	public void guardarOrganizacion() {
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "",
						"Organizacion guardada correctamente"));

		this.organizacionDTO = new OrganizacionDTO();
		this.productoSocioVO = new ProductoSocioVO();
		this.productoSocioVOs = new ArrayList<ProductoSocioVO>();

		this.idProducts = new ArrayList<String>();
		this.idProdSocio = new ArrayList<String>();
		this.idTipoSistema = new ArrayList<String>();
		this.idDestinosPro = new ArrayList<String>();
		this.idCedes = new ArrayList<String>();
		this.idCentros = new ArrayList<String>();
		this.idEquipamientos = new ArrayList<String>();
		this.idPracticas = new ArrayList<String>();
		this.idOrganica = new ArrayList<String>();

		// variables popup
		this.personaDTOs = new ArrayList<PersonaDTO>();

		this.socioDTOs = new ArrayList<PersonaDTO>();

	}

	public void addSocio() {
		if (this.productoSocioVO.getSelectedPersonaDTO() == null
				|| this.productoSocioVO.getSelectedPersonaDTO().getIdPersona() == null) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "",
							"Debe seleccionar un productor"));
			return;
		}

	}

	public void newSocio() {
		this.productoSocioVO.setSelectedPersonaDTO(new PersonaDTO());
		PersonaDTO personaDTO = new PersonaDTO();
		personaDTO.setEstado(Parameter.ESTADO_ACTIVO);
		this.personaDTOs = MagapFactory.getInstance().getIMagapService()
				.findProductor(personaDTO);
	}

	public void deleteProdSocio(ProductoSocioVO productoSocioVO) {
		this.productoSocioVOs.remove(productoSocioVO);
	}

	public void addProdSocio() {
		if (this.productoSocioVOs == null) {
			this.productoSocioVOs = new ArrayList<ProductoSocioVO>();
		}
		if (!BooleanUtils.toBoolean(this.productoSocioVO.getSelected())) {
			this.productoSocioVOs.add(this.productoSocioVO);
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "",
							"Productos por socio agregado correctamente"));
		} else {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "",
							"Productos por socio editado correctamente"));
		}
		this.productoSocioVO.setSelected(Boolean.TRUE);
		this.productoSocioVO = new ProductoSocioVO();
	}

	public void onRowSelect(SelectEvent event) {

	}

	public void onRowUnselect(UnselectEvent event) {

	}

	public OrganizacionDTO getOrganizacionDTO() {
		return organizacionDTO;
	}

	public void setOrganizacionDTO(OrganizacionDTO organizacionDTO) {
		this.organizacionDTO = organizacionDTO;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public List<CatalogoDTO> getProductDTOs() {
		return productDTOs;
	}

	public void setProductDTOs(List<CatalogoDTO> productDTOs) {
		this.productDTOs = productDTOs;
	}

	public List<String> getIdProducts() {
		return idProducts;
	}

	public void setIdProducts(List<String> idProducts) {
		this.idProducts = idProducts;
	}

	public List<String> getIdProdSocio() {
		return idProdSocio;
	}

	public void setIdProdSocio(List<String> idProdSocio) {
		this.idProdSocio = idProdSocio;
	}

	public List<PersonaDTO> getPersonaDTOs() {
		return personaDTOs;
	}

	public void setPersonaDTOs(List<PersonaDTO> personaDTOs) {
		this.personaDTOs = personaDTOs;
	}

	public List<PersonaDTO> getSocioDTOs() {
		return socioDTOs;
	}

	public void setSocioDTOs(List<PersonaDTO> socioDTOs) {
		this.socioDTOs = socioDTOs;
	}

	public ProductoSocioVO getProductoSocioVO() {
		return productoSocioVO;
	}

	public void setProductoSocioVO(ProductoSocioVO productoSocioVO) {
		this.productoSocioVO = productoSocioVO;
	}

	public List<ProductoSocioVO> getProductoSocioVOs() {
		return productoSocioVOs;
	}

	public void setProductoSocioVOs(List<ProductoSocioVO> productoSocioVOs) {
		this.productoSocioVOs = productoSocioVOs;
	}

	public List<String> getIdTipoSistema() {
		return idTipoSistema;
	}

	public void setIdTipoSistema(List<String> idTipoSistema) {
		this.idTipoSistema = idTipoSistema;
	}

	public List<CatalogoDTO> getTipoSistemaDTOs() {
		return tipoSistemaDTOs;
	}

	public void setTipoSistemaDTOs(List<CatalogoDTO> tipoSistemaDTOs) {
		this.tipoSistemaDTOs = tipoSistemaDTOs;
	}

	public List<CatalogoDTO> getDestinoProDTOs() {
		return destinoProDTOs;
	}

	public void setDestinoProDTOs(List<CatalogoDTO> destinoProDTOs) {
		this.destinoProDTOs = destinoProDTOs;
	}

	public List<String> getIdDestinosPro() {
		return idDestinosPro;
	}

	public void setIdDestinosPro(List<String> idDestinosPro) {
		this.idDestinosPro = idDestinosPro;
	}

	public List<CatalogoDTO> getCedeDTOs() {
		return cedeDTOs;
	}

	public void setCedeDTOs(List<CatalogoDTO> cedeDTOs) {
		this.cedeDTOs = cedeDTOs;
	}

	public List<CatalogoDTO> getCentroDTOs() {
		return centroDTOs;
	}

	public void setCentroDTOs(List<CatalogoDTO> centroDTOs) {
		this.centroDTOs = centroDTOs;
	}

	public List<CatalogoDTO> getEquipamientoDTOs() {
		return equipamientoDTOs;
	}

	public void setEquipamientoDTOs(List<CatalogoDTO> equipamientoDTOs) {
		this.equipamientoDTOs = equipamientoDTOs;
	}

	public List<String> getIdCedes() {
		return idCedes;
	}

	public void setIdCedes(List<String> idCedes) {
		this.idCedes = idCedes;
	}

	public List<String> getIdCentros() {
		return idCentros;
	}

	public void setIdCentros(List<String> idCentros) {
		this.idCentros = idCentros;
	}

	public List<String> getIdEquipamientos() {
		return idEquipamientos;
	}

	public void setIdEquipamientos(List<String> idEquipamientos) {
		this.idEquipamientos = idEquipamientos;
	}

	public List<String> getIdPracticas() {
		return idPracticas;
	}

	public void setIdPracticas(List<String> idPracticas) {
		this.idPracticas = idPracticas;
	}

	public List<String> getIdOrganica() {
		return idOrganica;
	}

	public void setIdOrganica(List<String> idOrganica) {
		this.idOrganica = idOrganica;
	}

}