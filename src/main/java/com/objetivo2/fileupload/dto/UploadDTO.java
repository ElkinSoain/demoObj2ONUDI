package com.objetivo2.fileupload.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UploadDTO {


    private Integer id;
    private String nroLicencia;
    private boolean original;
    private String respuestaGestorDocumentalUno;
    private String respuestaGestorDocumentalDos;
    private String respuestaGestorDocumentalTres;
    private boolean activo ;
    private LocalDateTime fechaCreacion;
    private String usuarioCrea;
    private LocalDateTime fechaModifica;
    private String usuarioModifica;


}
