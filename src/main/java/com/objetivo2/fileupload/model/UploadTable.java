package com.objetivo2.fileupload.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "LicenciaImportacion")
public class UploadTable {


    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "IdLicenciaImportacion")
    private Integer id;
    @Column(name = "NumeroLicencia",length = 30)
    private String nroLicencia;
    @Column(name = "Original")
    private boolean original;
    @Column (name = "RespuestaGestorDocumental_1")
    private String respuestaGestorDocumentalUno;
    @Column (name = "RespuestaGestorDocumental_2")
    private String respuestaGestorDocumentalDos;
    @Column (name = "RespuestaGestorDocumental_3")
    private String respuestaGestorDocumentalTres;
    @Column (name = "Activo")
    private boolean activo;
    @Column (name = "FechaCreacion")
    private LocalDateTime fechaCreacion;
    @Column (name = "UsuarioCrea")
    private String usuarioCrea;
    @Column (name = "FechaModifica")
    private LocalDateTime fechaModifica;
    @Column (name = "UsuarioModifica")
    private String usuarioModifica;

    public UploadTable(String nroLicencia, boolean original, String respuestaGestorDocumentalUno, String respuestaGestorDocumentalDos, String respuestaGestorDocumentalTres, boolean activo, LocalDateTime fechaCreacion, String usuarioCrea, LocalDateTime fechaModifica, String usuarioModifica) {
        this.nroLicencia = nroLicencia;
        this.original = original;
        this.respuestaGestorDocumentalUno = respuestaGestorDocumentalUno;
        this.respuestaGestorDocumentalDos = respuestaGestorDocumentalDos;
        this.respuestaGestorDocumentalTres = respuestaGestorDocumentalTres;
        this.activo = activo;
        this.fechaCreacion = fechaCreacion;
        this.usuarioCrea = usuarioCrea;
        this.fechaModifica = fechaModifica;
        this.usuarioModifica = usuarioModifica;
    }
}
