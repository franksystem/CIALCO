package ec.gob.magap.service.impl;

import java.util.List;

import ec.gob.magap.dto.CantonDTO;
import ec.gob.magap.dto.CatalogoDTO;
import ec.gob.magap.dto.CialcoDTO;
import ec.gob.magap.dto.MenuDTO;
import ec.gob.magap.dto.PantallaDTO;
import ec.gob.magap.dto.ParroquiaDTO;
import ec.gob.magap.dto.PerfilDTO;
import ec.gob.magap.dto.PersonaDTO;
import ec.gob.magap.dto.ProvinciaDTO;
import ec.gob.magap.dto.UsuarioDTO;
import ec.gob.magap.exception.MagapException;
import ec.gob.magap.gestor.IMagapGestor;
import ec.gob.magap.service.IMagapService;
import ec.gob.magap.vo.ProductorVO;

public class MagapService implements IMagapService {

	IMagapGestor magapGestor;

	public IMagapGestor getMagapGestor() {
		return magapGestor;
	}

	public void setMagapGestor(IMagapGestor magapGestor) {
		this.magapGestor = magapGestor;
	}

	public UsuarioDTO login(String userName, String password)
			throws MagapException {
		return magapGestor.login(userName, password);
	}

	public List<CatalogoDTO> findCatalogByType(Integer type, Integer status)
			throws MagapException {
		return magapGestor.findCatalogByType(type, status);
	}

	public List<ProvinciaDTO> findProvincias() throws MagapException {
		return magapGestor.findProvincias();
	}

	public List<CantonDTO> findCantones(Integer idProvincia)
			throws MagapException {
		return magapGestor.findCantones(idProvincia);
	}

	public List<ParroquiaDTO> findParroquias(Integer idCanton)
			throws MagapException {
		return magapGestor.findParroquias(idCanton);
	}

	public PersonaDTO findPersonaByCedula(Long cedula) throws MagapException {
		return magapGestor.findPersonaByCedula(cedula);
	}
	
	public PantallaDTO findPantallaByDescripcion(String nombrePantalla) throws MagapException{
		return magapGestor.findPantallaByDescripcion(nombrePantalla);
	}
	
	public void transSaveProductor(ProductorVO productorVO)
			throws MagapException {
		magapGestor.transSaveProductor(productorVO);
	}
	
	public void transSavePantalla(PantallaDTO pantallaDTO) throws MagapException{
		magapGestor.transSavePantalla(pantallaDTO);
	}
	
	public void transSaveMenu(MenuDTO menuDTO) throws MagapException{
		magapGestor.transSaveMenu(menuDTO);
	}

	public void transSaveCialco(CialcoDTO cialcoDTO) throws MagapException {
		magapGestor.transSaveCialco(cialcoDTO);
	}

	public List<PersonaDTO> findProductor(PersonaDTO personaDTO)
			throws MagapException {
		return magapGestor.findProductor(personaDTO);
	}

	public List<PersonaDTO> findUsuario(PersonaDTO personaDTO) throws MagapException{
		return magapGestor.findUsuario(personaDTO);
	}
	
	public List<PantallaDTO> findPantallaDTO(PantallaDTO pantallaDTO) throws MagapException{
		return magapGestor.findPantallaDTO(pantallaDTO);
	}
	
	public List<CialcoDTO> findCialcoDTO(CialcoDTO cialcoDTO) throws MagapException{
		return magapGestor.findCialcoDTO(cialcoDTO);
	}
	
	public List<MenuDTO> findMenuDTO(MenuDTO menuDTO) throws MagapException{
		return magapGestor.findMenuDTO(menuDTO);
	}
	
	public List<MenuDTO> findMenuPadreDTO(MenuDTO menuDTO) throws MagapException{
		return magapGestor.findMenuPadreDTO(menuDTO);
	}
	public List<PerfilDTO> findPerfilDTO(PerfilDTO perfilDTO) throws MagapException{
		return magapGestor.findPerfilDTO(perfilDTO);
	}
	public ProductorVO findDatosProductor(PersonaDTO personaDTO)
			throws MagapException {
		return magapGestor.findDatosProductor(personaDTO);
	}

	

}
