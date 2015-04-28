package br.com.casadocodigo.infra;

import java.io.IOException;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

@RequestScoped
public class FileSaver {

	@Inject
	private HttpServletRequest request;

	private static final String CONTENT_DISPOSITION = "content-disposition";

	private static final String FILENAME_KEY = "filename=";

	public String write(String baseFolder, Part multipartFile) {
		String realPath = request.getServletContext().getRealPath(
				"/" + baseFolder);
		String fileName = extractFilename(multipartFile
				.getHeader(CONTENT_DISPOSITION));
		String path = realPath + "/" + fileName;
		 try {
			multipartFile.write(path);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return baseFolder + "/" + fileName;
	}

	private String extractFilename(String contentDisposition) {
		// trecho retirado do SpringMVC
		// https://github.com/spring-projects/spring-framework/blob/73e8021e5946aa3ae949e766d3c509e2d8f782a7/spring-web/src/main/java/org/springframework/web/multipart/support/StandardMultipartHttpServletRequest.java

		if (contentDisposition == null) {
			return null;
		}
		int startIndex = contentDisposition.indexOf(FILENAME_KEY);
		if (startIndex == -1) {
			return null;
		}
		String filename = contentDisposition.substring(startIndex
				+ FILENAME_KEY.length());
		if (filename.startsWith("\"")) {
			int endIndex = filename.indexOf("\"", 1);
			if (endIndex != -1) {
				return filename.substring(1, endIndex);
			}
		} else {
			int endIndex = filename.indexOf(";");
			if (endIndex != -1) {
				return filename.substring(0, endIndex);
			}
		}
		return filename;
	}

}
