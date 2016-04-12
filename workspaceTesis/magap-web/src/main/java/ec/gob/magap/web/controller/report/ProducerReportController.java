package ec.gob.magap.web.controller.report;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import ec.gob.magap.common.util.Parameter;
import ec.gob.magap.dto.PersonaDTO;
import ec.gob.magap.factory.MagapFactory;
import ec.gob.magap.web.controller.ProducerController;
import ec.gob.magap.web.controller.common.CommonController;
import ec.gob.magap.web.util.ReportUtil;

@ManagedBean(name = "producerReportController")
@ViewScoped
public class ProducerReportController {

	@ManagedProperty(value = "#{commonController}")
	private CommonController commonController;

	@ManagedProperty(value = "#{producerController}")
	private ProducerController producerController;

	private PersonaDTO personaDTO;

	@PostConstruct
	public void init() {
		this.personaDTO = new PersonaDTO();
	}

	public void newProducer() {
		this.commonController.menuItem(2);
		this.producerController.newProductor();
	}

	public void findProducer() {

		List<PersonaDTO> personaDTOs = MagapFactory.getInstance()
				.getIMagapService().findProductor(this.personaDTO);
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("numero", personaDTOs.size());

		if (this.personaDTO.getEstado() == Parameter.ESTADO_ACTIVO) {
			parametros.put("estado", "ACTIVO");
		} else {
			parametros.put("estado", "INACTIVO");
		}
		ReportUtil.showReport(personaDTOs, parametros,
				"reportes/report1.jasper");
	}

	public PersonaDTO getPersonaDTO() {
		return personaDTO;
	}

	public void setPersonaDTO(PersonaDTO personaDTO) {
		this.personaDTO = personaDTO;
	}

	public CommonController getCommonController() {
		return commonController;
	}

	public void setCommonController(CommonController commonController) {
		this.commonController = commonController;
	}

	public ProducerController getProducerController() {
		return producerController;
	}

	public void setProducerController(ProducerController producerController) {
		this.producerController = producerController;
	}

}
