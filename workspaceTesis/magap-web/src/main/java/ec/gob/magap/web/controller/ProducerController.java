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

import ec.gob.magap.common.util.MagapLogger;
import ec.gob.magap.common.util.Parameter;
import ec.gob.magap.dto.CantonDTO;
import ec.gob.magap.dto.CatalogoDTO;
import ec.gob.magap.dto.CialcoDTO;
import ec.gob.magap.dto.OrganizacionDTO;
import ec.gob.magap.dto.ParroquiaDTO;
import ec.gob.magap.dto.PersonaDTO;
import ec.gob.magap.dto.PracticaProductivaDTO;
import ec.gob.magap.dto.ProductoProductorDTO;
import ec.gob.magap.dto.ProvinciaDTO;
import ec.gob.magap.dto.UbicacionFincaDTO;
import ec.gob.magap.exception.MagapException;
import ec.gob.magap.factory.MagapFactory;
import ec.gob.magap.vo.ProductorVO;
import ec.gob.magap.web.controller.common.PersonController;
import ec.gob.magap.web.controller.common.SupportController;
import ec.gob.magap.web.manager.SessionUser;
import ec.gob.magap.web.util.CompareUtil;

@ManagedBean(name = "producerController")
@ViewScoped
public class ProducerController {

	@ManagedProperty(value = "#{sessionUser}")
	private SessionUser sessionUser;

	@ManagedProperty(value = "#{supportController}")
	private SupportController supportController;

	@ManagedProperty(value = "#{personController}")
	private PersonController personController;

	private UbicacionFincaDTO ubicacionFincaDTO;
	private OrganizacionDTO organizacionDTO;
	private CialcoDTO cialcoFeriaDTO;
	private PersonaDTO addPersonaDTO;

	private PracticaProductivaDTO practicaAgroDTO;
	private PracticaProductivaDTO practicaOrgaDTO;
	private ProductoProductorDTO addProductoDTO;
	private ProductoProductorDTO addProductoProcessDTO;

	private List<CatalogoDTO> fuenteIngresosDTOs;
	private List<ProvinciaDTO> provinciaDTOs;
	private List<CantonDTO> cantonDTOs;
	private List<ParroquiaDTO> parroquiaDTOs;
	private List<CatalogoDTO> posesionDTOs;
	private List<CatalogoDTO> practicasDTOs;
	private List<CatalogoDTO> apoyoProDTOs;
	private List<CatalogoDTO> destComerDTOs;
	private List<CatalogoDTO> frecuenciaDTOs;
	private List<CatalogoDTO> destinoIngDTOs;
	private List<CatalogoDTO> tipoProductDTOs;
	private List<CatalogoDTO> rubroProductDTOs;
	private List<CatalogoDTO> productDTOs;
	private List<CatalogoDTO> parentescoDTOs;

	private List<OrganizacionDTO> organizacionDTOs;
	private List<OrganizacionDTO> deleteOrganizacionDTOs;
	private List<ProductoProductorDTO> addProductoProductorDTOs;
	private List<ProductoProductorDTO> addProducProcessDTOs;
	private List<ProductoProductorDTO> addProducOfertDTOs;

	private List<String> idFuentes;
	private List<String> idPracticas;
	private List<String> idApoyoPro;
	private List<String> idDestComer;// destinos produccion
	private List<String> idDestIng;// destinos Ingresos

	private Boolean organica = Boolean.FALSE;
	private Boolean agroEcologic = Boolean.FALSE;
	private Integer numeroFamiliares = 0;
	private Boolean checkFeria = Boolean.FALSE;

	private String labelCheckFeria = "";
	private String labelCheckOrgnica = "";
	private String labelCheckAgro = "";

	private Double promCialcomes;
	private Double promMes;

	@PostConstruct
	public void init() {

	}

	public void newProductor() {
		this.personController.setPersonaDTO(new PersonaDTO());
		this.setUbicacionFincaDTO(new UbicacionFincaDTO());

		findFuenteIgresos();
		findDatosFinca();
		findPracticasProductivas();
		findApoyoProduccion();
		initOrganizacion();
		findDestinoIngresos();
		findDatosComercializacion();
		findParentesco();
		findProductos();
	}

