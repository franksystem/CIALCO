package ec.gob.magap.web.util;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import ec.gob.magap.common.util.MagapLogger;

public final class ReportUtil {
	private ReportUtil() {
	}

	// "reportes/report1.jasper"
	public static void showReport(List<?> objectDTOs,
			Map<String, Object> parameters, String path) {
		try {
			if (objectDTOs == null || objectDTOs.isEmpty()) {
				FacesContext
						.getCurrentInstance()
						.addMessage(
								null,
								new FacesMessage(FacesMessage.SEVERITY_INFO,
										"",
										"No existen registros, por favor verifique los filtros de b\u00FAsqueda"));
			} else {
				File jasper = new File(FacesContext.getCurrentInstance()
						.getExternalContext().getRealPath(path));

				byte[] bytes = JasperRunManager.runReportToPdf(
						jasper.getPath(), parameters,
						new JRBeanCollectionDataSource(objectDTOs));

				HttpServletResponse response = (HttpServletResponse) FacesContext
						.getCurrentInstance().getExternalContext()
						.getResponse();
				response.setContentType("application/pdf");
				response.setContentLength(bytes.length);
				// response.addHeader("Content-Disposition",
				// "attachment; filename=producer.pdf");

				ServletOutputStream outStream = response.getOutputStream();
				outStream.write(bytes, 0, bytes.length);
				outStream.flush();
				outStream.close();
				FacesContext.getCurrentInstance().responseComplete();
			}
		} catch (JRException e) {
			MagapLogger.log.error("JRException", e);
		} catch (IOException e) {
			MagapLogger.log.error("IOException", e);
		}
	}
}
