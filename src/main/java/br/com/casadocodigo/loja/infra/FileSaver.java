package br.com.casadocodigo.loja.infra;

import java.io.IOException;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.http.Part;

import com.amazonaws.AmazonClientException;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;

@RequestScoped
public class FileSaver {

	private static final String CONTENT_DISPOSITION = "content-disposition";

	private static final String FILENAME_KEY = "filename=";
	
	@Inject
	private AmazonS3Client s3;	

	public String write(String baseFolder, Part multipartFile) {
		String fileName = extractFilename(multipartFile
				.getHeader(CONTENT_DISPOSITION));
		try {
			s3.putObject("casadocodigo/"+baseFolder, fileName,
					multipartFile.getInputStream(), new ObjectMetadata());
			return "http://localhost:9444/s3/casadocodigo/"+baseFolder+"_"+fileName+"?noAuth=true";
		} catch (AmazonClientException | IOException e) {
			throw new RuntimeException(e);
		}
	}

	private String extractFilename(String contentDisposition) {
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
