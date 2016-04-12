package ec.gob.magap.vo;

import java.util.List;

import ec.gob.magap.dto.CialcoDTO;
import ec.gob.magap.dto.InstitucionApoyoDTO;
import ec.gob.magap.dto.OrganizacionDTO;
import ec.gob.magap.dto.PersonaDTO;
import ec.gob.magap.dto.PracticaProductivaDTO;
import ec.gob.magap.dto.ProductoProductorDTO;
import ec.gob.magap.dto.ProductorDTO;
import ec.gob.magap.dto.UbicacionFincaDTO;

public class ProductorVO {

	private PersonaDTO personaDTO;

	private UbicacionFincaDTO ubicacionFincaDTO;
	private OrganizacionDTO organizacionDTO;
	private PersonaDTO addPersonaDTO;
	private ProductorDTO productorDTO;

	private PracticaProductivaDTO practicaAgroDTO;
	private PracticaProductivaDTO practicaOrgaDTO;
	private List<InstitucionApoyoDTO> institucionApoyoDTOs;
	private List<InstitucionApoyoDTO> deleteInstitucionApoyoDTOs;

	private List<OrganizacionDTO> deleteOrganizacionDTOs;
	private List<OrganizacionDTO> organizacionDTOs;
	private List<PersonaDTO> addPersonasDTOs;
	private List<ProductoProductorDTO> addProductoProductorDTOs;
	private List<CialcoDTO> cialcoDTOs;

	private List<String> idFuentes;
	private List<String> idPracticas;
	private List<String> idApoyoPro;
	private List<String> idDestComer;// destinos produccion
	private List<String> idDestIng;// destinos Ingresos

	public PersonaDTO getPersonaDTO() {
		return personaDTO;
	}

	public void setPersonaDTO(PersonaDTO personaDTO) {
		this.personaDTO = personaDTO;
	}

	public UbicacionFincaDTO getUbicacionFincaDTO() {
		return ubicacionFincaDTO;
	}

	public void setUbicacionFincaDTO(UbicacionFincaDTO ubicacionFincaDTO) {
		this.ubicacionFincaDTO = ubicacionFincaDTO;
	}

	public OrganizacionDTO getOrganizacionDTO() {
		return organizacionDTO;
	}

	public void setOrganizacionDTO(OrganizacionDTO organizacionDTO) {
		this.organizacionDTO = organizacionDTO;
	}

	public List<CialcoDTO> getCialcoDTOs() {
		return cialcoDTOs;
	}

	public void setCialcoDTOs(List<CialcoDTO> cialcoDTOs) {
		this.cialcoDTOs = cialcoDTOs;
	}

	public PersonaDTO getAddPersonaDTO() {
		return addPersonaDTO;
	}

	public void setAddPersonaDTO(PersonaDTO addPersonaDTO) {
		this.addPersonaDTO = addPersonaDTO;
	}

	public List<OrganizacionDTO> getOrganizacionDTOs() {
		return organizacionDTOs;
	}

	public void setOrganizacionDTOs(List<OrganizacionDTO> organizacionDTOs) {
		this.organizacionDTOs = organizacionDTOs;
	}

	public List<PersonaDTO> getAddPersonasDTOs() {
		return addPersonasDTOs;
	}

	public void setAddPersonasDTOs(List<PersonaDTO> addPersonasDTOs) {
		this.addPersonasDTOs = addPersonasDTOs;
	}

	public List<String> getIdFuentes() {
		return idFuentes;
	}

	public void setIdFuentes(List<String> idFuentes) {
		this.idFuentes = idFuentes;
	}

	public List<String> getIdPracticas() {
		return idPracticas;
	}

	public void setIdPracticas(List<String> idPracticas) {
		this.idPracticas = idPracticas;
	}

	public List<String> getIdApoyoPro() {
		return idApoyoPro;
	}

	public void setIdApoyoPro(List<String> idApoyoPro) {
		this.idApoyoPro = idApoyoPro;
	}

	public List<String> getIdDestComer() {
		return idDestComer;
	}

	public void setIdDestComer(List<String> idDestComer) {
		this.idDestComer = idDestComer;
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

	public List<String> getIdDestIng() {
		return idDestIng;
	}

	public void setIdDestIng(List<String> idDestIng) {
		this.idDestIng = idDestIng;
	}

	public List<ProductoProductorDTO> getAddProductoProductorDTOs() {
		return addProductoProductorDTOs;
	}

	public void setAddProductoProductorDTOs(
			List<ProductoProductorDTO> addProductoProductorDTOs) {
		this.addProductoProductorDTOs = addProductoProductorDTOs;
	}

	public List<InstitucionApoyoDTO> getInstitucionApoyoDTOs() {
		return institucionApoyoDTOs;
	}

	public void setInstitucionApoyoDTOs(
			List<InstitucionApoyoDTO> institucionApoyoDTOs) {
		this.institucionApoyoDTOs = institucionApoyoDTOs;
	}

	public ProductorDTO getProductorDTO() {
		return productorDTO;
	}

	public void setProductorDTO(ProductorDTO productorDTO) {
		this.productorDTO = productorDTO;
	}

	public List<OrganizacionDTO> getDeleteOrganizacionDTOs() {
		return deleteOrganizacionDTOs;
	}

	public void setDeleteOrganizacionDTOs(
			List<OrganizacionDTO> deleteOrganizacionDTOs) {
		this.deleteOrganizacionDTOs = deleteOrganizacionDTOs;
	}

	public List<InstitucionApoyoDTO> getDeleteInstitucionApoyoDTOs() {
		return deleteInstitucionApoyoDTOs;
	}

	public void setDeleteInstitucionApoyoDTOs(
			List<InstitucionApoyoDTO> deleteInstitucionApoyoDTOs) {
		this.deleteInstitucionApoyoDTOs = deleteInstitucionApoyoDTOs;
	}

}