package ec.gob.magap.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import ec.gob.magap.common.util.Parameter;
import ec.gob.magap.dto.CatalogoDTO;
import ec.gob.magap.factory.MagapFactory;
import ec.gob.magap.web.controller.common.CialcoController;
import ec.gob.magap.web.controller.common.CommonController;
import ec.gob.magap.web.controller.common.ConsumerController;
import ec.gob.magap.web.controller.common.OrgController;
import ec.gob.magap.web.controller.common.ProductsController;

@ManagedBean(name = "fairController")
@ViewScoped
public class FairController extends CommonController {

	@ManagedProperty(value = "#{cialcoController}")
	private CialcoController cialcoController;

	@ManagedProperty(value = "#{orgController}")
	private OrgController orgController;

	@ManagedProperty(value = "#{productosController}")
	private ProductsController productosController;

	@ManagedProperty(value = "#{consumerController}")
	private ConsumerController consumerController;

	private Integer idTrueque;

	private List<CatalogoDTO> equipamientoDTOs;
	private List<CatalogoDTO> difusionDTOs;
	private List<CatalogoDTO> tiposProdDTOs;
	private List<CatalogoDTO> funcionamientoDTOs;
	private List<CatalogoDTO> participantesDTOs;

	private List<String> idEquipamientos;
	private List<String> idDifusiones;
	private List<String> idTiposProductos;
	private List<String> idFuncionamientos;
	private List<String> idParticipantes;

	private Integer hombres;
	private Integer mujeres;

	@PostConstruct
	public void init() {
		findEquipamientos();
		findDifusionFeria();
		findTipoProd();
		findFuncionamiento();
		findParticipante();
		this.productosController.setFeria(Boolean.TRUE);
	}

	private void findEquipamientos() {
		if (this.equipamientoDTOs == null) {
			this.equipamientoDTOs = MagapFactory
					.getInstance()
					.getIMagapService()
					.findCatalogByType(Parameter.EQUIPAMIENTO_FERIA,
							Parameter.ESTADO_ACTIVO);
		}
	}

	private void findDifusionFeria() {
		if (this.difusionDTOs == null) {
			this.difusionDTOs = MagapFactory
					.getInstance()
					.getIMagapService()
					.findCatalogByType(Parameter.DIFUCION_FERIA,
							Parameter.ESTADO_ACTIVO);
		}
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

	private void findFuncionamiento() {
		if (this.funcionamientoDTOs == null) {
			this.funcionamientoDTOs = MagapFactory
					.getInstance()
					.getIMagapService()
					.findCatalogByType(Parameter.FUNCIONAMIENTO_CIALCO,
							Parameter.ESTADO_ACTIVO);
		}
	}

	private void findParticipante() {
		if (this.participantesDTOs == null) {
			this.participantesDTOs = MagapFactory
					.getInstance()
					.getIMagapService()
					.findCatalogByType(Parameter.PARTICIPANTES_ACTUALES,
							Parameter.ESTADO_ACTIVO);
		}
	}

	public void guardarCialco() {
		this.cialcoController.getCialcoDTO().setTipo(Parameter.ID_CIALCO_FERIA);
		MagapFactory.getInstance().getIMagapService()
				.transSaveCialco(this.cialcoController.getCialcoDTO());

		this.cialcoController.newCialco();
		this.orgController.newOrganizacion();
		this.productosController.newProductos(Boolean.TRUE);
		this.consumerController.resetConsumer();
		setIdDifusiones(new ArrayList<String>());
		setIdEquipamientos(new ArrayList<String>());
		setIdTiposProductos(new ArrayList<String>());
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "",
						"Cialco feria guardado correctamente"));

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

	public OrgController getOrgController() {
		return orgController;
	}

	public void setOrgController(OrgController orgController) {
		this.orgController = orgController;
	}

	public List<CatalogoDTO> getDifusionDTOs() {
		return difusionDTOs;
	}

	public void setDifusionDTOs(List<CatalogoDTO> difusionDTOs) {
		this.difusionDTOs = difusionDTOs;
	}

	public List<String> getIdDifusiones() {
		return idDifusiones;
	}

	public void setIdDifusiones(List<String> idDifusiones) {
		this.idDifusiones = idDifusiones;
	}

	public ProductsController getProductosController() {
		return productosController;
	}

	public void setProductosController(ProductsController productosController) {
		this.productosController = productosController;
	}

	public Integer getIdTrueque() {
		return idTrueque;
	}

	public void setIdTrueque(Integer idTrueque) {
		this.idTrueque = idTrueque;
	}

	public ConsumerController getConsumerController() {
		return consumerController;
	}

	public void setConsumerController(ConsumerController consumerController) {
		this.consumerController = consumerController;
	}

	public CialcoController getCialcoController() {
		return cialcoController;
	}

	public void setCialcoController(CialcoController cialcoController) {
		this.cialcoController = cialcoController;
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

	public void setTiposProdDTOs(List<CatalogoDTO> tiposProdDTOs) {
		this.tiposProdDTOs = tiposProdDTOs;
	}

	public List<CatalogoDTO> getFuncionamientoDTOs() {
		return funcionamientoDTOs;
	}

	public void setFuncionamientoDTOs(List<CatalogoDTO> funcionamientoDTOs) {
		this.funcionamientoDTOs = funcionamientoDTOs;
	}

	public List<CatalogoDTO> getParticipantesDTOs() {
		return participantesDTOs;
	}

	public void setParticipantesDTOs(List<CatalogoDTO> participantesDTOs) {
		this.participantesDTOs = participantesDTOs;
	}

	public List<String> getIdFuncionamientos() {
		return idFuncionamientos;
	}

	public void setIdFuncionamientos(List<String> idFuncionamientos) {
		this.idFuncionamientos = idFuncionamientos;
	}

	public List<String> getIdParticipantes() {
		return idParticipantes;
	}

	public void setIdParticipantes(List<String> idParticipantes) {
		this.idParticipantes = idParticipantes;
	}

	public Integer getHombres() {
		return hombres;
	}

	public void setHombres(Integer hombres) {
		this.hombres = hombres;
	}

	public Integer getMujeres() {
		return mujeres;
	}

	public void setMujeres(Integer mujeres) {
		this.mujeres = mujeres;
	}

}