package org.example.demoreadfileslocal.controller;

import lombok.RequiredArgsConstructor;
import org.example.demoreadfileslocal.service.FileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class AppController {

    private final FileService fileService;

    @GetMapping("/getFilesName")
    public ResponseEntity<List<String>> getFileName(@RequestParam("startDate") String startDate,
                                                    @RequestParam(value = "typeDocument") String typeDocument) {

        String route = "file:../chains_deployment/" + typeDocument + "/" + startDate.replace("-", "_");

        List<File> fileList = fileService.readFiles(route);

        List<String> fileNameList = new ArrayList<>();
        for (File file : fileList) {
            fileNameList.add(file.getName());
        }
        return ResponseEntity.ok(fileNameList);
    }
}
