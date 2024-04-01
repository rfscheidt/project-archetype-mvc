package br.com.project.config;

import java.awt.Desktop;
import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class OpenBrowser {
	
	@Value("${url}")
	private String url;

	@PostConstruct
	public void run() {
		try {
			openWebpage(new URI(url));
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}

	private void openWebpage(URI uri) {
		System.setProperty("java.awt.headless", "false");
		Desktop desktop = Desktop.getDesktop();
		try {
			desktop.browse(uri);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
