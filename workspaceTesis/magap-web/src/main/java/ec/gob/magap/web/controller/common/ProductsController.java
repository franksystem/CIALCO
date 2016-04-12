package ec.gob.magap.web.controller.common;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.commons.lang3.BooleanUtils;

import ec.gob.magap.common.util.MagapLogger;
import ec.gob.magap.common.util.Parameter;
import ec.gob.magap.dto.CatalogoDTO;
import ec.gob.magap.dto.PresentacionProductoDTO;
import ec.gob.magap.factory.MagapFactory;
import ec.gob.magap.web.util.CompareUtil;

@ManagedBean(name = "productosController")
@ViewScoped
public class ProductsController {

	private PresentacionProductoDTO presentacionProductoDTO;
	private Double montoTotal;
	private Boolean feria = Boolean.FALSE;

	private List<PresentacionProductoDTO> presentacionProductoDTOs;
	private List<CatalogoDTO> productoDTOs;
	private List<CatalogoDTO> presentacionDTOs;
	private List<CatalogoDTO> unidadDTOs;

	@PostConstruct
	public void init() {
		this.montoTotal = 0D;
		findProductos();
		findPresentacion();
		findUnidad();
	}

	private void findProductos() {
		if (this.productoDTOs == null || this.productoDTOs.isEmpty()) {
			this.productoDTOs = MagapFactory
					.getInstance()
					.getIMagapService()
					.findCatalogByType(Parameter.PRODUCTO,
							Parameter.ESTADO_ACTIVO);
		}
	}

	private void findPresentacion() {
		if (!this.feria
				&& (this.presentacionDTOs == null || this.presentacionDTOs
						.isEmpty())) {
			this.presentacionDTOs = MagapFactory
					.getInstance()
					.getIMagapService()
					.findCatalogByType(Parameter.PRODUCTOS_PRESENTACION,
							Parameter.ESTADO_ACTIVO);
		}
	}

	private void findUnidad() {
		if (this.unidadDTOs == null || this.unidadDTOs.isEmpty()) {
			this.unidadDTOs = MagapFactory
					.getInstance()
					.getIMagapService()
					.findCatalogByType(Parameter.UNIDAD_MEDIDA,
							Parameter.ESTADO_ACTIVO);
		}
	}

	public void addPresentacionProducto() {
		String nombreProducto = CompareUtil.findNameCatalogDTO(
				this.productoDTOs,
				this.presentacionProductoDTO.getIdCatalogoProducto());
		this.presentacionProductoDTO.setNombreProducto(nombreProducto);

		if (!this.feria) {
			String nombrePresentacion = CompareUtil.findNameCatalogDTO(
					this.presentacionDTOs,
					this.presentacionProductoDTO.getIdCatalogoPresentacion());
			this.presentacionProductoDTO
					.setNombrePresentacion(nombrePresentacion);
		}

		String nombreUnidad = CompareUtil.findNameCatalogDTO(this.unidadDTOs,
				this.presentacionProductoDTO.getIdCatalogoUnidad());
		this.presentacionProductoDTO.setNombreUnidad(nombreUnidad);

		if (!BooleanUtils.toBoolean(this.presentacionProductoDTO.getSelected())) {
			this.presentacionProductoDTOs.add(this.presentacionProductoDTO);
			this.montoTotal = 0D;
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
		for (PresentacionProductoDTO pro : this.presentacionProductoDTOs) {
			this.montoTotal = this.montoTotal + pro.getMontoMes();
		}
		this.presentacionProductoDTO.setSelected(Boolean.TRUE);
		this.setPresentacionProductoDTO(new PresentacionProductoDTO());
	}

	public void newProductos(Boolean feria) {
		MagapLogger.log.info("{}", feria);
		this.feria = feria;
		this.setPresentacionProductoDTO(new PresentacionProductoDTO());
		this.presentacionProductoDTOs = new ArrayList<PresentacionProductoDTO>();
		this.montoTotal = 0D;
	}

	public void deleteProductPresent(
			PresentacionProductoDTO presentacionProductoDTO) {
		this.montoTotal = this.montoTotal
				- presentacionProductoDTO.getMontoMes();
		this.presentacionProductoDTOs.remove(presentacionProductoDTO);

	}

	public PresentacionProductoDTO getPresentacionProductoDTO() {
		return presentacionProductoDTO;
	}

	public void setPresentacionProductoDTO(
			PresentacionProductoDTO presentacionProductoDTO) {
		this.presentacionProductoDTO = presentacionProductoDTO;
	}

	public Double getMontoTotal() {
		return montoTotal;
	}

	public void setMontoTotal(Double montoTotal) {
		this.montoTotal = montoTotal;
	}

	public List<PresentacionProductoDTO> getPresentacionProductoDTOs() {
		return presentacionProductoDTOs;
	}

	public void setPresentacionProductoDTOs(
			List<PresentacionProductoDTO> presentacionProductoDTOs) {
		this.presentacionProductoDTOs = presentacionProductoDTOs;
	}

	public List<CatalogoDTO> getProductoDTOs() {
		return productoDTOs;
	}

	public void setProductoDTOs(List<CatalogoDTO> productoDTOs) {
		this.productoDTOs = productoDTOs;
	}

	public List<CatalogoDTO> getPresentacionDTOs() {
		return presentacionDTOs;
	}

	public void setPresentacionDTOs(List<CatalogoDTO> presentacionDTOs) {
		this.presentacionDTOs = presentacionDTOs;
	}

	public List<CatalogoDTO> getUnidadDTOs() {
		return unidadDTOs;
	}

	public void setUnidadDTOs(List<CatalogoDTO> unidadDTOs) {
		this.unidadDTOs = unidadDTOs;
	}

	public Boolean getFeria() {
		return feria;
	}

	public void setFeria(Boolean feria) {
		this.feria = feria;
	}

}
