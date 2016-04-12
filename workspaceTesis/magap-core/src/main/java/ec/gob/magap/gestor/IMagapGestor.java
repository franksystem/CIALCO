package ec.gob.magap.gestor;

import java.util.List;

import ec.gob.magap.dto.CantonDTO;
import ec.gob.magap.dto.CatalogoDTO;
import ec.gob.magap.dto.CialcoDTO;
import ec.gob.magap.dto.MenuDTO;
import ec.gob.magap.dto.PantallaDTO;
import ec.gob.magap.dto.ParroquiaDTO;
import ec.gob.magap.dto.PersonaDTO;
import ec.gob.magap.dto.ProvinciaDTO;
import ec.gob.magap.dto.UsuarioDTO;
import ec.gob.magap.exception.MagapException;
import ec.gob.magap.vo.PantallaVO;
import ec.gob.magap.vo.ProductorVO;

public interface IMagapGestor {

	UsuarioDTO login(String userName, String password) throws MagapException;

	List<CatalogoDTO> findCatalogByType(Integer type, Integer status)
			throws MagapException;

	List<ProvinciaDTO> findProvincias() throws MagapException;

	List<CantonDTO> findCantones(Integer idProvincia) throws MagapException;

	List<ParroquiaDTO> findParroquias(Integer idCanton) throws MagapException;

	PersonaDTO findPersonaByCedula(Long cedula) throws MagapException;

	PantallaDTO findPantallaByDescripcion(String nombrePantalla) throws MagapException;
	
	void transSaveProductor(ProductorVO productorVO) throws MagapException;

	void transSavePantalla(PantallaVO pantallaVO) throws MagapException;
	
	void transUpdatePantalla(PantallaVO pantallaVO) throws MagapException;
	
	void transSaveCialco(CialcoDTO cialcoDTO) throws MagapException;

	List<PersonaDTO> findProductor(PersonaDTO personaDTO) throws MagapException;

	List<PantallaDTO> findPantallaDTO(PantallaDTO pantallaDTO) throws MagapException;
	
	List<MenuDTO> findMenuDTO(MenuDTO menuDTO) throws MagapException;
	
	ProductorVO findDatosProductor(PersonaDTO personaDTO) throws MagapException;

}