	private void findFuenteIgresos() {
		this.idFuentes = new ArrayList<String>();
		this.fuenteIngresosDTOs = MagapFactory
				.getInstance()
				.getIMagapService()
				.findCatalogByType(Parameter.FUENTES_INGRESOS,
						Parameter.ESTADO_ACTIVO);

	}

	private void findDatosFinca() {
		this.provinciaDTOs = MagapFactory.getInstance().getIMagapService()
				.findProvincias();

		this.posesionDTOs = MagapFactory
				.getInstance()
				.getIMagapService()
				.findCatalogByType(Parameter.POSESION_TIERRA,
						Parameter.ESTADO_ACTIVO);

	}

	public void findCantones(AjaxBehaviorEvent event) {
		this.cantonDTOs = MagapFactory.getInstance().getIMagapService()
				.findCantones(this.ubicacionFincaDTO.getIdProvincia());
	}

	public void findParroquias(AjaxBehaviorEvent event) {
		this.parroquiaDTOs = MagapFactory.getInstance().getIMagapService()
				.findParroquias(this.ubicacionFincaDTO.getIdCanton());
	}

	private void findPracticasProductivas() {
		this.setPracticaAgroDTO(new PracticaProductivaDTO());
		this.setPracticaOrgaDTO(new PracticaProductivaDTO());
		this.idPracticas = new ArrayList<String>();
		this.practicasDTOs = MagapFactory
				.getInstance()
				.getIMagapService()
				.findCatalogByType(Parameter.PRACTICAS_PRODUCTIVAS,
						Parameter.ESTADO_ACTIVO);
	}

	private void findApoyoProduccion() {
		this.idApoyoPro = new ArrayList<String>();
		this.apoyoProDTOs = MagapFactory
				.getInstance()
				.getIMagapService()
				.findCatalogByType(Parameter.APOYO_PRODUCCION,
						Parameter.ESTADO_ACTIVO);

	}

	private void initOrganizacion() {
		this.setOrganizacionDTO(new OrganizacionDTO());
		if (this.organizacionDTOs == null) {
			this.setOrganizacionDTOs(new ArrayList<OrganizacionDTO>());
		}

	}

	public void selectedPracticas() {
		this.organica = Boolean.FALSE;
		this.agroEcologic = Boolean.FALSE;

		if (this.idPracticas
				.contains(Parameter.ID_PRACTICA_ORGANICA.toString())) {
			CatalogoDTO catalogoDTO = CompareUtil.findCatalogDTO(
					this.practicasDTOs, Parameter.ID_PRACTICA_ORGANICA);
			this.getPracticaOrgaDTO().setIdCatalogoPracticaProductiva(
					catalogoDTO.getIdCatalogo());
			this.organica = Boolean.TRUE;
			this.labelCheckOrgnica = catalogoDTO.getElementoCatalogo();
		}
		if (this.idPracticas.contains(Parameter.ID_PRACTICA_AGROECOLOGICA
				.toString())) {
			CatalogoDTO catalogoDTO = CompareUtil.findCatalogDTO(
					this.practicasDTOs, Parameter.ID_PRACTICA_AGROECOLOGICA);
			this.getPracticaAgroDTO().setIdCatalogoPracticaProductiva(
					catalogoDTO.getIdCatalogo());
			this.labelCheckAgro = catalogoDTO.getElementoCatalogo();
			this.agroEcologic = Boolean.TRUE;
		}
	}

	public void selectedApoyoPro() {

	}

