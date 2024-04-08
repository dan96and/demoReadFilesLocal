package org.example.demoreadfileslocal.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface FileService {
    List<File> readFiles(String routeRealtive);
}
