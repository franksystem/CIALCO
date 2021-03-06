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

import ec.gob.magap.common.util.Parameter;
import ec.gob.magap.dto.CantonDTO;
import ec.gob.magap.dto.CatalogoDTO;
import ec.gob.magap.dto.CialcoDTO;
import ec.gob.magap.dto.ParroquiaDTO;
import ec.gob.magap.dto.PersonaDTO;
import ec.gob.magap.dto.PresentacionProductoDTO;
import ec.gob.magap.dto.ProvinciaDTO;
import ec.gob.magap.factory.MagapFactory;
import ec.gob.magap.web.controller.common.CommonController;
import ec.gob.magap.web.controller.common.ConsumerController;
import ec.gob.magap.web.controller.common.ProductsController;

@ManagedBean(name = "exportController")
@ViewScoped
public class exportController extends CommonController {

	@ManagedProperty(value = "#{productosController}")
	private ProductsController productosController;

	@ManagedProperty(value = "#{consumerController}")
	private ConsumerController consumerController;

	private CialcoDTO cialcoDTO;

	private List<ProvinciaDTO> provinciaDTOs;
	private List<CantonDTO> cantonDTOs;
	private List<ParroquiaDTO> parroquiaDTOs;

	private List<CatalogoDTO> equipamientoDTOs;

	private List<PersonaDTO> personaDTOs;
	private List<String> idProductos;
	private List<String> idProducts;
	private List<CatalogoDTO> productDTOs;
	private List<CatalogoDTO> tiposProdDTOs;
	private List<String> idTiposProductos;
	private List<String> idEquipamientos;

	@PostConstruct
	public void init() {
		this.setCialcoDTO(new CialcoDTO());
		findProvincias();
		findTipoProd();
		findProducts();
		findEquipamientos();
		setIdEquipamientos(new ArrayList<String>());
		setIdProductos(new ArrayList<String>());
		this.productosController.setFeria(Boolean.FALSE);
	}

	private void findEquipamientos() {
		if (this.equipamientoDTOs == null) {
			this.equipamientoDTOs = MagapFactory
					.getInstance()
					.getIMagapService()
					.findCatalogByType(Parameter.EQUIPAMIENTO,
							Parameter.ESTADO_ACTIVO);
		}
	}
	
	private void findProducts() {

		this.productDTOs = MagapFactory.getInstance().getIMagapService()
				.findCatalogByType(Parameter.PRODUCTO, Parameter.ESTADO_ACTIVO);
		
	}
	
	
	private void findTipoProd() {
		if (this.tiposProdDTOs == null) {
			this.tiposProdDTOs = MagapFactory
					.getInstance()
					.getIMagapService()
					.findCatalogByType(Parameter.TIPO_PRODUCTO,
							Parameter.ESTADO_ACTIVO);
		}
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

	public void guardarCialco() {

		this.cialcoDTO.setTipo(Parameter.ID_CIALCO_PIE_FINCA);
		MagapFactory.getInstance().getIMagapService()
				.transSaveCialco(this.cialcoDTO);

		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "",
						"Cialco pie de finca guardado correctamente"));

		setCialcoDTO(new CialcoDTO());
		setIdEquipamientos(new ArrayList<String>());
		setIdProductos(new ArrayList<String>());
		setIdTiposProductos(new ArrayList<String>());
		this.productosController.newProductos(Boolean.TRUE);
		this.productosController
				.setPresentacionProductoDTOs(new ArrayList<PresentacionProductoDTO>());
		this.productosController.setMontoTotal(0D);
		this.idProducts = new ArrayList<String>();
		
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

	public List<PersonaDTO> getPersonaDTOs() {
		return personaDTOs;
	}

	public void setPersonaDTOs(List<PersonaDTO> personaDTOs) {
		this.personaDTOs = personaDTOs;
	}

	public List<String> getIdProductos() {
		return idProductos;
	}

	public void setIdProductos(List<String> idProductos) {
		this.idProductos = idProductos;
	}
	
	public List<String> getIdTiposProductos() {
		return idTiposProductos;
	}

	public void setIdTiposProductos(List<String> idTiposProductos) {
		this.idTiposProductos = idTiposProductos;
	}

	public List<CatalogoDTO> getTiposProdDTOs() {
		return tiposProdDTOs;
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


	public void setTiposProdDTOs(List<CatalogoDTO> tiposProdDTOs) {
		this.tiposProdDTOs = tiposProdDTOs;
	}

	public List<String> getIdEquipamientos() {
		return idEquipamientos;
	}

	public void setIdEquipamientos(List<String> idEquipamientos) {
		this.idEquipamientos = idEquipamientos;
	}

	public List<CatalogoDTO> getEquipamientoDTOs() {
		return equipamientoDTOs;
	}

	public void setEquipamientoDTOs(List<CatalogoDTO> equipamientoDTOs) {
		this.equipamientoDTOs = equipamientoDTOs;
	}

	public ProductsController getProductosController() {
		return productosController;
	}

	public void setProductosController(ProductsController productosController) {
		this.productosController = productosController;
	}

	public ConsumerController getConsumerController() {
		return consumerController;
	}

	public void setConsumerController(ConsumerController consumerController) {
		this.consumerController = consumerController;
	}

}
