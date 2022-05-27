package com.objetivo2.fileupload.mapper;


import com.objetivo2.fileupload.dto.UploadDTO;
import com.objetivo2.fileupload.model.UploadTable;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean(name = "fileUploadMapper")
    public ModelMapper fileUploadMapper() {
        ModelMapper mapper = new ModelMapper();
        TypeMap<UploadDTO, UploadTable> typeMap = mapper.createTypeMap(UploadDTO.class, UploadTable.class);
        typeMap.addMapping(UploadDTO::getId, UploadTable::setId);
        typeMap.addMapping(UploadDTO::getNroLicencia,UploadTable::setNroLicencia);
        typeMap.addMapping(UploadDTO::isOriginal,UploadTable::setOriginal);
        typeMap.addMapping(UploadDTO::getRespuestaGestorDocumentalUno,UploadTable::setRespuestaGestorDocumentalUno);
        typeMap.addMapping(UploadDTO::getRespuestaGestorDocumentalDos,UploadTable::setRespuestaGestorDocumentalDos);
        typeMap.addMapping(UploadDTO::getRespuestaGestorDocumentalTres,UploadTable::setRespuestaGestorDocumentalTres);
        typeMap.addMapping(UploadDTO::isActivo,UploadTable::setActivo);
        typeMap.addMapping(UploadDTO::getFechaCreacion,UploadTable::setFechaCreacion);
        typeMap.addMapping(UploadDTO::getUsuarioCrea,UploadTable::setUsuarioCrea);
        typeMap.addMapping(UploadDTO::getFechaModifica,UploadTable::setFechaModifica);
        typeMap.addMapping(UploadDTO::getUsuarioModifica,UploadTable::setUsuarioModifica);


        return mapper;
    }



}
