package br.com.amigopet.server;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import br.com.amigopet.model.Dica;

@Component
public class DataDica {

	public void criaDiretorio(MultipartFile imagem, Dica dica) throws IOException {
		String pasta = "imagens\\imagensDicas\\";
		
		
		boolean success = (new File(pasta)).mkdirs();
	    if (!success) {
	    	byte[] bytes = imagem.getBytes();

			Path path = Paths.get(pasta + dica.getImagem());

			Files.write(path, bytes);
	    } else {
	    	byte[] bytes = imagem.getBytes();

			Path path = Paths.get(pasta + dica.getImagem());

			Files.write(path, bytes);
	    }
		
		
		

	}

}