	public void addOrg() {
		if (!BooleanUtils.toBoolean(this.organizacionDTO.getSelected())) {
			this.organizacionDTOs.add(this.organizacionDTO);
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "",
							"Organizacion agregada correctamente"));
		} else {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "",
							"Organizacion editada correctamente"));
		}
		this.organizacionDTO.setSelected(Boolean.TRUE);
		setOrganizacionDTO(new OrganizacionDTO());
	}

	public void deleteOrg(OrganizacionDTO organizacionDTO) {
		if (organizacionDTO.getIdOrganizacion() != null) {
			this.deleteOrganizacionDTOs.add(organizacionDTO);
		}
		this.organizacionDTOs.remove(organizacionDTO);
	}

	private void findDatosComercializacion() {
		this.idDestComer = new ArrayList<String>();
		this.destComerDTOs = MagapFactory
				.getInstance()
				.getIMagapService()
				.findCatalogByType(Parameter.DESTINO_PRODUCCION,
						Parameter.ESTADO_ACTIVO);

	}

	/**
	 * Se crea cialco ssi es Feria
	 */
	public void selectedDestinosProduccion() {

		this.checkFeria = Boolean.FALSE;
		if (this.idDestComer
				.contains(Parameter.ID_FERIA_PRODUCTORES.toString())) {

			CatalogoDTO feriaDTO = CompareUtil.findCatalogDTO(
					this.destComerDTOs, Parameter.ID_FERIA_PRODUCTORES);
			this.setLabelCheckFeria(feriaDTO.getElementoCatalogo());

			this.cialcoFeriaDTO = new CialcoDTO();
			this.cialcoFeriaDTO.setPersonaDTOs(new ArrayList<PersonaDTO>());
			findFrecuencia();
			findParentesco();
			this.numeroFamiliares = 0;
			this.checkFeria = Boolean.TRUE;
		}
	}

	private void findFrecuencia() {
		if (this.frecuenciaDTOs == null) {
			this.frecuenciaDTOs = MagapFactory
					.getInstance()
					.getIMagapService()
					.findCatalogByType(Parameter.FRECUENCIA,
							Parameter.ESTADO_ACTIVO);
		}
	}

	public void deleteAddPersona(PersonaDTO personaDTO) {
		this.cialcoFeriaDTO.getPersonaDTOs().remove(personaDTO);
		this.numeroFamiliares = this.cialcoFeriaDTO.getPersonaDTOs().size();
	}

	public void addPersona() {

		CatalogoDTO catalogoDTO = CompareUtil.findCatalogDTO(
				this.parentescoDTOs,
				this.addPersonaDTO.getIdCatalogoParentesco());

		this.addPersonaDTO.setParentesco(catalogoDTO.getElementoCatalogo());

		if (!BooleanUtils.toBoolean(this.addPersonaDTO.getSelected())) {
			this.cialcoFeriaDTO.getPersonaDTOs().add(this.addPersonaDTO);
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "",
							"Persona agregada correctamente"));
		} else {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "",
							"Persona editada correctamente"));
		}
		this.addPersonaDTO.setSelected(Boolean.TRUE);
		this.setAddPersonaDTO(new PersonaDTO());
		this.setNumeroFamiliares(this.cialcoFeriaDTO.getPersonaDTOs().size());

	}

	private void findParentesco() {
		this.setAddPersonaDTO(new PersonaDTO());
		this.parentescoDTOs = MagapFactory
				.getInstance()
				.getIMagapService()
				.findCatalogByType(Parameter.PARENTESCO,
						Parameter.ESTADO_ACTIVO);
	}

	public void newPersona() {
		findParentesco();
	}

	public void findPersona() {
		// MagapFactory.getInstance().getIMagapService().findPersonaByCedula(1);

	}

	public void guardarForm() {

		try {

			PersonaDTO personaDTO = MagapFactory
					.getInstance()
					.getIMagapService()
					.findPersonaByCedula(
							this.personController.getPersonaDTO()
									.getCedulaPersona());

			if (personaDTO != null) {
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "",
								"El productor con numero de cedula "
										+ this.personController.getPersonaDTO()
												.getCedulaPersona()
										+ " ya existe."));
				return;
			}
			if (this.addProductoProductorDTOs.isEmpty()) {
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "",
								"No existen productos cultivos que produce "));
				return;
			}
			this.personController.getPersonaDTO().setIdUsuarioCreacion(
					getSessionUser().getUsuarioDTO().getIdUsuario());
			ProductorVO productorVO = new ProductorVO();
			productorVO.setPersonaDTO(this.personController.getPersonaDTO());
			productorVO.setIdFuentes(this.idFuentes);
			productorVO.setUbicacionFincaDTO(this.ubicacionFincaDTO);
			productorVO.setIdPracticas(this.idPracticas);
			productorVO.setPracticaAgroDTO(this.practicaAgroDTO);
			productorVO.setPracticaOrgaDTO(this.practicaOrgaDTO);
			productorVO.setIdApoyoPro(this.idApoyoPro);
			productorVO.setOrganizacionDTOs(this.organizacionDTOs);
			productorVO.setDeleteOrganizacionDTOs(this.deleteOrganizacionDTOs);
			
			productorVO.setCialcoDTOs(cialcoDTOs);

			productorVO.setIdDestComer(this.idDestComer);
			// Datos productos
			productorVO.setIdDestIng(this.idDestIng);

			if (this.supportController.getInstitucionApoyoDTOs() != null
					&& !this.supportController.getInstitucionApoyoDTOs()
							.isEmpty()) {
				productorVO.setInstitucionApoyoDTOs(this.supportController
						.getInstitucionApoyoDTOs());
			}

			if (this.cialcoFeriaDTO != null
					&& StringUtils.isNotBlank(this.cialcoFeriaDTO
							.getNombreCialco())) {
				this.cialcoFeriaDTO.setTipo(Parameter.ID_CIALCO_FERIA);
				// productorVO.setCialcoDTOs(this.cialcoFeriaDTO);
			}

			if (this.supportController.getInstitucionApoyoDTOs() != null
					&& !this.supportController.getInstitucionApoyoDTOs()
							.isEmpty()) {
				productorVO.setInstitucionApoyoDTOs(this.supportController
						.getInstitucionApoyoDTOs());
			}
			if (this.supportController.getDeleteInstitucionApoyoDTOs() != null
					&& !this.supportController.getDeleteInstitucionApoyoDTOs()
							.isEmpty()) {
				productorVO
						.setDeleteInstitucionApoyoDTOs(this.supportController
								.getDeleteInstitucionApoyoDTOs());
			}

			productorVO.setAddProductoProductorDTOs(productosDTOs());

			MagapFactory.getInstance().getIMagapService()
					.transSaveProductor(productorVO);

			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "",
							"Productor guardado correctamente"));
			resetForm();
		} catch (Exception e) {
			MagapLogger.log.error("Error {}", e);
			FacesContext
					.getCurrentInstance()
					.addMessage(
							null,
							new FacesMessage(FacesMessage.SEVERITY_ERROR, "",
									"No se pudo guardar el productor. Intentelo mas tarde"));
			throw new MagapException(e);
		}
	}

	private void resetForm() {
		this.personController.resetForm();
		this.supportController.resetForm();
		this.setUbicacionFincaDTO(new UbicacionFincaDTO());
		this.setOrganizacionDTO(new OrganizacionDTO());
		this.setCialcoFeriaDTO(new CialcoDTO());
		this.setAddPersonaDTO(new PersonaDTO());

		this.setOrganizacionDTOs(new ArrayList<OrganizacionDTO>());
		this.setAddProductoProductorDTOs(new ArrayList<ProductoProductorDTO>());
		this.addProducOfertDTOs = new ArrayList<ProductoProductorDTO>();
		this.addProducProcessDTOs = new ArrayList<ProductoProductorDTO>();
		
		this.setIdFuentes(new ArrayList<String>());
		this.setIdPracticas(new ArrayList<String>());
		this.setIdApoyoPro(new ArrayList<String>());
		this.setIdDestComer(new ArrayList<String>());
		this.setIdDestIng(new ArrayList<String>());

		this.organica = Boolean.FALSE;
		this.agroEcologic = Boolean.FALSE;
		this.numeroFamiliares = 0;
		this.checkFeria = Boolean.FALSE;

		this.labelCheckFeria = "";
		this.labelCheckOrgnica = "";
		this.labelCheckAgro = "";

		this.promCialcomes = 0D;
		this.promMes = 0D;

	}

	private void findDestinoIngresos() {
		this.idDestIng = new ArrayList<String>();
		this.destinoIngDTOs = MagapFactory
				.getInstance()
				.getIMagapService()
				.findCatalogByType(Parameter.DESTINO_INGRESOS,
						Parameter.ESTADO_ACTIVO);
	}

	public void newOrganizacion() {
		initOrganizacion();
	}

	public void findProductos() {

		this.setAddProductoProductorDTOs(new ArrayList<ProductoProductorDTO>());
		this.setAddProducProcessDTOs(new ArrayList<ProductoProductorDTO>());
		this.setAddProducOfertDTOs(new ArrayList<ProductoProductorDTO>());

		this.tipoProductDTOs = MagapFactory
				.getInstance()
				.getIMagapService()
				.findCatalogByType(Parameter.TIPO_PRODUCTO,
						Parameter.ESTADO_ACTIVO);

		this.rubroProductDTOs = MagapFactory.getInstance().getIMagapService()
				.findCatalogByType(Parameter.RUBROS, Parameter.ESTADO_ACTIVO);

		this.productDTOs = MagapFactory.getInstance().getIMagapService()
				.findCatalogByType(Parameter.PRODUCTO, Parameter.ESTADO_ACTIVO);

	}

	public void newProducto() {
		this.addProductoDTO = new ProductoProductorDTO();
		this.addProductoDTO.setTipo(Parameter.PRODUCTO_PRODUCE);
	}

	public void addProductos() {

		String nameTipo = CompareUtil.findNameCatalogDTO(this.tipoProductDTOs,
				this.addProductoDTO.getIdCatalogoTipoPro());
		this.addProductoDTO.setNombreTipoPro(nameTipo);

		String nameRubroPro = CompareUtil.findNameCatalogDTO(
				this.rubroProductDTOs,
				this.addProductoDTO.getIdCatalogoRubroPro());
		this.addProductoDTO.setNombreRubroPro(nameRubroPro);

		String namePro = CompareUtil.findNameCatalogDTO(this.productDTOs,
				this.addProductoDTO.getIdCatalogoProducto());
		this.addProductoDTO.setNombrePro(namePro);
		this.addProductoDTO.setTipo(Parameter.PRODUCTO_PRODUCE);
		if (!BooleanUtils.toBoolean(this.addProductoDTO.getSelected())) {
			this.addProductoProductorDTOs.add(this.addProductoDTO);
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "",
							"Producto agregado correctamente"));
		} else {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "",
							"Producto editado correctamente"));
		}
		this.addProductoDTO.setSelected(Boolean.TRUE);
		this.setAddProductoDTO(new ProductoProductorDTO());

	}

	public void deleteAddProductos(ProductoProductorDTO productoProductorDTO) {
		this.addProductoProductorDTOs.remove(productoProductorDTO);

	}

	/**
	 * Productos procesados
	 * 
	 * @return
	 */

	public void newProductProcess() {
		this.addProductoProcessDTO = new ProductoProductorDTO();
		this.addProductoProcessDTO.setTipo(Parameter.PRODUCTO_PROCESADO);

	}

	public void newProductOfert() {
		this.addProductoProcessDTO = new ProductoProductorDTO();
		this.addProductoProcessDTO.setTipo(Parameter.PRODUCTO_OFERTADO);
	}

	public void addProductProcess() {

		String nameTipo = CompareUtil.findNameCatalogDTO(this.tipoProductDTOs,
				this.addProductoProcessDTO.getIdCatalogoTipoPro());
		this.addProductoProcessDTO.setNombreTipoPro(nameTipo);

		String nameRubroPro = CompareUtil.findNameCatalogDTO(
				this.rubroProductDTOs,
				this.addProductoProcessDTO.getIdCatalogoRubroPro());
		this.addProductoProcessDTO.setNombreRubroPro(nameRubroPro);

		String namePro = CompareUtil.findNameCatalogDTO(this.productDTOs,
				this.addProductoProcessDTO.getIdCatalogoProducto());
		this.addProductoProcessDTO.setNombrePro(namePro);

		if (!BooleanUtils.toBoolean(this.addProductoProcessDTO.getSelected())) {

			if (this.addProductoProcessDTO.getTipo() == Parameter.PRODUCTO_PROCESADO) {
				this.addProducProcessDTOs.add(this.addProductoProcessDTO);
			} else {
				this.addProductoProcessDTO.setTipo(Parameter.PRODUCTO_OFERTADO);
				this.addProducOfertDTOs.add(this.addProductoProcessDTO);
			}

			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "",
							"Producto agregado correctamente"));
		} else {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "",
							"Producto editado correctamente"));
		}
		this.addProductoProcessDTO.setSelected(Boolean.TRUE);
		this.setAddProductoProcessDTO(new ProductoProductorDTO());

	}

	public void deleteAddProductProcess(
			ProductoProductorDTO productoProductorDTO) {
		this.addProducProcessDTOs.remove(productoProductorDTO);

	}

	private List<ProductoProductorDTO> productosDTOs() {
		List<ProductoProductorDTO> result = new ArrayList<ProductoProductorDTO>();
		if (this.addProductoProductorDTOs != null
				&& !addProductoProductorDTOs.isEmpty()) {
			result.addAll(this.addProductoProductorDTOs);
		}
		if (this.addProducProcessDTOs != null
				&& !this.addProducProcessDTOs.isEmpty()) {
			result.addAll(this.addProducProcessDTOs);
		}
		if (this.addProducOfertDTOs != null
				&& !this.addProducOfertDTOs.isEmpty()) {
			result.addAll(this.addProducOfertDTOs);
		}
		return result;
	}

	/**
	 * Ofertados
	 * 
	 * @return
	 */

	public void deleteAddProductOfert(ProductoProductorDTO productoProductorDTO) {
		this.addProducOfertDTOs.remove(productoProductorDTO);

	}

	public SessionUser getSessionUser() {
		return sessionUser;
	}

	public void setSessionUser(SessionUser sessionUser) {
		this.sessionUser = sessionUser;
	}

	public List<CatalogoDTO> getFuenteIngresosDTOs() {
		return fuenteIngresosDTOs;
	}

	public void setFuenteIngresosDTOs(List<CatalogoDTO> fuenteIngresosDTOs) {
		this.fuenteIngresosDTOs = fuenteIngresosDTOs;
	}

	public List<ProvinciaDTO> getProvinciaDTOs() {
		return provinciaDTOs;
	}

	public void setProvinciaDTOs(List<ProvinciaDTO> provinciaDTOs) {
		this.provinciaDTOs = provinciaDTOs;
	}

	public UbicacionFincaDTO getUbicacionFincaDTO() {
		return ubicacionFincaDTO;
	}

	public void setUbicacionFincaDTO(UbicacionFincaDTO ubicacionFincaDTO) {
		this.ubicacionFincaDTO = ubicacionFincaDTO;
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

	public List<CatalogoDTO> getPosesionDTOs() {
		return posesionDTOs;
	}

	public void setPosesionDTOs(List<CatalogoDTO> posesionDTOs) {
		this.posesionDTOs = posesionDTOs;
	}

	public List<CatalogoDTO> getPracticasDTOs() {
		return practicasDTOs;
	}

	public void setPracticasDTOs(List<CatalogoDTO> practicasDTOs) {
		this.practicasDTOs = practicasDTOs;
	}

	public List<String> getIdPracticas() {
		return idPracticas;
	}

	public void setIdPracticas(List<String> idPracticas) {
		this.idPracticas = idPracticas;
	}

	public Boolean getOrganica() {
		return organica;
	}

	public void setOrganica(Boolean organica) {
		this.organica = organica;
	}

	public Boolean getAgroEcologic() {
		return agroEcologic;
	}

	public void setAgroEcologic(Boolean agroEcologic) {
		this.agroEcologic = agroEcologic;
	}

	public List<CatalogoDTO> getApoyoProDTOs() {
		return apoyoProDTOs;
	}

	public void setApoyoProDTOs(List<CatalogoDTO> apoyoProDTOs) {
		this.apoyoProDTOs = apoyoProDTOs;
	}

	public List<String> getIdFuentes() {
		return idFuentes;
	}

	public void setIdFuentes(List<String> idFuentes) {
		this.idFuentes = idFuentes;
	}

	public List<String> getIdApoyoPro() {
		return idApoyoPro;
	}

	public void setIdApoyoPro(List<String> idApoyoPro) {
		this.idApoyoPro = idApoyoPro;
	}

	public OrganizacionDTO getOrganizacionDTO() {
		return organizacionDTO;
	}

	public void setOrganizacionDTO(OrganizacionDTO organizacionDTO) {
		this.organizacionDTO = organizacionDTO;
	}

	public List<OrganizacionDTO> getOrganizacionDTOs() {
		return organizacionDTOs;
	}

	public void setOrganizacionDTOs(List<OrganizacionDTO> organizacionDTOs) {
		this.organizacionDTOs = organizacionDTOs;
	}

	public List<CatalogoDTO> getDestComerDTOs() {
		return destComerDTOs;
	}

	public void setDestComerDTOs(List<CatalogoDTO> destComerDTOs) {
		this.destComerDTOs = destComerDTOs;
	}

	public List<String> getIdDestComer() {
		return idDestComer;
	}

	public void setIdDestComer(List<String> idDestComer) {
		this.idDestComer = idDestComer;
	}

	public CialcoDTO getCialcoFeriaDTO() {
		return cialcoFeriaDTO;
	}

	public void setCialcoFeriaDTO(CialcoDTO cialcoFeriaDTO) {
		this.cialcoFeriaDTO = cialcoFeriaDTO;
	}

	public List<CatalogoDTO> getFrecuenciaDTOs() {
		return frecuenciaDTOs;
	}

	public void setFrecuenciaDTOs(List<CatalogoDTO> frecuenciaDTOs) {
		this.frecuenciaDTOs = frecuenciaDTOs;
	}

	public Integer getNumeroFamiliares() {
		return numeroFamiliares;
	}

	public void setNumeroFamiliares(Integer numeroFamiliares) {
		this.numeroFamiliares = numeroFamiliares;
	}

	public PersonaDTO getAddPersonaDTO() {
		return addPersonaDTO;
	}

	public void setAddPersonaDTO(PersonaDTO addPersonaDTO) {
		this.addPersonaDTO = addPersonaDTO;
	}

	public Boolean getCheckFeria() {
		return checkFeria;
	}

	public void setCheckFeria(Boolean checkFeria) {
		this.checkFeria = checkFeria;
	}

	public String getLabelCheckFeria() {
		return labelCheckFeria;
	}

	public void setLabelCheckFeria(String labelCheckFeria) {
		this.labelCheckFeria = labelCheckFeria;
	}

	public String getLabelCheckOrgnica() {
		return labelCheckOrgnica;
	}

	public void setLabelCheckOrgnica(String labelCheckOrgnica) {
		this.labelCheckOrgnica = labelCheckOrgnica;
	}

	public String getLabelCheckAgro() {
		return labelCheckAgro;
	}

	public void setLabelCheckAgro(String labelCheckAgro) {
		this.labelCheckAgro = labelCheckAgro;
	}

	public PracticaProductivaDTO getPracticaAgroDTO() {
		return practicaAgroDTO;
	}

	public void setPracticaAgroDTO(PracticaProductivaDTO practicaAgroDTO) {
		this.practicaAgroDTO = practicaAgroDTO;
	}

	public PracticaProductivaDTO getPracticaOrgaDTO() {
		return practicaOrgaDTO;
	}

	public void setPracticaOrgaDTO(PracticaProductivaDTO practicaOrgaDTO) {
		this.practicaOrgaDTO = practicaOrgaDTO;
	}

	public List<CatalogoDTO> getDestinoIngDTOs() {
		return destinoIngDTOs;
	}

	public void setDestinoIngDTOs(List<CatalogoDTO> destinoIngDTOs) {
		this.destinoIngDTOs = destinoIngDTOs;
	}

	public List<String> getIdDestIng() {
		return idDestIng;
	}

	public void setIdDestIng(List<String> idDestIng) {
		this.idDestIng = idDestIng;
	}

	public ProductoProductorDTO getAddProductoDTO() {
		return addProductoDTO;
	}

	public void setAddProductoDTO(ProductoProductorDTO addProductoDTO) {
		this.addProductoDTO = addProductoDTO;
	}

	public List<ProductoProductorDTO> getAddProductoProductorDTOs() {
		return addProductoProductorDTOs;
	}

	public void setAddProductoProductorDTOs(
			List<ProductoProductorDTO> addProductoProductorDTOs) {
		this.addProductoProductorDTOs = addProductoProductorDTOs;
	}

	public List<CatalogoDTO> getTipoProductDTOs() {
		return tipoProductDTOs;
	}

	public void setTipoProductDTOs(List<CatalogoDTO> tipoProductDTOs) {
		this.tipoProductDTOs = tipoProductDTOs;
	}

	public List<CatalogoDTO> getRubroProductDTOs() {
		return rubroProductDTOs;
	}

	public void setRubroProductDTOs(List<CatalogoDTO> rubroProductDTOs) {
		this.rubroProductDTOs = rubroProductDTOs;
	}

	public List<CatalogoDTO> getProductDTOs() {
		return productDTOs;
	}

	public void setProductDTOs(List<CatalogoDTO> productDTOs) {
		this.productDTOs = productDTOs;
	}

	public Double getPromCialcomes() {
		return promCialcomes;
	}

	public void setPromCialcomes(Double promCialcomes) {
		this.promCialcomes = promCialcomes;
	}

	public Double getPromMes() {
		return promMes;
	}

	public void setPromMes(Double promMes) {
		this.promMes = promMes;
	}

	public ProductoProductorDTO getAddProductoProcessDTO() {
		return addProductoProcessDTO;
	}

	public void setAddProductoProcessDTO(
			ProductoProductorDTO addProductoProcessDTO) {
		this.addProductoProcessDTO = addProductoProcessDTO;
	}

	public List<ProductoProductorDTO> getAddProducProcessDTOs() {
		return addProducProcessDTOs;
	}

	public void setAddProducProcessDTOs(
			List<ProductoProductorDTO> addProducProcessDTOs) {
		this.addProducProcessDTOs = addProducProcessDTOs;
	}

	public List<ProductoProductorDTO> getAddProducOfertDTOs() {
		return addProducOfertDTOs;
	}

	public void setAddProducOfertDTOs(
			List<ProductoProductorDTO> addProducOfertDTOs) {
		this.addProducOfertDTOs = addProducOfertDTOs;
	}

	public List<CatalogoDTO> getParentescoDTOs() {
		return parentescoDTOs;
	}

	public void setParentescoDTOs(List<CatalogoDTO> parentescoDTOs) {
		this.parentescoDTOs = parentescoDTOs;
	}

	public SupportController getSupportController() {
		return supportController;
	}

	public void setSupportController(SupportController supportController) {
		this.supportController = supportController;
	}

	public PersonController getPersonController() {
		return personController;
	}

	public void setPersonController(PersonController personController) {
		this.personController = personController;
	}

	public List<OrganizacionDTO> getDeleteOrganizacionDTOs() {
		return deleteOrganizacionDTOs;
	}

	public void setDeleteOrganizacionDTOs(
			List<OrganizacionDTO> deleteOrganizacionDTOs) {
		this.deleteOrganizacionDTOs = deleteOrganizacionDTOs;
	}

}