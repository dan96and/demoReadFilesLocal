package org.example.demoreadfileslocal.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.demoreadfileslocal.service.FileService;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {

    private final ResourceLoader resourceLoader;

    @Override
    public List<File> readFiles(String routeRealative) {
        //Solicito que me proporcione el recurso segun la ruta relativa que le he proporcionado
        Resource resource = resourceLoader.getResource(routeRealative);
        File file;

        try {
            //Obtengo el archivo o carpeta del recurso
            file = resource.getFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if (file.exists() && file.isDirectory()) {
            //Devuelvo la lista de archivos que contiene la carpeta
            return List.of(Objects.requireNonNull(file.listFiles()));
        }else {
            System.out.println("No existe la carpeta");
        }
        return List.of();
    }
}
