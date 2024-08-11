package com.org.asm2.config;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.Part;

public class FileConfig {

	public static String updateFiletoCreate(Part filePart,
			HttpServletRequest req) throws IOException {
		String fileName = getFileName(filePart);
		String uploadDir = req.getServletContext().getRealPath("/uploads");
		File uploadDirFile = new File(uploadDir);
		if (!uploadDirFile.exists()) {
			uploadDirFile.mkdirs();
		}
		String filePath = Paths.get("uploads", fileName).toString();
		filePart.write(Paths.get(uploadDir, fileName).toString());
		return filePath;
	}

	public static String getFileName(Part part) {
		for (String content : part.getHeader("content-disposition")
				.split(";")) {
			if (content.trim().startsWith("filename")) {
				return content.substring(content.indexOf('=') + 1).trim()
						.replace("\"", "");
			}
		}
		return null;
	}
}
