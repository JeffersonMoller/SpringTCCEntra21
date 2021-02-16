package br.com.amigopet.server;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import br.com.amigopet.model.Animal;

@Component
public class DataAnimal {

	public void criaDiretorio(MultipartFile imagem, Animal animal) throws IOException {
		String pasta = "imagens\\imagensAnimais\\";

		boolean success = (new File(pasta)).mkdirs();
		if (!success) {
			byte[] bytes = imagem.getBytes();

			Path path = Paths.get(pasta + animal.getImagem());

			Files.write(path, bytes);
		} else {
			byte[] bytes = imagem.getBytes();

			Path path = Paths.get(pasta + animal.getImagem());

			Files.write(path, bytes);
		}

	}
}
